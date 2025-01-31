package xir.wirelesshatchmore.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import xir.gregtech.loader.GT_Loader;
import xir.wirelesshatchmore.Tags;

@Mod(
    modid = Tags.MODID,
    version = Tags.VERSION,
    name = Tags.MODNAME,
    dependencies = "required-before:IC2; " + "required-before:gregtech; " + "required-before:tectech; ",
    acceptedMinecraftVersions = "[1.7.10]")
public class WirelessHatchMore {

    public static final String MODID = Tags.MODID;
    public static final Logger LOG = LogManager.getLogger(MODID);

    @Mod.Instance(Tags.MODID)
    public static WirelessHatchMore instance;

    @SidedProxy(
        clientSide = "xir.wirelesshatchmore.main.ClientProxy",
        serverSide = "xir.wirelesshatchmore.main.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    // preInit "Run before anything else. Read your config, create blocks, items, etc, and register them with the
    // GameRegistry." (Remove if not needed)
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    // load "Do your mod setup. Build whatever data structures you care about. Register recipes." (Remove if not needed)
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
        GT_Loader.energyHatchMore();
        GT_Loader.dynamoHatchMore();
        GT_Loader.test();
    }

    @Mod.EventHandler
    // postInit "Handle interaction with other mods, complete your setup based on this." (Remove if not needed)
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    // register server commands in this event handler (Remove if not needed)
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }
}
