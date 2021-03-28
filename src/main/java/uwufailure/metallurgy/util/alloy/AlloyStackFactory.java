package uwufailure.metallurgy.util.alloy;

import java.util.HashMap;
import java.util.Iterator;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.StringNBT;
import uwufailure.metallurgy.init.ModItems;
import uwufailure.metallurgy.metals.Metal;
import uwufailure.metallurgy.conditions.ArmorConditionRegistry;

public class AlloyStackFactory {
	public static ItemStack build(int strength, int durability, int weight, int resistance, int refractory, int color, HashMap<Metal, Integer> composition) {
		ItemStack stack = new ItemStack(ModItems.ALLOY_INGOT);
		CompoundNBT properties = new CompoundNBT();
		properties.putInt("strength", strength);
		properties.putInt("durability", durability);
		properties.putInt("weight", weight);
		properties.putInt("resistance", resistance);
		properties.putInt("refractory", refractory);
		properties.putInt("color", color);
		CompoundNBT tag = new CompoundNBT();
		tag.putBoolean("doRust", true);
		tag.putIntArray("rustCount", new int[] {0, 0, 0, 0, 0});
		tag.put("Properties", properties);

		int index = 0;
		ListNBT conditions = new ListNBT();
		Iterator<String> iterator = ArmorConditionRegistry.getKeyIterator();
		while(iterator.hasNext()) {
			String item = iterator.next();
			if(ArmorConditionRegistry.get(item).isConditionPresent(stack)) {
				conditions.add(index, StringNBT.valueOf(item));
			}
			index++;
		}
		tag.put("conditions", conditions);
		stack.setTag(tag);
		
		return stack;
	};
}