package view;

import java.awt.Toolkit;


import javax.swing.JFrame;

import logica.GestionDeLaInformacion;
import modeloPaneles.DescubrirMusica;
import modeloPaneles.Login;
import modeloPaneles.Menu;
import modeloPaneles.PanelAlbum;
import modeloPaneles.PanelAdministrador;
import modeloPaneles.PanelArtista;
import modeloPaneles.PanelReproducion;
import modeloPaneles.Perfil;
import modeloPaneles.Registro;

public class VistaPrincipal extends JFrame{
	
	private GestionDeLaInformacion gestion;


	private static final long serialVersionUID = 1L;

	public VistaPrincipal() {
		setTitle("Yfitops");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gestion = new GestionDeLaInformacion();
		setIconImage(Toolkit.getDefaultToolkit().getImage("multimedia/iconoApp.png"));
		setLocationRelativeTo(null);
		// cambiarDePanel(0);
		setSize(720,660);
		setResizable(false);
	}
	
	public void cambiarDePanel(int i, int cont) {

		switch (i) {
		case 0:
			setContentPane(new Login(this, gestion));
			break;
		case 1:
			setContentPane(new Registro(this, gestion));
			break;
		case 2:
			VistaPopUp popup = new VistaPopUp ();
			popup.setVisible(true);
			break;
		case 3:
			setContentPane(new Menu(this, gestion));
			break;
		case 4:
			Perfil perfil = new Perfil(this, gestion);
			perfil.setVisible(true);
			break;
		case 5:
			setContentPane(new DescubrirMusica(this, gestion));
			break;
		case 6:
			setContentPane(new PanelArtista(this, gestion));
			break;
		case 7:
			setContentPane(new PanelAlbum(this, gestion));
			break;
		case 8:
			setContentPane(new PanelAdministrador(this, gestion));
			break;
		case 9:
			setContentPane(new PanelReproducion(this, gestion, cont));
			break;
	
		}
	}
}
