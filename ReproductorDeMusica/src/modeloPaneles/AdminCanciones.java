package modeloPaneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import interfaces.Paneles;
import logica.GestionDeLaInformacion;
import modelo.Cancion;
import view.VistaPrincipal;

public class AdminCanciones extends JPanel implements Paneles {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Cancion> canciones;
	private Cancion cancion;
	private JTextField txtNombre;
	private JLabel idaudio;
	private int contador;
	private JTextField textduracion;
	private JLabel lblIDAudio;
	private JLabel lblIDCancion;
	private JLabel lblIDAlbum;
	
	public AdminCanciones(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		setLayout(null);
		gestion.recogerCancionesDeLaBaseDeDatosAdmin();
		canciones = gestion.devolverCanciones();
		contador = 0;

		setBackground(new Color(0, 255, 127));
		setSize(ventana.getSize());
		// setSize(new Dimension(709, 600));
		

		JPanel panel1 = new JPanel();
		panel1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel1.setBackground(new Color(127, 255, 0));
		panel1.setBounds(0, 0, 754, 142);
		add(panel1);
		panel1.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("multimedia/TipografiaAplicacion.png"));
		lblNewLabel.setBounds(144, 11, 313, 118);
		panel1.add(lblNewLabel);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(0, 13, 167, 108);
		panel1.add(lblLogo);
		lblLogo.setIcon(new ImageIcon("multimedia/logoAplicacion.png"));

		JLabel lblClase1 = new JLabel();
		lblClase1.setBounds(455, 600, 13, 0);
		add(lblClase1);
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				lblIDCancion.setText("");
				textduracion.setText("");
				lblIDAlbum.setText("");
				lblIDAudio.setText("");
				
			}
		});
		btnLimpiar.setBounds(410, 491, 226, 23);
		add(btnLimpiar);
		
		JButton bntCerrarSesion = new JButton("");
		bntCerrarSesion.setIcon(new ImageIcon("multimedia/cerrarSesion.png"));
		bntCerrarSesion.setFocusPainted(false);
		bntCerrarSesion.setBorderPainted(false);
		bntCerrarSesion.setContentAreaFilled(false);
		bntCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(11, 0);
			}
		});
		bntCerrarSesion.setBounds(580, 527, 153, 62);
		add(bntCerrarSesion);

		
		

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
			 * Cargar imagen
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
			 * Agregar JLabel de nombre al lado de la imagen
			 */
			JLabel label1 = new JLabel(canciones.get(i).getNombreAudio());
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
		
	
		txtNombre = new JTextField(canciones.get(contador).getNombreAudio());
		txtNombre.setBounds(410, 311, 106, 20);
		add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblTitulo = new JLabel("Nombre:");
		lblTitulo.setBounds(410, 286, 58, 14);
		add(lblTitulo);

		JLabel lblID = new JLabel("ID Audio:");
		lblID.setBounds(410, 236, 111, 14);
		add(lblID);

		JButton btnNewButton_1 = new JButton("Seleccione archivo...\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * El selector de archivos para guardarlos en el proyecto
				 */
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Seleccione un archivo .ppg");
				/**
				 * Filtro para solo elegir archivos .jpg
				 */
				fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos .jpg", "jpg"));

				int userSelection = fileChooser.showOpenDialog(null);

				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					Path sourcePath = selectedFile.toPath();
					/**
					 * En que parte debe dejar el archivo subido
					 */
					Path destinationPath = new File("multimedia/imagenesInsertadas").toPath();

					try {
						Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
						System.out.println("Archivo subido correctamente a la carpeta 'imagenes/portadasMu'.");
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}

			}
		});
		btnNewButton_1.setBounds(465, 419, 173, 20);
		add(btnNewButton_1);

		
		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setBounds(410, 422, 46, 14);
		add(lblImagen);

		JScrollPane scrollArtista = new JScrollPane(panel);
		scrollArtista.getVerticalScrollBar().setUnitIncrement(30);
		scrollArtista.setSize(350, 387);
		scrollArtista.setLocation(34, 168);
		add(scrollArtista);

		JLabel ID_audio = new JLabel("");
		ID_audio.setBounds(620, 286, 51, 14);
		add(ID_audio);

		JLabel lblIdCanciones = new JLabel("ID Canciones:");
		lblIdCanciones.setBounds(526, 286, 205, 14);
		add(lblIdCanciones);

		JButton btnNewButton_1_1 = new JButton("Seleccione archivo...\r\n");
		btnNewButton_1_1.setBounds(465, 449, 173, 20);
		add(btnNewButton_1_1);

		JLabel lblCanciones = new JLabel("Canciones");
		lblCanciones.setBounds(410, 452, 58, 14);
		add(lblCanciones);

		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setBounds(410, 342, 67, 14);
		add(lblDuracion);

		textduracion = new JTextField(canciones.get(contador).getDuracion());
		textduracion.setColumns(10);
		textduracion.setBounds(410, 363, 106, 20);
		add(textduracion);

		JLabel lblIdalbum = new JLabel("IDAlbum");
		lblIdalbum.setBounds(536, 342, 67, 14);
		add(lblIdalbum);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestion.editarCancionAdministrador(lblIdCanciones.getText(),lblIdCanciones.getText()
						,txtNombre.getText(), textduracion.getText(), lblIdalbum.getText());
			}
		});
		btnNewButton.setBounds(411, 168, 226, 23);
		add(btnNewButton);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestion.eliminarCancionAdministrador(lblIDAudio.getText());
			}
		});
		btnEliminar.setBounds(410, 202, 226, 23);
		add(btnEliminar);
		
		lblIDAudio = new JLabel(canciones.get(contador).getIdAudio());
		lblIDAudio.setBounds(410, 255, 111, 20);
		add(lblIDAudio);
		
		lblIDCancion = new JLabel(canciones.get(contador).getIdCancion());
		lblIDCancion.setBounds(526, 311, 111, 20);
		add(lblIDCancion);
		
		JButton btnNewButton_2 = new JButton("Artista");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(8, 0);
			}
		});
		btnNewButton_2.setBounds(410, 532, 98, 23);
		add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Albumes");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(12, 0);
			}
		});
		btnNewButton_2_1.setBounds(518, 532, 98, 23);
		add(btnNewButton_2_1);
		
		 lblIDAlbum = new JLabel(canciones.get(contador).getIdAlbum());
		lblIDAlbum.setBounds(526, 363, 111, 20);
		add(lblIDAlbum);
	}

	@Override
	public void cambiarContenidoDeLabels() {
		lblIDAudio.setText(canciones.get(contador).getIdAudio());
		lblIDCancion.setText(canciones.get(contador).getIdCancion());

		txtNombre.setText(canciones.get(contador).getNombreAudio());

		textduracion.setText(Integer.toString(canciones.get(contador).getDuracion()));

		lblIDAlbum.setText(canciones.get(contador).getIdAlbum());

	}
}
