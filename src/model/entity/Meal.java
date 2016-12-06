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
	private int id;
	private String name;
	ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public void save() {
		Dao.save(this);
	}
	public static Meal loadMeals(){
		return (Meal) Dao.load("meal");
	}
}
