package view;

import java.awt.Toolkit;

import javax.swing.JFrame;

import logica.GestionDeLaInformacion;
import modeloPaneles.Login;

public class VistaPrincipal extends JFrame{
	
	private GestionDeLaInformacion gestion;

	private static final long serialVersionUID = 1L;

	public VistaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gestion = new GestionDeLaInformacion();
		setIconImage(Toolkit.getDefaultToolkit().getImage("multimedia/logo.jpg"));
		setLocationRelativeTo(null);
		// cambiarDePanel(0);
		setSize(760,600);
		setResizable(false);
	}
	
	public void cambiarDePanel(int i) {

		switch (i) {
		case 0:
			setContentPane(new Login(this, gestion));
			break;
	
	
		}
	}
}
