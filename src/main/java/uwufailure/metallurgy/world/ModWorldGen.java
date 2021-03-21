package uwufailure.metallurgy.world;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import uwufailure.metallurgy.init.ModBlocks;
import uwufailure.metallurgy.util.Reference;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModWorldGen {
//	@Override
//	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
//		if(world.provider.getDimension() == 0) {
//			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
//		}
//	}
//	
//	private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
//		generateOre(ModBlocks.AQUAMARINE_ORE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 20, 54, random.nextInt(4) + 2, 4);
//		if(world.getBiome(new BlockPos(chunkX*16,60,chunkZ*16)) == Biomes.OCEAN || world.getBiome(new BlockPos(chunkX*16,60,chunkZ*16)) == Biomes.DEEP_OCEAN || world.getBiome(new BlockPos(chunkX*16,60,chunkZ*16)) == Biomes.FROZEN_OCEAN) {
//			generateOre(ModBlocks.BAUXITE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 8, 48, random.nextInt(8) + 4, 3);
//		}
//	}
//	private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) {
//		int deltaY = maxY - minY;
//		
//		for(int i=0;i<chances;i++) {
//			BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));
//			
//			WorldGenMinable generator = new WorldGenMinable(ore, size);
//			generator.generate(world, random, pos);
//		}
//	}
	public static ConfiguredFeature<?, ?> BAUXITE_ORE_CONFIG;
	public static ConfiguredFeature<?, ?> AQUAMARINE_ORE_CONFIG;

	@SubscribeEvent
	public static void setup(FMLCommonSetupEvent event) {
		BAUXITE_ORE_CONFIG = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "ore_bauxite",
				Feature.ORE.withConfiguration(
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.BAUXITE.getDefaultState(), 15)));
		AQUAMARINE_ORE_CONFIG = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "ore_bauxite",
				Feature.ORE.withConfiguration(
						new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, ModBlocks.AQUAMARINE_ORE.getDefaultState(), 6)));
	}
	
	@SubscribeEvent
	public void onBiomeLoading(final BiomeLoadingEvent biome) {
		if(biome.getCategory() == Biome.Category.OCEAN) {
			biome.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> BAUXITE_ORE_CONFIG);
		}
		if(biome.getCategory() != Biome.Category.THEEND || biome.getCategory() != Biome.Category.NETHER) {
			biome.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> AQUAMARINE_ORE_CONFIG);
		}
	}
}