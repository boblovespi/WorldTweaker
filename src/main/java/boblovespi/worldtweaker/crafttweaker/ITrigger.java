package boblovespi.worldtweaker.crafttweaker;

import crafttweaker.annotations.ZenRegister;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

/**
 * Created by Willi on 1/22/2019.
 */
@ZenClass("worldtweaker.ITrigger")
@ZenRegister
public interface ITrigger
{
	@ZenMethod()
	ITrigger register(String name);

	IResult getResult();

	ICondition[] getConditions();

	ICondition[] getGlobalConditions();
}
