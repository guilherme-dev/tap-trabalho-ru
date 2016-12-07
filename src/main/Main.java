/**
 * 
 */
package main;

import java.io.*;

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
		Ingredient ingr = new Ingredient(1, "arroz", 200, 100);
		ingr.save();
		//Ingredient novoIngr = Ingredient.loadIngredients();
		//System.out.println(novoIngr.getName());
		StockController.insertIngredient(ingr);
	}

}
