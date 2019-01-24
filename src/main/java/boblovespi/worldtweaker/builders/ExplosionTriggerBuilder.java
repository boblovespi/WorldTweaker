package boblovespi.worldtweaker.builders;

import boblovespi.worldtweaker.conditions.TimeCondition;
import boblovespi.worldtweaker.crafttweaker.ITrigger;
import boblovespi.worldtweaker.crafttweaker.ITriggerBuilder;
import boblovespi.worldtweaker.crafttweaker.TimeRange;
import boblovespi.worldtweaker.crafttweaker.ICondition;
import boblovespi.worldtweaker.crafttweaker.IResult;
import boblovespi.worldtweaker.results.ItemDropResult;
import boblovespi.worldtweaker.triggers.ExplosionTrigger;
import boblovespi.worldtweaker.util.ConditionUtils;
import boblovespi.worldtweaker.util.Transformers;
import crafttweaker.api.item.IItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Willi on 1/22/2019.
 */
public class ExplosionTriggerBuilder implements ITriggerBuilder
{
	private IResult result;
	private List<ICondition> conditions;

	public ExplosionTriggerBuilder()
	{
		conditions = new ArrayList<>(20);
	}

	@Override
	public ITriggerBuilder addResult(IItemStack stack)
	{
		result = new ItemDropResult(Transformers.transform(stack));
		return this;
	}

	@Override
	public ITrigger build()
	{
		conditions.sort(ConditionUtils::compare);
		return new ExplosionTrigger(result, conditions.toArray(new ICondition[0]));
	}

	@Override
	public ITriggerBuilder requiresTime(TimeRange timeRange)
	{
		conditions.add(new TimeCondition(timeRange));
		return this;
	}
}
