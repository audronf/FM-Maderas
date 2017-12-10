package pantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MenuPrincipal {

	private JFrame frmPrototipo;
	private JButton btnClientes;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frmPrototipo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MenuPrincipal() {
		initialize();
	}


	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	private void initialize() {
		frmPrototipo = new JFrame();
		frmPrototipo.setResizable(false);
		frmPrototipo.setTitle("Prototipo");
		frmPrototipo.setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		
		frmPrototipo.getContentPane().setBackground(UIManager.getColor("Button.highlight"));
		frmPrototipo.setBounds(100, 100, 808, 540);
		frmPrototipo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrototipo.getContentPane().setLayout(null);
		
		JLabel lblFmMaderas = new JLabel("FM Maderas");
		lblFmMaderas.setForeground(new Color(255, 135, 0));
		lblFmMaderas.setFont(new Font("Dosis", Font.BOLD, 60));
		lblFmMaderas.setBounds(82, 22, 330, 91);
		frmPrototipo.getContentPane().add(lblFmMaderas);
		
		JButton btnProductos = new JButton("Productos");
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnProductos.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 21));
		btnProductos.setBounds(77, 147, 150, 118);
		frmPrototipo.getContentPane().add(btnProductos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(467, 43, 325, 457);
		frmPrototipo.getContentPane().add(scrollPane);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		JLabel lblNotificaciones = new JLabel("Notificaciones");
		lblNotificaciones.setForeground(new Color(255,135,0));
		lblNotificaciones.setFont(new Font("Dosis", Font.BOLD, 20));
		lblNotificaciones.setBounds(467, 11, 174, 38);
		frmPrototipo.getContentPane().add(lblNotificaciones);
		
		btnClientes = new JButton("Clientes");
		btnClientes.setEnabled(false);
		btnClientes.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 21));
		btnClientes.setBounds(237, 147, 150, 118);
		frmPrototipo.getContentPane().add(btnClientes);
		
		JButton btnRegistrarVenta = new JButton("Registrar \r\nVenta\r\n");
		btnRegistrarVenta.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 21));
		btnRegistrarVenta.setBounds(75, 276, 312, 55);
		frmPrototipo.getContentPane().add(btnRegistrarVenta);
		
		JButton btnAnalisisVentas = new JButton("An\u00E1lisis de \r\nVentas\r\n");
		btnAnalisisVentas.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 21));
		btnAnalisisVentas.setBounds(75, 342, 312, 55);
		frmPrototipo.getContentPane().add(btnAnalisisVentas);
	}
}
