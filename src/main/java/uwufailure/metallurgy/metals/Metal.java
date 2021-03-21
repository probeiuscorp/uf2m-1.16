package uwufailure.metallurgy.metals;

import net.minecraft.item.Item;

public class Metal {
	private Item baseItem;
	private int[] properties;
	private int tier;
	
	public Metal(Item baseItem, int[] properties, int tier) {
		this.baseItem = baseItem;
		this.properties = properties;
		this.tier = tier;
		
		MetalMap.add(baseItem, this);
	}
	
	public Item getBaseItem() {
		return this.baseItem;
	}
	
	public int[] getProperties() {
		return this.properties;
	}
	
	public int getTier() {
		return this.tier;
	}
	
	public int getStrength() {
		return properties[0];
	}
	
	public int getDurability() {
		return properties[1];
	}
	
	public int getWeight() {
		return properties[2];
	}
	
	public int getResistance() {
		return properties[3];
	}
	
	public int getRefractory() {
		return properties[4];
	}
}
