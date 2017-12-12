package pantallas;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import javax.swing.JTextField;

import controlador.Controlador;
import excepciones.ClienteException;
import excepciones.ConnectionException;
import excepciones.ProductoException;
import excepciones.VentaException;
import views.ItemVentaView;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import javax.swing.DefaultListModel;

public class RegistrarVenta {

	public JFrame frmRegistrarVenta;
	private JTextField textCuit;
	private JTextField textPrecio;
	private Controlador co;
	private String cuit;
	private List<ItemVentaView> productos;

	public RegistrarVenta(Controlador c, String cuit, List<ItemVentaView> productos) {
		this.cuit=cuit;
		if(productos!=null)
			this.productos=productos;
		else
			this.productos= new ArrayList<ItemVentaView>();
		co=c;
		initialize();
		

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frmRegistrarVenta = new JFrame();
		frmRegistrarVenta.setResizable(false);
		frmRegistrarVenta.setTitle("FM MADERAS");
		frmRegistrarVenta.setBounds(100, 100, 553, 461);
		frmRegistrarVenta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegistrarVenta.getContentPane().setLayout(null);
		
		JLabel lblRegistrarVenta = new JLabel("Registrar  Venta");
		lblRegistrarVenta.setForeground(new Color(255, 135, 0));
		lblRegistrarVenta.setFont(new Font("Dosis", Font.BOLD, 40));
		lblRegistrarVenta.setBounds(134, 11, 287, 69);
		frmRegistrarVenta.getContentPane().add(lblRegistrarVenta);
		
		JLabel lblNewLabel = new JLabel("CUIT Cliente:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(87, 112, 118, 20);
		frmRegistrarVenta.getContentPane().add(lblNewLabel);
		
		textCuit = new JTextField();
		textCuit.setBounds(190, 112, 259, 20);
		frmRegistrarVenta.getContentPane().add(textCuit);
		textCuit.setColumns(10);
		textCuit.setText(cuit);
		
		JCheckBox chckbxConsumidorFinal = new JCheckBox("Consumidor Final");
		chckbxConsumidorFinal.setBounds(342, 139, 107, 23);
		frmRegistrarVenta.getContentPane().add(chckbxConsumidorFinal);
		
		JLabel lblProductos = new JLabel("Productos a vender:");
		lblProductos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductos.setBounds(87, 170, 162, 20);
		frmRegistrarVenta.getContentPane().add(lblProductos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 201, 336, 105);
		frmRegistrarVenta.getContentPane().add(scrollPane);
		
		JList listProd = new JList();
        DefaultListModel<String> model = new DefaultListModel<String>();        
        for( ItemVentaView iv : productos) {
       	  
        		 model.addElement(iv.toString());                                   	
            
            }
        listProd.setModel(model);
		scrollPane.setViewportView(listProd);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(433, 223, 89, 23);
		frmRegistrarVenta.getContentPane().add(btnAgregar);
		btnAgregar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			AgregarProductoVenta apv = new AgregarProductoVenta(co, textCuit.getText(), productos);
			apv.frmFmMaderas.setVisible(true);
			frmRegistrarVenta.dispose();
		}
		});
		JButton btnQuitar = new JButton("Quitar");
		btnQuitar.setBounds(433, 257, 89, 23);
		frmRegistrarVenta.getContentPane().add(btnQuitar);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecio.setBounds(87, 316, 52, 20);
		frmRegistrarVenta.getContentPane().add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(134, 316, 162, 20);
		frmRegistrarVenta.getContentPane().add(textPrecio);
		
		JButton btnRecomendar = new JButton("Recomendar");
		btnRecomendar.setBounds(306, 313, 118, 23);
		frmRegistrarVenta.getContentPane().add(btnRecomendar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(20, 369, 107, 31);
		frmRegistrarVenta.getContentPane().add(btnCancelar);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(406, 369, 107, 31);
		frmRegistrarVenta.getContentPane().add(btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<List<String>> resultado = new ArrayList<List<String>>();
				for(int i=0; i<listProd.getModel().getSize();i++){
					String a=listProd.getModel().getElementAt(i).toString();
					String[] aux= a.split(" ");
					List<String> codCant = new ArrayList<String>();
					codCant.add(aux[0]);
					codCant.add(aux[aux.length-1]);
					resultado.add(codCant);
					try {
						co.registrarVenta(textCuit.getText(), resultado, textPrecio.getText());
					
					textCuit.setText("");
					textPrecio.setText(""); 
					((DefaultListModel)listProd.getModel()).clear();
					productos.clear();
					cuit="";					
					} catch (ConnectionException | ProductoException | ClienteException | VentaException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
			}
			});
	}
}
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

public class RegistrarVenta {

	public JFrame frmRegistrarVenta;
	private JTextField textCuit;
	private JTextField textPrecio;

	public RegistrarVenta() {
		initialize();
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	private void initialize() {
		frmRegistrarVenta = new JFrame();
		frmRegistrarVenta.setResizable(false);
		frmRegistrarVenta.setTitle("FM MADERAS");
		frmRegistrarVenta.setBounds(100, 100, 553, 461);
		frmRegistrarVenta.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegistrarVenta.getContentPane().setLayout(null);
		
		JLabel lblRegistrarVenta = new JLabel("Registrar  Venta");
		lblRegistrarVenta.setForeground(new Color(255, 135, 0));
		lblRegistrarVenta.setFont(new Font("Dosis", Font.BOLD, 40));
		lblRegistrarVenta.setBounds(134, 11, 287, 69);
		frmRegistrarVenta.getContentPane().add(lblRegistrarVenta);
		
		JLabel lblNewLabel = new JLabel("CUIT Cliente:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(87, 112, 118, 20);
		frmRegistrarVenta.getContentPane().add(lblNewLabel);
		
		textCuit = new JTextField();
		textCuit.setBounds(190, 112, 259, 20);
		frmRegistrarVenta.getContentPane().add(textCuit);
		textCuit.setColumns(10);
		
		JCheckBox chckbxConsumidorFinal = new JCheckBox("Consumidor Final");
		chckbxConsumidorFinal.setBounds(342, 139, 107, 23);
		frmRegistrarVenta.getContentPane().add(chckbxConsumidorFinal);
		
		JLabel lblProductos = new JLabel("Productos a vender:");
		lblProductos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProductos.setBounds(87, 170, 162, 20);
		frmRegistrarVenta.getContentPane().add(lblProductos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 201, 336, 105);
		frmRegistrarVenta.getContentPane().add(scrollPane);
		
		JList listProd = new JList();
		listProd.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listProd);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(433, 223, 89, 23);
		frmRegistrarVenta.getContentPane().add(btnAgregar);
		
		JButton btnQuitar = new JButton("Quitar");
		btnQuitar.setBounds(433, 257, 89, 23);
		frmRegistrarVenta.getContentPane().add(btnQuitar);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecio.setBounds(87, 316, 52, 20);
		frmRegistrarVenta.getContentPane().add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(134, 316, 162, 20);
		frmRegistrarVenta.getContentPane().add(textPrecio);
		
		JButton btnRecomendar = new JButton("Recomendar");
		btnRecomendar.setBounds(306, 313, 118, 23);
		frmRegistrarVenta.getContentPane().add(btnRecomendar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(20, 369, 107, 31);
		frmRegistrarVenta.getContentPane().add(btnCancelar);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(406, 369, 107, 31);
		frmRegistrarVenta.getContentPane().add(btnRegistrar);
	}
}
