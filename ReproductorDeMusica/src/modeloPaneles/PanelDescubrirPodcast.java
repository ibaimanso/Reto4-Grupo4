package modeloPaneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.border.LineBorder;

import logica.GestionDeLaInformacion;
import modelo.Podcaster;
import view.VistaPrincipal;

public class PanelDescubrirPodcast extends JPanel {

	private ArrayList<Podcaster> podcasters;
	private int contador;
	private JLabel lblDescripcion_1;

	public PanelDescubrirPodcast(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		
		setBackground(new Color(0, 255, 127));
		setSize(new Dimension(716, 603));
		setLayout(null);
		gestion.recogerPodcastersDeLaBaseDeDatos();
		podcasters = gestion.devolverPodcasters();
		contador = 0;
		
		/**
		 * Lista
		 */
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBackground(new Color(32, 178, 170));
		// panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setLayout(new GridLayout(0, 1));

		/**
		 * Agregar JLabels al panel
		 */
		for (int i = 0; i < podcasters.size(); i++) {
			JPanel panelItem = new JPanel();
			panelItem.setLayout(new GridLayout());
			panelItem.setSize(80, 396);

			/**
			 * Cargar imagen
			 */
			ImageIcon imageIcon = null;
			if (podcasters.get(i).getImagen() == null) {
				imageIcon = new ImageIcon("multimedia/default_perfil.png");
			} else {

				imageIcon = podcasters.get(i).getImagen();
			}
			Image image = imageIcon.getImage();
			Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			ImageIcon newImageIcon = new ImageIcon(newImage);
			JLabel imageLabel = new JLabel(newImageIcon);
			panelItem.add(imageLabel);

			/*
			 * Agregar JLabel de nombre al lado de la imagen
			 */
			JLabel label1 = new JLabel("Nombre: " + podcasters.get(i).getNombre());
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
					cambiarContenidoDeLabels();

				}
			});
			// Agregar panelItem al panel principal
			panel.add(panelItem);
		}

		JScrollPane scrollArtista = new JScrollPane(panel);
		scrollArtista.getVerticalScrollBar().setUnitIncrement(30);
		scrollArtista.setSize(351, 381);
		scrollArtista.setLocation(34, 174);
		add(scrollArtista);

		JLabel lblDescripcion = new JLabel("Descripción:");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDescripcion.setBounds(441, 174, 187, 41);
		add(lblDescripcion);

		JLabel lblDescripcion_1 = new JLabel(podcasters.get(contador).getDescripcion());
		lblDescripcion_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcion_1.setBounds(441, 224, 187, 41);
		add(lblDescripcion_1);

	}

	public void cambiarContenidoDeLabels() {
		lblDescripcion_1.setText(podcasters.get(contador).getDescripcion());
	}
}
