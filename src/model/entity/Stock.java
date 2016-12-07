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
public class Stock implements Serializable {
	
	ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

	public ArrayList<Ingredient> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(ArrayList<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}
	
	public static void save(ArrayList<Ingredient> item) {
		Dao.save(item);
	}
	
	public static ArrayList<Ingredient> loadStock(){
		return (ArrayList<Ingredient>) Dao.load("stock");
	}
}
