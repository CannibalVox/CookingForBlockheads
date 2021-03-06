package net.blay09.mods.cookingbook.client;

import net.blay09.mods.cookingbook.block.TileEntityFridge;
import net.blay09.mods.cookingbook.container.ContainerFridge;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiFridge extends GuiContainer {

    private static final ResourceLocation texture = new ResourceLocation("textures/gui/container/generic_54.png");
    private TileEntityFridge tileEntity;
    private int inventoryRows;

    public GuiFridge(InventoryPlayer inventory, TileEntityFridge tileEntity) {
        super(new ContainerFridge(inventory, tileEntity));
        this.tileEntity = tileEntity;
        this.inventoryRows = tileEntity.isLargeFridge() ? 6 : 3;
        this.ySize = 114 + this.inventoryRows * 18;
    }

    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
        this.fontRendererObj.drawString(I18n.format(tileEntity.getInventoryName()), 8, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        GL11.glColor4f(1f, 1f, 1f, 1f);
        this.mc.getTextureManager().bindTexture(texture);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
        this.drawTexturedModalRect(guiLeft, guiTop + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
    }

}
