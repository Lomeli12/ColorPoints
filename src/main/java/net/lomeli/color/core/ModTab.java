package net.lomeli.color.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import net.lomeli.color.ColorPoints;
import net.lomeli.color.items.ModItems;

public class ModTab extends CreativeTabs {
    public static final ModTab modTab = new ModTab();

    public ModTab() {
        super(ColorPoints.MOD_ID);
    }

    @Override
    public Item getTabIconItem() {
        return ModItems.triCompass;
    }
}
