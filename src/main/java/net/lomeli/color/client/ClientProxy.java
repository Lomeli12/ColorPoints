package net.lomeli.color.client;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;

import net.lomeli.color.ColorPoints;
import net.lomeli.color.blocks.ModBlocks;
import net.lomeli.color.core.Proxy;
import net.lomeli.color.items.ModItems;
import net.lomeli.color.lib.BasicItemMesh;

public class ClientProxy extends Proxy {
    @Override
    public void preInit() {
        super.preInit();
    }

    @Override
    public void init() {
        super.init();

        registerModel(ModItems.triCompass, ColorPoints.MOD_ID + ":triCompass");
        registerModel(Item.getItemFromBlock(ModBlocks.waypointBlock), ColorPoints.MOD_ID + ":waypointBlock");
        registerModel(Item.getItemFromBlock(ModBlocks.resetBlock), ColorPoints.MOD_ID + ":resetBlock");
    }

    @Override
    public void postInit() {
        super.postInit();
    }

    private void registerModel(Item item, String resource) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, new BasicItemMesh(resource));
    }
}
