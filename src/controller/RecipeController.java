/**
 * 
 */
package controller;

import java.util.Hashtable;

import model.entity.Ingredient;
import model.entity.Recipe;
import model.entity.RecipeList;

/**
 * @author guilherme
 *
 */
public class RecipeController {
	RecipeList recipes;

	public RecipeController() {
		super();
		this.recipes = new RecipeList();
	}
	
	public void saveRecipe(Recipe recipe) { 
		this.recipes.insertRecipe(recipe);
	}
	
	public void addIngredients(Recipe recipe, Ingredient ingredient, int qty) {
		recipe.putIngredient(ingredient, qty);
	}
	
	
}
