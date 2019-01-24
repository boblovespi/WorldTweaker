package boblovespi.worldtweaker.crafttweaker;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Willi on 1/22/2019.
 */
@FunctionalInterface
public interface ICondition
{
	/**
	 * @param world the world object of the crafting
	 * @param pos the position of the entity targeted, or the block targeted
	 * @param target the entity targeted. null if no entity was targeted
	 * @param blocksAffected the blocks that were affected by the trigger. null if the trigger does not target blocks
	 * @param entitiesAffected the entities that were affected by the trigger. null if the trigger does not target entities
	 * @return true if passes conditional test
	 */
	boolean matches(World world, BlockPos pos, @Nullable Entity target, List<BlockPos> blocksAffected, List<Entity> entitiesAffected);
}
