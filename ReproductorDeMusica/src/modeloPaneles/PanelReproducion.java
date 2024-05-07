package modeloPaneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import logica.GestionDeLaInformacion;
import modelo.Album;
import modelo.Audio;
import modelo.Cancion;
import view.VistaPrincipal;

public class PanelReproducion extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btnPlay, btnAnterior, btnSiguiente, btnMenu, btnMeGusta;
	private ArrayList<Cancion> canciones;
	private Album album;
	private int contador;
	private JLabel lblNombre;
	
	public PanelReproducion(VistaPrincipal ventana, GestionDeLaInformacion gestion, int contadorPista) {
		setLayout(null);
		gestion.recogerCancionesDeLaBaseDeDatos();
		canciones = gestion.devolverCanciones();
		album = gestion.devolverAlbum();
		this.contador = contadorPista;

		setSize(new Dimension(704, 603));

		JLabel lblInformacion = new JLabel("Información");
		lblInformacion.setBounds(89, 480, 238, 30);
		add(lblInformacion);

		lblNombre = new JLabel(album.getGenero());
		lblNombre.setBounds(89, 505, 238, 30);
		add(lblNombre);
		
		JLabel lblImagenAutor = new JLabel("");
		ImageIcon imageIcon = null;
		if (album.getImagen() == null) {
			imageIcon = new ImageIcon("multimedia/default_perfil.png");
		} else {
			imageIcon = album.getImagen();
		}
		Image image = imageIcon.getImage();
		Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon newImageIcon = new ImageIcon(newImage);
		lblImagenAutor.setIcon(newImageIcon);
		lblImagenAutor.setBounds(185, 75, 300, 300);
		add(lblImagenAutor);

		JButton bntCerrarSesion = new JButton("");
		bntCerrarSesion.setIcon(new ImageIcon("multimedia/cerrarSesion.png"));
		bntCerrarSesion.setFocusPainted(false);
		bntCerrarSesion.setBorderPainted(false);
		bntCerrarSesion.setContentAreaFilled(false);
		bntCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(7);
			}
		});
		bntCerrarSesion.setBounds(38, 22, 153, 62);
		add(bntCerrarSesion);
		
		JButton btnPerfil = new JButton("");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(2);
			}
		});
		btnPerfil.setIcon(new ImageIcon("multimedia/perfil.png"));
		btnPerfil.setBounds(590, 7, 137, 120);
		btnPerfil.setFocusPainted(false);
		btnPerfil.setBorderPainted(false);
		btnPerfil.setContentAreaFilled(false);
		add(btnPerfil);
		
		JLabel lblDuracion = new JLabel((String) null);
		lblDuracion.setBounds(89, 535, 238, 30);
		add(lblDuracion);
		
		JLabel lblAlbum = new JLabel((String) null);
		lblAlbum.setBounds(340, 505, 238, 30);
		add(lblAlbum);
		
		JLabel lblColaboradores = new JLabel((String) null);
		lblColaboradores.setBounds(340, 535, 238, 30);
		add(lblColaboradores);
		
		btnPlay = new JButton("▶");
		btnPlay.setBounds(292, 414, 89, 23);
		add(btnPlay);
		
		btnAnterior = new JButton("▶");
		btnAnterior.setBounds(241, 414, 41, 23);
		add(btnAnterior);
		
		btnSiguiente = new JButton("▶");
		btnSiguiente.setBounds(391, 414, 41, 23);
		add(btnSiguiente);
		
		btnMenu = new JButton("▶");
		btnMenu.setBounds(89, 414, 89, 23);
		add(btnMenu);
		
		btnMeGusta = new JButton("▶");
		btnMeGusta.setBounds(500, 414, 89, 23);
		add(btnMeGusta);
		

	}
}
