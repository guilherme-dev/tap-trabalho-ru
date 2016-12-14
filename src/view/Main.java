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
import java.awt.Font;
import javax.swing.JComboBox;

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
	private JTextField textField_recipe;
	private JTextField textField_recipeIngredient;
	private JTextField textField_qtyIngredient;
	private JTextField textField_mealName;
	private JTextField textField_mealQuantity;
	private JTextField textField_mealRecipe;

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
		frame.setBounds(100, 100, 1132, 708);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIngredientes = new JLabel("Ingredientes");
		lblIngredientes.setFont(new Font("Dialog", Font.BOLD, 14));
		lblIngredientes.setBounds(12, 12, 123, 15);
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
		lblEstoque.setFont(new Font("Dialog", Font.BOLD, 14));
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
		lblReceitas.setFont(new Font("Dialog", Font.BOLD, 14));
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
		lblDescrio.setBounds(12, 352, 79, 15);
		frame.getContentPane().add(lblDescrio);
		
		JTextArea textArea_recipeDescription = new JTextArea();
		textArea_recipeDescription.setBounds(12, 379, 362, 97);
		frame.getContentPane().add(textArea_recipeDescription);
		
		JButton btnCriarReceita = new JButton("Criar Receita");
		btnCriarReceita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recipe newRecipe = new Recipe(textField_recipeName.getText(), textArea_recipeDescription.getText());
				recipeController.saveRecipe(newRecipe);
			}
		});
		btnCriarReceita.setBounds(12, 488, 142, 25);
		frame.getContentPane().add(btnCriarReceita);
		
		JLabel lblAdicionarIngredientes = new JLabel("Adicionar Ingredientes");
		lblAdicionarIngredientes.setBounds(516, 305, 172, 15);
		frame.getContentPane().add(lblAdicionarIngredientes);
		
		JLabel lblReceita = new JLabel("Receita");
		lblReceita.setBounds(469, 352, 70, 15);
		frame.getContentPane().add(lblReceita);
		
		textField_recipe = new JTextField();
		textField_recipe.setBounds(465, 377, 202, 19);
		frame.getContentPane().add(textField_recipe);
		textField_recipe.setColumns(10);
		
		JLabel lblIngrendiente = new JLabel("Ingrendiente");
		lblIngrendiente.setBounds(703, 352, 117, 15);
		frame.getContentPane().add(lblIngrendiente);
		
		textField_recipeIngredient = new JTextField();
		textField_recipeIngredient.setBounds(703, 377, 202, 19);
		frame.getContentPane().add(textField_recipeIngredient);
		textField_recipeIngredient.setColumns(10);
		
		JLabel lblQuantidade_1 = new JLabel("Quantidade");
		lblQuantidade_1.setBounds(465, 408, 117, 15);
		frame.getContentPane().add(lblQuantidade_1);
		
		textField_qtyIngredient = new JTextField();
		textField_qtyIngredient.setBounds(465, 435, 114, 19);
		frame.getContentPane().add(textField_qtyIngredient);
		textField_qtyIngredient.setColumns(10);
		
		JButton btnAdicionarNaReceita = new JButton("Adicionar na receita");
		btnAdicionarNaReceita.setBounds(638, 432, 239, 25);
		frame.getContentPane().add(btnAdicionarNaReceita);
		
		JLabel lblRefeies = new JLabel("Refeições");
		lblRefeies.setFont(new Font("Dialog", Font.BOLD, 14));
		lblRefeies.setBounds(12, 534, 142, 15);
		frame.getContentPane().add(lblRefeies);
		
		JLabel lblNome_2 = new JLabel("Nome");
		lblNome_2.setBounds(12, 561, 70, 15);
		frame.getContentPane().add(lblNome_2);
		
		textField_mealName = new JTextField();
		textField_mealName.setBounds(12, 588, 209, 19);
		frame.getContentPane().add(textField_mealName);
		textField_mealName.setColumns(10);
		
		JLabel lblServeQuantasPessoas = new JLabel("Serve quantas pessoas");
		lblServeQuantasPessoas.setBounds(254, 561, 184, 15);
		frame.getContentPane().add(lblServeQuantasPessoas);
		
		textField_mealQuantity = new JTextField();
		textField_mealQuantity.setBounds(254, 588, 114, 19);
		frame.getContentPane().add(textField_mealQuantity);
		textField_mealQuantity.setColumns(10);
		
		JButton btnCriarRefeio = new JButton("Criar  Refeição");
		btnCriarRefeio.setBounds(12, 619, 142, 25);
		frame.getContentPane().add(btnCriarRefeio);
		
		JLabel lblAdicionarReceita = new JLabel("Adicionar Receita");
		lblAdicionarReceita.setBounds(516, 551, 163, 34);
		frame.getContentPane().add(lblAdicionarReceita);
		
		textField_mealRecipe = new JTextField();
		textField_mealRecipe.setBounds(516, 588, 167, 19);
		frame.getContentPane().add(textField_mealRecipe);
		textField_mealRecipe.setColumns(10);
		
		JButton btnAdicionarNaRefeio = new JButton("Adicionar na refeição");
		btnAdicionarNaRefeio.setBounds(516, 619, 220, 25);
		frame.getContentPane().add(btnAdicionarNaRefeio);
		
		JButton btnGerarOrdemDe = new JButton("Gerar Ordem de Refeição");
		btnGerarOrdemDe.setBounds(839, 572, 220, 25);
		frame.getContentPane().add(btnGerarOrdemDe);
		
		
		
	}
}
