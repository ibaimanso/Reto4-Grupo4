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

import logica.GestionDeLaInformacion;
import modelo.Podcaster;
import view.VistaPrincipal;

/**
 * Panel utilizado para la eleción de las los podcasters de la base de datos
 * @author Kaiet Zarzosa
 */
public class PanelDescubrirPodcast extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<Podcaster> podcasters;
	private int contador;
	private JTextArea textAreaDescripcion;

	public PanelDescubrirPodcast(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		
		setBackground(new Color(0, 255, 127));
		setSize(ventana.getSize());
		setLayout(null);
		gestion.recogerPodcastersDeLaBaseDeDatos();
		podcasters = gestion.devolverPodcasters();
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
		
		textAreaDescripcion = new JTextArea(podcasters.get(contador).getDescripcion());
		textAreaDescripcion.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 18));
		textAreaDescripcion.setBackground(new Color(0, 255, 127));
		textAreaDescripcion.setEditable(false);
		textAreaDescripcion.setBounds(441, 222, 243, 140);
		add(textAreaDescripcion);

		
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
		lblDescripcion.setFont(new Font("Franklin Gothic Heavy", Font.PLAIN, 24));
		lblDescripcion.setBounds(441, 174, 187, 41);
		add(lblDescripcion);
		
	
		
		JButton btnNewButton = new JButton("Ir al podcaster");
		btnNewButton.setBounds(441, 458, 187, 48);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestion.guardarPodcaster(podcasters.get(contador));
				ventana.cambiarDePanel(16, 0);
			}
		});
		add(btnNewButton);
		
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

	}

	public void cambiarContenidoDeLabels() {
		textAreaDescripcion.setText(podcasters.get(contador).getDescripcion());
	}
}
