/**
 * 
 */
package controller;

import model.entity.Meal;
import model.entity.Recipe;

/**
 * @author guilherme
 *
 */
public class MealController {
	Meal meal;
	
	
	public MealController() {
		super();
		this.meal = new Meal();
	}

	//name, calories e quantity sao fornecidos pela view
	public void createMeal(String name, int quantity) {
		this.meal.setName(name);
		this.meal.setQuantity(quantity);
		this.meal.save();
	}
	
	public void addRecipe(Recipe recipe) {
		this.meal.putRecipe(recipe);
		this.meal.save();
	}
}
