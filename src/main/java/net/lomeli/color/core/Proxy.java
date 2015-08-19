package net.lomeli.color.core;

import net.minecraftforge.common.MinecraftForge;

import net.lomeli.color.blocks.ModBlocks;
import net.lomeli.color.core.handler.CompassHandler;
import net.lomeli.color.items.ModItems;

public class Proxy {
    public void preInit() {
        ModItems.loadItems();
        ModBlocks.initBlocks();
    }

    public void init() {
        MinecraftForge.EVENT_BUS.register(new CompassHandler());
    }

    public void postInit() {
        ModRecipes.loadRecipes();
    }
}
