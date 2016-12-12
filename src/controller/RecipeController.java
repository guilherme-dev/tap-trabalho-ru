/**
 * 
 */
package controller;

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
	
	public void newRecipe(String name, String description) { 
		Recipe recipe = new Recipe(name, description);
		this.recipes.insertRecipe(recipe);
	}
	
	
}
