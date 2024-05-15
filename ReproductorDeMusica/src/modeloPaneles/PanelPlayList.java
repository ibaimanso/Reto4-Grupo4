package modeloPaneles;

import java.awt.Color;
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
import javax.swing.border.LineBorder;

import logica.GestionDeLaInformacion;
import modelo.Cancion;
import view.VistaPrincipal;

/**
 * Panel utilizado para la eleción de las canciones dentro de una playlist
 * @author Kaiet Zarzosa
 */
public class PanelPlayList extends JPanel {

	private static final long serialVersionUID = 1L;

	private ArrayList<Cancion> canciones;
	
	private int contador;

	public PanelPlayList(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		setBackground(new Color(125, 255, 190));
		setLayout(null);
		// setSize(ventana.getSize());
		setSize(720, 660);
		gestion.recogerCancionesDeLaBaseDeDatos();
		canciones = gestion.devolverCanciones();

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBackground(new Color(0, 255, 0));
		panel.setBounds(-48, 0, 762, 140);
		add(panel);
		panel.setLayout(null);

		JPanel panel2 = new JPanel();
		// panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel2.setLayout(new GridLayout(0, 1));

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
			JLabel label1 = new JLabel("Nombre: " + canciones.get(i).getNombreAudio());
			label1.setSize(80, 396);
			;
			panelItem.add(label1);
			/**
			 * Le damos un identificador
			 */
			panelItem.setName("" + i);
			/**
			 * Añadirmos un borde al panelItem para hacerlo mas visual
			 */
			panelItem.setBorder(BorderFactory.createLineBorder(Color.BLACK));

			// Añadir escuchador al panel
			panelItem.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JPanel clickedPanel = (JPanel) e.getSource();
					contador = Integer.parseInt(clickedPanel.getName());
					ventana.cambiarDePanel(9, contador);
				}
			});
			// Agregar panelItem al panel principal
			panel2.add(panelItem);
		}

		JScrollPane scrollArtista = new JScrollPane(panel2);
		scrollArtista.getVerticalScrollBar().setUnitIncrement(30);
		scrollArtista.setSize(580, 430);
		scrollArtista.setLocation(34, 185);
		add(scrollArtista);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("multimedia/TipografiaAplicacion.png"));
		lblNewLabel.setBounds(179, 9, 313, 118);
		panel.add(lblNewLabel);

		JButton btnPerfil = new JButton("");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(4, 0);

			}
		});
		btnPerfil.setIcon(new ImageIcon("multimedia/perfil.png"));
		btnPerfil.setBounds(590, 7, 137, 120);
		btnPerfil.setFocusPainted(false);
		btnPerfil.setBorderPainted(false);
		btnPerfil.setContentAreaFilled(false);
		panel.add(btnPerfil);

		JLabel lblUsuario = new JLabel();
		// lblUsuario.setText(gestion.devolverNombreUsuario());
		lblUsuario.setBounds(608, 97, 105, 21);
		panel.add(lblUsuario);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(35, 11, 167, 108);
		panel.add(lblLogo);
		lblLogo.setIcon(new ImageIcon("multimedia/logoAplicacion.png"));

		JButton bntCerrarSesion = new JButton("");
		bntCerrarSesion.setIcon(new ImageIcon("multimedia/cerrarSesion.png"));
		bntCerrarSesion.setFocusPainted(false);
		bntCerrarSesion.setBorderPainted(false);
		bntCerrarSesion.setContentAreaFilled(false);
		bntCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(14, 0);
			}
		});
		bntCerrarSesion.setBounds(580, 527, 153, 62);
		add(bntCerrarSesion);

		
	}
}
