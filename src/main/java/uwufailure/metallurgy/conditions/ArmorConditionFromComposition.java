package uwufailure.metallurgy.conditions;

import java.util.Set;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import uwufailure.metallurgy.items.alloy.AlloyHelper;
import uwufailure.metallurgy.items.alloy.IAlloyItem;

public class ArmorConditionFromComposition extends ArmorCondition {
	private Integer[] minStats;
	
	public ArmorConditionFromComposition(String unlocalizedName, ArmorConditionAlignment alignment, Set<IAlloyItem> validOn, Integer[] minStats) {
		super(unlocalizedName, alignment, validOn);
		
		this.minStats = minStats;
	}
	
	public Integer[] getMinStats() {
		return this.minStats;
	}
	
	@Override
	public boolean isConditionPresent(ItemStack stack) {
		CompoundNBT nbt = AlloyHelper.fillDefaultProperties(stack).getCompound("Properties");
		boolean meetsStats = true;

		if(nbt.getInt("strength") < minStats[0]) {
			meetsStats = false;
		} else if(nbt.getInt("durability") < minStats[1]) {
			meetsStats = false;
		} else if(nbt.getInt("weight") < minStats[2]) {
			meetsStats = false;
		} else if(nbt.getInt("resistance") < minStats[3]) {
			meetsStats = false;
		} else if(nbt.getInt("refractory") < minStats[4]) {
			meetsStats = false;
		}
		
		return meetsStats;
	}

}
