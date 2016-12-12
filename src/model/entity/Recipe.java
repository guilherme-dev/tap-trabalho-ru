/**
 * 
 */
package model.entity;

import model.dao.Dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;


/**
 * @author guilherme, ana
 *
 */
public class Recipe implements Serializable {
	
	private String name;
	private String description;
	//Key: objeto ingredient, value eh a quantidade do ingredient na receita
	private Hashtable<Ingredient, Integer> ingredientList;
	
	
	public Recipe(String name, String description) {
		super();
		this.name = name;
		this.description = description;
		this.ingredientList = null;
	}
	
	public void save() {
		Dao.save("ingredient", this);
	}
	public static Recipe load() {
		return (Recipe) Dao.load("recipes");
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
	public Hashtable<Ingredient, Integer> getIngredientList() {
		return ingredientList;
	}

	public void setIngredientList(Hashtable<Ingredient, Integer> ingredientList) {
		this.ingredientList = ingredientList;
	}
	
}
