package modeloPaneles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import logica.GestionDeLaInformacion;
import view.VistaPrincipal;
import java.awt.Dimension;
import java.awt.Font;

public class Perfil extends JFrame{
	public Perfil(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		getContentPane().setBackground(new Color(125, 255, 190));
		setBackground(new Color(0, 255, 0));
		getContentPane().setLayout(null);
		setSize(new Dimension(432, 600));
		
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
		//Dejar este boton puede que se le de un uso en otro momento (en este panel no hace nada)
		
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
		
		JLabel lblNombre_2 = new JLabel("Nombre");
		lblNombre_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre_2.setBounds(10, 40, 150, 38);
		panel_1.add(lblNombre_2);
		
		JLabel lblNombre_2_1 = new JLabel("Apellido");
		lblNombre_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre_2_1.setBounds(10, 100, 150, 38);
		panel_1.add(lblNombre_2_1);
		
		JLabel lblNombre_2_1_1 = new JLabel("Usuario");
		lblNombre_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre_2_1_1.setBounds(10, 160, 150, 38);
		panel_1.add(lblNombre_2_1_1);
		
		JLabel lblNombre_2_1_1_1 = new JLabel("fecha");
		lblNombre_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre_2_1_1_1.setBounds(10, 227, 150, 38);
		panel_1.add(lblNombre_2_1_1_1);
		
		JLabel lblNombre_2_1_1_1_1 = new JLabel("fecha nacimiento");
		lblNombre_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre_2_1_1_1_1.setBounds(10, 291, 150, 38);
		panel_1.add(lblNombre_2_1_1_1_1);
		
		JLabel lblNombre_2_1_1_1_1_1 = new JLabel("premium o free");
		lblNombre_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre_2_1_1_1_1_1.setBounds(10, 351, 150, 38);
		panel_1.add(lblNombre_2_1_1_1_1_1);
	}
	
	

}
