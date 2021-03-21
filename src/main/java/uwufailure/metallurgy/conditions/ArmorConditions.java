package uwufailure.metallurgy.conditions;

import java.util.Set;

import com.google.common.collect.Sets;

import uwufailure.metallurgy.items.alloy.IAlloyItem;

public class ArmorConditions {
	/** Loads class so constructors are called. Not ideal, probably should change later */
	public static void loadClass() {}
	
	private static final Set<IAlloyItem> ALL = Sets.newHashSet();
//	private static final Set<IAlloyItem> ARMOR = Sets.newHashSet(ModItems.ALLOY_HELMET, ModItems.ALLOY_CHESTPLATE, ModItems.ALLOY_LEGGINGS, ModItems.ALLOY_BOOTS);
//	private static final Set<IAlloyItem> TOOLS = Sets.newHashSet(ModItems.ALLOY_PICKAXE);
	
	public static final ArmorCondition BRITTLE = new ArmorConditionBrittle("brittle", ArmorConditionAlignment.NEGATIVE, ALL);
	public static final ArmorCondition HEAT_RESISTANT = new ArmorConditionFromProperties("heat_resistant", ArmorConditionAlignment.POSITIVE, ALL, new Integer[] {0, 0, 0, 0, 60});
}
