package boblovespi.worldtweaker.crafttweaker;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Willi on 1/22/2019.
 */
@FunctionalInterface
public interface IResult
{
	/**
	 * @param world  the world object of the crafting
	 * @param pos    the position of the entity targeted, or the block targeted
	 * @param target the entity targeted. null if no entity was targeted
	 */
	void preformResult(World world, BlockPos pos, Entity target);
}
