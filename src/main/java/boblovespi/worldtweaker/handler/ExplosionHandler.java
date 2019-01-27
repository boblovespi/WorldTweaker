package boblovespi.worldtweaker.handler;

import boblovespi.worldtweaker.crafttweaker.ICondition;
import boblovespi.worldtweaker.triggers.BlockExplosionTrigger;
import boblovespi.worldtweaker.triggers.ExplosionTrigger;
import boblovespi.worldtweaker.triggers.ItemExplosionTrigger;
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
	private static HashMap<String, ItemExplosionTrigger> triggerItem = new HashMap<>();
	private static HashMap<String, BlockExplosionTrigger> triggerBlock = new HashMap<>();

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
				if (!condition.matches(world, pos, null))
					continue outer;
			}
			trigger.getResult().preformResult(world, pos, null);
		}

		item:
		for (ItemExplosionTrigger trigger : triggerItem.values())
		{
			ICondition[] globalConditions = trigger.getGlobalConditions();
			for (ICondition condition : globalConditions)
			{
				if (!condition.matches(world, pos, null))
					continue item;
			}
			entities:
			for (Entity e : affectedEntities)
			{
				ICondition[] conditions = trigger.getConditions();
				for (ICondition condition : conditions)
				{
					if (!condition.matches(world, pos, e))
						continue entities;
				}
				trigger.getResult().preformResult(world, pos, e);
			}

		}

		block:
		for (BlockExplosionTrigger trigger : triggerBlock.values())
		{
			ICondition[] globalConditions = trigger.getGlobalConditions();
			for (ICondition condition : globalConditions)
			{
				if (!condition.matches(world, pos, null))
					continue block;
			}

			blockTargets:
			for (BlockPos e : affectedBlocks)
			{
				ICondition[] conditions = trigger.getConditions();
				for (ICondition condition : conditions)
				{
					if (!condition.matches(world, e, null))
						continue blockTargets;
				}
				trigger.getResult().preformResult(world, e, null);
			}

		}
	}

	public static void register(String name, ExplosionTrigger explosionTrigger)
	{
		triggers.put(name, explosionTrigger);
	}

	public static void registerItem(String name, ItemExplosionTrigger explosionTrigger)
	{
		triggerItem.put(name, explosionTrigger);
	}

	public static void registerBlock(String name, BlockExplosionTrigger explosionTrigger)
	{
		triggerBlock.put(name, explosionTrigger);
	}
}
