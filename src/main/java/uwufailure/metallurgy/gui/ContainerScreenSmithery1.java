package uwufailure.metallurgy.gui;
/*
import java.util.ArrayList;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import uwufailure.metallurgy.containers.ContainerSmithery1;
import uwufailure.metallurgy.util.Reference;
*/
public class ContainerScreenSmithery1 /*extends ContainerScreen<ContainerSmithery1>*/ {
//	private static final ResourceLocation TEXTURES_PAGE_1 = new ResourceLocation(Reference.MOD_ID + ":textures/gui/smithery_gui_1.png");
//	private static final ResourceLocation TEXTURES_PAGE_2 = new ResourceLocation(Reference.MOD_ID + ":textures/gui/smithery_gui_2.png");
//	private static final ResourceLocation TEXTURES_PAGE_3 = new ResourceLocation(Reference.MOD_ID + ":textures/gui/smithery_gui_3.png");
//	private final PlayerInventory player;
//	private final World world;
//	private final BlockPos blockPos;
//	/** What step on the GUI it is on (1: Default, list of available alloys; 2: 6x6 table for composition; 3: Final information, name etc.)*/
//	private int page;
//	
//	private ArrayList<ItemStack> ingotItems = new ArrayList<>();
//	
//	private ImageButton buttonRemoveRecipe;
//	private ImageButton buttonNewRecipe;
//	
//	private ImageButton buttonCancelRecipePage2;
//	private ImageButton buttonContinueRecipe;
//	
//	private ImageButton buttonCancelRecipePage3;
//	private ImageButton buttonCompleteRecipe;
//	
//	public ContainerScreenSmithery1(ContainerSmithery1 container, PlayerInventory inventory, ITextComponent title) {
//		super(container, inventory, title);
//		this.player = player;
//		this.world = worldIn;
//		this.blockPos = pos;
//		this.ySize = 222;
//		this.page = 0;
//		//ingotItems.add(new ItemStack(ModItems.ALLOY_INGOT, 1).setTagCompound(new NBTTagCompound().setTag("Properties", new NBTTag)));
//	}
//
//	@Override
//	public void initGui() {
//		super.initGui();
//
//		this.addButton(null);
//		this.buttonNewRecipe = (SmitheryButton)this.addButton(new SmitheryButton(0, this.guiLeft+116, this.guiTop+108));
//		this.buttonRemoveRecipe = (SmitheryButton)this.addButton(new SmitheryButton(1, this.guiLeft+138, this.guiTop+108));
//		
//		this.buttonContinueRecipe = (SmitheryButton)this.addButton(new SmitheryButton(2, this.guiLeft+11, this.guiTop+53));
//		this.buttonCancelRecipePage2 = (SmitheryButton)this.addButton(new SmitheryButton(3, this.guiLeft+11, this.guiTop+73));
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
//        int ingotX = ((ContainerSmithery1)this.inventorySlots).getIngotX();
//        int ingotY = ((ContainerSmithery1)this.inventorySlots).getIngotY();
//		
//		if(button.id == 0 && this.page == 0) {
////			EntityPlayer player = this.player.player;
////			if(player instanceof EntityPlayerMP && !(player instanceof FakePlayer)) {
////				((EntityPlayerMP)player).closeContainer();
////			}
////			player.openGui(Main.instance, Reference.GUI_SMITHERY_PAGE_2, world, this.blockPos.getX(), this.blockPos.getY(), this.blockPos.getZ());
//			this.page = 1;
//			((ContainerSmithery1)inventorySlots).toggleSlotStatesForPage2();
//		}
//		if(button.id == 1 && (ingotX != 1 && ingotY != 1) && this.page == 0) {
//			System.out.println("Deleting Entry "+ingotX+", "+ingotY);
//		}
//		if(button.id == 2 && this.page == 1) {
//			
//		} else if(button.id == 3 && this.page == 1) {
//			this.page = 0;
//			((ContainerSmithery1)inventorySlots).toggleSlotStatesForPage1();
//		}
//	}
//	
//	@Override
//	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
//		if(this.page == 0) {
//			this.fontRenderer.drawString(this.name, (134 - this.fontRenderer.getStringWidth(this.name)/2) + 3, 6, 4210752);
//		} else if(this.page == 1) {
//			this.fontRenderer.drawString(this.name, this.xSize/2 - (this.fontRenderer.getStringWidth(this.name)/2) + 3, 6, 4210752);
//		}
//		this.fontRenderer.drawString(this.player.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
//	}
//	
//	@Override
//    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
//    {
//        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
//        this.mc.getTextureManager().bindTexture(this.page == 0 ? this.TEXTURES_PAGE_1 : (this.page == 1 ? this.TEXTURES_PAGE_2 : this.TEXTURES_PAGE_3));
//        this.drawTexturedModalRect(this.guiLeft, (this.height - this.ySize) / 2, 0, 0, this.xSize, this.ySize);
//        if(this.page == 0) {
//	        int ingotX = ((ContainerSmithery1)this.inventorySlots).getIngotX();
//	        int ingotY = ((ContainerSmithery1)this.inventorySlots).getIngotY();
//	        
//	        if(mouseX > this.guiLeft+114 && mouseX < this.guiLeft+133 && mouseY > this.guiTop+106 && mouseY < this.guiTop+125) {
//	        	this.drawTexturedModalRect(this.guiLeft+115, this.guiTop+107, 176, 0, 18, 18);
//	        }
//	        
//	        if(mouseX > this.guiLeft+136 && mouseX < this.guiLeft+155 && mouseY > this.guiTop+106 && mouseY < this.guiTop+125) {
//	        	this.drawTexturedModalRect(this.guiLeft+137, this.guiTop+107, 176, 18, 18, 18);
//	        }
//	        
//	        if(ingotX != -1 && ingotY != -1) {
//	        	this.drawTexturedModalRect(this.guiLeft+6+ingotX*18, this.guiTop+16+ingotY*18, 176, 36, 22, 22);
//	        } else {
//	        	this.drawTexturedModalRect(this.guiLeft+137, this.guiTop+107, 194, 18, 18, 18);
//	        }
//        } else if(this.page == 1) {
//        	if(this.isPointInRegion(11, 53, 16, 16, mouseX, mouseY)) {
//        		this.drawTexturedModalRect(this.guiLeft+10, this.guiTop+52, 176, 0, 18, 18);
//        	}
//        	
//        	if(this.isPointInRegion(11, 73, 16, 16, mouseX, mouseY)) {
//        		this.drawTexturedModalRect(this.guiLeft+10, this.guiTop+72, 176, 18, 18, 18);
//        	}
//        } else if(this.page == 2) {
//        	
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
}
