/**
 * 
 */
package main;

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
		
		//Novo ingrediente, serializa em ingredient.ser
		Ingredient ingr = new Ingredient(1, "arroz", 200, 100);
		ingr.save();
		StockController stockController = new StockController();
		
		//Faz load do ingredient serializado no arquivo
		//Ingredient novoIngr = Ingredient.loadIngredients();
		//System.out.println(novoIngr.getName());
		
		//Insere ingrediente no estoque, se o arquivo stock.ser nao existe, cria novo
		stockController.insertIngredient(ingr);
	}

}
