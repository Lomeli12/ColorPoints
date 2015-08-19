package net.lomeli.color;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import net.lomeli.color.core.Proxy;

@Mod(modid = ColorPoints.MOD_ID, name = ColorPoints.MOD_NAME, version = ColorPoints.VERSION, acceptedMinecraftVersions = ColorPoints.MINECRAFT)
public class ColorPoints {
    public static final String MOD_ID = "colorpoints";
    public static final String MOD_NAME = "Color Points";
    public static final int MAJOR = 1, MINOR = 0, REV = 0;
    public static final String VERSION = MAJOR + "." + MINOR + "." + REV;
    public static final String MINECRAFT = "1.8";

    @SidedProxy(serverSide = "net.lomeli.color.core.Proxy", clientSide = "net.lomeli.color.client.ClientProxy")
    public static Proxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }
}
