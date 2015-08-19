package net.lomeli.color.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import net.lomeli.color.ColorPoints;
import net.lomeli.color.core.ModTab;

public class BlockColor extends Block {
    public BlockColor(Material material, String unlocalized) {
        super(material);
        this.setCreativeTab(ModTab.modTab);
        this.setUnlocalizedName(ColorPoints.MOD_ID + "." + unlocalized);
    }
}
