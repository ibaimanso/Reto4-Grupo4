package modeloPaneles;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import interfaces.Paneles;
import logica.GestionDeLaInformacion;
import modelo.Album;
import modelo.Cancion;
import view.VistaPrincipal;



public class AdminCanciones extends JPanel implements Paneles{
	

	private ArrayList<Cancion> canciones;
	private Album album;
	private int contador;
	private JLabel lblCaracteristica;
	private JLabel lblDescripcion;
	
	
	
	public AdminCanciones(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		setLayout(null);
		gestion.recogerCancionesDeLaBaseDeDatosAdmin();
		canciones = gestion.devolverCanciones();
		contador = 0;
		
		setBackground(new Color(0, 255, 127));
		setSize(720,600);
	//	setSize(new Dimension(709, 600));	
		
		
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
	}

	@Override
	public void cambiarContenidoDeLabels() {
		
	}
	
	

}
