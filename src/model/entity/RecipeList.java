package model.entity;

import java.util.ArrayList;

import model.dao.Dao;

/**
 * @author ana araujo, guilherme santos
 *
 */
public class RecipeList {
	private ArrayList<Recipe> recipeList;
	
	public RecipeList() {
		this.recipeList = (ArrayList<Recipe>) Dao.load("recipes");
		if (!(recipeList == null)){
			System.out.println("Lista de receitas carregada corretamente..");
		} else {
			System.out.println("Nenhum arquivo para lista de receitas, criando novo..");
			this.recipeList = new ArrayList<Recipe>();
		}
	}

	public ArrayList<Recipe> getRecipeList() {
		return recipeList;
	}

	public void setRecipeList(ArrayList<Recipe> recipeList) {
		this.recipeList = recipeList;
	}

	public void save() {
		Dao.save("recipes", this.recipeList);
	}
	
	public void load(){
		this.recipeList = (ArrayList<Recipe>) Dao.load("recipes");
	}
	
	public void insertRecipe(Recipe item) {
		if(!this.recipeList.contains(item)){
			this.recipeList.add(item);
			this.save();
			System.out.println("Receita salva");
		} else {
			System.out.println("Receita ja existe");
		}
	}
	
	public Recipe getRecipe(Recipe item){
		if(this.recipeList.contains(item)){
			int i = this.recipeList.indexOf(item);
			return this.recipeList.get(i);
		} else {
			System.out.println("Receita nao encontrada");
			return null;
		}
	}
	
	public boolean deleteRecipe(Recipe item) {
		if(this.recipeList.remove(item)){
			this.save();
			System.out.println("Receita removida");
			return true;
		} else {
			System.out.println("Erro ao remover receita");
			return false;
		}
		
	}
	
}
