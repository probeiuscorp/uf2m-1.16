package uwufailure.metallurgy.conditions;

import java.util.HashMap;

public class ArmorConditionMap {
	private static HashMap<String, ArmorCondition> map = new HashMap<String, ArmorCondition>();
	
	public static void add(String unlocalizedName, ArmorCondition condition) {
		map.put(unlocalizedName, condition);
	}
	
	public static ArmorCondition get(String unlocalizedName) {
		return map.get(unlocalizedName);
	}
}
