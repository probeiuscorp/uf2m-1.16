package uwufailure.metallurgy.inventory;

public class InventorySmitheryRecipeResult {
//
//	private final NonNullList<ItemStack> stackList;
//	
//	public InventorySmitheryRecipeResult() {
//		stackList = NonNullList.<ItemStack>withSize(1, ItemStack.EMPTY);
//	}
//	
//	@Override
//	public String getName() {
//		return "container.smithery.recipe.result";
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
//		return 1;
//	}
//
//	@Override
//	public boolean isEmpty() {
//		return stackList.get(0).isEmpty();
//	}
//
//	@Override
//	public ItemStack getStackInSlot(int index) {
//		return index >= 1 ? ItemStack.EMPTY : stackList.get(index);
//	}
//
//	@Override
//	public ItemStack decrStackSize(int index, int count) {
//        return ItemStackHelper.getAndSplit(this.stackList, index, count);
//	}
//
//	@Override
//	public ItemStack removeStackFromSlot(int index) {
//        return ItemStackHelper.getAndRemove(this.stackList, index);
//	}
//
//	@Override
//	public void setInventorySlotContents(int index, ItemStack stack) {
//        if(index == 0) this.stackList.set(index, stack);
//        else System.out.println("[InventorySmitheryCraftingOutput#setInventorySlotContents] - Why are you trying to access index "+index+"?");
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
//		return true;
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
