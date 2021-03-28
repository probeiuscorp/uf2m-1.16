package uwufailure.metallurgy.conditions;

import java.util.Set;

import net.minecraft.item.ItemStack;
import uwufailure.metallurgy.items.alloy.IAlloyItem;

public abstract class ArmorCondition {
	private ArmorConditionAlignment alignment;
	private Set<IAlloyItem> validOn;
	private String unlocalizedName;
	
	public ArmorCondition(String unlocalizedName, ArmorConditionAlignment alignment, Set<IAlloyItem> validOn) {
		this.alignment = alignment;
		this.validOn = validOn;
		this.unlocalizedName = unlocalizedName;
		
		ArmorConditionRegistry.register(this);
	}
	
	public ArmorConditionAlignment getAlignment() {
		return this.alignment;
	}
	
	public Set<IAlloyItem> getEquipmentValidOn() {
		return this.validOn;
	}
	
	public String getUnlocalizedName() {
		return this.unlocalizedName;
	}
	
	public String getTranslationKey() {
		return "ufmm.armorcondition."+this.unlocalizedName;
	}
	
	/** Called when the ItemStack is created in the Metallurgist's Table and when it rusts. */
	public abstract boolean isConditionPresent(ItemStack stack);
}