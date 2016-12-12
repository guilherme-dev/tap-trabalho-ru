/**
 * 
 */
package main;

import model.entity.*;
import controller.*;

/**
 * @author guilherme
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StockController stockController = new StockController();
		RecipeController recipeController = new RecipeController();
		//Novo ingrediente, serializa em ingredient.ser
		//Ingredient ingr = new Ingredient(1, "arroz", 200, 100);
		//ingr.save();
		
		
		//Faz load do ingredient serializado no arquivo
		//Ingredient novoIngr = Ingredient.loadIngredients();
		//System.out.println(novoIngr.getName());
		
		
		
		//Insere ingrediente no estoque, se o arquivo stock.ser nao existe, cria novo
		//stockController.addToStock("arroz", 150, 1000);
		//stockController.addToStock("feijao", 150, 1000);
		Ingredient ingredient = stockController.getFromStock(null, "feijao");
		System.out.println(ingredient.getName());
		
		
		//recipeController.newRecipe("arroz cozinho", "Para fazer arroz, coloca arroz e agua e sal e ferve e gg");
		
	}

}
