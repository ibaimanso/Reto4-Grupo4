package modeloPaneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import logica.GestionDeLaInformacion;
import modelo.Cliente;
import view.VistaPrincipal;

public class Registro extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNombredeUsuario;
	private JTextField textField;
	private JTextField txtConfirmarContraseña;
	private JTextField txtFechaDeNacimiento;
	private JTextField txtIdioma;

	public Registro(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		getContentPane().setBackground(new Color(128, 255, 128));
		setResizable(false);
		setForeground(new Color(128, 255, 128));
		getContentPane().setForeground(new Color(128, 255, 128));
		setBackground(new Color(128, 255, 128));
		setSize(720,660);
		getContentPane().setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("multimedia/logoAplicacion.png"));
		lblLogo.setBounds(115, 0, 147, 139);
		getContentPane().add(lblLogo);

		JLabel lblLogo_1 = new JLabel("");
		lblLogo_1.setIcon(new ImageIcon("multimedia/TipografiaAplicacion.png"));
		lblLogo_1.setBounds(257, 0, 331, 139);
		getContentPane().add(lblLogo_1);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBackground(new Color(0, 255, 128));
		panel.setBounds(115, 132, 456, 446);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombre.setBounds(50, 22, 368, 27);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBounds(50, 49, 133, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblApellido.setBounds(236, 22, 182, 27);
		panel.add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(236, 49, 133, 20);
		panel.add(txtApellido);

		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario:");
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombreDeUsuario.setBounds(50, 78, 368, 27);
		panel.add(lblNombreDeUsuario);

		txtNombredeUsuario = new JTextField();
		txtNombredeUsuario.setColumns(10);
		txtNombredeUsuario.setBounds(50, 107, 241, 20);
		panel.add(txtNombredeUsuario);

		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblContrasea.setBounds(50, 138, 368, 27);
		panel.add(lblContrasea);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(50, 169, 241, 20);
		panel.add(textField);

		JLabel lblConfirmarContrasea = new JLabel("Confirmar Contraseña:");
		lblConfirmarContrasea.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConfirmarContrasea.setBounds(50, 200, 368, 27);
		panel.add(lblConfirmarContrasea);

		txtConfirmarContraseña = new JTextField();
		txtConfirmarContraseña.setColumns(10);
		txtConfirmarContraseña.setBounds(50, 230, 241, 20);
		panel.add(txtConfirmarContraseña);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha De Nacimiento:\r\n");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFechaDeNacimiento.setBounds(50, 261, 368, 27);
		panel.add(lblFechaDeNacimiento);

		txtFechaDeNacimiento = new JTextField();
		txtFechaDeNacimiento.setColumns(10);
		txtFechaDeNacimiento.setBounds(50, 290, 241, 20);
		panel.add(txtFechaDeNacimiento);

		JLabel lblIdioma = new JLabel("Idioma:");
		lblIdioma.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblIdioma.setBounds(50, 333, 76, 27);
		panel.add(lblIdioma);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				cliente.setNombre(txtNombredeUsuario.getText());
				cliente.setApellido(txtApellido.getText());
				cliente.setContraseña(txtConfirmarContraseña.getText());
				cliente.setFecha_de_nacimiento(txtFechaDeNacimiento.getText());
				cliente.setIdioma(txtIdioma.getText());
				
				if(!gestion.recogerInformacionFormulario(cliente)) {
					JOptionPane.showMessageDialog(null, "Parametros incorrectos");
				}else {
					if(!gestion.validarExistenciaEnLaBaseDeDatos(cliente)) {
						JOptionPane.showMessageDialog(null, "Usuario ya existe en la base de datos");
					}else {
						JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
						ventana.cambiarDePanel(1);
					}
				}
				
			}
		});

	
		btnRegistrarse.setBounds(50, 387, 241, 23);
		panel.add(btnRegistrarse);

		JButton btnNewButton = new JButton("PREMIUM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(340, 387, 89, 23);
		panel.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("¿Quieres \r");
		lblNewLabel.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 14));
		lblNewLabel.setBounds(343, 322, 86, 49);
		panel.add(lblNewLabel);

		JLabel lblVentajas = new JLabel("ventajas?");
		lblVentajas.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 14));
		lblVentajas.setBounds(340, 343, 89, 49);
		panel.add(lblVentajas);
		
		txtIdioma = new JTextField();
		txtIdioma.setColumns(10);
		txtIdioma.setBounds(128, 339, 152, 20);
		panel.add(txtIdioma);
	}
}
