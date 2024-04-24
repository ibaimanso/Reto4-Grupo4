package view;

import java.awt.Toolkit;

import javax.swing.JFrame;

import logica.GestionDeLaInformacion;
import modeloPaneles.CondicionesYTerminosDeUso;
import modeloPaneles.PopUpPremium;

public class VistaPopUp extends JFrame {

	private GestionDeLaInformacion gestion;

	public VistaPopUp() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gestion = new GestionDeLaInformacion();
		setIconImage(Toolkit.getDefaultToolkit().getImage("multimedia/iconoApp.png"));
		setLocationRelativeTo(null);
		cambiarDePanel(0);
		setSize(450, 400);
		setResizable(false);
	}

	public void cambiarDePanel(int i) {

		switch (i) {
		case 0:
			setContentPane(new PopUpPremium(this, gestion));
			break;
		case 1:
			setContentPane(new CondicionesYTerminosDeUso(this, gestion));
			break;
		}
	}
}
