package boblovespi.worldtweaker.conditions;

import boblovespi.worldtweaker.crafttweaker.ICondition;
import boblovespi.worldtweaker.crafttweaker.TimeRange;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by Willi on 1/22/2019.
 */
public class TimeCondition implements ICondition
{
	private final TimeRange timeRange;

	public TimeCondition(TimeRange timeRange)
	{
		if (timeRange == null)
			timeRange = TimeRange.NONE;
		this.timeRange = timeRange;
	}

	@Override
	public boolean matches(World world, BlockPos pos, @Nullable Entity target)
	{
		return timeRange.matches(world.getWorldTime());
	}

	@Override
	public boolean isGlobal()
	{
		return true;
	}
}
