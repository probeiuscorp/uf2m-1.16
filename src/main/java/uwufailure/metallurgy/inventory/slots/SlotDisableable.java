package uwufailure.metallurgy.inventory.slots;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SlotDisableable extends Slot {
	private boolean enabled = true;
	
	public SlotDisableable(IInventory inventory, int index, int x, int y) {
		super(inventory, index, x, y);
	}
	
	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isEnabled() {
		return this.enabled;
	}
	
	/** Returns {@code this} for chaining */
	public SlotDisableable disable() {
		this.enabled = false;
		return this;
	}
	
	/** Returns {@code this} for chaining */
	public SlotDisableable enable() {
		this.enabled = true;
		return this;
	}
}
