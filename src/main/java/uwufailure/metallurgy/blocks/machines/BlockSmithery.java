package uwufailure.metallurgy.blocks.machines;

import net.minecraft.block.material.Material;
import uwufailure.metallurgy.blocks.BlockBase;

public class BlockSmithery extends BlockBase {
	
	public BlockSmithery() {
		super("smithery", Material.ROCK);
	}
	
//	@Override
//	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
//		if(!worldIn.isRemote) {
//			player.openGui(Main.instance, Reference.GUI_SMITHERY_PAGE_1, worldIn, pos.getX(), pos.getY(), pos.getY());
//		}
//		
//		return true;
//	}
}
