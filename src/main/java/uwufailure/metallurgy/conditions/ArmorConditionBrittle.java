package uwufailure.metallurgy.conditions;

import java.util.Set;

import net.minecraft.item.ItemStack;
import uwufailure.metallurgy.items.alloy.IAlloyItem;

public class ArmorConditionBrittle extends ArmorCondition {
	
	public ArmorConditionBrittle(String unlocalizedName, ArmorConditionAlignment alignment, Set<IAlloyItem> validOn) {
		super(unlocalizedName, alignment, validOn);
	}
	
	public boolean isConditionPresent(ItemStack stack) {
		return true;
	}
}
