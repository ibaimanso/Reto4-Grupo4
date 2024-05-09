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
import modelo.Cancion;
import view.VistaPrincipal;

public class PanelAlbum extends JPanel {

	private static final long serialVersionUID = 1L;

	private ArrayList<Cancion> canciones;
	private Album album;
	private int contador;
	private JLabel lblCaracteristica;
	private JLabel lblDescripcion;
	
	public PanelAlbum(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		setLayout(null);
		gestion.recogerCancionesDeLaBaseDeDatos();
		canciones = gestion.devolverCanciones();
		album = gestion.devolverAlbum();
		contador = 0;

		setSize(new Dimension(704, 603));

		/**
		 * Crear un panel para contener los JLabels
		 */
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));

		/**
		 * Agregar JLabels al panel
		 */
		for (int i = 0; i < canciones.size(); i++) {
			JPanel panelItem = new JPanel();
			panelItem.setLayout(new GridLayout());
			panelItem.setSize(80, 396);

			/**
			 *  Cargar imagen
			 */
			ImageIcon imageIcon = null;
			if (canciones.get(i).getImagen() == null) {
				imageIcon = new ImageIcon("multimedia/default_perfil.png");
			} else {
				imageIcon = canciones.get(i).getImagen();
			}
			Image image = imageIcon.getImage();
			Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			ImageIcon newImageIcon = new ImageIcon(newImage);
			JLabel imageLabel = new JLabel(newImageIcon);
			panelItem.add(imageLabel);

			/*
			 *  Agregar JLabel de nombre al lado de la imagen
			 */
			JLabel label1 = new JLabel(canciones.get(i).getNombreAudio());
			label1.setSize(80, 396);
			;
			panelItem.add(label1);
			/**
			 *  Le damos un identificador
			 */
			panelItem.setName("" + i);
			/**
			 *  Añadirmos un borde al panelItem para hacerlo mas visual
			 */
			panelItem.setBorder(BorderFactory.createLineBorder(Color.BLACK));

			// Añadir escuchador al panel
			panelItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JPanel clickedPanel = (JPanel) e.getSource();
					contador = Integer.parseInt(clickedPanel.getName());
					
				}
			});
			// Agregar panelItem al panel principal
			panel.add(panelItem);
		}

		JScrollPane scrollArtista = new JScrollPane(panel);
		scrollArtista.getVerticalScrollBar().setUnitIncrement(30);
		scrollArtista.setSize(350, 490);
		scrollArtista.setLocation(34, 65);
		add(scrollArtista);
		
		JLabel lblNombre = new JLabel(album.getTitulo());
		lblNombre.setFont(new Font("Snap ITC", Font.BOLD, 18));
		lblNombre.setBounds(420, 65, 274, 45);
		add(lblNombre);

		JLabel lblTituloCaracteristica = new JLabel("Caracteristica:");
		lblTituloCaracteristica.setBounds(420, 121, 238, 30);
		add(lblTituloCaracteristica);

		lblCaracteristica = new JLabel(album.getGenero());
		lblCaracteristica.setBounds(420, 162, 238, 30);
		add(lblCaracteristica);

		JLabel lblTituloDescripcion = new JLabel("Descripcion:");
		lblTituloDescripcion.setBounds(420, 203, 238, 43);
		add(lblTituloDescripcion);

		lblDescripcion = new JLabel(album.getAño() + " , Nº Canciones "+ album.getNumeroDeCanciones());
		lblDescripcion.setBounds(420, 257, 238, 100);
		add(lblDescripcion);
		
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
		lblImagenAutor.setBounds(470, 379, 100, 100);
		add(lblImagenAutor);

		JButton bntCerrarSesion = new JButton("");
		bntCerrarSesion.setIcon(new ImageIcon("multimedia/cerrarSesion.png"));
		bntCerrarSesion.setFocusPainted(false);
		bntCerrarSesion.setBorderPainted(false);
		bntCerrarSesion.setContentAreaFilled(false);
		bntCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(6, 0);
			}
		});
		bntCerrarSesion.setBounds(580, 527, 153, 62);
		add(bntCerrarSesion);
		
		JButton btnPerfil = new JButton("");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(3, 0);
			}
		});
		btnPerfil.setIcon(new ImageIcon("multimedia/perfil.png"));
		btnPerfil.setBounds(590, 7, 137, 120);
		btnPerfil.setFocusPainted(false);
		btnPerfil.setBorderPainted(false);
		btnPerfil.setContentAreaFilled(false);
		add(btnPerfil);
		
		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(9, contador);
			}
		});
		btnSiguiente.setBounds(481, 518, 89, 23);
		add(btnSiguiente);

	}
}
