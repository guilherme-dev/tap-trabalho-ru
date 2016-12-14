package view;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import controller.StockController;
import model.entity.Ingredient;

public class StockView {

	public static void updateStockList(DefaultTableModel tableModel, StockController stockController){
		Ingredient tableItem;
		ArrayList<Ingredient> ingredientList = stockController.getStock();
		for(int i = 0; i < ingredientList.size();  i++){
			tableItem = ingredientList.get(i);
			tableModel.addRow(new Object[]{tableItem.getName(), tableItem.getCalories(), tableItem.getQuantity()});
		}
	}
}
