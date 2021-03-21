package uwufailure.metallurgy.items;

import net.minecraft.item.Item;
import uwufailure.metallurgy.metals.Metal;

public interface IAlloyChip {
	public Metal getMetal();
	public Item getIngotParent();
}
