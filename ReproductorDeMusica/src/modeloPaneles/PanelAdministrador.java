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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import logica.GestionDeLaInformacion;
import modelo.Musico;
import view.VistaPrincipal;

public class PanelAdministrador extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JLabel txtID;
	private JTextArea txtDescripcion;
	private ArrayList<Musico> musicos;
	private int contador;

	public PanelAdministrador(VistaPrincipal ventana, GestionDeLaInformacion gestion) {

		gestion.recogerMusicosDeLaBaseDeDatos();
		musicos = gestion.devolverMusicos();
		contador = 0;

		setBackground(new Color(0, 255, 127));
		setSize(ventana.getSize());
		//setSize(new Dimension(709, 600));

		setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
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
				

				gestion.eliminarArtistaAdministrador(txtID.getText());
				
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
		lblID.setBounds(549, 286, 46, 14);
		add(lblID);

		txtID = new JLabel(musicos.get(contador).getId());
		txtID.setBounds(549, 311, 98, 20);
		add(txtID);

		JLabel lblClase = new JLabel("Clase:");
		lblClase.setBounds(412, 341, 46, 14);
		add(lblClase);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(546, 341, 88, 14);
		add(lblDescripcion);

		txtDescripcion = new JTextArea(musicos.get(contador).getDescripcion());
		txtDescripcion.setWrapStyleWord(true);
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(546, 366, 153, 80);
		add(txtDescripcion);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 173, 280, 375);
		add(scrollPane);

		JButton btnAadir_1 = new JButton("Albumes");
		btnAadir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(12, 0);
			}
		});
		btnAadir_1.setBounds(420, 532, 81, 23);
		add(btnAadir_1);

		JButton btnAadir_1_1 = new JButton("Audios");
		btnAadir_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(13, 0);
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
				ventana.cambiarDePanel(11, 0);
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

	}

	public void cambiarContenidoTextFields() {
		txtNombre.setText(musicos.get(contador).getNombre());
		txtDescripcion.setText(musicos.get(contador).getDescripcion());
		txtID.setText(musicos.get(contador).getId());
	}
}
