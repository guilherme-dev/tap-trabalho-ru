/**
 * 
 */
package controller;

import model.entity.Ingredient;

/**
 * @author guilherme
 *
 */
public class IngredientController {
	
	public static void newIngredient(int id, String name, int calories, int quantity) {
		Ingredient ingred = new Ingredient(id, name, calories, quantity);
	}

}
