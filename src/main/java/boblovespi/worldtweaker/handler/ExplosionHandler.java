package boblovespi.worldtweaker.handler;

import boblovespi.worldtweaker.crafttweaker.ICondition;
import boblovespi.worldtweaker.triggers.ExplosionTrigger;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Willi on 1/22/2019.
 */
@Mod.EventBusSubscriber
public class ExplosionHandler
{
	private static HashMap<String, ExplosionTrigger> triggers = new HashMap<>();

	@SubscribeEvent
	public static void onExplosionDetonate(ExplosionEvent.Detonate event)
	{
		World world = event.getWorld();
		if (world.isRemote)
			return;
		BlockPos pos = new BlockPos(event.getExplosion().getPosition());
		List<BlockPos> affectedBlocks = event.getAffectedBlocks();
		List<Entity> affectedEntities = event.getAffectedEntities();
		outer:
		for (ExplosionTrigger trigger : triggers.values())
		{
			ICondition[] conditions = trigger.getConditions();
			for (ICondition condition : conditions)
			{
				if (!condition.matches(world, pos, null, affectedBlocks, affectedEntities))
					continue outer;
			}
			trigger.getResult().preformResult(world, pos, affectedBlocks, affectedEntities);
		}
	}

	public static void register(String name, ExplosionTrigger explosionTrigger)
	{
		triggers.put(name, explosionTrigger);
	}
}
