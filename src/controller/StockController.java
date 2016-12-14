/**
 * 
 */
package controller;

import java.util.ArrayList;

import model.entity.*;

/**
 * @author ana araujo, guilherme santos
 *
 */
public class StockController {

	Stock stock;
	
	
	
	public StockController() {
		this.stock = new Stock();
	}

	//name, calories e quantity sao fornecidos pela view
	public void addToStock(String name, int calories, int quantity) {
		Ingredient item = new Ingredient(name, calories, quantity);
		this.stock.insertIngredient(item);
	}
	
	public Ingredient getFromStock(Ingredient item, String name) {
		if(item == null && name != null){
			return this.stock.getIngredientByName(name);
		} else if(item != null && name == null){
			return this.stock.getIngredient(item);
		} else {
			System.out.println("Argumetos errados em getFromStock");
			return null;
		}
	}
	
	public ArrayList<Ingredient> getStock(){
		return this.stock.getStock();
	}
	
	public void showStock() {
		System.out.println(this.stock.toString());
	}
}
