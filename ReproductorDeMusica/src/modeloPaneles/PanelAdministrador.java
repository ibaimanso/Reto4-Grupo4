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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import logica.GestionDeLaInformacion;
import modelo.Musico;
import view.VistaPrincipal;

public class PanelAdministrador extends JPanel {
	private JTextField txtNombre;
	private JLabel txtID;
	private JTextField txtDescripcion;
	private ArrayList<Musico> musicos;
	private int contador;

	public PanelAdministrador(VistaPrincipal ventana, GestionDeLaInformacion gestion) {

		gestion.recogerMusicosDeLaBaseDeDatos();
		musicos = gestion.devolverMusicos();
		contador = 0;

		setBackground(new Color(0, 255, 127));
		// setSize(720,600);
		setSize(new Dimension(709, 600));

		setLayout(null);

		JPanel panel1 = new JPanel();
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
		 * Lista
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
					cambiarContenidoTextFields();

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

		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestion.editarArtistaAdministrador(txtNombre.getText(), txtID.getText(), txtDescripcion.getText(), lblClase1.getText());
			}
		});
		btnNewButton.setBounds(423, 186, 226, 23);
		add(btnNewButton);

		JButton btnAadir = new JButton("Añadir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				gestion.añadirMusicoABaseDeDatos(txtNombre.getText(), txtDescripcion.getText(), lblClase1.getText());

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

		txtNombre = new JTextField(musicos.get(contador).getNombre());
		txtNombre.setBounds(410, 311, 106, 20);
		add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblombre = new JLabel("Nombre:");
		lblombre.setBounds(410, 286, 58, 14);
		add(lblombre);

		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(578, 286, 46, 14);
		add(lblID);

		txtID = new JLabel(musicos.get(contador).getId());
		txtID.setBounds(565, 311, 98, 20);
		add(txtID);

		JLabel lblClase = new JLabel("Clase:");
		lblClase.setBounds(412, 341, 46, 14);
		add(lblClase);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(575, 341, 88, 14);
		add(lblDescripcion);

		txtDescripcion = new JTextField(musicos.get(contador).getDescripcion());
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(585, 366, 98, 70);
		add(txtDescripcion);

		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setBounds(410, 422, 46, 14);
		add(lblImagen);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 173, 280, 375);
		add(scrollPane);

		JButton btnAadir_1 = new JButton("Albumes");
		btnAadir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(12);
			}
		});
		btnAadir_1.setBounds(420, 532, 81, 23);
		add(btnAadir_1);

		JButton btnAadir_1_1 = new JButton("Audios");
		btnAadir_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(13);
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
				ventana.cambiarDePanel(0);
			}
		});
		bntCerrarSesion.setBounds(580, 527, 153, 62);
		add(bntCerrarSesion);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				txtDescripcion.setText("");
				txtID.setText("");
			}
		});
		btnLimpiar.setBounds(423, 491, 226, 23);
		add(btnLimpiar);

		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] { "solista", "grupo" }));
		comboBoxTipo.setBounds(410, 366, 106, 22);
		comboBoxTipo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Obtener el elemento seleccionado
				String selectedItem = (String) comboBoxTipo.getSelectedItem();
				// Actualizar el JLabel con el elemento seleccionado
				lblClase1.setText(selectedItem);
			}
		});
		add(comboBoxTipo);
		
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

	}

	public void cambiarContenidoTextFields() {
		txtNombre.setText(musicos.get(contador).getNombre());
		txtDescripcion.setText(musicos.get(contador).getDescripcion());
		txtID.setText(musicos.get(contador).getId());
	}
}
