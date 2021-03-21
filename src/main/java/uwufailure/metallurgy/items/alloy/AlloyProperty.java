package uwufailure.metallurgy.items.alloy;

public enum AlloyProperty {
	STRENGTH,
	DURABILITY,
	WEIGHT,
	RESISTANCE,
	REFRACTORY;
	
	public static String propertyToString(AlloyProperty property) {
		switch(property) {
			case STRENGTH:
				return "strength";
			case DURABILITY:
				return "durability";
			case WEIGHT:
				return "weight";
			case RESISTANCE:
				return "resistance";
			case REFRACTORY:
				return "refractory";
			default:
				return null;
		}
	};
}
