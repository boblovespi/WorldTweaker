package boblovespi.worldtweaker.conditions;

import boblovespi.worldtweaker.crafttweaker.ICondition;
import boblovespi.worldtweaker.util.IngredientUtils;
import crafttweaker.api.item.IIngredient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Willi on 1/23/2019.
 */
public class ItemContactCondition implements ICondition
{
	private static final AxisAlignedBB blockRadius = new AxisAlignedBB(-1, -1, -1, 2, 2, 2);
	private final IIngredient ingredient;

	public ItemContactCondition(IIngredient ingredient)
	{
		this.ingredient = ingredient;
	}

	/**
	 * @param world  the world object of the crafting
	 * @param pos    the position of the entity targeted, or the block targeted
	 * @param target the entity targeted. null if no entity was targeted
	 * @return true if passes conditional test
	 */
	@Override
	public boolean matches(World world, BlockPos pos, @Nullable Entity target)
	{
		if (target == null)
		{
			List<EntityItem> items = world.getEntitiesWithinAABB(EntityItem.class, blockRadius.offset(pos));
			for (EntityItem item : items)
			{
				if (IngredientUtils.matches(ingredient, item.getItem()))
					return true;
			}
			return false;
		} else if (target instanceof EntityItem)
		{
			EntityItem entityItem = (EntityItem) target;

			List<EntityItem> items = world
					.getEntitiesWithinAABB(EntityItem.class, entityItem.getEntityBoundingBox().grow(6 / 16d));
			for (EntityItem item : items)
			{
				if (item.equals(entityItem))
					continue;
				if (IngredientUtils.matches(ingredient, item.getItem()))
					return true;
			}
			return false;
		} else
			return false;
	}
}
