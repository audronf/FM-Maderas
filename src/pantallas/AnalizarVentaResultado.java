package pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AnalizarVentaResultado {

	public JFrame frmAnalizarVentaResultado;

	public AnalizarVentaResultado() {
		initialize();
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	private void initialize() {
		frmAnalizarVentaResultado = new JFrame();
		frmAnalizarVentaResultado.setResizable(false);
		frmAnalizarVentaResultado.setTitle("FM MADERAS");
		frmAnalizarVentaResultado.setBounds(100, 100, 430, 394);
		frmAnalizarVentaResultado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAnalizarVentaResultado.getContentPane().setLayout(null);
		
		JLabel lblA = new JLabel("An\u00E1lisis de venta");
		lblA.setForeground(new Color(255, 135, 0));
		lblA.setFont(new Font("Dosis", Font.BOLD, 40));
		lblA.setBounds(71, 21, 287, 69);
		frmAnalizarVentaResultado.getContentPane().add(lblA);
		
		JLabel label = new JLabel("Producto:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(70, 102, 69, 20);
		frmAnalizarVentaResultado.getContentPane().add(label);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de Inicio:");
		lblFechaDeInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaDeInicio.setBounds(70, 133, 131, 20);
		frmAnalizarVentaResultado.getContentPane().add(lblFechaDeInicio);
		
		JLabel lblFechaDe = new JLabel("Fecha de fin:");
		lblFechaDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaDe.setBounds(70, 164, 91, 20);
		frmAnalizarVentaResultado.getContentPane().add(lblFechaDe);
		
		JLabel lblCantidadVendida = new JLabel("Cantidad vendida:");
		lblCantidadVendida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCantidadVendida.setBounds(70, 195, 131, 20);
		frmAnalizarVentaResultado.getContentPane().add(lblCantidadVendida);
		
		JLabel lblPrecioPromedioDe = new JLabel("Precio promedio de venta:");
		lblPrecioPromedioDe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrecioPromedioDe.setBounds(70, 226, 187, 20);
		frmAnalizarVentaResultado.getContentPane().add(lblPrecioPromedioDe);
		
		JLabel lblDiferenciaConEl = new JLabel("Diferencia con el precio estimado:");
		lblDiferenciaConEl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDiferenciaConEl.setBounds(70, 257, 240, 20);
		frmAnalizarVentaResultado.getContentPane().add(lblDiferenciaConEl);
		
		JLabel ResProducto = new JLabel("");
		ResProducto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ResProducto.setBounds(149, 101, 69, 20);
		frmAnalizarVentaResultado.getContentPane().add(ResProducto);
		
		JLabel ResFechaInicio = new JLabel("");
		ResFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ResFechaInicio.setBounds(190, 133, 69, 20);
		frmAnalizarVentaResultado.getContentPane().add(ResFechaInicio);
		
		JLabel ResFechaFin = new JLabel("");
		ResFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ResFechaFin.setBounds(171, 164, 69, 20);
		frmAnalizarVentaResultado.getContentPane().add(ResFechaFin);
		
		JLabel ResCantidad = new JLabel("");
		ResCantidad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ResCantidad.setBounds(211, 195, 69, 20);
		frmAnalizarVentaResultado.getContentPane().add(ResCantidad);
		
		JLabel ResPrecioPromedio = new JLabel("");
		ResPrecioPromedio.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ResPrecioPromedio.setBounds(267, 226, 69, 20);
		frmAnalizarVentaResultado.getContentPane().add(ResPrecioPromedio);
		
		JLabel ResDiferencia = new JLabel("");
		ResDiferencia.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ResDiferencia.setBounds(320, 257, 69, 20);
		frmAnalizarVentaResultado.getContentPane().add(ResDiferencia);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAnalizarVentaResultado.dispose();
			}
		});
		btnVolver.setBounds(23, 323, 107, 31);
		frmAnalizarVentaResultado.getContentPane().add(btnVolver);
	}
}
