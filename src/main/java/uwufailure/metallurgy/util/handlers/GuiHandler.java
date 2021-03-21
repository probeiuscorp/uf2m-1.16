package uwufailure.metallurgy.util.handlers;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import uwufailure.metallurgy.containers.ContainerSmithery1;
import uwufailure.metallurgy.containers.ContainerSmithery2;
import uwufailure.metallurgy.gui.GuiSmithery2;
import uwufailure.metallurgy.util.Reference;

public class GuiHandler /*implements IGuiHandler*/ {
//	@Override
//	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
//		if(ID == Reference.GUI_SMITHERY_PAGE_1) return new ContainerSmithery1(player.inventory, world, new BlockPos(x,y,z));
//		else if(ID == Reference.GUI_SMITHERY_PAGE_2) return new ContainerSmithery2(player.inventory, world, new BlockPos(x,y,z)); 
//		return null;
//	}
//	
//	@Override
//	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
//		if(ID == Reference.GUI_SMITHERY_PAGE_1) return new GuiSmithery1(player.inventory, world, new BlockPos(x,y,z));
//		else if(ID == Reference.GUI_SMITHERY_PAGE_2) return new GuiSmithery2(player.inventory, world, new BlockPos(x,y,z));
//		return null;
//	}
}
