package uwufailure.metallurgy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BeaconReceiverBlock extends BlockBase {
	protected static final VoxelShape SHAPE = Block.makeCuboidShape(0D, 10D, 0D, 16D, 16D, 16D);
	public static final BooleanProperty ACTIVE = BooleanProperty.create("active");
	
	public BeaconReceiverBlock(String name, Material material) {
		super(name, material, ToolType.PICKAXE, 2, 3.0F, 15F);
		this.setDefaultState(this.stateContainer.getBaseState().with(ACTIVE, Boolean.valueOf(false)));
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
      builder.add(ACTIVE);
   }
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		updateIfValid(worldIn, pos, state);
	}
	
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		return !worldIn.isAirBlock(pos.up());
	}
	
	/**
	 * {@code pos} should be the location of the {@code BeaconReceiverBlock}
	 * @param world
	 * @param pos
	 * @param state
	 */
	public static void updateIfValid(World world, BlockPos pos, BlockState state) {
		boolean valid = false;
		BlockPos copy = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
		
		while(!World.isOutsideBuildHeight(pos)) {
			copy.down();
			BlockState copyState = world.getBlockState(copy);
			if(copyState.isIn(Blocks.BEACON)) {
				valid = true;
				break;
			} else if(!world.isAirBlock(copy)) {
				break;
			}
		}
		
		int topX = copy.getX() - 3;
		int topY = copy.getY();
		int topZ = copy.getZ() - 3;
		if(valid) {
			for(int layer=1;layer<=3;layer++) {
				int width = 1+layer*2;
				for(int x=0;x<width;x++) {
					for(int y=0;y<width;y++) {
						if(!world.getBlockState(new BlockPos(topX+x, topY-layer, topZ+y)).isIn(BlockTags.BEACON_BASE_BLOCKS)) {
							valid = false;
							break;
						}
					}
					if(!valid) break;
				}
				if(!valid) break;
			}
		}
		
		if(valid) System.out.println("Your beacon receiver is now active!");
		
		world.setBlockState(pos, state.with(ACTIVE, valid));
	}
	
	@Override
	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		return !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}
}
