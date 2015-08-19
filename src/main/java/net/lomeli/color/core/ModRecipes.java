package net.lomeli.color.core;

import net.minecraft.init.Items;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

import net.lomeli.color.items.ModItems;

public class ModRecipes {
    public static void loadRecipes() {
        GameRegistry.addRecipe(new ShapedOreRecipe(ModItems.triCompass, "RGB", "IPI", "CMY", 'R', "dyeRed", 'G', "dyeGreen", 'B', "dyeBlue", 'I', "ingotIron", 'P', Items.compass, 'C', "dyeCyan", 'M', "dyeMagenta", 'Y', "dyeYellow"));
    }
}
