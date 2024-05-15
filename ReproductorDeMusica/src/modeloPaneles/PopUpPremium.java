package modeloPaneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logica.GestionDeLaInformacion;
import view.VistaPopUp;

/**
 * Panel utilizado para la reprodución de los podcasts
 * @author Ibai Manso
 */
public class PopUpPremium extends JPanel {
	
	private static final long serialVersionUID = 1L;

	public PopUpPremium(VistaPopUp popup, GestionDeLaInformacion gestion) {
		
		setSize(new Dimension(681, 545));

		
		setBackground(new Color(128, 255, 128));
		setBackground(new Color(128, 255, 128));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(27, 141, 367, 187);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("VENTAJAS:");
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(10, 11, 175, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("1- Dile adios a los anuncios!\r\n\r\n\r\n");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 36, 291, 14);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("2- Libertad completa para cambiar\r\n\r\n\r\n");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(10, 61, 291, 14);
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("las canciones cuando quieras!\r\n\r\n\r\n\r\n");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(32, 81, 291, 14);
		panel.add(lblNewLabel_1_1_1_1);

		JButton btnNewButton = new JButton("Condiciones y terminos de uso");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popup.cambiarDePanel(1);
				
				

			}
		});
		btnNewButton.setBounds(42, 119, 281, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("MOLA!");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popup.setVisible(false);
			
				
			}
		});
		btnNewButton_1.setBounds(42, 153, 281, 23);
		panel.add(btnNewButton_1);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("multimedia/logoAplicacion.png"));
		lblLogo.setBounds(-18, 11, 154, 130);
		add(lblLogo);

		JLabel lblLogo_1 = new JLabel("");
		lblLogo_1.setIcon(new ImageIcon("multimedia/TipografiaAplicacion.png"));
		lblLogo_1.setBounds(119, 0, 319, 105);
		add(lblLogo_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("multimedia/premium.png")); //cambiar tamaño de las letras premium
		lblNewLabel.setBounds(129, 84, 256, 46);
		add(lblNewLabel);
	}

	
	}
