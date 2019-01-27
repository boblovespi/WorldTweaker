package boblovespi.worldtweaker.util;

import crafttweaker.api.item.IIngredient;
import crafttweaker.mc1120.item.MCItemStack;
import net.minecraft.item.ItemStack;

/**
 * Created by Willi on 1/23/2019.
 */
public class IngredientUtils
{
	public static boolean matches(IIngredient target, ItemStack item)
	{
		return target.matches(new MCItemStack(item));
	}
}
