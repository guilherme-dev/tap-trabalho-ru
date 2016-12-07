/**
 * 
 */
package model.dao;

import java.io.*;
import java.util.ArrayList;

import model.entity.*;

/**
 * @author guilherme
 *
 */
public class Dao {
	public static void save(Object el) {
		FileOutputStream fileOut = null;
		try {
			if(el instanceof Ingredient) {
				fileOut = new FileOutputStream("data/ingredient.ser");
			} else if (el instanceof Recipe) {
				fileOut = new FileOutputStream("data/recipes.ser");
			} else if (el instanceof Meal) {
				fileOut = new FileOutputStream("data/meals.ser");
			} else if (el instanceof ArrayList) {
				fileOut = new FileOutputStream("data/stock.ser");
			}
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(el);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in data.ser");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Object load(String elType) {
		FileInputStream fileIn = null;
		Object obj;
		try {
			if(elType.equals("ingredient")) {
				fileIn = new FileInputStream("data/ingredient.ser");
			} else if (elType.equals("recipe")) {
				fileIn = new FileInputStream("data/recipes.ser");
			} else if (elType.equals("meal")) {
				fileIn = new FileInputStream("data/meals.ser");
			} else if (elType.equals("stock")) {
				fileIn = new FileInputStream("data/stock.ser");
			} else {
				return null;
			}
			ObjectInputStream in = new ObjectInputStream(fileIn);
		    obj = in.readObject();
		    in.close();
		    fileIn.close();
		    return obj;
		} catch(IOException e) {
            //e.printStackTrace();
			return null;
        } catch(ClassNotFoundException c) {
            System.out.println("Employee class not found");
            //c.printStackTrace();
            return null;
        }
	}
}
