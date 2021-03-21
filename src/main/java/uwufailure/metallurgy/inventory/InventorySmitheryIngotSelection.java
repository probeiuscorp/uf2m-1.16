package uwufailure.metallurgy.inventory;

public class InventorySmitheryIngotSelection {
//
//	private final NonNullList<ItemStack> stackList;
//	
//	public InventorySmitheryIngotSelection() {
//		stackList = NonNullList.<ItemStack>withSize(24, ItemStack.EMPTY);
//	}
//	
//	@Override
//	public String getName() {
//		return "container.smither.selection";
//	}
//
//	@Override
//	public boolean hasCustomName() {
//		return false;
//	}
//
//	@Override
//	public ITextComponent getDisplayName() {
//		return (ITextComponent)new TextComponentTranslation(this.getName());
//	}
//
//	@Override
//	public int getSizeInventory() {
//		return 24;
//	}
//
//	@Override
//	public boolean isEmpty() {
//		for(int i=0;i<24;i++) {
//			if(!stackList.get(i).isEmpty()) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	@Override
//	public ItemStack getStackInSlot(int index) {
//		return index >= 24 ? ItemStack.EMPTY : stackList.get(index);
//	}
//
//	@Override
//	public ItemStack decrStackSize(int index, int count) {
//        ItemStack itemstack = ItemStackHelper.getAndSplit(this.stackList, index, count);
//        
//        return itemstack;
//	}
//
//	@Override
//	public ItemStack removeStackFromSlot(int index) {
//        return ItemStackHelper.getAndRemove(this.stackList, index);
//	}
//
//	@Override
//	public void setInventorySlotContents(int index, ItemStack stack) {
//        if(index <= 8) this.stackList.set(index, stack);
//	}
//
//	@Override
//	public int getInventoryStackLimit() {
//		return 64;
//	}
//
//	@Override
//	public void markDirty() {
//		
//	}
//
//	@Override
//	public boolean isUsableByPlayer(EntityPlayer player) {
//		return true;
//	}
//
//	@Override
//	public void openInventory(EntityPlayer player) {
//		
//	}
//
//	@Override
//	public void closeInventory(EntityPlayer player) {
//
//	}
//
//	@Override
//	public boolean isItemValidForSlot(int index, ItemStack stack) {
//		return false;
//	}
//
//	@Override
//	public int getField(int id) {
//		return 0;
//	}
//
//	@Override
//	public void setField(int id, int value) {
//		
//	}
//
//	@Override
//	public int getFieldCount() {
//		return 0;
//	}
//
//	@Override
//	public void clear() {
//        this.stackList.clear();
//	}
}
