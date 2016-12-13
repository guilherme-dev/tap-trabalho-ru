/**
 * 
 */
package model.entity;

import model.dao.Dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;


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
		this.ingredientList =  new Hashtable<Ingredient, Integer>();
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
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Hashtable<Ingredient, Integer> getIngredientList() {
		return this.ingredientList;
	}

	public void setIngredientList(Hashtable<Ingredient, Integer> ingredientList) {
		this.ingredientList = ingredientList;
	}
	
	public void putIngredient(Ingredient ingredient, int qty) {
		if(this.ingredientList.containsKey(ingredient)){
			System.out.println("Ingrediente ja adicionado");
		} else {
			this.ingredientList.put(ingredient, qty);
			System.out.println("Ingrediente adicionado a receita");
		}
	}
	
	public int getCalories(){
		Ingredient item;
		int totalCalories = 0;
		Set<Ingredient> ingredients = this.getIngredientList().keySet();
		
		Iterator<Ingredient> itr = ingredients.iterator();
		
		while(itr.hasNext()){
			item = itr.next();
			totalCalories += item.getCalories();
		}
		
		return totalCalories;
		
	}
	
}
