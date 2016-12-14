/**
 * 
 */
package view;

import java.util.Scanner;

import controller.*;
import model.entity.*;

/**
 * @author guilherme
 *
 */
public class RecipeTEst {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StockController stockController = new StockController();
		MealController mealController = new MealController();
		RecipeController recipeController = new RecipeController();
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Digite o nome da receita");
		String name = keyboard.nextLine();
		System.out.println("Digite a descricao da receita");
		String description = keyboard.nextLine();
		
		Recipe newRecipe = new Recipe(name, description);
		
		System.out.println("Digite o nome do ingrediente para adicionar na receita");
		String ingredientName = keyboard.nextLine();
		
		Ingredient item = stockController.getFromStock(null, ingredientName);
		
		System.out.print("Digite a quantidade deste ingrediente necessaria para a receita");
		int qty = keyboard.nextInt();
		
		
		recipeController.addIngredients(newRecipe, item, qty);
		recipeController.saveRecipe(newRecipe);
		
		System.out.println("Receita salva:");
		System.out.println(newRecipe.toString());
		
		
		

	}

}
