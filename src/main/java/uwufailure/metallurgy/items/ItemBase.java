package uwufailure.metallurgy.items;

import net.minecraft.item.Item;
import uwufailure.metallurgy.Main;
import uwufailure.metallurgy.init.ModItems;
import uwufailure.metallurgy.util.Reference;

public class ItemBase extends Item {
	
	public ItemBase(String name) {
		super(new Item.Properties().maxStackSize(64).group(Main.UF2M_ITEM_GROUP));
		this.setRegistryName(Reference.MOD_ID, name);
	}
	
	public ItemBase(String name, int stackSize) {
		super(new Item.Properties().maxStackSize(stackSize).group(Main.UF2M_ITEM_GROUP));
		this.setRegistryName(Reference.MOD_ID, name);
		
		ModItems.ITEMS.add(this);
	}
}
