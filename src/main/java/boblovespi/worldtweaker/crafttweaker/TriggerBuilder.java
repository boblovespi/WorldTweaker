package boblovespi.worldtweaker.crafttweaker;

import boblovespi.worldtweaker.builders.ExplosionTriggerBuilder;
import boblovespi.worldtweaker.builders.ItemExplosionTriggerBuilder;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
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

	@ZenMethod()
	public static ITriggerBuilder itemExplosionTrigger(IIngredient target)
	{
		return new ItemExplosionTriggerBuilder(target);
	}
}
