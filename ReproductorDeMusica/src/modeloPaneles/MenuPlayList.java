package modeloPaneles;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import logica.GestionDeLaInformacion;
import modelo.PlayList;
import view.VistaPrincipal;

public class MenuPlayList extends JPanel {

	private static final long serialVersionUID = 1L;

	private ArrayList<PlayList> playList;
	private int contador;
	private GestionDeLaInformacion gestionInfo;

	public MenuPlayList(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		setBackground(new Color(125, 255, 190));
		setLayout(null);
		setSize(ventana.getSize());
		gestion.recogerPlayListsDeLaBaseDeDatos();
		playList = gestion.devolverPlayLists();
		gestionInfo = gestion;

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBackground(new Color(0, 255, 0));
		panel.setBounds(-48, 0, 762, 140);
		add(panel);
		panel.setLayout(null);

		JPanel panel2 = new JPanel();
		// panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel2.setLayout(new GridLayout(0, 1));

		/**
		 * Agregar JLabels al panel
		 */
		for (int i = 0; i < playList.size(); i++) {
			JPanel panelItem = new JPanel();
			panelItem.setLayout(new GridLayout());
			panelItem.setSize(80, 396);

			JLabel label1 = new JLabel("Nombre: " + playList.get(i).getTitulo());
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

				}
			});
			// Agregar panelItem al panel principal
			panel2.add(panelItem);
		}

		JScrollPane scrollArtista = new JScrollPane(panel2);
		scrollArtista.getVerticalScrollBar().setUnitIncrement(30);
		scrollArtista.setSize(350, 370);
		scrollArtista.setLocation(34, 185);
		add(scrollArtista);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("multimedia/TipografiaAplicacion.png"));
		lblNewLabel.setBounds(179, 9, 313, 118);
		panel.add(lblNewLabel);

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
		panel.add(btnPerfil);

		JLabel lblUsuario = new JLabel();
		// lblUsuario.setText(gestion.devolverNombreUsuario());
		lblUsuario.setBounds(608, 97, 105, 21);
		panel.add(lblUsuario);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(35, 11, 167, 108);
		panel.add(lblLogo);
		lblLogo.setIcon(new ImageIcon("multimedia/logoAplicacion.png"));

		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestion.guardarPlayList(playList.get(contador));
				ventana.cambiarDePanel(15, 0);
			}
		});
		btnSiguiente.setBounds(481, 518, 89, 23);
		add(btnSiguiente);

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

		JButton btnNuevo = new JButton("Nueva Playlist");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gestion.devolverUsuario().getPremium().equalsIgnoreCase("Free")
						&& gestion.cantidadDePlayList() >= 3) {
					JOptionPane.showMessageDialog(null, "Mas de tres playlist creadas");
				} else {
					String respuesta = JOptionPane.showInputDialog(null, "Inserte nombre: ", "Crear PlayList",
							JOptionPane.QUESTION_MESSAGE);
					if (respuesta == null) {
						JOptionPane.showMessageDialog(null, "Inserte algun campo");
					} else if (respuesta.equalsIgnoreCase("Favoritos")) {

						JOptionPane.showMessageDialog(null, "No puedes generar favoritos");
					} else {
						boolean seleccion = false;
						for (int i = 0; i < playList.size(); i++) {
							if (respuesta.equalsIgnoreCase(playList.get(i).getTitulo())) {
								JOptionPane.showMessageDialog(null,
										"No puedes generar una playlist llamada " + playList.get(i).getTitulo());
								seleccion = true;
							}
						}
						if (seleccion == false) {
							gestion.crearPlayList(respuesta);
							ventana.cambiarDePanel(14, 0);
						}
					}
				}
			}
		});
		btnNuevo.setBounds(470, 185, 174, 50);
		add(btnNuevo);

		JButton btnBorrarPlaylist = new JButton("Borrar PlayList");
		btnBorrarPlaylist.setBounds(470, 252, 174, 50);
		btnBorrarPlaylist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (playList.get(contador).getTitulo().equalsIgnoreCase("Favoritos")) {
					gestion.borrarPlayListAdmin(playList.get(contador));
				} else {
					gestion.borrarPlayList(playList.get(contador));
					ventana.cambiarDePanel(14, 0);
				}
			}
		});
		add(btnBorrarPlaylist);

		JButton btnImportar = new JButton("Importar");
		btnImportar.setBounds(470, 325, 174, 50);
		btnImportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File fichero = abrirArchivo();
				String nombrefichero = fichero.getName().split("/")[1];
				if(!nombrefichero.split(".")[1].equalsIgnoreCase("txt")) {
					JOptionPane.showMessageDialog(null, "formato de fichero incorrecto");
				}else {
					importar(nombrefichero.split(".")[1]);
				}
			}
		});
		add(btnImportar);

		JButton btnExportar = new JButton("Exportar");
		btnExportar.setBounds(470, 394, 174, 50);
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestion.guardarPlayList(playList.get(contador));
				gestion.recogerCancionesDeLaBaseDeDatos();
				gestion.escribirFichero();
			}
		});
		add(btnExportar);
	}

	private File abrirArchivo() {
		/** llamamos el metodo que permite cargar la ventana */
		JFileChooser file = new JFileChooser();
		file.showOpenDialog(this);
		/** abrimos el archivo seleccionado */
		file.getSelectedFile().getName();
		return file.getSelectedFile();// El texto se almacena en el JTextArea
	}

	private void importar(String fichero) {
		boolean encontrado = false;
		for (int i = 0; i < playList.size(); i++) {
			if(playList.get(i).getTitulo().equalsIgnoreCase(fichero)) {
				encontrado = true;
			}
		}
		if(encontrado) {
			
		}else {
			if (gestionInfo.devolverUsuario().getPremium().equalsIgnoreCase("Free")){
				if(gestionInfo.cantidadDePlayList() >= 3) {
					JOptionPane.showMessageDialog(null, "Compre premium para mas de 3 playlist");
				}else {
					
				}
				
			}else {
				 
			}
		}
		
	}
}
