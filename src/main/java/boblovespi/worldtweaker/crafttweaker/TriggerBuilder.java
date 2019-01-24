package boblovespi.worldtweaker.crafttweaker;

import boblovespi.worldtweaker.builders.ExplosionTriggerBuilder;
import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * Created by Willi on 1/22/2019.
 */
@ZenClass("worldtweaker.TriggerBuilder")
@ZenRegister
public class TriggerBuilder
{
	@ZenMethod()
	public static ITriggerBuilder explosionTrigger()
	{
		return new ExplosionTriggerBuilder();
	}
}
