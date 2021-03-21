package uwufailure.metallurgy.inventory.slots;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class SlotDisplayOnly extends SlotDisableable {
	
	public SlotDisplayOnly(IInventory inventory, int index, int x, int y) {
		super(inventory, index, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack) {
		return false;
	}
	
	@Override
	public boolean canTakeStack(PlayerEntity player) {
		return false;
	}
}
