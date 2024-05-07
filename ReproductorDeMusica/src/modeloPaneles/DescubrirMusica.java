package modeloPaneles;

import java.awt.Color;
import java.awt.Dimension;
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

import interfaces.Paneles;
import logica.GestionDeLaInformacion;
import modelo.Musico;
import view.VistaPrincipal;

public class DescubrirMusica extends JPanel implements Paneles {

	private static final long serialVersionUID = 1L;

	private ArrayList<Musico> musicos;
	private int contador;
	private JLabel lblCaracteristica;
	private JLabel lblDescripcion;

	public DescubrirMusica(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		setLayout(null);
		gestion.recogerMusicosDeLaBaseDeDatos();
		musicos = gestion.devolverMusicos();
		contador = 0;

		setSize(new Dimension(704, 603));

		/**
		 * Crear un panel para contener los JLabels
		 */
		JPanel panel = new JPanel();
		// panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setLayout(new GridLayout(0, 1));

		/**
		 * Agregar JLabels al panel
		 */
		for (int i = 0; i < musicos.size(); i++) {
			JPanel panelItem = new JPanel();
			panelItem.setLayout(new GridLayout());
			panelItem.setSize(80, 396);

			/**
			 * Cargar imagen
			 */	
			ImageIcon imageIcon = null;
			if (musicos.get(i).getImagen() == null) {
				imageIcon = new ImageIcon("multimedia/default_perfil.png");
			} else {
				imageIcon = musicos.get(i).getImagen();
			}
			Image image = imageIcon.getImage();
			Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			ImageIcon newImageIcon = new ImageIcon(newImage);
			JLabel imageLabel = new JLabel(newImageIcon);
			panelItem.add(imageLabel);

			/*
			 * Agregar JLabel de nombre al lado de la imagen
			 */
			JLabel label1 = new JLabel("Nombre: " + musicos.get(i).getNombre());
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
		scrollArtista.setSize(350, 490);
		scrollArtista.setLocation(34, 65);
		add(scrollArtista);

		JLabel lblTituloCaracteristica = new JLabel("Caracteristica:");
		lblTituloCaracteristica.setBounds(420, 65, 238, 43);
		add(lblTituloCaracteristica);

		lblCaracteristica = new JLabel(musicos.get(contador).getClase());
		lblCaracteristica.setBounds(420, 119, 238, 57);
		add(lblCaracteristica);

		JLabel lblTituloDescripcion = new JLabel("Descripcion:");
		lblTituloDescripcion.setBounds(420, 203, 238, 43);
		add(lblTituloDescripcion);

		lblDescripcion = new JLabel(musicos.get(contador).getDescripcion());
		lblDescripcion.setBounds(420, 257, 238, 180);
		add(lblDescripcion);

		JButton bntCerrarSesion = new JButton("");
		bntCerrarSesion.setIcon(new ImageIcon("multimedia/cerrarSesion.png"));
		bntCerrarSesion.setFocusPainted(false);
		bntCerrarSesion.setBorderPainted(false);
		bntCerrarSesion.setContentAreaFilled(false);
		bntCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(3);
			}
		});
		bntCerrarSesion.setBounds(580, 527, 153, 62);
		add(bntCerrarSesion);

		JButton btnPerfil = new JButton("");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(4);
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
				gestion.guardarMusico(musicos.get(contador));
				ventana.cambiarDePanel(6);
			}
		});
		btnSiguiente.setBounds(481, 518, 89, 23);
		add(btnSiguiente);

	}

	public void cambiarContenidoDeLabels() {
		lblCaracteristica.setText(musicos.get(contador).getClase());
		lblDescripcion.setText(musicos.get(contador).getDescripcion());
	}
}
