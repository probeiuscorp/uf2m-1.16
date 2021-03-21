package uwufailure.metallurgy.util.alloy;

import java.io.File;
import java.util.ArrayList;

public class Alloy {
	public String name;
	public int hue;
	public ArrayList<AlloyComponent> composition;
	public int[] properties;
	
	public Alloy(String name, int hue, ArrayList<AlloyComponent> composition) {
		
	}
	
	/**
	 * Returns {@code null} if there was a problem, like malformed JSON
	 */
	public static Alloy alloyFromJSON(File json) {
		if(!json.exists() || !json.isFile() || !json.canRead()) {
			return null;
		}
		
		return new Alloy("robert",128,new ArrayList<AlloyComponent>());
	}
}
