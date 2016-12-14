/**
 * 
 */
package controller;

import java.util.Iterator;
import java.util.Set;

import model.entity.Ingredient;
import model.entity.Meal;
import model.entity.Recipe;
import model.entity.Stock;

/**
 * @author ana araujo, guilherme santos
 *
 */
public class MealController {
	private Meal meal;
	
	
	public MealController() {
		super();
		this.meal = new Meal();
	}

	public Meal getMeal() {
		return meal;
	}

	public void setMeal(Meal meal) {
		this.meal = meal;
	}

	//name, calories e quantity sao fornecidos pela view
	public void createMeal(String name, int quantity) {
		this.meal.setName(name);
		this.meal.setQuantity(quantity);
		this.meal.save();
	}
	
	public void addRecipe(Recipe recipe) {
		Set<Ingredient> ingredientList = recipe.getIngredientList().keySet();
		Iterator<Ingredient> itr = ingredientList.iterator();
		
		Stock stock = new Stock();
		Ingredient recipeIngredient;
		Ingredient stockIngredient;
		
		
		while(itr.hasNext()){
			recipeIngredient = itr.next();
			System.out.println(recipeIngredient.toString());
			stockIngredient = stock.getIngredientByName(recipeIngredient.getName());
			if(this.meal.enoughIngredient(recipeIngredient, stockIngredient)){
				System.out.print("Nao tem " + recipeIngredient.getName() + "em estoque!");
				return;
			}
		}
		this.meal.putRecipe(recipe);
	}
	
	public String showMeal(){
		return this.meal.toString();
	}
}
