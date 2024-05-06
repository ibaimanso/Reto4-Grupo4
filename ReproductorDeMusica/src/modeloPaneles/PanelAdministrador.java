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
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import logica.GestionDeLaInformacion;
import modelo.Musico;
import view.VistaPrincipal;

public class PanelAdministrador extends JPanel {
	private JTextField txtNombre;
	private JTextField txtID;
	private JTextField txtDescripcion;
	private ArrayList<Musico> musicos;
	private int contador;

	public PanelAdministrador(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		
		gestion.recogerMusicosDeLaBaseDeDatos();
		musicos = gestion.devolverMusicos();
		contador = 0;

		setBackground(new Color(0, 255, 127));
		// setSize(720,600);
		setSize(ventana.getSize());

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
			 *  Cargar imagen
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
			 *  Agregar JLabel de nombre al lado de la imagen
			 */
			JLabel label1 = new JLabel("Nombre: "+ musicos.get(i).getNombre());
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
		scrollArtista.setSize(350, 490);
		scrollArtista.setLocation(34, 65);
		add(scrollArtista);
		
		//
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.setBounds(398, 186, 226, 23);
		add(btnNewButton);

		JButton btnAadir = new JButton("Añadir");
		btnAadir.setBounds(398, 457, 226, 23);
		add(btnAadir);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setBounds(398, 233, 226, 23);
		add(btnEliminar);

		txtNombre = new JTextField();
		txtNombre.setBounds(410, 311, 106, 20);
		add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblombre = new JLabel("Nombre:");
		lblombre.setBounds(410, 286, 46, 14);
		add(lblombre);

		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(526, 286, 46, 14);
		add(lblID);

		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(526, 311, 98, 20);
		add(txtID);

		JLabel lblClase = new JLabel("Clase:");
		lblClase.setBounds(412, 341, 46, 14);
		add(lblClase);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(524, 342, 88, 14);
		add(lblDescripcion);

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(526, 367, 98, 70);
		add(txtDescripcion);

		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setBounds(410, 395, 46, 14);
		add(lblImagen);

		JComboBox comboBoxClase = new JComboBox();
		comboBoxClase.setModel(new DefaultComboBoxModel(new String[] { "Solista", "Grupo" }));
		comboBoxClase.setBounds(410, 366, 86, 22);
		add(comboBoxClase);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 173, 280, 375);
		add(scrollPane);

		JButton btnAadir_1 = new JButton("Añadir");
		btnAadir_1.setBounds(398, 504, 106, 23);
		add(btnAadir_1);

		JButton btnAadir_1_1 = new JButton("Añadir");
		btnAadir_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAadir_1_1.setBounds(526, 504, 98, 23);
		add(btnAadir_1_1);
	}
}
