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
public class Recipe implements Serializable {
	
	private int id;
	private String name;
	private String description;
	ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
	
	public Recipe(int id, String name, String description, ArrayList<Ingredient> ingredientList) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.ingredientList = ingredientList;
	}
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 
	public ArrayList<Ingredient> getIngredientList() {
		return ingredientList;
	}
	public void setIngredientList(ArrayList<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}
	
	public void save() {
		Dao.save(this);
	}
	public static Recipe loadRecipes() {
		return (Recipe) Dao.load("recipe");
	}
	
}