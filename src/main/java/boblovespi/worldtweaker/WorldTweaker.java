package boblovespi.worldtweaker;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Willi on 1/22/2019.
 */
@Mod(modid = WorldTweaker.MODID, name = WorldTweaker.NAME, version = WorldTweaker.VERSION)
public class WorldTweaker
{
	public static final String MODID = "worldtweaker";
	public static final String VERSION = "Alpha 0.0.0";
	public static final String NAME = "WorldTweaker";
	public static final String SERVER_PROXY_CLASS = "boblovespi.worldtweaker.ServerProxy";
	public static final String CLIENT_PROXY_CLASS = "boblovespi.worldtweaker.ClientProxy";
	public static final String GUI_FACTORY = "net.minecraftforge.fml.client.DefaultGuiFactory";
	@Mod.Instance(MODID)
	public static WorldTweaker instance = new WorldTweaker();
	@SidedProxy(serverSide = SERVER_PROXY_CLASS, clientSide = CLIENT_PROXY_CLASS)
	public static CommonProxy proxy;

	//	static
	//	{
	//		FluidRegistry.enableUniversalBucket();
	//	}

	@SuppressWarnings("unused")
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent Event)
	{

	}

	@SuppressWarnings("unused")
	@Mod.EventHandler
	public void init(FMLInitializationEvent Event)
	{

	}

	@SuppressWarnings("unused")
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent Event)
	{

	}
}
