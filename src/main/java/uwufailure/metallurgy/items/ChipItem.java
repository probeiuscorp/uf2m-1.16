package uwufailure.metallurgy.items;

import net.minecraft.item.Item;
import uwufailure.metallurgy.metals.Metal;

public class ChipItem extends ItemBase {
	private Metal metal;
	private Item ingot;
	
	public ChipItem(String name, int stackSize, Metal metal, Item ingot) {
		super(name, stackSize);
		this.metal = metal;
		this.ingot = ingot;
	}
	
	public Metal getMetal() {
		return this.metal;
	}
	
	public Item getIngot() {
		return this.ingot;
	}
}
