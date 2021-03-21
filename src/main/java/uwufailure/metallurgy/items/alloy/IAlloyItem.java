package uwufailure.metallurgy.items.alloy;

import java.util.Set;

import net.minecraft.item.ItemStack;
import uwufailure.metallurgy.conditions.ArmorCondition;

public interface IAlloyItem {
	public int getColor(ItemStack stack);
	
	public void setColor(ItemStack stack, int color);
	
	public boolean hasArmorCondition(ItemStack stack, ArmorCondition condition);
	public Set<ArmorCondition> getArmorConditions(ItemStack stack);
	
	public int getStrength(ItemStack stack);
	public int getDurability(ItemStack stack);
	public int getWeight(ItemStack stack);
	public int getResistance(ItemStack stack);
	public int getRefractory(ItemStack stack);
}
