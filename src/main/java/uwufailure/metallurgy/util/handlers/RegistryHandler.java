package uwufailure.metallurgy.util.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import uwufailure.metallurgy.Main;
import uwufailure.metallurgy.init.DimensionInit;
import uwufailure.metallurgy.init.ModBlocks;
import uwufailure.metallurgy.init.ModItems;
import uwufailure.metallurgy.util.IHasModel;

@EventBusSubscriber
public class RegistryHandler {
//	@SubscribeEvent
//	public static void onItemRegister(RegistryEvent.Register<Item> event) {
//		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
//	}
//	
//	@SubscribeEvent
//	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
//		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
//		TileEntityHandler.registerTileEntities();
//	}
//	
//	@SubscribeEvent
//	public static void onModelRegister(ModelRegistryEvent event) {
//		for(Item item : ModItems.ITEMS) {
//			if(item instanceof IHasModel) {
//				((IHasModel)item).registerModels();
//			}
//		}
//		
//		for(Block block : ModBlocks.BLOCKS) {
//			if(block instanceof IHasModel) {
//				((IHasModel)block).registerModels();
//			}
//		}
//	}
//	public static void preInitRegistries() {
//		DimensionInit.registerDimensions();
//	}
//	public static void serverRegistries(FMLServerStartingEvent event) {
//		event.registerServerCommand(new CommandDimensionTeleport());
//	}
//	public static void initRegistries(FMLInitializationEvent event) {
//		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
//	}
}
