package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import controller.*;
import model.entity.*;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;

public class Main {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	StockController stockController = new StockController();
	MealController mealController = new MealController();
	RecipeController recipeController = new RecipeController();
	
	
	private JTextField txtCalorias;
	private JTable table;
	private JTextField textField_recipeName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 769, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIngredientes = new JLabel("Ingredientes");
		lblIngredientes.setBounds(12, 12, 97, 15);
		frame.getContentPane().add(lblIngredientes);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(12, 39, 63, 15);
		frame.getContentPane().add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(12, 66, 209, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(227, 39, 97, 15);
		frame.getContentPane().add(lblQuantidade);
		
		textField_1 = new JTextField();
		textField_1.setBounds(233, 66, 79, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCalorias = new JLabel("Calorias");
		lblCalorias.setBounds(336, 39, 70, 15);
		frame.getContentPane().add(lblCalorias);
		
		txtCalorias = new JTextField();
		txtCalorias.setBounds(324, 66, 114, 19);
		frame.getContentPane().add(txtCalorias);
		txtCalorias.setColumns(10);
		
		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setBounds(12, 111, 70, 15);
		frame.getContentPane().add(lblEstoque);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 140, 671, 126);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ingrediente", "Calorias", "Quantidade"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(104);
		table.getColumnModel().getColumn(1).setPreferredWidth(109);
		table.getColumnModel().getColumn(2).setPreferredWidth(112);
		scrollPane.setViewportView(table);
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		StockView.updateStockList(tableModel, stockController);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stockController.addToStock(textField.getText(), Integer.parseInt(txtCalorias.getText()) , Integer.parseInt(textField_1.getText()));
				StockView.updateStockList(tableModel, stockController);
			}
		});
		btnAdicionar.setBounds(465, 63, 117, 25);
		frame.getContentPane().add(btnAdicionar);
		
		
		
		JLabel lblReceitas = new JLabel("Receitas");
		lblReceitas.setBounds(12, 278, 70, 15);
		frame.getContentPane().add(lblReceitas);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(12, 305, 70, 15);
		frame.getContentPane().add(lblNome_1);
		
		textField_recipeName = new JTextField();
		textField_recipeName.setBounds(12, 321, 209, 19);
		frame.getContentPane().add(textField_recipeName);
		textField_recipeName.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(282, 305, 79, 15);
		frame.getContentPane().add(lblDescrio);
		
		JTextArea textArea_recipeDescription = new JTextArea();
		textArea_recipeDescription.setBounds(275, 323, 362, 97);
		frame.getContentPane().add(textArea_recipeDescription);
		
		JButton btnCriarReceita = new JButton("Criar Receita");
		btnCriarReceita.setBounds(24, 377, 142, 25);
		frame.getContentPane().add(btnCriarReceita);
		
		
		
	}
}
