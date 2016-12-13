/**
 * 
 */
package model.entity;

import java.io.Serializable;
import model.dao.*;

/**
 * @author ana araujo, guilherme santos
 *
 */
public class Ingredient implements Serializable {
	
	private String name;
	private int calories;
	private int quantity;

	public Ingredient() {
		this.name = "";
		this.calories = 0;
		this.quantity = 0;
	}
	
	public Ingredient(String name, int calories, int quantity) {
		this.name = name;
		this.calories = calories;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return name + " - " + calories + " calorias, " + quantity + " gramas em estoque.";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void save() {
		Dao.save("ingredient", this);
	}
	public static Ingredient load(){
		return (Ingredient) Dao.load("ingredient");
	}
}
