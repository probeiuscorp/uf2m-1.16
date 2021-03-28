package uwufailure.metallurgy.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import uwufailure.metallurgy.Main;
import uwufailure.metallurgy.blocks.BeaconReceiverBlock;
import uwufailure.metallurgy.blocks.BlockBase;
import uwufailure.metallurgy.blocks.machines.BlockSmithery;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block AQUAMARINE_ORE = new BlockBase("aquamarine_ore", Material.ROCK);
	public static final Block BAUXITE = new BlockBase("bauxite", Material.ROCK, ToolType.PICKAXE, 1, 3.0F, 15F);
	//public static final Block RUBBER_LOG = new BlockRubberLog();
	public static final Block TITANIUM_ORE = new BlockBase("titanium_ore", Material.ROCK, ToolType.PICKAXE, 3, 4.0F, 20F);		
	public static final Block TITANIUM_BLOCK = new BlockBase("titanium_block", Material.IRON, ToolType.PICKAXE, 3, 5.0F, 30F);
//	public static final Block ORANGE_PIPE = new BlockPipeBase("orange");
//	public static final Block WHITE_PIPE = new BlockPipeBase("white");
//	public static final Block MAGENTA_PIPE = new BlockPipeBase("magenta");
//	public static final Block LIGHT_BLUE_PIPE = new BlockPipeBase("light_blue");
//	public static final Block YELLOW_PIPE = new BlockPipeBase("yellow");
//	public static final Block LIME_PIPE = new BlockPipeBase("lime");
//	public static final Block PINK_PIPE = new BlockPipeBase("pink");
//	public static final Block GRAY_PIPE = new BlockPipeBase("gray");
//	public static final Block SILVER_PIPE = new BlockPipeBase("silver");
//	public static final Block CYAN_PIPE = new BlockPipeBase("cyan");
//	public static final Block PURPLE_PIPE = new BlockPipeBase("purple");
//	public static final Block BLUE_PIPE = new BlockPipeBase("blue");
//	public static final Block BROWN_PIPE = new BlockPipeBase("brown");
//	public static final Block GREEN_PIPE = new BlockPipeBase("green");
//	public static final Block RED_PIPE = new BlockPipeBase("red");
//	public static final Block BLACK_PIPE = new BlockPipeBase("black");
//	public static final Block JOINING_PIPE = new BlockJoiningPipe();
	
	public static final BeaconReceiverBlock BEACON_RECIEVER = new BeaconReceiverBlock("beacon_receiver", Material.ROCK);
	
	public static final BlockSmithery SMITHERY = new BlockSmithery();
	
	@SubscribeEvent
	public static void onBlocksRegistration(final RegistryEvent.Register<Block> blockRegisterEvent) {
		blockRegisterEvent.getRegistry().register(AQUAMARINE_ORE);
		blockRegisterEvent.getRegistry().register(BAUXITE);
		blockRegisterEvent.getRegistry().register(TITANIUM_ORE);
		blockRegisterEvent.getRegistry().register(TITANIUM_BLOCK);
//		blockRegisterEvent.getRegistry().register(ORANGE_PIPE);
//		blockRegisterEvent.getRegistry().register(WHITE_PIPE);
//		blockRegisterEvent.getRegistry().register(MAGENTA_PIPE);
//		blockRegisterEvent.getRegistry().register(LIGHT_BLUE_PIPE);
//		blockRegisterEvent.getRegistry().register(YELLOW_PIPE);
//		blockRegisterEvent.getRegistry().register(LIME_PIPE);
//		blockRegisterEvent.getRegistry().register(PINK_PIPE);
//		blockRegisterEvent.getRegistry().register(GRAY_PIPE);
//		blockRegisterEvent.getRegistry().register(SILVER_PIPE);
//		blockRegisterEvent.getRegistry().register(CYAN_PIPE);
//		blockRegisterEvent.getRegistry().register(PURPLE_PIPE);
//		blockRegisterEvent.getRegistry().register(BLUE_PIPE);
//		blockRegisterEvent.getRegistry().register(BROWN_PIPE);
//		blockRegisterEvent.getRegistry().register(GREEN_PIPE);
//		blockRegisterEvent.getRegistry().register(RED_PIPE);
//		blockRegisterEvent.getRegistry().register(BLACK_PIPE);
//		blockRegisterEvent.getRegistry().register(JOINING_PIPE);
		blockRegisterEvent.getRegistry().register(BEACON_RECIEVER);
		blockRegisterEvent.getRegistry().register(SMITHERY);
	}
	
	@SubscribeEvent
	public static void onItemsRegistration(final RegistryEvent.Register<Item> itemRegisterEvent) {
		register(itemRegisterEvent, AQUAMARINE_ORE);
		register(itemRegisterEvent, BAUXITE);
		register(itemRegisterEvent, TITANIUM_ORE);
		register(itemRegisterEvent, TITANIUM_BLOCK);
//		register(itemRegisterEvent, ORANGE_PIPE);
//		register(itemRegisterEvent, WHITE_PIPE);
//		register(itemRegisterEvent, LIGHT_BLUE_PIPE);
//		register(itemRegisterEvent, YELLOW_PIPE);
//		register(itemRegisterEvent, LIME_PIPE);
//		register(itemRegisterEvent, PINK_PIPE);
//		register(itemRegisterEvent, GRAY_PIPE);
//		register(itemRegisterEvent, SILVER_PIPE);
//		register(itemRegisterEvent, CYAN_PIPE);
//		register(itemRegisterEvent, PURPLE_PIPE);
//		register(itemRegisterEvent, BLUE_PIPE);
//		register(itemRegisterEvent, BROWN_PIPE);
//		register(itemRegisterEvent, GREEN_PIPE);
//		register(itemRegisterEvent, RED_PIPE);
//		register(itemRegisterEvent, BLACK_PIPE);
//		register(itemRegisterEvent, JOINING_PIPE);
		register(itemRegisterEvent, BEACON_RECIEVER);
		register(itemRegisterEvent, SMITHERY);
	}
	
	private static void register(final RegistryEvent.Register<Item> itemRegisterEvent, Block block) {
		register(itemRegisterEvent, block, 64);
	}
	
	private static void register(final RegistryEvent.Register<Item> itemRegisterEvent, Block block, int stackSize) {
		BlockItem itemBlock = new BlockItem(block, new Item.Properties().group(Main.UF2M_ITEM_GROUP).maxStackSize(stackSize));
		itemBlock.setRegistryName(block.getRegistryName());
		itemRegisterEvent.getRegistry().register(itemBlock);
	}
}
