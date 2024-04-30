package modeloPaneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import logica.GestionDeLaInformacion;
import modelo.Cliente;
import view.VistaPrincipal;

public class Perfil extends JFrame {
	
	public Perfil(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		
		Cliente cliente = gestion.devolverUsuario();
		
		
		getContentPane().setBackground(new Color(125, 255, 190));
		setBackground(new Color(0, 255, 0));
		getContentPane().setLayout(null);
		setSize(new Dimension(432, 600));
		setResizable(false);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBackground(new Color(128, 255, 0));
		panel.setBounds(-38, 0, 810, 113);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("multimedia/logoAplicacion.png"));
		lblLogo.setBounds(10, 0, 177, 113);
		panel.add(lblLogo);

		JLabel lblTipograsfia = new JLabel("");
		lblTipograsfia.setIcon(new ImageIcon("multimedia/TipografiaAplicacion.png"));
		lblTipograsfia.setBounds(161, 0, 372, 113);
		panel.add(lblTipograsfia);

		JButton btnAtras = new JButton("");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(3);
			}
		});
		// Dejar este boton puede que se le de un uso en otro momento (en este panel no
		// hace nada)

		btnAtras.setIcon(new ImageIcon("C:\\Users\\in1dm3-v\\Downloads\\btnAtras_1__1_-removebg-preview.png"));
		btnAtras.setBounds(650, 11, 89, 91);
		btnAtras.setFocusPainted(false);
		btnAtras.setBorderPainted(false);
		btnAtras.setContentAreaFilled(false);
		panel.add(btnAtras);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 255, 128));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_1.setBounds(10, 139, 396, 411);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombre.setBounds(10, 11, 150, 38);
		panel_1.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblApellido.setBounds(10, 70, 150, 38);
		panel_1.add(lblApellido);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsuario.setBounds(10, 131, 150, 38);
		panel_1.add(lblUsuario);

		JLabel lblFechaDeRegistro = new JLabel("Fecha De Registro:");
		lblFechaDeRegistro.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFechaDeRegistro.setBounds(10, 196, 213, 38);
		panel_1.add(lblFechaDeRegistro);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha De Nacimiento:");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFechaDeNacimiento.setBounds(10, 264, 213, 38);
		panel_1.add(lblFechaDeNacimiento);

		JLabel lblLicencia = new JLabel("Licencia:\r\n");
		lblLicencia.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLicencia.setBounds(10, 325, 213, 38);
		panel_1.add(lblLicencia);

		JLabel lblNombre1 = new JLabel("Nombre");
		lblNombre1.setText(cliente.getNombre());
		lblNombre1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre1.setBounds(10, 40, 150, 38);
		panel_1.add(lblNombre1);

		JLabel lblApellido1 = new JLabel("Apellido");
		lblApellido1.setText(cliente.getApellido());
		lblApellido1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido1.setBounds(10, 100, 150, 38);
		panel_1.add(lblApellido1);

		JLabel lblUsuario1 = new JLabel("Usuario");
		lblUsuario1.setText(cliente.getUsuario());
		lblUsuario1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario1.setBounds(10, 160, 150, 38);
		panel_1.add(lblUsuario1);

		JLabel lblFecha = new JLabel("fecha");
		lblFecha.setText(cliente.getContratacion());
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(10, 227, 150, 38);
		panel_1.add(lblFecha);

		JLabel lblfechaDeNacimiento1 = new JLabel("fecha nacimiento");
		lblfechaDeNacimiento1.setText(cliente.getFecha_de_nacimiento());
		lblfechaDeNacimiento1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblfechaDeNacimiento1.setBounds(10, 291, 150, 38);
		panel_1.add(lblfechaDeNacimiento1);

		JLabel lblLicencia1 = new JLabel("premium o free");
		lblLicencia1.setText(cliente.getPremium());
		lblLicencia1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLicencia1.setBounds(10, 351, 150, 38);
		panel_1.add(lblLicencia1);
		
		JLabel lblIdioma = new JLabel("Idioma:");
	
		lblIdioma.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblIdioma.setBounds(170, 11, 150, 38);
		panel_1.add(lblIdioma);
		
		JLabel lblIdioma1 = new JLabel((String) null);
		lblIdioma1.setText(cliente.getIdioma());
		lblIdioma1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdioma1.setBounds(170, 40, 150, 38);
		panel_1.add(lblIdioma1);
	}

}
