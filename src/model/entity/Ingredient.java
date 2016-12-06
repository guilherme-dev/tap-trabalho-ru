/**
 * 
 */
package model.entity;

import java.io.Serializable;
import model.dao.*;

/**
 * @author guilherme
 *
 */
public class Ingredient implements Serializable {
	
	private int id;
	private String name;
	private int calories;
	private int quantity;

	public Ingredient() {
		this.id = 0;
		this.name = "";
		this.calories = 0;
	}
	
	public Ingredient(int id, String name, int calories) {
		this.id = id;
		this.name = name;
		this.calories = calories;
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
		Dao.save(this);
	}
	public static Ingredient loadIngredients(){
		return (Ingredient) Dao.load("ingredient");
	}
}
