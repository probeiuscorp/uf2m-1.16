package uwufailure.metallurgy.metals;

import java.util.HashMap;
import net.minecraft.item.Item;

public class MetalMap {
	private static HashMap<Item, Metal> map = new HashMap<Item, Metal>();
	
	public static void add(Item baseItem, Metal metal) {
		map.put(baseItem, metal);
	}
	
	public static Metal get(Item baseItem) {
		return map.get(baseItem);
	}
}
