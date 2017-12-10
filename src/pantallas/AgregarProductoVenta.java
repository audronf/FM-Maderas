package pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AgregarProductoVenta {

	private JFrame frmFmMaderas;
	private JTextField textField;

	public AgregarProductoVenta() {
		initialize();
	}

	private void initialize() {
		frmFmMaderas = new JFrame();
		frmFmMaderas.setTitle("FM MADERAS");
		frmFmMaderas.setResizable(false);
		frmFmMaderas.setBounds(100, 100, 450, 418);
		frmFmMaderas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmFmMaderas.getContentPane().setLayout(null);
		
		JLabel lblAgregarProducto = new JLabel("Agregar producto a venta");
		lblAgregarProducto.setForeground(new Color(255, 135, 0));
		lblAgregarProducto.setFont(new Font("Dosis", Font.BOLD, 35));
		lblAgregarProducto.setBounds(38, 11, 406, 69);
		frmFmMaderas.getContentPane().add(lblAgregarProducto);
		
		JLabel lblTipoDeProducto = new JLabel("Tipo de producto:");
		lblTipoDeProducto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoDeProducto.setBounds(38, 91, 136, 20);
		frmFmMaderas.getContentPane().add(lblTipoDeProducto);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"B\u00E1sicos", "Con medida"}));
		comboBox.setBounds(184, 91, 129, 20);
		frmFmMaderas.getContentPane().add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 137, 375, 145);
		frmFmMaderas.getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCantidad.setBounds(48, 299, 77, 20);
		frmFmMaderas.getContentPane().add(lblCantidad);
		
		textField = new JTextField();
		textField.setBounds(125, 301, 107, 20);
		frmFmMaderas.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("Volver");
		button.setBounds(23, 340, 107, 31);
		frmFmMaderas.getContentPane().add(button);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(307, 340, 107, 31);
		frmFmMaderas.getContentPane().add(btnAgregar);
	}

}
