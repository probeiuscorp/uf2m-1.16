package uwufailure.metallurgy.items.tools;

import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import uwufailure.metallurgy.Main;
import uwufailure.metallurgy.conditions.ArmorCondition;
import uwufailure.metallurgy.init.ModItems;
import uwufailure.metallurgy.items.alloy.AlloyHelper;
import uwufailure.metallurgy.items.alloy.IAlloyItem;

public class AlloySword extends SwordItem implements IAlloyItem {
	
	public AlloySword (String name, int attackDamage, float attackSpeed, IItemTier material) {
		
		super(material, attackDamage, attackSpeed, (new Item.Properties()));
		setRegistryName(name);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if(worldIn == null) return; // Prevent pre-generating tooltips for the item search from crashing
		tooltip.add(new TranslationTextComponent("ufmm.tooltip.sword.attack_damage", TextFormatting.BLUE, AlloyHelper.getAttackDamage(stack), TextFormatting.RESET));
		AlloyHelper.addStandardTooltip(stack, tooltip);
	}
	
	@Override
	public void inventoryTick(ItemStack stack, World world, Entity entity, int par4, boolean isCurrentItem) {
		AlloyHelper.onRustTick(stack, world);
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
	public boolean hasArmorCondition(ItemStack stack, ArmorCondition condition) {
		return AlloyHelper.hasArmorCondition(stack, condition);
	}

	@Override
	public Set<ArmorCondition> getArmorConditions(ItemStack stack) {
		return AlloyHelper.getArmorConditions(stack);
	}
	
	/**
	 * Not my code! Copied from one of Choonster's GitHub's.
	 */
//	@Override
//	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
//		final Multimap<String, AttributeModifier> modifiers = super.getAttributeModifiers(slot, stack);
//
//		if (slot == EntityEquipmentSlot.MAINHAND) {
//			replaceModifier(modifiers, SharedMonsterAttributes.ATTACK_DAMAGE, ATTACK_DAMAGE_MODIFIER, (AlloyHelper.getAttackDamage(stack)-4), "Add");
//			replaceModifier(modifiers, SharedMonsterAttributes.ATTACK_SPEED, ATTACK_SPEED_MODIFIER, 1-(float)this.getWeight(stack)/50, "Add");
////			System.out.println(this.getWeight(stack) + " | " + ((float)this.getWeight(stack)/50-1));
//		}
//
//		return modifiers;
//	}
//    
//	/**
//	 * Not my code! Also copied from Choonster.
//	 * 
//	 * @param operationModifier Accepts "Multiply", "Add" - Too lazy to add an Enum for this simple method
//	 */
//	private void replaceModifier(Multimap<String, AttributeModifier> modifierMultimap, IAttribute attribute, UUID id, double operationModifier, String operation) {
//		// Get the modifiers for the specified attribute
//		final Collection<AttributeModifier> modifiers = modifierMultimap.get(attribute.getName());
//
//		// Find the modifier with the specified ID, if any
//		final Optional<AttributeModifier> modifierOptional = modifiers.stream().filter(attributeModifier -> attributeModifier.getID().equals(id)).findFirst();
//
//		if (modifierOptional.isPresent()) { // If it exists,
//			final AttributeModifier modifier = modifierOptional.get();
//			modifiers.remove(modifier); // Remove it
//			if(operation == "Multiply") {
//				modifiers.add(new AttributeModifier(modifier.getID(), modifier.getName(), modifier.getAmount() * operationModifier, modifier.getOperation())); // Add the new modifier
//			} else if(operation == "Add") {
//				modifiers.add(new AttributeModifier(modifier.getID(), modifier.getName(), modifier.getAmount() + operationModifier, modifier.getOperation()));
//			}
//		}
//	}
	@Override
	public int getMaxDamage(ItemStack stack) {
		return AlloyHelper.getDurabilityTool(stack);
	}
	
	public int getStrength(ItemStack stack) {
		return AlloyHelper.getStrength(stack);
	}
	
	public int getDurability(ItemStack stack) {
		return AlloyHelper.getDurability(stack);
	}
	
	public int getWeight(ItemStack stack) {
		return AlloyHelper.getWeight(stack);
	}
	
	public int getResistance(ItemStack stack) {
		return AlloyHelper.getResistance(stack);
	}
	
	public int getRefractory(ItemStack stack) {
		return AlloyHelper.getRefractory(stack);
	}
}
