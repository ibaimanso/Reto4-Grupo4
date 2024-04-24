package modeloPaneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logica.GestionDeLaInformacion;
import view.VistaPopUp;

public class PopUpPremium extends JPanel {
	



	public PopUpPremium(VistaPopUp popup, GestionDeLaInformacion gestion) {

		
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
				popup.cambiarDePanel(2);
				
				

			}
		});
		btnNewButton.setBounds(42, 106, 208, 23);
		panel.add(btnNewButton);

		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBackground(new Color(0, 0, 0));
		chckbxNewCheckBox.setBounds(10, 106, 97, 23);
		panel.add(chckbxNewCheckBox);

		JButton btnNewButton_1 = new JButton("Comprar Premium");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(42, 153, 281, 23);
		panel.add(btnNewButton_1);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Users\\in1dw3\\Downloads\\logoReproductor-removebg-preview(1).png"));
		lblLogo.setBounds(-18, 11, 154, 130);
		add(lblLogo);

		JLabel lblLogo_1 = new JLabel("");
		lblLogo_1.setIcon(new ImageIcon("C:\\Users\\in1dw3\\Downloads\\YFITOPS-23-4-2024(2)(1).png"));
		lblLogo_1.setBounds(119, 0, 319, 105);
		add(lblLogo_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\in1dw3\\Downloads\\PREMIUM-24-4-2024(1).png"));
		lblNewLabel.setBounds(129, 84, 256, 46);
		add(lblNewLabel);
	}

	
	}
