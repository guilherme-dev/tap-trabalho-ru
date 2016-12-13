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
	
	ArrayList<Ingredient> stock;
	
	
	
	public Stock() {
		this.stock = (ArrayList<Ingredient>) Dao.load("stock");
		if (!(stock == null)){
			System.out.println("Estoque carregado corretamente..");
		} else {
			System.out.println("Nenhum arquivo para estoque, criando novo..");
			this.stock = new ArrayList<Ingredient>();
		}
	}
	
	

	@Override
	public String toString() {
		String stockString = "";
		for(int i = 0; i < this.stock.size(); i++){
			stockString = stockString + this.stock.get(i).toString() + "\n";
		}
		return stockString;
	}



	public void save() {
		Dao.save("stock", this.stock);
	}
	
	public void load(){
		this.stock = (ArrayList<Ingredient>) Dao.load("stock");
	}
	
	public void insertIngredient(Ingredient item) {
		
		if(!this.stock.contains(item)){
			this.stock.add(item);
			this.save();
			System.out.println("Item inserido no estoque");
		} else {
			System.out.println("Item ja esta no estoque");
		}
	}
	
	public Ingredient getIngredient(Ingredient item) {
		if(this.stock.contains(item)){
			int i = this.stock.indexOf(item);
			return this.stock.get(i);
		} else {
			System.out.println("O item nao foi encontrado no estoque");
			return null;
		}
	}
	
	public Ingredient getIngredientByName(String name) {
		int i;
		Ingredient item;
		for(i = 0; i < this.stock.size(); i++){
			
			item = this.stock.get(i);
			if(item.getName().equals(name)){
				return item;
			}
		}
		return null;
	}
}
