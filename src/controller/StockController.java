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

	ArrayList<Ingredient> stock;
	
	
	
	public StockController() {
		this.stock = Stock.loadStock();
		if (!(stock == null)){
			System.out.println("Estoque carregado corretamente..");
		} else {
			System.out.println("Nenhum arquivo para estoque, criando novo..");
			this.stock = new ArrayList<Ingredient>();
		}
	}

	public void insertIngredient(Ingredient item) {
		
		if(!this.stock.contains(item)){
			this.stock.add(item);
			Stock.save(this.stock);
			System.out.println("Item inserido no estoque");
		} else {
			System.out.println("Item ja esta no estoque");
		}
	}
	
//	public Ingredient getIngredient(int id){
//		
//		
//	}
	
}
