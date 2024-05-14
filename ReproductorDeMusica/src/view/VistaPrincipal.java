package view;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import logica.GestionDeLaInformacion;
import modeloPaneles.AdminAlbumes;
import modeloPaneles.AdminCanciones;
import modeloPaneles.DescubrirMusica;
import modeloPaneles.Login;
import modeloPaneles.Menu;
import modeloPaneles.MenuPanelAdmin;
import modeloPaneles.MenuPlayList;
import modeloPaneles.PanelAdministrador;
import modeloPaneles.PanelAlbum;
import modeloPaneles.PanelArtista;
import modeloPaneles.PanelDescubrirPodcast;
import modeloPaneles.PanelPlayList;
import modeloPaneles.PanelPodcast;
import modeloPaneles.PanelReproducion;
import modeloPaneles.PanelReproducionPodcasts;
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
		setLocationRelativeTo(null);
		setResizable(false);
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				gestion.borrarAudiosDelSistema();
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
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
		case 10:
			setContentPane(new PanelDescubrirPodcast(this, gestion));
			break;
		case 11:
			setContentPane(new MenuPanelAdmin(this, gestion));
			break;
		case 12:
			setContentPane(new AdminAlbumes(this, gestion));
			break;
		case 13:
			setContentPane(new AdminCanciones(this, gestion));
			break;
		case 14:
			setContentPane(new MenuPlayList(this, gestion));
			break;
		case 15:
			setContentPane(new PanelPlayList(this, gestion));
			break;
		case 16:
			setContentPane(new PanelPodcast(this, gestion));
			break;
		case 17:
			setContentPane(new PanelReproducionPodcasts(this, gestion, cont));
			break;
		
	
		}
	}
}
