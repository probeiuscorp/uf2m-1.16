package uwufailure.metallurgy.creativetabs;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import uwufailure.metallurgy.init.ModItems;

public class UF2MItemGroup extends ItemGroup {
	public UF2MItemGroup() {
		super("uf2m");
	}
	
	@Override
	public ItemStack createIcon() {
		return new ItemStack(ModItems.RUBBER);
	}
}
