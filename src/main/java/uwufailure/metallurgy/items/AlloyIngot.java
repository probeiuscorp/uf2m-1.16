package uwufailure.metallurgy.items;

import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import uwufailure.metallurgy.conditions.ArmorCondition;
import uwufailure.metallurgy.items.alloy.AlloyHelper;
import uwufailure.metallurgy.items.alloy.IAlloyItem;

public class AlloyIngot extends ItemBase implements IAlloyItem {
	
	public AlloyIngot(String name) {
		super(name, new Item.Properties().maxStackSize(64));
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		if(worldIn == null) return; // Prevent pre-generating tooltips for the item search from crashing
		tooltip.add(new TranslationTextComponent("ufmm.tooltip.ingot.attack_damage", TextFormatting.BLUE, AlloyHelper.getAttackDamage(stack), TextFormatting.RESET));
		tooltip.add(new TranslationTextComponent("ufmm.tooltip.ingot.protection", TextFormatting.BLUE, AlloyArmor.getProtectionPercent(AlloyHelper.getStrength(stack)), TextFormatting.RESET));
		tooltip.add(new TranslationTextComponent("ufmm.tooltip.ingot.efficiency", TextFormatting.BLUE, AlloyHelper.getEfficiency(stack), TextFormatting.RESET));
		AlloyHelper.addStandardTooltip(stack, tooltip, false);
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