package uwufailure.metallurgy.blocks.machines.slots.smithery;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import uwufailure.metallurgy.inventory.slots.SlotDisableable;
import uwufailure.metallurgy.items.IAlloyChip;

public class SlotSmitheryCraftInput extends SlotDisableable {
	public SlotSmitheryCraftInput(IInventory inventory, int index, int x, int y) {
		super(inventory, index, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return stack.getItem() instanceof IAlloyChip;
	}
}
