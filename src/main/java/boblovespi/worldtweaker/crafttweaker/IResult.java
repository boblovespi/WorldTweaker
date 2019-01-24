package boblovespi.worldtweaker.crafttweaker;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Willi on 1/22/2019.
 */
@FunctionalInterface
public interface IResult
{
	void preformResult(World world, BlockPos pos, List<BlockPos> blocksAffected, List<Entity> entitiesAffected);
}
