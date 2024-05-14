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
	private JTextField nombreAudio;
	private JLabel idaudio;
	private int contador;
	private JTextField textduracion;
	private JTextField Idalbum;
	private JTextField textidcancion;
	private JTextField ldAudio;

	public AdminCanciones(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		setLayout(null);
		gestion.recogerCancionesDeLaBaseDeDatosAdmin();
		canciones = gestion.devolverCanciones();
		contador = 0;

		setBackground(new Color(0, 255, 127));
		setSize(ventana.getSize());
		// setSize(new Dimension(709, 600));

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

			JButton btnLimpiar = new JButton("Limpiar");
			btnLimpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					nombreAudio.setText("");
					textidcancion.setText("");
					textduracion.setText("");
					Idalbum.setText("");
					ldAudio.setText("");
					
				}
			});
			btnLimpiar.setBounds(423, 491, 226, 23);
			add(btnLimpiar);
			
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
		
//		JButton btnNewButton = new JButton("Editar");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				gestion.editarCancionAdministrador(ldAudio.getText(), textidcancion.getText(), nombreAudio.getText(), textduracion.getText(),Idalbum.getText());
//				
//			}
//		});
//		btnNewButton.setBounds(423, 186, 226, 23);
//		add(btnNewButton);
		
		nombreAudio = new JTextField(canciones.get(contador).getNombreAudio());
		nombreAudio.setBounds(410, 311, 106, 20);
		add(nombreAudio);
		nombreAudio.setColumns(10);

		JLabel lblTitulo = new JLabel("Nombre:");
		lblTitulo.setBounds(410, 286, 58, 14);
		add(lblTitulo);

		JLabel lblID = new JLabel("ID Audio:");
		lblID.setBounds(526, 243, 111, 14);
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

		JButton bntCerrarSesion = new JButton("");
		bntCerrarSesion.setIcon(new ImageIcon("multimedia/cerrarSesion.png"));
		bntCerrarSesion.setFocusPainted(false);
		bntCerrarSesion.setBorderPainted(false);
		bntCerrarSesion.setContentAreaFilled(false);
		bntCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(0, 0);
			}
		});

		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setBounds(410, 422, 46, 14);
		add(lblImagen);

		JScrollPane scrollArtista = new JScrollPane(panel);
		scrollArtista.getVerticalScrollBar().setUnitIncrement(30);
		scrollArtista.setSize(350, 490);
		scrollArtista.setLocation(34, 65);
		add(scrollArtista);

		JLabel ID_audio = new JLabel("");
		ID_audio.setBounds(620, 286, 51, 14);
		add(ID_audio);

		JLabel lblIdCanciones = new JLabel("ID Canciones:");
		lblIdCanciones.setBounds(526, 286, 205, 14);
		add(lblIdCanciones);

		textidcancion = new JTextField(canciones.get(contador).getDuracion());
		textidcancion.setColumns(10);
		textidcancion.setBounds(531, 311, 106, 20);
		add(textidcancion);

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

		Idalbum = new JTextField(canciones.get(contador).getIdAlbum());
		Idalbum.setColumns(10);
		Idalbum.setBounds(536, 363, 106, 20);
		add(Idalbum);

		ldAudio = new JTextField(canciones.get(contador).getIdAudio());
		ldAudio.setColumns(10);
		ldAudio.setBounds(526, 266, 106, 20);
		add(ldAudio);
	}

	@Override
	public void cambiarContenidoDeLabels() {
		ldAudio.setText(canciones.get(contador).getIdAudio());
		textidcancion.setText(canciones.get(contador).getIdCancion());

		nombreAudio.setText(canciones.get(contador).getNombreAudio());

		textduracion.setText(Integer.toString(canciones.get(contador).getDuracion()));

		Idalbum.setText(canciones.get(contador).getIdAlbum());

	}
}
