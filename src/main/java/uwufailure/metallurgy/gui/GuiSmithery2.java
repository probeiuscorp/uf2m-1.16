package uwufailure.metallurgy.gui;
/*
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.recipebook.IRecipeShownListener;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import uwufailure.metallurgy.Main;
import uwufailure.metallurgy.containers.ContainerSmithery1;
import uwufailure.metallurgy.init.ModBlocks;
import uwufailure.metallurgy.init.ModItems;
import uwufailure.metallurgy.metals.Metal;
import uwufailure.metallurgy.util.Reference;
*/
public class GuiSmithery2 /*extends GuiContainer*/ {
//	private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/gui/smithery_gui_2.png");
//	//private static final ResourceLocation TEXTURE_3 = new ResourceLocation(Reference.MOD_ID + ":textures/gui/smithery_gui_3.png");
//	private static String BASE_STR = Reference.MOD_ID + ":textures/gui/smithery_gui_";
//	private final InventoryPlayer player;
//	private final World world;
//	private final BlockPos blockPos;
//	private final String name = I18n.format("tile.smithery.name");
//	/** What step on the GUI it is on (1: Default, list of available alloys; 2: 6x6 table for composition; 3: Final information, name etc.)*/
//	
//	private ArrayList<ItemStack> ingotItems = new ArrayList<>();
//	
//	private GuiButton buttonProceed;
//	private GuiButton buttonCancel;
//	
//	public GuiSmithery2(InventoryPlayer player, World worldIn, BlockPos pos) {
//		super(new ContainerSmithery1(player, worldIn, pos));
//		this.player = player;
//		this.world = worldIn;
//		this.blockPos = pos;
//		this.ySize = 222;
//		//ingotItems.add(new ItemStack(ModItems.ALLOY_INGOT, 1).setTagCompound(new NBTTagCompound().setTag("Properties", new NBTTag)));
//	}
//
//	@Override
//	public void initGui() {
//		super.initGui();
//
//		this.buttonProceed = (SmitheryButton)this.addButton(new SmitheryButton(0, this.guiLeft+11, this.guiTop+53));
//		this.buttonCancel = (SmitheryButton)this.addButton(new SmitheryButton(1, this.guiLeft+11, this.guiTop+73));
//	}
//	
//	@Override
//    public void updateScreen() {
//        super.updateScreen();
//    }
//	
//	@Override
//	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
//        this.drawDefaultBackground();
//        super.drawScreen(mouseX, mouseY, partialTicks);
//        this.renderHoveredToolTip(mouseX, mouseY);
//	}
//	
//	@Override
//	protected void actionPerformed(GuiButton button) throws IOException {
//		if(button.id == 0) {
//			
//		}
//		if(button.id == 1) {
//			player.player.openGui(Main.instance, Reference.GUI_SMITHERY_PAGE_1, world, blockPos.getX(), blockPos.getY(), blockPos.getZ());
//		}
//	}
//	
//	@Override
//	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
//		this.fontRenderer.drawString(this.name, (134 - this.fontRenderer.getStringWidth(this.name)/2) + 3, 6, 4210752);
//		this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
//	}
//	
//	@Override
//    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
//    {
//        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
//        this.mc.getTextureManager().bindTexture(this.TEXTURES);
//        this.drawTexturedModalRect(this.guiLeft, (this.height - this.ySize) / 2, 0, 0, this.xSize, this.ySize);
//
//        if(mouseX > this.guiLeft + 9 && mouseX < this.guiLeft + 28 && mouseY > this.guiTop + 51 && mouseY < this.guiTop + 70) {
//        	this.drawTexturedModalRect(this.guiLeft+10, this.guiTop+52, 176, 0, 18, 18);	
//        }
//    }
//	
//	@SideOnly(Side.CLIENT)
//	static class SmitheryButton extends GuiButton {
//
//        public SmitheryButton(int buttonId, int x, int y) {
//            super(buttonId, x, y, 18, 18, "");
//        }
//        
//        public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
//        	
//        }
//        	
//	}
//	
//	private boolean valid() {
//		return true;
//	}
}
