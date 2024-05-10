package modeloPaneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import logica.GestionDeLaInformacion;
import view.VistaPrincipal;
import java.awt.Dimension;

public class Menu extends JPanel {

	private static final long serialVersionUID = 1L;

	public Menu(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		setBackground(new Color(125, 255, 190));
		setLayout(null);
		setSize(ventana.getSize());
		

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBackground(new Color(0, 255, 0));
		panel.setBounds(-48, 0, 762, 140);
		add(panel);
		panel.setLayout(null);

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

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_1.setBackground(new Color(50, 205, 50));
		panel_1.setBounds(77, 199, 540, 330);
		add(panel_1);
		panel_1.setLayout(null);

		JButton btnDescubrirMusica = new JButton("Descubrir Musica");
		btnDescubrirMusica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(5, 0);
			}
		});
		btnDescubrirMusica.setBackground(new Color(173, 255, 47)); 

		btnDescubrirMusica.setForeground(Color.BLACK);

		btnDescubrirMusica.setFont(new Font("Arial", Font.BOLD, 16));

		btnDescubrirMusica.setMargin(new Insets(10, 20, 10, 20));

		btnDescubrirMusica.setBounds(144, 55, 234, 43);
		panel_1.add(btnDescubrirMusica);

		JButton btnDescubrirPodcast = new JButton("Descubrir Podcast");
		btnDescubrirPodcast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(10, 0);
			}
		});
		btnDescubrirPodcast.setBounds(144, 135, 234, 43);
		btnDescubrirPodcast.setBackground(new Color(173, 255, 47)); 

		btnDescubrirPodcast.setForeground(Color.BLACK);

		btnDescubrirPodcast.setFont(new Font("Arial", Font.BOLD, 16));

		btnDescubrirPodcast.setMargin(new Insets(10, 20, 10, 20));
		panel_1.add(btnDescubrirPodcast);

		JButton btnPlayList = new JButton("Mis PlayList");
		btnPlayList.setBounds(144, 218, 234, 43);
		btnPlayList.setBackground(new Color(173, 255, 47)); 
		btnPlayList.setForeground(Color.BLACK);
		btnPlayList.setFont(new Font("Arial", Font.BOLD, 16));
		btnPlayList.setMargin(new Insets(10, 20, 10, 20));
		btnPlayList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.cambiarDePanel(10, 0);
			}
		});
		panel_1.add(btnPlayList);

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
		bntCerrarSesion.setBounds(580, 527, 153, 62);
		add(bntCerrarSesion);
	}
}
