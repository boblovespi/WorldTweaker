package boblovespi.worldtweaker.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * Created by Willi on 1/22/2019.
 */
@ZenClass("worldtweaker.ITriggerHandler")
@ZenRegister
public interface ITriggerBuilder
{
	@ZenMethod
	ITriggerBuilder addResult(IItemStack stack);

	@ZenMethod
	ITrigger build();

	@ZenMethod
	ITriggerBuilder requiresTime(TimeRange timeRange);
}
