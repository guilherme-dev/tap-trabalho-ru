/**
 * 
 */
package controller;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import model.entity.Ingredient;
import model.entity.Recipe;
import model.entity.RecipeList;

/**
 * @author ana araujo, guilherme santos
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
	
	public void removeFromRecipeList(Recipe recipe) {
		this.recipes.deleteRecipe(recipe);
	}
	
	public Recipe getRecipe(String name){
		return this.recipes.getRecipeByName(name);
	}
	
	public String showRecipes(){
		return this.recipes.toString();
	}
	
}
