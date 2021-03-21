package uwufailure.metallurgy.items;

import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import uwufailure.metallurgy.conditions.ArmorCondition;
import uwufailure.metallurgy.items.alloy.AlloyHelper;
import uwufailure.metallurgy.items.alloy.IAlloyItem;
import uwufailure.metallurgy.util.IHasModel;
import java.util.Scanner;

public class AlloyIngot extends ItemBase implements IAlloyItem {
	
	public AlloyIngot(String name) {
		super(name, 64);
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		NBTTagCompound nbt = AlloyHelper.fillDefaultProperties(stack);
		tooltip.add(TextFormatting.BLUE + "Attack Damage: " + AlloyHelper.getAttackDamage(stack));
		tooltip.add(TextFormatting.BLUE + "Protection Percent: " + AlloyArmor.getProtectionPercent(AlloyHelper.getStrength(stack)));
		tooltip.add(TextFormatting.BLUE + "Efficiency: " + AlloyHelper.getEfficiency(stack));
		tooltip.add("");
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