package uwufailure.metallurgy;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import uwufailure.metallurgy.creativetabs.UF2MItemGroup;
import uwufailure.metallurgy.util.Reference;

@Mod(Reference.MOD_ID)
public class Main {
	public static final UF2MItemGroup UF2M_ITEM_GROUP = new UF2MItemGroup();
	
	public Main() {
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		final ClientSideOnlyModEventRegistrar clientSideOnlyModEventRegistrar = new ClientSideOnlyModEventRegistrar(modEventBus);
		registerCommonEvents(modEventBus);
		DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> clientSideOnlyModEventRegistrar::registerClientOnlyEvents);
	}
	
	public void registerCommonEvents(IEventBus eventBus) {
		eventBus.register(uwufailure.metallurgy.init.ModItems.class);
		eventBus.register(uwufailure.metallurgy.init.ModBlocks.class);
	}
}
