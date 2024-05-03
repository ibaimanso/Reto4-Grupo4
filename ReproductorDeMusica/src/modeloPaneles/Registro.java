package modeloPaneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import logica.GestionDeLaInformacion;
import modelo.Cliente;
import view.VistaPrincipal;

public class Registro extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNombredeUsuario;
	private JTextField txtContraseña;
	private JTextField txtConfirmarContraseña;
	private JTextField txtFechaDeNacimiento;
	private JComboBox<String> comboBoxLicencia;
	private JComboBox<String> comboBoxIdioma;

	public Registro(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		setBackground(new Color(128, 255, 128));

		setSize(new Dimension(697, 734));
		setVisible(true);
		setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("multimedia/logoAplicacion.png"));
		lblLogo.setBounds(115, 0, 147, 139);
		add(lblLogo);

		JLabel lblLogo_1 = new JLabel("");
		lblLogo_1.setIcon(new ImageIcon("multimedia/TipografiaAplicacion.png"));
		lblLogo_1.setBounds(257, 0, 331, 139);
		add(lblLogo_1);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBackground(new Color(0, 255, 128));
		panel.setBounds(115, 132, 456, 446);
		add(panel);
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

		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(50, 169, 241, 20);
		panel.add(txtContraseña);

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

		comboBoxIdioma = new JComboBox<String>(
				new DefaultComboBoxModel<String>(new String[] { "ES", "EU", "EN", "FR", "DE" }));
		comboBoxIdioma.setBounds(130, 338, 65, 22);

		panel.add(comboBoxIdioma);

		comboBoxLicencia = new JComboBox<String>();
		comboBoxLicencia.setModel(new DefaultComboBoxModel<String>(new String[] { "Free", "Premium" }));
		comboBoxLicencia.setBounds(291, 338, 66, 22);
		panel.add(comboBoxLicencia);

		JLabel lblFechaHoy = new JLabel();
		lblFechaHoy.setText(LocalDate.now().toString());
		lblFechaHoy.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaHoy.setBounds(370, 11, 97, 14);
		panel.add(lblFechaHoy);

		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(txtNombredeUsuario.getText());
				if (txtNombredeUsuario.getText().equalsIgnoreCase("") || txtApellido.getText().equalsIgnoreCase("")
						|| txtConfirmarContraseña.getText().equalsIgnoreCase("")
						|| txtContraseña.getText().equalsIgnoreCase("")
						|| txtFechaDeNacimiento.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Rellene todos los campos");

				} else if (txtNombredeUsuario.getText().equalsIgnoreCase("admin")) {
					JOptionPane.showMessageDialog(null, "Admin no se puede registrar");
				} else if (!gestion.validarExistenciaEnLaBaseDeDatos(txtNombredeUsuario.getText())) {
					JOptionPane.showMessageDialog(null, "Usuario ya existe en la base de datos");
				} else if (!txtContraseña.getText().equalsIgnoreCase(txtConfirmarContraseña.getText())) {
					JOptionPane.showMessageDialog(null, "Contraseña mal escrita");
				} else if (!gestion.recogerInformacionFormulario(txtFechaDeNacimiento.getText())) {
					JOptionPane.showMessageDialog(null, "Fecha deberia ser año-mes-dia");
				} else {
					Cliente cliente = new Cliente();
					cliente.setNombre(txtNombre.getText());
					cliente.setApellido(txtApellido.getText());
					cliente.setContraseña(txtConfirmarContraseña.getText());
					cliente.setFecha_de_nacimiento(txtFechaDeNacimiento.getText());
					cliente.setContratacion(LocalDateTime.now().toString());
					cliente.setUsuario(txtNombredeUsuario.getText());
					String idioma = comboBoxIdioma.getSelectedItem().toString();
					cliente.setIdioma(idioma);
					String licencia = comboBoxLicencia.getSelectedItem().toString();
					cliente.setPremium(licencia);
					gestion.insertarUsuario(cliente);
					ventana.cambiarDePanel(0);
				}

			}
		});

		btnRegistrarse.setBounds(50, 387, 241, 23);
		panel.add(btnRegistrarse);

		JButton btnNewButton = new JButton("PREMIUM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(2);

			}
		});
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(357, 393, 89, 23);
		panel.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("¿Quieres \r");
		lblNewLabel.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 14));
		lblNewLabel.setBounds(370, 333, 86, 49);
		panel.add(lblNewLabel);

		JLabel lblVentajas = new JLabel("ventajas?");
		lblVentajas.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 14));
		lblVentajas.setBounds(367, 354, 89, 49);
		panel.add(lblVentajas);

		JLabel lblLicencia = new JLabel("Licencia:");
		lblLicencia.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLicencia.setBounds(205, 333, 97, 27);
		panel.add(lblLicencia);
		
		JButton bntCerrarSesion = new JButton("");
		bntCerrarSesion.setIcon(new ImageIcon("multimedia/cerrarSesion.png"));
		bntCerrarSesion.setFocusPainted(false);
		bntCerrarSesion.setBorderPainted(false);
		bntCerrarSesion.setContentAreaFilled(false);
		bntCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(0);
			}
		});
		bntCerrarSesion.setBounds(580, 527, 153, 62);
		add(bntCerrarSesion);

	}

}
