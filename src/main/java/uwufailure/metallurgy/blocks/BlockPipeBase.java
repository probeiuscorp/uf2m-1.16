package uwufailure.metallurgy.blocks;

public class BlockPipeBase /*extends BlockBase*/ {
//	public static final PropertyBool UP = PropertyBool.create("up");
//	public static final PropertyBool DOWN = PropertyBool.create("down");
//    public static final PropertyBool NORTH = PropertyBool.create("north");
//    public static final PropertyBool EAST = PropertyBool.create("east");
//    public static final PropertyBool SOUTH = PropertyBool.create("south");
//    public static final PropertyBool WEST = PropertyBool.create("west");
//    
//    private static double q = 1/4;
//	public static final AxisAlignedBB CENTER_AABB = new AxisAlignedBB(q, q, q, 1-q, 1-q, 1-q);
//	public static final AxisAlignedBB NORTH_AABB = new AxisAlignedBB( q, q, 1-q, 1-q, 1-q, 1);
//	public static final AxisAlignedBB SOUTH_AABB = new AxisAlignedBB( q,1-q,q,1-q,1,1-q);
//	public static final AxisAlignedBB EAST_AABB = new AxisAlignedBB(  1-q,q,q,1,1-q,1-q);
//	public static final AxisAlignedBB WEST_AABB = new AxisAlignedBB(  0,q,q,q,1-q,1-q);
//	public static final AxisAlignedBB UP_AABB = new AxisAlignedBB(    q,1-q,q,1-q,1,1-q);
//	public static final AxisAlignedBB DOWN_AABB = new AxisAlignedBB(  q,0,q,1-q,1,1-q);
//	private static final AxisAlignedBB[] BOUNDING_BOXES = calculateAABB();
//	
//	public BlockPipeBase(String name) {
//		super(name+"_pipe", Material.ROCK);
//        this.setDefaultState(this.blockState.getBaseState().withProperty(NORTH, false).withProperty(SOUTH, false).withProperty(WEST, false).withProperty(EAST, false).withProperty(DOWN, true).withProperty(UP, true));
//     }
//
//	public static boolean isPipe(Block block) {
//		return BlockPipeBase.class.isInstance(block);
//	} 
//	
//	@Override
//	public boolean isOpaqueCube(IBlockState state) {
//		return false;
//	}
//	@Override
//	public boolean isFullCube(IBlockState state) {
//		return false;
//	}
//	
//	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
//        if (!isActualState) {
//            state = state.getActualState(worldIn, pos);
//        }
//
//        addCollisionBoxToList(pos, entityBox, collidingBoxes, CENTER_AABB);
//
//        if (((Boolean)state.getValue(NORTH)).booleanValue()) {
//            addCollisionBoxToList(pos, entityBox, collidingBoxes, NORTH_AABB);
//        }
//
//        if (((Boolean)state.getValue(EAST)).booleanValue()) {
//            addCollisionBoxToList(pos, entityBox, collidingBoxes, EAST_AABB);
//        }
//
//        if (((Boolean)state.getValue(SOUTH)).booleanValue()) {
//            addCollisionBoxToList(pos, entityBox, collidingBoxes, SOUTH_AABB);
//        }
//
//        if (((Boolean)state.getValue(WEST)).booleanValue()) {
//            addCollisionBoxToList(pos, entityBox, collidingBoxes, WEST_AABB);
//        }
//        
//        if (((Boolean)state.getValue(UP)).booleanValue()) {
//            addCollisionBoxToList(pos, entityBox, collidingBoxes, EAST_AABB);
//        }
//        
//        if (((Boolean)state.getValue(DOWN)).booleanValue())  {
//            addCollisionBoxToList(pos, entityBox, collidingBoxes, DOWN_AABB);
//        }
//    }
//	@Override
//	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
//        state = this.getActualState(state, source, pos);
//		return BOUNDING_BOXES[getBoundingBoxIdx(state)];
//	}
//	
//	protected BlockStateContainer createBlockState() {
//        return new BlockStateContainer(this, new IProperty[] {UP, DOWN, NORTH, EAST, SOUTH, WEST});
//    }
//	
//	public IBlockState getStateFromMeta(int meta) {
//	    return this.getDefaultState();
//	}
//
//	// Working
//	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
//		boolean[] flags = new boolean[6];
//        flags[0] = canPipeConnectTo(worldIn, pos, EnumFacing.NORTH);
//        flags[1] = canPipeConnectTo(worldIn, pos, EnumFacing.EAST);
//        flags[2] = canPipeConnectTo(worldIn, pos, EnumFacing.DOWN);
//        flags[3] = canPipeConnectTo(worldIn, pos, EnumFacing.SOUTH);
//        flags[4] = canPipeConnectTo(worldIn, pos, EnumFacing.WEST);
//        flags[5] = canPipeConnectTo(worldIn, pos, EnumFacing.UP);
//        int connections = 0; 
//        int last = 0;
//        for(int i=0;i<flags.length;i++) {
//        	if(flags[i]) {
//        		connections++;
//        		last = i;
//        	}
//        }
//        
//        if(connections==0) {
//        	flags[2] = true;
//        	flags[5] = true;
//        }
//        
//        if(connections==1) {
//        	flags[(last+3)%6] = true;
//        }
//        
//        return state.withProperty(NORTH, flags[0]).withProperty(EAST, flags[1]).withProperty(DOWN, flags[2]).withProperty(SOUTH, flags[3]).withProperty(WEST, flags[4]).withProperty(UP, flags[5]);
//        //boolean flag4 = flag && !flag1 && flag2 && !flag3 || !flag && flag1 && !flag2 && flag3;
//        //return state.withProperty(UP, Boolean.valueOf(!flag4 || !worldIn.isAirBlock(pos.up()))).withProperty(NORTH, Boolean.valueOf(flag)).withProperty(EAST, Boolean.valueOf(flag1)).withProperty(SOUTH, Boolean.valueOf(flag2)).withProperty(WEST, Boolean.valueOf(flag3));
//    }
//	
//	
//	public int getMetaFromState(IBlockState state) {
//		return 0;
//	}
//	
//	private static int getBoundingBoxIdx(IBlockState state) {
//		/*
//        int i = 0;
//
//        if (((Boolean)state.getValue(NORTH)).booleanValue()) {
//            i |= 1 << EnumFacing.NORTH.getHorizontalIndex();
//        }
//
//        if (((Boolean)state.getValue(EAST)).booleanValue()) {
//            i |= 1 << EnumFacing.EAST.getHorizontalIndex();
//        }
//
//        if (((Boolean)state.getValue(SOUTH)).booleanValue()) {
//            i |= 1 << EnumFacing.SOUTH.getHorizontalIndex();
//        }
//
//        if (((Boolean)state.getValue(WEST)).booleanValue()) {
//            i |= 1 << EnumFacing.WEST.getHorizontalIndex();
//        }
//        
//        if (((Boolean)state.getValue(UP)).booleanValue()) {
//            i |= 1 << EnumFacing.UP.getHorizontalIndex();
//        }
//        
//        if (((Boolean)state.getValue(DOWN)).booleanValue()) {
//            i |= 1 << EnumFacing.DOWN.getHorizontalIndex();
//        }
//
//        System.out.println(i);
//        return i;
//        */
//		int i = 0;
//		if(state.getValue(NORTH).booleanValue()) {
//			i+=32;
//		}
//		if(state.getValue(SOUTH).booleanValue()) {
//			i+=16;
//		}
//		if(state.getValue(EAST).booleanValue()) {
//			i+=8;
//		}
//		if(state.getValue(WEST).booleanValue()) {
//			i+=4;
//		}
//		if(state.getValue(UP).booleanValue()) {
//			i+=2;
//		}
//		if(state.getValue(DOWN).booleanValue()) {
//			i+=1;
//		}
//		
//		return i;
//    }
//	
//	protected boolean canPipeConnectTo(IBlockAccess worldIn, BlockPos pos, EnumFacing facing) {
//		BlockPos other = pos.offset(facing);
//		Block block = worldIn.getBlockState(other).getBlock();
//		return block == this || block == ModBlocks.JOINING_PIPE;
//	}
//	
//	private static AxisAlignedBB calculateBB(int connectionsBin) {
//		AxisAlignedBB aabb;
//		
//		boolean[] c = new boolean[6];
//		for(int i=0;i<6;i++) {
//			int tempbin = connectionsBin;
//			c[5 - i] = ((tempbin >> i) & 1) == 1;
//		}
//		System.out.println(c);
//		
//		double offsetX = 0, offsetY = 0, offsetZ = 0;
//		double insetX = 1, insetY = 1, insetZ = 1;
//		if(c[0]) insetZ = 0.75;
//		if(c[3]) offsetZ = 0.25;
//		if(c[1]) insetX = 0.75;
//		if(c[4]) offsetX = 0.25;
//		if(c[5]) insetY = 0.75;
//		if(c[2]) offsetY = 0.25;
//		aabb = new AxisAlignedBB(offsetX, offsetY, offsetZ, insetX, insetY, insetZ);
//		return aabb;
//	}
//	
//	private static AxisAlignedBB[] calculateAABB() {
//		
//		AxisAlignedBB[] aabbs = new AxisAlignedBB[64];
//		
//		for(int i = 0;i<64;i++) {
//			aabbs[i] = calculateBB(i);
//		}
//		
//		return aabbs;
//	}
//	
}
