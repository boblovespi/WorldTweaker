package boblovespi.worldtweaker.crafttweaker;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by Willi on 1/22/2019.
 */
@FunctionalInterface
public interface ICondition
{
	/**
	 * @param world  the world object of the crafting
	 * @param pos    the position of the entity targeted, or the block targeted
	 * @param target the entity targeted. null if no entity was targeted
	 * @return true if passes conditional test
	 */
	boolean matches(World world, BlockPos pos, @Nullable Entity target);

	/**
	 * @return whether the condition is the same regardless of details of the event (eg. time of day, weather, moon phase)
	 */
	default boolean isGlobal()
	{
		return false;
	}
}
