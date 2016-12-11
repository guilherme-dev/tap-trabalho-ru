/**
 * 
 */
package main;

import java.io.*;

import controller.IngredientController;
import controller.StockController;
import model.entity.*;

/**
 * @author guilherme
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ingredient ingr = IngredientController.newIngredient(1, "arroz", 200, 100);
		ingr.save();
		StockController.insertIngredient(ingr);
		ingr = IngredientController.newIngredient(1, "arroz", 200, 400);
		ingr.save();
		StockController.insertIngredient(ingr);
		int qty = IngredientController.qtyIngredient (1);
		System.out.println(qty);
		//Ingredient novoIngr = Ingredient.loadIngredients();
		//System.out.println(novoIngr.getName());
	}

}
