package boblovespi.worldtweaker.triggers;

import boblovespi.worldtweaker.crafttweaker.ICondition;
import boblovespi.worldtweaker.crafttweaker.IResult;
import boblovespi.worldtweaker.crafttweaker.ITrigger;
import boblovespi.worldtweaker.handler.ExplosionHandler;

/**
 * Created by Willi on 1/23/2019.
 */
public class ItemExplosionTrigger implements ITrigger
{
	private final IResult result;
	private final ICondition[] globalConditions;
	private final ICondition[] conditions;

	public ItemExplosionTrigger(IResult result, ICondition[] globalConditions, ICondition[] conditions)
	{
		this.result = result;
		this.globalConditions = globalConditions;
		this.conditions = conditions;
	}

	@Override
	public ITrigger register(String name)
	{
		ExplosionHandler.registerItem(name, this);
		return this;
	}

	@Override
	public IResult getResult()
	{
		return result;
	}

	@Override
	public ICondition[] getConditions()
	{
		return conditions;
	}

	@Override
	public ICondition[] getGlobalConditions()
	{
		return globalConditions;
	}
}
