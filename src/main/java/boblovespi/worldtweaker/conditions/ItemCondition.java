package boblovespi.worldtweaker.conditions;

import boblovespi.worldtweaker.crafttweaker.ICondition;
import boblovespi.worldtweaker.util.IngredientUtils;
import crafttweaker.api.item.IIngredient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by Willi on 1/23/2019.
 */
public class ItemCondition implements ICondition
{
	private final IIngredient target;

	public ItemCondition(IIngredient target)
	{
		this.target = target;
	}

	@Override
	public boolean matches(World world, BlockPos pos, @Nullable Entity target)
	{
		if (target == null || !(target instanceof EntityItem))
			return false;
		return IngredientUtils.matches(this.target, ((EntityItem) target).getItem());
	}
}
