/**
 * 
 */
package model.dao;

import java.io.*;

import model.entity.Ingredient;

/**
 * @author guilherme
 *
 */
public class Dao {
	public static <T>  void save(T el) {
		try {
			FileOutputStream fileOut = new FileOutputStream("data/data.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(el);
			out.close();
			fileOut.close();
			System.out.println("Serialized data is saved in data.ser");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static Ingredient find() {
		Ingredient ingr = null;
		try {
	         FileInputStream fileIn = new FileInputStream("data/data.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         ingr = (Ingredient) in.readObject();
	         in.close();
	         fileIn.close();
	    } catch(IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
        }
		return ingr;
	}
}
