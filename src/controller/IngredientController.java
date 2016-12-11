/**
 * 
 */
package controller;

import java.util.ArrayList;

import model.entity.Ingredient;
import model.entity.Stock;

/**
 * @author guilherme
 *
 */
public class IngredientController {
	
	public static Ingredient newIngredient(int id, String name, int calories, int quantity) {
		Ingredient ingr = new Ingredient(id, name, calories, quantity);
		return ingr;
	}
	
	public static int qtyIngredient (int id){
		int sum = 0;
		ArrayList<Ingredient> stock = Stock.loadStock();
		if (!(stock == null)){
			//for (Ingredient ingr : stock) {
			for (int i = 0; i < stock.size(); i++) {
				Ingredient ingr = stock.get(i);
				if (ingr.getId() == id) {
		            sum = sum + ingr.getQuantity();
		        }				
			}
		}
		else {
			System.out.println("The stock is empty");
		}
		return sum;	
	}

}
