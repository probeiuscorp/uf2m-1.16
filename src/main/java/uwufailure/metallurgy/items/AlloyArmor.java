package uwufailure.metallurgy.items;

import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import uwufailure.metallurgy.conditions.ArmorCondition;
import uwufailure.metallurgy.init.ModItems;
import uwufailure.metallurgy.items.alloy.AlloyHelper;
import uwufailure.metallurgy.items.alloy.IAlloyItem;
import uwufailure.metallurgy.util.Reference;

public class AlloyArmor extends ArmorItem implements IAlloyItem, IDyeableArmorItem {
	public static final float[] PIECE_FACTORS = new float[] { 3.0F, 6.0F, 8.0F, 3.0F };

	public AlloyArmor(String name, IArmorMaterial materialIn, EquipmentSlotType equipmentSlotIn, Item.Properties properties) {
		super(materialIn, equipmentSlotIn, properties.maxStackSize(1));
		this.setRegistryName(Reference.MOD_ID, name);
		
		ModItems.ITEMS.add(this);
	}
	

	@Override
	public boolean hasColor(ItemStack stack) {
		return true;
	}

	@Override
	public int getColor(ItemStack stack) {
		return AlloyHelper.getColor(stack);
	}

	@Override
	public void setColor(ItemStack stack, int color) {
		AlloyHelper.setColor(stack, color);
	}

	@Override
	public int getMaxDamage(ItemStack stack) {
		return AlloyHelper.getDurabilityArmor(stack);
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if(worldIn == null) return; // Prevent pre-generating tooltips for the item search from crashing
		tooltip.add(new TranslationTextComponent("ufmm.tooltip.armor.protection", TextFormatting.BLUE, AlloyArmor.getProtectionPercent(AlloyHelper.getStrength(stack))));
		AlloyHelper.addStandardTooltip(stack, tooltip);
	}

	public float pieceFactorSum() {
		return PIECE_FACTORS[0] + PIECE_FACTORS[1] + PIECE_FACTORS[2] + PIECE_FACTORS[3];
	}

	public int getProperty(ItemStack stack, String property) {
		CompoundNBT nbt = stack.getTag();

		if (nbt == null) {
			nbt = new CompoundNBT();
		}

		if (!nbt.contains("Properties")) {
			nbt.put("Properties", new CompoundNBT());
			nbt = AlloyHelper.fillDefaultProperties(nbt);
			stack.setTag(nbt);
		}

		CompoundNBT propertyTag = nbt.getCompound("Properties");

		return propertyTag.getInt(property);
	}
	
	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int par4, boolean isCurrentItem) {
		AlloyHelper.onRustTick(stack, world);
	}

	@Override
	public boolean hasArmorCondition(ItemStack stack, ArmorCondition condition) {
		return AlloyHelper.hasArmorCondition(stack, condition);
	}
	
	@Override
	public Set<ArmorCondition> getArmorConditions(ItemStack stack) {
		return AlloyHelper.getArmorConditions(stack);
	}

	// /give @s ufmm:alloy_chestplate 1 0 {Properties:{"color":123456,"strength":24,"durability":16,"weight":8,"resistance":4,"refractory":2},"rust":0,"rustTick":0,"nextRust":250}
	
	/** Takes a strength value and returns the protection percent */
	public static double getProtectionPercent(int strength) {
//      100 - 80*(1/2)^strength/20
		return 100 - 80*Math.pow(0.5, strength/20);
	}
	
	/** */
	public int calculateArmorDurability(int durability) {
		return durability * 10;
	}
	
	@Override
	public int getStrength(ItemStack stack) {
		return AlloyHelper.getStrength(stack);
	}
	
	@Override
	public int getDurability(ItemStack stack) {
		return AlloyHelper.getDurability(stack);
	}
	
	@Override
	public int getWeight(ItemStack stack) {
		return AlloyHelper.getWeight(stack);
	}
	
	@Override
	public int getResistance(ItemStack stack) {
		return AlloyHelper.getResistance(stack);
	}
	
	@Override
	public int getRefractory(ItemStack stack) {
		return AlloyHelper.getRefractory(stack);
	}
}
