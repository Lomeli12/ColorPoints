package net.lomeli.color.items;

import net.minecraft.item.Item;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
    public static Item triCompass;

    public static void loadItems() {
        triCompass = new ItemDirectCompass();

        GameRegistry.registerItem(triCompass, "triCompass");
    }
}
