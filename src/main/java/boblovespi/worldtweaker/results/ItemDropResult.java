package boblovespi.worldtweaker.results;

import boblovespi.worldtweaker.crafttweaker.IResult;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Willi on 1/22/2019.
 */
public class ItemDropResult implements IResult
{
	private final ItemStack stack;

	public ItemDropResult(ItemStack stack)
	{
		this.stack = stack;
	}

	@Override
	public void preformResult(World world, BlockPos pos, List<BlockPos> blocksAffected, List<Entity> entitiesAffected)
	{
		world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack.copy()));
	}
}
