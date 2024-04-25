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
		setSize(ventana.getSize());
		setBackground(new Color(128, 255, 128));
		setLayout(null);

		JLabel lblNombre = new JLabel("");
		lblNombre.setIcon(new ImageIcon("multimedia/TipografiaAplicacion.png"));
		lblNombre.setBounds(253, 47, 274, 134);
		add(lblNombre);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("multimedia/logoAplicacion.png"));
		lblLogo.setBounds(105, 64, 174, 102);
		add(lblLogo);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBackground(new Color(0, 255, 128));
		panel.setBounds(214, 177, 274, 247);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Contraseña:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(20, 81, 162, 14);
		panel.add(lblNewLabel);

		JLabel lblUsuario = new JLabel("Nombre de Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsuario.setBounds(20, 25, 235, 14);
		panel.add(lblUsuario);

		txtfieldUsuario = new JTextField();
		txtfieldUsuario.setBounds(20, 50, 235, 20);
		panel.add(txtfieldUsuario);
		txtfieldUsuario.setColumns(10);

		textFieldContraseña = new JTextField();
		textFieldContraseña.setBounds(20, 106, 235, 20);
		panel.add(textFieldContraseña);
		textFieldContraseña.setColumns(10);
		
		JButton btnContinuar = new JButton("Iniciar Sesion");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gestion.testUsuarioYContraseña(txtfieldUsuario.getText(), textFieldContraseña.getText()) == true) {
					JOptionPane.showMessageDialog(null, "Has iniciado sesión");
					ventana.cambiarDePanel(3);
				} else {
					JOptionPane.showMessageDialog(null, "usuario o contraseña erronea");

				}
			}
		});

		/**
		 * KeyListener para el campo de contraseña
		 */
		textFieldContraseña.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			/**
			 * Llama al ActionListener del botón si se presiona "Enter" en el campo de
			 * contraseña
			 */
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnContinuar.doClick();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
				
		btnContinuar.setBounds(20, 157, 231, 23);
		panel.add(btnContinuar);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(1);
			}
		});
		btnRegistrarse.setBounds(20, 191, 231, 23);
		panel.add(btnRegistrarse);

	}
}
