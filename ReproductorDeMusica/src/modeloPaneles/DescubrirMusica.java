package modeloPaneles;

import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import logica.GestionDeLaInformacion;
import modelo.Musico;
import view.VistaPrincipal;

public class DescubrirMusica extends JPanel {
	
	private Musico musico;
	
	public DescubrirMusica(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		setLayout(null);
		
		setSize(ventana.getSize());
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(60, 176, 588, 324);
		add(panel);
		panel.setLayout(null);
		
		JList<String> list = new JList<String>();
		JScrollPane scrollArtista = new JScrollPane(list);
		scrollArtista.setSize(568, 302);
		scrollArtista.setLocation(10, 11);
		panel.add(scrollArtista);
		DefaultListModel<String> artista = new DefaultListModel<String>();
		
		String linea = musico.getNombre();
		artista.addElement(linea);


	}
}
