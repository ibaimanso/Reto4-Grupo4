package modeloPaneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import logica.GestionDeLaInformacion;
import view.VistaPrincipal;

public class Login extends JPanel {
	private static final long serialVersionUID = 1L;
	public JTextField txtfieldUsuario;
	public JTextField textFieldContraseña;
	

	public Login(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		setBackground(new Color(128, 255, 128));
		setLayout(null);
		
		JLabel lblNombre = new JLabel("");
		lblNombre.setIcon(new ImageIcon("multimedia/TipografiaAplicacion.png"));
		lblNombre.setBounds(281, 47, 274, 134);
		add(lblNombre);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("multimedia/logoAplicacion.png"));
		lblLogo.setBounds(133, 64, 174, 102);
		add(lblLogo);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.setBackground(new Color(0, 255, 128));
		panel.setBounds(270, 171, 274, 218);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contraseña:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 70, 162, 14);
		panel.add(lblNewLabel);
		
		JLabel lblUsuario = new JLabel("Nombre de Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuario.setBounds(10, 11, 235, 14);
		panel.add(lblUsuario);
		
		txtfieldUsuario = new JTextField();
		txtfieldUsuario.setBounds(20, 36, 235, 20);
		panel.add(txtfieldUsuario);
		txtfieldUsuario.setColumns(10);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setBounds(20, 95, 235, 20);
		panel.add(textFieldContraseña);
		textFieldContraseña.setColumns(10);
		
		JButton btnNewButton = new JButton("Iniciar sesion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gestion.testUsuarioYContraseña(txtfieldUsuario.getText(), textFieldContraseña.getText()) == true) {
					JOptionPane.showMessageDialog(null, "Has iniciado sesión");
					ventana.cambiarDePanel(3);
				} else {
					JOptionPane.showMessageDialog(null, "usuario o contraseña erronea");

				}
			}
		});

		
}
}
