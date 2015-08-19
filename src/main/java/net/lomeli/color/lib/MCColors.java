package net.lomeli.color.lib;

import net.minecraft.util.StatCollector;

public enum MCColors {
    WHITE(0), ORANGE(1), MAGENTA(2), LIGHT_BLUE(3), YELLOW(4), LIME(5), PINK(6), GRAY(7),
    LIGHT_GRAY(8), CYAN(9), PURPLE(10), BLUE(11), BROWN(12), GREEN(13), RED(14), BLACK(15);

    private static final String[] unloclColorNames = new String[]{
            "color.colorpoints.White",
            "color.colorpoints.Orange",
            "color.colorpoints.Magenta",
            "color.colorpoints.LightBlue",
            "color.colorpoints.Yellow",
            "color.colorpoints.Lime",
            "color.colorpoints.Pink",
            "color.colorpoints.Gray",
            "color.colorpoints.LightGray",
            "color.colorpoints.Cyan",
            "color.colorpoints.Purple",
            "color.colorpoints.Blue",
            "color.colorpoints.Brown",
            "color.colorpoints.Green",
            "color.colorpoints.Red",
            "color.colorpoints.Black"
    };

    private static final MCColors[] VALID_VALUES = {WHITE, ORANGE, MAGENTA, LIGHT_BLUE, YELLOW, LIME, PINK, GRAY, LIGHT_GRAY, CYAN, PURPLE, BLUE, BROWN, GREEN, RED, BLACK};

    public static MCColors getColor(int i) {
        return (i >= 0 && i < VALID_VALUES.length) ? VALID_VALUES[i] : WHITE;
    }

    private final int colorIndex;

    MCColors(int index) {
        colorIndex = index;
    }

    public String getUnlocalizedColor() {
        return unloclColorNames[this.colorIndex];
    }

    public String getColorName() {
        return StatCollector.translateToLocal(this.getUnlocalizedColor());
    }

    public int getColorIndex() {
        return this.colorIndex;
    }
}
