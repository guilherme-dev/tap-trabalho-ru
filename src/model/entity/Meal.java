/**
 * 
 */
package model.entity;

import java.io.Serializable;
import java.util.ArrayList;

import model.dao.Dao;

/**
 * @author guilherme
 *
 */
public class Meal implements Serializable {
	private String name;
	ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
	private int quantity;
	private int calories;
	
	
	public int getCalories() {
		return this.calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public Meal() {
		this.name = "";
		this.quantity = 0;
		this.calories = 0;
	}
	
	public Meal(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.calories = 0;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Recipe> getRecipeList() {
		return recipeList;
	}
	public void setRecipeList(ArrayList<Recipe> recipeList) {
		this.recipeList = recipeList;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void save() {
		Dao.save("meals", this);
	}
	public static Meal load(){
		return (Meal) Dao.load("meal");
	}
	
	public void putRecipe(Recipe recipe) {
		if(this.recipeList.contains(recipe)){
			System.out.println("Receita ja adicionada");
		} else {
			this.recipeList.add(recipe);
			this.setCalories(recipe.getCalories());
			this.save();
			System.out.println("Receita adicionada a refeicao");
		}
	}
}
