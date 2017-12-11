package pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.time.DayOfWeek;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnalizarVenta {

	public JFrame frmAnalizarVenta;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public AnalizarVenta() {
		initialize();
	}

	private void initialize() {
		frmAnalizarVenta = new JFrame();
		frmAnalizarVenta.setResizable(false);
		frmAnalizarVenta.setTitle("FM MADERAS");
		frmAnalizarVenta.setBounds(100, 100, 468, 384);
		frmAnalizarVenta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAnalizarVenta.getContentPane().setLayout(null);
		
		JLabel lblAnalizarVenta = new JLabel("Analizar  Venta");
		lblAnalizarVenta.setBounds(95, 11, 287, 69);
		lblAnalizarVenta.setForeground(new Color(255, 135, 0));
		lblAnalizarVenta.setFont(new Font("Dosis", Font.BOLD, 40));
		frmAnalizarVenta.getContentPane().add(lblAnalizarVenta);
		
		JLabel lblPerdoname = new JLabel("Producto:");
		lblPerdoname.setBounds(32, 138, 69, 20);
		lblPerdoname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmAnalizarVenta.getContentPane().add(lblPerdoname);
		
		JLabel lblMujer = new JLabel("Inicio Per\u00EDodo:");
		lblMujer.setBounds(32, 182, 105, 20);
		lblMujer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmAnalizarVenta.getContentPane().add(lblMujer);
		
		JLabel lblFinPeriodo = new JLabel("Fin Per\u00EDodo:");
		lblFinPeriodo.setBounds(32, 226, 86, 20);
		lblFinPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		frmAnalizarVenta.getContentPane().add(lblFinPeriodo);
		
		textField = new JTextField();
		textField.setBounds(118, 138, 224, 20);
		frmAnalizarVenta.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(352, 135, 79, 23);
		frmAnalizarVenta.getContentPane().add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(147, 182, 37, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		frmAnalizarVenta.getContentPane().add(comboBox);
		
		JLabel lblDe = new JLabel("de");
		lblDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDe.setBounds(194, 182, 23, 20);
		frmAnalizarVenta.getContentPane().add(lblDe);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		comboBox_1.setBounds(227, 182, 86, 20);
		frmAnalizarVenta.getContentPane().add(comboBox_1);
		
		JLabel label = new JLabel("de");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(323, 182, 23, 20);
		frmAnalizarVenta.getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(352, 182, 53, 20);
		frmAnalizarVenta.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_2.setBounds(147, 224, 37, 20);
		frmAnalizarVenta.getContentPane().add(comboBox_2);
		
		JLabel label_1 = new JLabel("de");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(194, 224, 23, 20);
		frmAnalizarVenta.getContentPane().add(label_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		comboBox_3.setBounds(227, 224, 86, 20);
		frmAnalizarVenta.getContentPane().add(comboBox_3);
		
		JLabel label_2 = new JLabel("de");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(323, 224, 23, 20);
		frmAnalizarVenta.getContentPane().add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(352, 224, 53, 20);
		frmAnalizarVenta.getContentPane().add(textField_2);
		
		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAnalizarVenta.dispose();
			}
		});
		button.setBounds(30, 303, 107, 31);
		frmAnalizarVenta.getContentPane().add(button);
		
		JButton btnAnalizar = new JButton("Analizar");
		btnAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnalizarVentaResultado avr = new AnalizarVentaResultado();
				avr.frmAnalizarVentaResultado.setVisible(true);
			}
		});
		btnAnalizar.setBounds(314, 303, 107, 31);
		frmAnalizarVenta.getContentPane().add(btnAnalizar);
	}
}
