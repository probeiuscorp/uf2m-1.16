package uwufailure.metallurgy.containers;

import javax.annotation.Nullable;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import uwufailure.metallurgy.blocks.machines.slots.smithery.SlotSmitheryCraftInput;
import uwufailure.metallurgy.blocks.machines.slots.smithery.SlotSmitheryCraftOutput;
import uwufailure.metallurgy.init.ModBlocks;
import uwufailure.metallurgy.init.ModItems;
import uwufailure.metallurgy.inventory.InventorySmitheryCraftingInput;
import uwufailure.metallurgy.inventory.InventorySmitheryCraftingOutput;
import uwufailure.metallurgy.inventory.InventorySmitheryIngotSelection;
import uwufailure.metallurgy.inventory.InventorySmitheryRecipe;
import uwufailure.metallurgy.inventory.InventorySmitheryRecipeResult;
import uwufailure.metallurgy.inventory.slots.SlotDisplayOnly;

public class ContainerSmithery2 /*extends Container*/ {
//	
//	private final World world;
//	private final BlockPos pos;
//	private final EntityPlayer player;
//	
////	public InventorySmitheryCraftingInput craftingInput = new InventorySmitheryCraftingInput();
////	public InventorySmitheryCraftingOutput craftingOutput = new InventorySmitheryCraftingOutput();
////	public InventorySmitheryIngotSelection ingotSelect = new InventorySmitheryIngotSelection();
//	
//	public InventorySmitheryRecipe recipeInventory = new InventorySmitheryRecipe();
//	public InventorySmitheryRecipeResult recipeResult = new InventorySmitheryRecipeResult();
//	
//	public ContainerSmithery2(InventoryPlayer playerInventory, World worldIn, BlockPos posIn) {
//        this.world = worldIn;
//        this.pos = posIn;
//        this.player = playerInventory.player;
//        
//        // Crafting table
//        for(int i=0;i<6;i++) {
//        	for(int j=0;j<6;j++) {
//                this.addSlotToContainer(new SlotSmitheryCraftInput(recipeInventory, i*6+j, 35+18*i, 18+18*j));
//        	}
//        }
//        
//        this.addSlotToContainer(new SlotDisplayOnly(recipeResult, 0, 151, 65));
//        
//        // Player Inventory
//        for (int k = 0; k < 3; ++k)
//        {
//            for (int i1 = 0; i1 < 9; ++i1)
//            {
//                this.addSlotToContainer(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 140 + k * 18));
//            }
//        }
//
//        // Hotbar
//        for (int l = 0; l < 9; ++l)
//        {
//            this.addSlotToContainer(new Slot(playerInventory, l, 8 + l * 18, 198));
//        }
//	}
//
//	@Override
//	public boolean canInteractWith(EntityPlayer playerIn) {
//        return true;
//	}
//
//	@Override
//	public void onCraftMatrixChanged(IInventory inventory) {
//		
//	}
//	
//	@Override
//	public void onContainerClosed(EntityPlayer playerIn) {
//		// Put everything back into player's inventory
//		if(!this.world.isRemote) {
//			System.out.println("Smithery2 being closed");
//			this.clearContainer(playerIn, this.world, this.recipeInventory);
//		}
//    }
//	
//	@Override
//	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
//		Slot slot = (Slot) inventorySlots.get(index);
//        // If there is something in the stack to pick up
//        if (slot != null && slot.getHasStack()) {
//            // If the slot is one of the custom slots
//            if (slot.inventory.equals(recipeInventory)) {
//                // try to move to player inventory
//                if (!player.inventory.addItemStackToInventory(slot.getStack())) {
//                    return ItemStack.EMPTY;
//                }
//                slot.putStack(ItemStack.EMPTY);
//                slot.onSlotChanged();
//            }
//        }
//        return ItemStack.EMPTY;
//    }
//	
//	@Override
//	public ItemStack slotClick(int slotId, int dragType, ClickType clickTypeIn, EntityPlayer player) {
//
//	}
}
