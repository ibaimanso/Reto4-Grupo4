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
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import interfaces.Paneles;
import logica.GestionDeLaInformacion;
import modelo.Musico;
import view.VistaPrincipal;

/**
 * Panel utilizado para dar a elegir al usuario un artista de la base de datos
 * @author Ibai Manso, Kaiet Zarzosa
 */
public class DescubrirMusica extends JPanel implements Paneles {

	private static final long serialVersionUID = 1L;

	private ArrayList<Musico> musicos;
	private int contador;
	private JLabel lblCaracteristica;
	private JTextArea textArea;

	public DescubrirMusica(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		setBackground(new Color(0, 255, 127));
		setLayout(null);
		gestion.recogerMusicosDeLaBaseDeDatos();
		musicos = gestion.devolverMusicos();
		contador = 0;

		//setSize(new Dimension(704, 603));
		setSize(ventana.getSize());
		
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


		/**
		 * Crear un panel para contener los JLabels
		 */
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
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
		scrollArtista.setSize(350, 396);
		scrollArtista.setLocation(34, 159);
		add(scrollArtista);

		JLabel lblTituloCaracteristica = new JLabel("Caracteristica:");
		lblTituloCaracteristica.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 24));
		lblTituloCaracteristica.setBounds(420, 159, 238, 43);
		add(lblTituloCaracteristica);

		lblCaracteristica = new JLabel(musicos.get(contador).getClase());
		lblCaracteristica.setText(musicos.get(contador).getClase().toUpperCase());
		lblCaracteristica.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		lblCaracteristica.setBounds(420, 199, 238, 57);
		add(lblCaracteristica);

		JLabel lblTituloDescripcion = new JLabel("Descripcion:");
		lblTituloDescripcion.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 24));
		lblTituloDescripcion.setBounds(420, 279, 238, 43);
		add(lblTituloDescripcion);

		

		JButton bntCerrarSesion = new JButton("");
		bntCerrarSesion.setIcon(new ImageIcon("multimedia/cerrarSesion.png"));
		bntCerrarSesion.setFocusPainted(false);
		bntCerrarSesion.setBorderPainted(false);
		bntCerrarSesion.setContentAreaFilled(false);
		bntCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(3, 0);
			}
		});
		bntCerrarSesion.setBounds(580, 527, 153, 62);
		add(bntCerrarSesion);

		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(4, 0);
			}
		});
		

		JButton btnSiguiente = new JButton("Ir al artista");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestion.guardarMusico(musicos.get(contador));
				ventana.cambiarDePanel(6, 0);
			}
		});
		btnSiguiente.setBounds(420, 495, 124, 43);
		add(btnSiguiente);
		
		textArea = new JTextArea(musicos.get(contador).getDescripcion());
		textArea.setWrapStyleWord(true);
		textArea.setBackground(new Color(0, 255, 127));
		textArea.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBounds(420, 320, 238, 164);
		add(textArea);

	}

	public void cambiarContenidoDeLabels() {
		lblCaracteristica.setText(musicos.get(contador).getClase().toUpperCase());
		textArea.setText(musicos.get(contador).getDescripcion());
		
	}
}
