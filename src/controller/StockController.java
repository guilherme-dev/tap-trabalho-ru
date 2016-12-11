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

	Stock stockModel;
	int tracker;
	
	
	
	public StockController() {
		this.stockModel = new Stock();
	}

	//name, calories e quantity sao fornecidos pela view
	public void addToStock(String name, int calories, int quantity) {
		Ingredient item = new Ingredient(name, calories, quantity);
		this.stockModel.insertIngredient(item);
	}
	
}
