package uwufailure.metallurgy.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import uwufailure.metallurgy.items.AlloyArmor;
import uwufailure.metallurgy.items.AlloyIngot;
import uwufailure.metallurgy.items.ChipItem;
import uwufailure.metallurgy.items.ItemBase;
import uwufailure.metallurgy.items.alloy.AlloyItemTier;
import uwufailure.metallurgy.items.alloy.AlloyMaterial;
import uwufailure.metallurgy.items.tools.AlloyAxe;
import uwufailure.metallurgy.items.tools.AlloyPickaxe;
import uwufailure.metallurgy.items.tools.AlloyShovel;
import uwufailure.metallurgy.items.tools.AlloySword;
import uwufailure.metallurgy.metals.Metals;

public class ModItems {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	// Items
	public static final Item AQUAMARINE = new ItemBase("aquamarine");
	public static final Item TITANIUM = new ItemBase("titanium");
	public static final Item URANIUM_ROD = new ItemBase("uranium_rod");
	public static final Item UNREFINED_URANIUM = new ItemBase("unrefined_uranium");
	public static final Item REFINED_URANIUM = new ItemBase("refined_uranium");
	public static final Item SAPPHIRE = new ItemBase("sapphire");
	public static final Item RUBBER = new ItemBase("rubber");
	public static final Item RUBBER_WOOD = new ItemBase("rubber_wood");
	public static final Item LATEX = new ItemBase("latex");
	public static final Item ALUMINUM = new ItemBase("aluminum");
	public static final Item ALLOY_INGOT = new AlloyIngot("alloy_ingot");
	public static final ChipItem IRON_CHIP = new ChipItem("iron_chip", 64, Metals.IRON, Items.IRON_INGOT);
	public static final ChipItem GOLD_CHIP = new ChipItem("gold_chip", 64, Metals.GOLD, Items.GOLD_INGOT);

	// Tools

	// Armor
	public static final AlloyMaterial ALLOY_MATERIAL = new AlloyMaterial();
	public static final AlloyArmor ALLOY_HELMET = new AlloyArmor("alloy_helmet", ALLOY_MATERIAL, EquipmentSlotType.HEAD, new Item.Properties());
	public static final AlloyArmor ALLOY_CHESTPLATE = new AlloyArmor("alloy_chestplate", ALLOY_MATERIAL, EquipmentSlotType.CHEST, new Item.Properties());
	public static final AlloyArmor ALLOY_LEGGINGS = new AlloyArmor("alloy_leggings", ALLOY_MATERIAL, EquipmentSlotType.LEGS, new Item.Properties());
	public static final AlloyArmor ALLOY_BOOTS = new AlloyArmor("alloy_boots", ALLOY_MATERIAL, EquipmentSlotType.FEET, new Item.Properties());

	public static final AlloyItemTier ALLOY_TOOL_ITEM_TIER = new AlloyItemTier();
	public static final AlloyPickaxe ALLOY_PICKAXE = new AlloyPickaxe("alloy_pickaxe", 0, 1, ALLOY_TOOL_ITEM_TIER);
	public static final AlloySword ALLOY_SWORD = new AlloySword("alloy_sword", 0, 1, ALLOY_TOOL_ITEM_TIER);
	public static final AlloyAxe ALLOY_AXE = new AlloyAxe("alloy_axe", 0, 1, ALLOY_TOOL_ITEM_TIER);
	public static final AlloyShovel ALLOY_SHOVEL = new AlloyShovel("alloy_shovel", 0, 1, ALLOY_TOOL_ITEM_TIER);
	
	@SubscribeEvent
	public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
		itemRegisterEvent.getRegistry().register(AQUAMARINE);
		itemRegisterEvent.getRegistry().register(TITANIUM);
		itemRegisterEvent.getRegistry().register(URANIUM_ROD);
		itemRegisterEvent.getRegistry().register(UNREFINED_URANIUM);
		itemRegisterEvent.getRegistry().register(REFINED_URANIUM);
		itemRegisterEvent.getRegistry().register(SAPPHIRE);
		itemRegisterEvent.getRegistry().register(RUBBER);
		itemRegisterEvent.getRegistry().register(RUBBER_WOOD);
		itemRegisterEvent.getRegistry().register(LATEX);
		itemRegisterEvent.getRegistry().register(ALUMINUM);
		itemRegisterEvent.getRegistry().register(ALLOY_INGOT);
		itemRegisterEvent.getRegistry().register(IRON_CHIP);
		itemRegisterEvent.getRegistry().register(GOLD_CHIP);
		
		itemRegisterEvent.getRegistry().register(ALLOY_HELMET);
		itemRegisterEvent.getRegistry().register(ALLOY_CHESTPLATE);
		itemRegisterEvent.getRegistry().register(ALLOY_LEGGINGS);
		itemRegisterEvent.getRegistry().register(ALLOY_BOOTS);
		itemRegisterEvent.getRegistry().register(ALLOY_PICKAXE);
		itemRegisterEvent.getRegistry().register(ALLOY_SWORD);
		itemRegisterEvent.getRegistry().register(ALLOY_AXE);
		itemRegisterEvent.getRegistry().register(ALLOY_SHOVEL);
	}
	
	@SubscribeEvent
	public static void onCommonSetupEvent(FMLCommonSetupEvent event) {
		
	}
}

// /give @s ufmm:alloy_legging{"Properties":{"strength":"2","durability":"3","color":"#aef546"}}