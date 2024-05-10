package modeloPaneles;

import java.awt.Color;
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
import modelo.Album;
import view.VistaPrincipal;

public class AdminAlbumes extends JPanel implements Paneles{
	
	private JTextField txtNombre;
	private JTextField txtGenero;
	private JTextField txtAño;
	private JLabel txtID;

	private Album album;
	
	private ArrayList<Album> albums;

	private int contador;


	
	public AdminAlbumes(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		
		gestion.recogerAlbumsDeLaBaseDeDatosAdmin();
		albums = gestion.devolverAlbums();
		contador = 0;
		

		setBackground(new Color(0, 255, 127));
		setSize(720,600);
	//	setSize(new Dimension(709, 600));

		setLayout(null);

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

		/**
		 * Inicio scrollpane
		 */
		/**
		 * Crear un panel para contener los JLabels
		 */
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 1));

		/**
		 * Agregar JLabels al panel
		 */
		for (int i = 0; i < albums.size(); i++) {
			JPanel panelItem = new JPanel();
			panelItem.setLayout(new GridLayout());
			panelItem.setSize(80, 396);

			/**
			 *  Cargar imagen
			 */
			ImageIcon imageIcon = null;
			if (albums.get(i).getImagen() == null) {
				imageIcon = new ImageIcon("multimedia/default_perfil.png");
			} else {
				imageIcon = albums.get(i).getImagen();
			}
			Image image = imageIcon.getImage();
			Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
			ImageIcon newImageIcon = new ImageIcon(newImage);
			JLabel imageLabel = new JLabel(newImageIcon);
			panelItem.add(imageLabel);

			/*
			 *  Agregar JLabel de nombre al lado de la imagen
			 */
			JLabel label1 = new JLabel(albums.get(i).datosPanel());
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
				cambiarContenidoDeLabels();
					
				}
			});
			// Agregar panelItem al panel principal
			panel.add(panelItem);
		}

		JScrollPane scrollArtista = new JScrollPane(panel);
		scrollArtista.getVerticalScrollBar().setUnitIncrement(30);
		scrollArtista.setSize(350, 369);
		scrollArtista.setLocation(34, 186);
		add(scrollArtista);
		
		/**
		 * Fin de scrollpane
		 */

		 txtID = new JLabel(albums.get(contador).getIdAlbum());
		 txtID.setBounds(565, 314, 106, 14);
		add(txtID);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestion.editarAlbumAdministrador(txtID.getText(), txtNombre.getText(), txtAño.getText(), txtGenero.getText());
			}
		});
		btnNewButton.setBounds(423, 186, 226, 23);
		add(btnNewButton);

		JButton btnAadir = new JButton("Añadir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

//				gestion.añadirMusicoABaseDeDatos(txtNombre.getText(), txtDescripcion.getText(), lblClase1.getText());

			}
		});

		btnAadir.setBounds(423, 457, 226, 23);
		add(btnAadir);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setBounds(423, 235, 226, 23);
		add(btnEliminar);

		txtNombre = new JTextField(albums.get(contador).getTitulo());
		txtNombre.setBounds(410, 311, 106, 20);
		add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setBounds(410, 286, 58, 14);
		add(lblTitulo);

		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(565, 286, 46, 14);
		add(lblID);

		

		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(412, 341, 46, 14);
		add(lblGenero);

		JLabel lblAño = new JLabel("Año:");
		lblAño.setBounds(565, 342, 88, 14);
		add(lblAño);

		txtAño = new JTextField(albums.get(contador).getAño());
		txtAño.setColumns(10);
		txtAño.setBounds(565, 366, 106, 20);
		add(txtAño);

		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setBounds(410, 422, 46, 14);
		add(lblImagen);

		JButton btnAadir_1 = new JButton("Artistas");
		btnAadir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(8);
				
			}
		});
		btnAadir_1.setBounds(420, 532, 81, 23);
		add(btnAadir_1);

		JButton btnAadir_1_1 = new JButton("Audios");
		btnAadir_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAadir_1_1.setBounds(511, 532, 81, 23);
		add(btnAadir_1_1);

		JButton bntCerrarSesion = new JButton("");
		bntCerrarSesion.setIcon(new ImageIcon("multimedia/cerrarSesion.png"));
		bntCerrarSesion.setFocusPainted(false);
		bntCerrarSesion.setBorderPainted(false);
		bntCerrarSesion.setContentAreaFilled(false);
		bntCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(8);
			}
		});
		bntCerrarSesion.setBounds(580, 527, 153, 62);
		add(bntCerrarSesion);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				txtGenero.setText("");
				txtAño.setText("");
				txtID.setText("");
			}
		});
		btnLimpiar.setBounds(423, 491, 226, 23);
		add(btnLimpiar);
		
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
		btnNewButton_1.setBounds(455, 421, 117, 20);
		add(btnNewButton_1);
		
		txtGenero = new JTextField(albums.get(contador).getGenero());
		txtGenero.setColumns(10);
		txtGenero.setBounds(410, 366, 106, 20);
		add(txtGenero);
		
		

	}


	@Override
	public void cambiarContenidoDeLabels() {
		txtNombre.setText(albums.get(contador).getTitulo());
		txtGenero.setText(albums.get(contador).getGenero());
		txtAño.setText(albums.get(contador).getAño());
		txtID.setText(albums.get(contador).getIdAlbum());
		
	}
}
