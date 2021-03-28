package uwufailure.metallurgy.conditions;

import java.util.HashMap;
import java.util.Iterator;

public class ArmorConditionRegistry {
	private static HashMap<String, ArmorCondition> registry = new HashMap<String, ArmorCondition>();
	
	public static void register(ArmorCondition condition) {
		registry.put(condition.getUnlocalizedName(), condition);
	}
	
	public static ArmorCondition get(String unlocalizedName) {
		return registry.get(unlocalizedName);
	}
	
	public static Iterator<String> getKeyIterator() {
		return registry.keySet().iterator();
	}
}
