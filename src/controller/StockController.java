/**
 * 
 */
package controller;

import java.util.ArrayList;

import model.entity.*;

/**
 * @author guilherme
 *
 */
public class StockController {

	
	public static void insertIngredient(Ingredient item) {
		ArrayList<Ingredient> stock = Stock.loadStock();
		if (!(stock == null)){
			System.out.println("File not found, creating new");
			if(!stock.contains(item)){
				stock.add(item);
			} else {
				System.out.println("Item already on stock");
			}
		}
		stock = new ArrayList<Ingredient>();
		stock.add(item);
		Stock.save(stock);
		System.out.println("Item saved on stock");
	}
		
}
