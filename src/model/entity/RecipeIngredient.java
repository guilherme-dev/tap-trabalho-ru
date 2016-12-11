/**
 * 
 */
package model.entity;

/**
 * @author guilherme
 *
 */
public class RecipeIngredient {
	private Ingredient ingredient;
	private int quantity;
	
	
	public RecipeIngredient(Ingredient ingredient, int quantity) {
		super();
		this.ingredient = ingredient;
		this.quantity = quantity;
	}
	
	public Ingredient getIngredient() {
		return ingredient;
	}
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
