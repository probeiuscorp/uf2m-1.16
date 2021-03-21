package uwufailure.metallurgy.blocks.machines.slots.smithery;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import uwufailure.metallurgy.inventory.slots.SlotDisableable;

public class SlotSmitheryCraftOutput extends SlotDisableable {
	
	public SlotSmitheryCraftOutput(IInventory inventory, int index, int x, int y) {
		super(inventory, index, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return false;
	}
}
