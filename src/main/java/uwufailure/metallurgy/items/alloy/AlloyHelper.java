package uwufailure.metallurgy.items.alloy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import uwufailure.metallurgy.conditions.ArmorCondition;
import uwufailure.metallurgy.conditions.ArmorConditionAlignment;
import uwufailure.metallurgy.conditions.ArmorConditionRegistry;

public class AlloyHelper {
	/** Default tint for all Alloy equipment */
	public static final int DEFAULT_COLOR = 9807533;
	
	/** Fills the ItemStack's NBT with the default values. Returns the filled NBT and sets the NBT of the unit to the filled NBT. */
	public static CompoundNBT fillDefaultProperties(ItemStack stack) {
		CompoundNBT nbt = fillDefaultProperties(stack.getTag());
		stack.setTag(nbt);
		return nbt;
	}
	
	/** Fills the NBT Compound with the default values. Returns the filled NBT. */
	public static CompoundNBT fillDefaultProperties(CompoundNBT nbt) {
		if(nbt == null) {
			nbt = new CompoundNBT();
		}
		if(!nbt.contains("rust")) {
			nbt.putInt("rust", 0);
		}
		if(!nbt.contains("nextRust")) {
			nbt.putInt("nextRust", 0);
		}
		if(!nbt.contains("doRust")) {
			nbt.putBoolean("doRust", true);
		}
		if(!nbt.contains("Properties")) {
			nbt.put("Properties", new CompoundNBT());
		}
		if(!nbt.contains("rustCount")) {
			nbt.putIntArray("rustCount", new int[] {0,0,0,0,0});
		}
		if(!nbt.getCompound("Properties").contains("strength")) {
			nbt.getCompound("Properties").putInt("strength", 29);
		}
		if(!nbt.getCompound("Properties").contains("durability")) {
			nbt.getCompound("Properties").putInt("durability", 15);
		}
		if(!nbt.getCompound("Properties").contains("weight")) {
			nbt.getCompound("Properties").putInt("weight", 8);
		}
		if(!nbt.getCompound("Properties").contains("resistance")) {
			nbt.getCompound("Properties").putInt("resistance", 12);
		}
		if(!nbt.getCompound("Properties").contains("refractory")) {
			nbt.getCompound("Properties").putInt("refractory", 17);
		}
		if(!nbt.getCompound("Properties").contains("color")) {
			nbt.getCompound("Properties").putInt("color", DEFAULT_COLOR);
		}
		if(!nbt.contains("conditions")) {
			ListNBT list = new ListNBT();
			nbt.put("conditions", list);
		}

		return nbt;
	}

	/** Checks to see if the current time has surpassed the item's "nextRust". If so it calls {@link AlloyHelper#rust(ItemStack)}*/
	public static void onRustTick(ItemStack itemStack, World world) {
		CompoundNBT nbt = AlloyHelper.fillDefaultProperties(itemStack);
		if (nbt.getBoolean("doRust") && (int)(world.getGameTime()/20) >= nbt.getInt("nextRust")) {
			rust(itemStack, world);
		}
	}
	
	/** Rusts the equipment. Picks a property via {@link AlloyHelper#getRandomPropertyWeighted(CompoundNBT)} and decrements its value. */
	public static void rust(ItemStack stack, World world) {
		CompoundNBT nbt = AlloyHelper.fillDefaultProperties(stack.getTag());
		CompoundNBT propertyTag = nbt.getCompound("Properties");
		AlloyProperty property = getRandomPropertyWeighted(nbt);
		
		// Armor is completely rusted over
		if(property == null) {
			nbt.putBoolean("doRust", false);
			stack.setTag(nbt);
			return;
		}
		
		propertyTag.putInt(AlloyProperty.propertyToString(property),
		propertyTag.getInt(AlloyProperty.propertyToString(property)) - 1);
		nbt.putInt("rust", nbt.getInt("rust") + 1);
		System.out.println(world.getGameTime());
		nbt.putInt("nextRust", (int)(world.getGameTime()/20 + AlloyHelper.getRustLength(stack)));
	}
	
	/** Returns the time (in seconds) that it will take for the item stack to rust */
	public static int getRustLength(ItemStack stack) {
		return 500;
	}
	
	/** Picks a random property, but weights it by the amount the alloy has */
	public static AlloyProperty getRandomPropertyWeighted(CompoundNBT nbt) {
		nbt = AlloyHelper.fillDefaultProperties(nbt);
		CompoundNBT propertyNBT = nbt.getCompound("Properties");
		AlloyProperty property = null;
		int sum = propertyNBT.getInt("strength") + propertyNBT.getInt("durability")
				+ propertyNBT.getInt("weight") + propertyNBT.getInt("resistance")
				+ propertyNBT.getInt("refractory");
		int digit = (int) Math.round(Math.random() * (sum));
		// Wrap-around
		if (digit == sum) {
			digit = 0;
		}
		
		if(sum == 0) {
			return null;
		}

		int propertyValue;

		for (int i = 0; i < 5; i++) {
			propertyValue = new int[] { propertyNBT.getInt("strength"), propertyNBT.getInt("durability"),
					propertyNBT.getInt("weight"), propertyNBT.getInt("resistance"),
					propertyNBT.getInt("refractory") }[i];
			if (propertyValue > digit) {
				property = new AlloyProperty[] { AlloyProperty.STRENGTH, AlloyProperty.DURABILITY, AlloyProperty.WEIGHT,
						AlloyProperty.RESISTANCE, AlloyProperty.REFRACTORY }[i];
				int[] rustCnt = nbt.getIntArray("rustCount");
				rustCnt[i]++;
				nbt.putIntArray("rustCount", rustCnt);
				break;
			}
			digit -= propertyValue;
		}

		return property;
	}
	
	public static void addStandardTooltip(ItemStack stack, List<ITextComponent> tooltip, boolean showRust) {
		System.out.println(stack.toString());
		System.out.flush();

		CompoundNBT nbt = AlloyHelper.fillDefaultProperties(stack);
		if(nbt != null) {
			if(showRust) {
				tooltip.add(new TranslationTextComponent("ufmm.tooltip.alloy.rust", nbt.getInt("rust"), TextFormatting.RED, TextFormatting.BOLD, TextFormatting.RESET));
			}
			
			if(Screen.hasControlDown()) {
				int[] rustCnt = nbt.getIntArray("rustCount");
				if(rustCnt[0] == 0)
					tooltip.add(new TranslationTextComponent("ufmm.tooltip.alloy.strength", TextFormatting.DARK_PURPLE, TextFormatting.LIGHT_PURPLE, nbt.getCompound("Properties").getInt("strength")));
				else
					tooltip.add(new TranslationTextComponent("ufmm.tooltip.alloy.strength_rusted", TextFormatting.DARK_PURPLE, TextFormatting.LIGHT_PURPLE, nbt.getCompound("Properties").getInt("strength"), TextFormatting.RED, rustCnt[0]));
				if(rustCnt[1] == 0)
					tooltip.add(new TranslationTextComponent("ufmm.tooltip.alloy.durability", TextFormatting.DARK_PURPLE, TextFormatting.LIGHT_PURPLE, nbt.getCompound("Properties").getInt("durability")));
				else
					tooltip.add(new TranslationTextComponent("ufmm.tooltip.alloy.durability_rusted", TextFormatting.DARK_PURPLE, TextFormatting.LIGHT_PURPLE, nbt.getCompound("Properties").getInt("durability"), TextFormatting.RED, rustCnt[1]));
				if(rustCnt[2] == 0)
					tooltip.add(new TranslationTextComponent("ufmm.tooltip.alloy.weight", TextFormatting.DARK_PURPLE, TextFormatting.LIGHT_PURPLE, nbt.getCompound("Properties").getInt("weight")));
				else
					tooltip.add(new TranslationTextComponent("ufmm.tooltip.alloy.weight_rusted", TextFormatting.DARK_PURPLE, TextFormatting.LIGHT_PURPLE, nbt.getCompound("Properties").getInt("weight"), TextFormatting.RED, rustCnt[2]));
				if(rustCnt[3] == 0)
					tooltip.add(new TranslationTextComponent("ufmm.tooltip.alloy.resistance", TextFormatting.DARK_PURPLE, TextFormatting.LIGHT_PURPLE, nbt.getCompound("Properties").getInt("resistance")));
				else
					tooltip.add(new TranslationTextComponent("ufmm.tooltip.alloy.resistance_rusted", TextFormatting.DARK_PURPLE, TextFormatting.LIGHT_PURPLE, nbt.getCompound("Properties").getInt("resistance"), TextFormatting.RED, rustCnt[3]));
				if(rustCnt[4] == 0)
					tooltip.add(new TranslationTextComponent("ufmm.tooltip.alloy.refractory", TextFormatting.DARK_PURPLE, TextFormatting.LIGHT_PURPLE, nbt.getCompound("Properties").getInt("refractory")));
				else
					tooltip.add(new TranslationTextComponent("ufmm.tooltip.alloy.refractory_rusted", TextFormatting.DARK_PURPLE, TextFormatting.LIGHT_PURPLE, nbt.getCompound("Properties").getInt("refractory"), TextFormatting.RED, rustCnt[4]));
			} else {
				tooltip.add(new TranslationTextComponent("ufmm.tooltip.alloy.additional_information", TextFormatting.BLUE, TextFormatting.DARK_PURPLE));
			}
			
			for(ArmorCondition condition : AlloyHelper.getArmorConditions(stack)) {
				TextFormatting formatting = TextFormatting.GRAY;
				
				if(condition.getAlignment() == ArmorConditionAlignment.NEGATIVE) {
					formatting = TextFormatting.RED;
				} else if(condition.getAlignment() == ArmorConditionAlignment.POSITIVE) {
					formatting = TextFormatting.GREEN;
				}
				tooltip.add(new TranslationTextComponent("%s" + condition.getTranslationKey(), formatting));
			}
		}
	}
	
	public static void addStandardTooltip(ItemStack stack, List<ITextComponent> tooltip) {
		AlloyHelper.addStandardTooltip(stack, tooltip, true);
	}

	public static int getColor(ItemStack stack) {
		return fillDefaultProperties(stack.getTag()).getCompound("Properties").getInt("color");
	}
	
	public static void setColor(ItemStack stack, int color) {
		CompoundNBT nbt = AlloyHelper.fillDefaultProperties(stack);

		nbt.getCompound("Properties").putInt("color", color);
		stack.setTag(nbt);
	}
	
	public static boolean hasArmorCondition(ItemStack stack, ArmorCondition condition) {
		ListNBT conditions = AlloyHelper.fillDefaultProperties(stack).getList("conditions", Constants.NBT.TAG_STRING);
		
		for(int i=0;i<conditions.size();i++) {
			if(conditions.getString(i).equals(condition.getUnlocalizedName())) {
				return true;
			}
		}
		
		return false;
	}
	
	public static Set<ArmorCondition> getArmorConditions(ItemStack stack) {
		Set<ArmorCondition> armorConditions = new HashSet<ArmorCondition>();
		ListNBT nbt = AlloyHelper.fillDefaultProperties(stack).getList("conditions", Constants.NBT.TAG_STRING);
		
		for(int i=0;i<nbt.size();i++) {
			ArmorCondition condition = ArmorConditionRegistry.get(nbt.getString(i));
			
			// Ignore invalid conditions
			if(condition != null) {
				armorConditions.add(condition);
			}
		}
		
		return armorConditions;
	}
	
	public static int getStrength(ItemStack stack) {
		CompoundNBT nbt = stack.getTag();
		if(!nbt.contains("Properties")) {
			return -1;
		}
		CompoundNBT PropNBT = nbt.getCompound("Properties");
		if(!PropNBT.contains("strength")) {
			return -1;
		}
		return PropNBT.getInt("strength");
	}

	public static int getDurability(ItemStack stack) {
		CompoundNBT nbt = stack.getTag();
		if(!nbt.contains("Properties")) {
			return -1;
		}
		CompoundNBT PropNBT = nbt.getCompound("Properties");
		if(!PropNBT.contains("durability")) {
			return -1;
		}
		return PropNBT.getInt("durability");
	}

	public static int getWeight(ItemStack stack) {
		CompoundNBT nbt = stack.getTag();
		if(!nbt.contains("Properties")) {
			return -1;
		}
		CompoundNBT PropNBT = nbt.getCompound("Properties");
		if(!PropNBT.contains("weight")) {
			return -1;
		}
		return PropNBT.getInt("weight");
	}

	public static int getResistance(ItemStack stack) {
		CompoundNBT nbt = stack.getTag();
		if(!nbt.contains("Properties")) {
			return -1;
		}
		CompoundNBT PropNBT = nbt.getCompound("Properties");
		if(!PropNBT.contains("resistance")) {
			return -1;
		}
		return PropNBT.getInt("resistance");
	}

	public static int getRefractory(ItemStack stack) {
		CompoundNBT nbt = stack.getTag();
		if(!nbt.contains("Properties")) {
			return -1;
		}
		CompoundNBT PropNBT = nbt.getCompound("Properties");
		if(!PropNBT.contains("refractory")) {
			return -1;
		}
		return PropNBT.getInt("refractory");
	}
	
	public static float getEfficiency(ItemStack stack) {
		return AlloyHelper.getStrength(stack)/5 + 2;
	}
	
	public static int getDurabilityTool(ItemStack stack) {
		int x = AlloyHelper.getDurability(stack);
		return 100 * (int)(Math.pow(1.03, x)+x/10+2);
	}
	
	public static int getDurabilityArmor(ItemStack stack) {
		int x = AlloyHelper.getDurability(stack);
		return 40 * (int)(Math.pow(1.03, x)+x/10+2);
	}

	public static int getAttackDamage(ItemStack stack) {
		int strength = ((IAlloyItem)stack.getItem()).getStrength(stack);
		return (int) Math.round(Math.pow(1.03, strength) + 3 + strength/20);
	}
	
	public static int getAxeDamage(ItemStack stack) {
		int strength = ((IAlloyItem)stack.getItem()).getStrength(stack);
		return (int) Math.round(Math.pow(1.033, strength) + 3 + strength/20);
	}
}