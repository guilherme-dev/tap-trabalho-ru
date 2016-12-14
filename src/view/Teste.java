/**
 * 
 */
package view;

import java.util.Scanner;

import controller.*;
import model.entity.*;

/**
 * @author guilherme, ana
 *
 */
public class Teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StockController stockController = new StockController();
		MealController mealController = new MealController();
		RecipeController recipeController = new RecipeController();
		
		/**
		 * Cria novo ingrediente e adiciona no estoque.
		 * Calorias eh por receita
		 * Quantidade eh quantos tem no estoque, em gramas
		 */
		stockController.addToStock("arroz", 150, 5000);
		stockController.addToStock("feijao", 200, 2000);
		stockController.addToStock("sal", 5, 1000);
		stockController.addToStock("alface", 30, 800);
		stockController.addToStock("tomate", 30, 800);
		stockController.showStock();
		
		/**
		 * busca por nome ou por objeto
		 */
		Ingredient ingredientArroz = stockController.getFromStock(null, "arroz");
		
		System.out.println(ingredientArroz.toString());
		
		Recipe arrozCozido = new Recipe("arroz cozido", "Passo a passo de como cozinhar arroz....");
		
		/**
		 * Adiciona o ingrediente arroz para a receita arroz cozido, para a receita, eh
		 * necessario 200 gramas de arroz por exemplo
		 */
		recipeController.addIngredients(arrozCozido, ingredientArroz, 200);
		recipeController.saveRecipe(arrozCozido);
		
		System.out.println(arrozCozido.toString());
		
		

	}

}
