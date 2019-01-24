package boblovespi.worldtweaker.crafttweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

/**
 * Created by Willi on 1/22/2019.
 */
@ZenClass("worldtweaker.TimeRange")
@ZenRegister
public class TimeRange
{
	@ZenProperty(getter = "day")
	public static final TimeRange DAY = new TimeRange(1000, 12000);
	public static final TimeRange NONE = new TimeRange(1, 0);
	private final int start;
	private final int end;

	public TimeRange(int start, int end)
	{
		this.start = start;
		this.end = end;
	}

	public static TimeRange day()
	{
		return TimeRange.DAY;
	}

	@ZenMethod
	public static TimeRange create(int start, int end)
	{
		if (start > end)
		{
			CraftTweakerAPI.logError("start time in time range object must be <= end time");
			return NONE;
		} else
			return new TimeRange(start, end);
	}

	public boolean matches(long worldTime)
	{
		return worldTime >= start && worldTime <= end;
	}
}
