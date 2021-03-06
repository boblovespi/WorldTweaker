package boblovespi.worldtweaker.triggers;

import boblovespi.worldtweaker.crafttweaker.ITrigger;
import boblovespi.worldtweaker.crafttweaker.ICondition;
import boblovespi.worldtweaker.handler.ExplosionHandler;
import boblovespi.worldtweaker.crafttweaker.IResult;

/**
 * Created by Willi on 1/22/2019.
 */
public class ExplosionTrigger implements ITrigger
{
	private final IResult result;
	private final ICondition[] conditions;
	private final ICondition[] globalConditions;

	public ExplosionTrigger(IResult result, ICondition... conditions)
	{
		this(result, new ICondition[0], conditions);
	}

	public ExplosionTrigger(IResult result, ICondition[] globalConditions, ICondition... conditions)
	{
		this.result = result;
		this.globalConditions = globalConditions;
		this.conditions = conditions;
	}

	@Override
	public ITrigger register(String name)
	{
		ExplosionHandler.register(name, this);
		return this;
	}

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
