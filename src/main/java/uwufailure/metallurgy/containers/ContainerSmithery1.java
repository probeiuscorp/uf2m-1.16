package uwufailure.metallurgy.containers;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.network.PacketBuffer;

public class ContainerSmithery1 /*extends Container*/ {
	
//	private final World world;
//	private final BlockPos pos;
//	private final EntityPlayer player;
//	
//	private int ingotX = -1, ingotY = -1;
//	
//	public InventorySmitheryCraftingInput craftingInput = new InventorySmitheryCraftingInput();
//	public InventorySmitheryCraftingOutput craftingOutput = new InventorySmitheryCraftingOutput();
//	public InventorySmitheryIngotSelection ingotSelect = new InventorySmitheryIngotSelection();
//	
//	public InventorySmitheryRecipe recipeInventory = new InventorySmitheryRecipe();
//	public InventorySmitheryRecipeResult recipeResult = new InventorySmitheryRecipeResult();
//	
//	public ContainerSmithery1(InventoryPlayer playerInventory, World worldIn, BlockPos posIn) {
//        this.world = worldIn;
//        this.pos = posIn;
//        this.player = playerInventory.player;
//
//        // Crafting Matrix
//        for(int i=0;i<3;i++) {
//        	for(int j=0;j<3;j++) {
//                this.addSlotToContainer(new SlotSmitheryCraftInput(craftingInput, i*3+j, 109+18*i, 18+18*j));
//        	}
//        }
//        
//        // Crafting Output
//        this.addSlotToContainer(new SlotSmitheryCraftOutput(craftingOutput, 0, 127, 78));
//        
//        // Recipe Crafting Matrix
//        for(int i=0;i<6;i++) {
//        	for(int j=0;j<6;j++) {
//                this.addSlotToContainer(new SlotSmitheryCraftInput(recipeInventory, i*6+j, 35+18*i, 18+18*j).disable());
//        	}
//        }
//        
//        // Recipe Result
//        this.addSlotToContainer(new SlotDisplayOnly(recipeResult, 0, 150, 64).disable());
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
//        for (int l = 0; l < 9; ++l)
//        {
//            this.addSlotToContainer(new Slot(playerInventory, l, 8 + l * 18, 198));
//        }
//        
//        for(int i=0;i<4;i++) {
//        	for(int j=0;j<6;j++) {
//        		this.addSlotToContainer(new SlotDisplayOnly(ingotSelect, i*6+j, 8+18*i, 18+18*j));
//        	}
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
//		if(this.craftingInput.getStackInSlot(0).getItem() == ModItems.GOLD_CHIP) {
//			this.craftingOutput.setInventorySlotContents(0, new ItemStack(Items.GOLD_INGOT, 4));
//		} else {
//			this.craftingOutput.setInventorySlotContents(0, ItemStack.EMPTY);
//		}
//	}
//
//	@Override
//	public void onContainerClosed(EntityPlayer playerIn) {
//		super.onContainerClosed(playerIn);
//		
//		// Put everything back into player's inventory
//		if(!this.world.isRemote) {
//			this.clearContainer(playerIn, this.world, this.craftingInput);
//		}
//		
//		System.out.println("Smithery1 being closed");
//    }
//	
//	@Override
//	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
//		Slot slot = (Slot) inventorySlots.get(index);
//        // If there is something in the stack to pick up
//        if (slot != null && slot.getHasStack()) {
//            // If the slot is one of the custom slots
//            if (slot.inventory.equals(craftingOutput) || slot.inventory.equals(craftingInput)) {
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
//		Slot slot = (Slot) this.inventorySlots.get(slotId);
//		int realId = this.inventorySlots.get(slotId).getSlotIndex();
//		
//		if(slot.inventory == this.ingotSelect) {
//			int ingotX = (int) Math.floor((realId)/6.0F);
//			int ingotY = (realId) % 6;
//			
//			if(ingotX != this.ingotX || ingotY != this.ingotY) {
//				this.ingotX = ingotX;
//				this.ingotY = ingotY;
//				player.playSound(SoundEvents.UI_BUTTON_CLICK, 0.2F, 1.0F);
//			}
//		}
//		
//		return super.slotClick(slotId, dragType, clickTypeIn, player);
//	}
//	
//	public void toggleSlotStatesForPage1() {
//		Slot slot;
//		IInventory inventory;
//		for(int i=0;i<this.inventorySlots.size();i++) {
//			slot = this.inventorySlots.get(i);
//			if(slot instanceof SlotDisableable) {
//				inventory = slot.inventory;
//				if(inventory == this.craftingInput) {
//					((SlotDisableable) slot).enable();
//				} else if(inventory == this.craftingOutput) {
//					((SlotDisableable) slot).enable();
//				} else if(inventory == this.ingotSelect) {
//					((SlotDisableable) slot).enable();
//				} else if(inventory == this.recipeInventory) {
//					((SlotDisableable) slot).disable();
//				} else if(inventory == this.recipeResult) {
//					((SlotDisableable) slot).disable();
//				}
//			}
//		}
//	}
//	
//	public void toggleSlotStatesForPage2() {
//		Slot slot;
//		IInventory inventory;
//		for(int i=0;i<this.inventorySlots.size();i++) {
//			slot = this.inventorySlots.get(i);
//			if(slot instanceof SlotDisableable) {
//				inventory = slot.inventory;
//				if(inventory == this.craftingInput) {
//					((SlotDisableable) slot).disable();
//				} else if(inventory == this.craftingOutput) {
//					((SlotDisableable) slot).disable();
//				} else if(inventory == this.ingotSelect) {
//					((SlotDisableable) slot).disable();
//				} else if(inventory == this.recipeInventory) {
//					((SlotDisableable) slot).enable();
//				} else if(inventory == this.recipeResult) {
//					((SlotDisableable) slot).enable();
//				}
//			}
//		}
//	}
//	
//	public void toggleSlotStatesForPage3() {
//		
//	}
//	
//	public int getIngotX() { return this.ingotX; }
//	
//	public int getIngotY() { return this.ingotY; }
}
