package uwufailure.metallurgy.blocks;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import uwufailure.metallurgy.init.ModBlocks;

public class StartupClientOnly {
	@SubscribeEvent
	public static void onClientStartupEvent(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(ModBlocks.AQUAMARINE_ORE, RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(ModBlocks.BAUXITE, RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(ModBlocks.TITANIUM_ORE, RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(ModBlocks.TITANIUM_BLOCK, RenderType.getSolid());
		RenderTypeLookup.setRenderLayer(ModBlocks.SMITHERY, RenderType.getSolid());
	}
}