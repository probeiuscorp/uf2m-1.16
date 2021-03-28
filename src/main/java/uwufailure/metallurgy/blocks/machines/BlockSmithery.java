package uwufailure.metallurgy.blocks.machines;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import uwufailure.metallurgy.blocks.BlockBase;

public class BlockSmithery extends BlockBase {
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	
	public BlockSmithery() {
		super("smithery", Material.ROCK);
		
		setDefaultState(getDefaultState().with(FACING, Direction.NORTH));
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
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
