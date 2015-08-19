package net.lomeli.color.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
    public static Block waypointBlock, resetBlock;

    public static void initBlocks() {
        waypointBlock = new BlockColor(Material.iron, "waypointBlock").setHardness(2f).setResistance(10f);
        resetBlock = new BlockColor(Material.cloth, "resetBlock").setHardness(0.7f);

        GameRegistry.registerBlock(waypointBlock, "waypointBlock");
        GameRegistry.registerBlock(resetBlock, "resetBlock");
    }
}
