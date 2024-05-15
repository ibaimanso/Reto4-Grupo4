package modeloPaneles;

import java.awt.Color;
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
import javax.swing.border.LineBorder;

import logica.GestionDeLaInformacion;
import modelo.Podcast;
import modelo.Podcaster;
import view.VistaPrincipal;

/**
 * Panel utilizado para la eleción de las podcasts de un podcaster
 * @author Kaiet Zarzosa, Ibai Manso
 */
public class PanelPodcast extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Podcast> podcasts;
	private Podcaster podcaster;
	private int contador;

	public PanelPodcast(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		setBackground(new Color(0, 255, 127));
		setSize(716, 603);
		setLayout(null);
		gestion.recogerPodcastsDeLaBaseDeDatos();
		podcasts = gestion.devolverPodcasts();
		podcaster = gestion.devolverPodcaster();
		contador = 0;

		JPanel panel1 = new JPanel();

		panel1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel1.setBackground(new Color(0, 255, 0));
		panel1.setBounds(-48, 0, 762, 140);
		add(panel1);
		panel1.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("multimedia/TipografiaAplicacion.png"));
		lblNewLabel.setBounds(179, 9, 313, 118);
		panel1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));

		/**
		 * Agregar JLabels al panel
		 */
		for (int i = 0; i < podcasts.size(); i++) {
			JPanel panelItem = new JPanel();
			panelItem.setLayout(new GridLayout());
			panelItem.setSize(80, 396);

			/**
			 *  Cargar imagen
			 */
			ImageIcon imageIcon = null;
			if (podcasts.get(i).getImagen() == null) {
				imageIcon = new ImageIcon("multimedia/default_perfil.png");
			} else {
				imageIcon = podcasts.get(i).getImagen();
			}
			Image image = imageIcon.getImage();
			Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			ImageIcon newImageIcon = new ImageIcon(newImage);
			JLabel imageLabel = new JLabel(newImageIcon);
			panelItem.add(imageLabel);

			/*
			 *  Agregar JLabel de nombre al lado de la imagen
			 */
			JLabel label1 = new JLabel(podcasts.get(i).getNombreAudio());
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
		scrollArtista.setSize(350, 393);
		scrollArtista.setLocation(34, 162);
		add(scrollArtista);

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
		panel1.add(btnPerfil);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(35, 11, 167, 108);
		panel1.add(lblLogo);
		lblLogo.setIcon(new ImageIcon("multimedia/logoAplicacion.png"));
		
		JLabel lblNombre = new JLabel(podcaster.getNombre());
		lblNombre.setFont(new Font("Snap ITC", Font.BOLD, 24));
		lblNombre.setBounds(420, 162, 274, 45);
		add(lblNombre);

		JLabel lblTituloDescripcion = new JLabel("Descripcion:");
		lblTituloDescripcion.setBounds(420, 300, 238, 43);
		lblTituloDescripcion.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 24));
		add(lblTituloDescripcion);

		JLabel lblDescripcion = new JLabel(podcaster.getDescripcion());
		lblDescripcion.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		lblDescripcion.setBounds(420, 318, 238, 73);
		add(lblDescripcion);
		
		JLabel lblImagenAutor = new JLabel("");
		ImageIcon imageIcon = null;
		if (podcaster.getImagen() == null) {
			imageIcon = new ImageIcon("multimedia/default_perfil.png");
		} else {
			imageIcon = podcaster.getImagen();
		}
		Image image = imageIcon.getImage();
		Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon newImageIcon = new ImageIcon(newImage);
		lblImagenAutor.setIcon(newImageIcon);
		lblImagenAutor.setBounds(470, 385, 100, 100);
		add(lblImagenAutor);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(17, contador);
			}
		});
		btnSiguiente.setBounds(420, 490, 202, 51);
		add(btnSiguiente);
		
		JButton bntCerrarSesion = new JButton("");
		bntCerrarSesion.setIcon(new ImageIcon("multimedia/cerrarSesion.png"));
		bntCerrarSesion.setFocusPainted(false);
		bntCerrarSesion.setBorderPainted(false);
		bntCerrarSesion.setContentAreaFilled(false);
		bntCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(10, 0);
			}
		});
		bntCerrarSesion.setBounds(580, 527, 153, 62);
		add(bntCerrarSesion);
	}

}
