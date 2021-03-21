package uwufailure.metallurgy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import uwufailure.metallurgy.util.Reference;

public class BlockBase extends Block {
	public BlockBase(String name, Material material) {
		super(Block.Properties.create(material));
		this.setRegistryName(Reference.MOD_ID, name);
	}
	
	public BlockBase(String name, Material material, ToolType harvestTool) {
		super(Block.Properties.create(material).harvestTool(harvestTool));
		this.setRegistryName(Reference.MOD_ID, name);
	}
	
	public BlockBase(String name, Material material, ToolType harvestTool, int harvestLevel, float hardness, float resistance) {
		super(Block.Properties.create(material).hardnessAndResistance(hardness, resistance).harvestLevel(harvestLevel).harvestTool(harvestTool));
		this.setRegistryName(Reference.MOD_ID, name);
	}

//	@Override
//	public void registerModels() {
//		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
//	}
	@Override
	public BlockRenderType getRenderType(BlockState blockState) {
		return BlockRenderType.MODEL;
	}
}
