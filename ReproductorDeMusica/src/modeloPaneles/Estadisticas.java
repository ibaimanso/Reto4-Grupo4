package modeloPaneles;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import interfaces.Paneles;
import logica.GestionDeLaInformacion;
import view.VistaPrincipal;

import java.awt.Font;

public class Estadisticas extends JPanel implements Paneles {
	public Estadisticas(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		
		setBackground(new Color(0, 255, 127));
		setSize(720,600);
		
		setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel1.setBackground(new Color(127, 255, 0));
		panel1.setBounds(0, 0, 754, 142);
		add(panel1);
		panel1.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("multimedia/TipografiaAplicacion.png"));
		lblNewLabel.setBounds(144, 11, 313, 118);
		panel1.add(lblNewLabel);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(0, 13, 167, 108);
		panel1.add(lblLogo);
		lblLogo.setIcon(new ImageIcon("multimedia/logoAplicacion.png"));

		JLabel lblClase1 = new JLabel();
		lblClase1.setBounds(455, 600, 13, 0);
		add(lblClase1);
		
		JLabel lblNewLabel_1 = new JLabel("Estadisticas");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(362, 165, 348, 136);
		add(lblNewLabel_1);
	}
	
	

	@Override
	public void cambiarContenidoDeLabels() {
		// TODO Auto-generated method stub
		
	}
}
