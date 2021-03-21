package uwufailure.metallurgy.metals;

import net.minecraft.item.Items;
import uwufailure.metallurgy.init.ModItems;

public class Metals {
	public static final Metal IRON = new Metal(Items.IRON_INGOT, new int[] {12, 45, 9, 18, 79}, 1);
	public static final Metal GOLD = new Metal(Items.GOLD_INGOT, new int[] {80, 4, 12, 18, 60}, 1);
	public static final Metal ALUMINUM = new Metal(ModItems.ALUMINUM, new int[] {19, 20, 47, 12, 8}, 1);
}
