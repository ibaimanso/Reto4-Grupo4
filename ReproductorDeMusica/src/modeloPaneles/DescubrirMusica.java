package modeloPaneles;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import logica.GestionDeLaInformacion;
import modelo.Musico;
import view.VistaPrincipal;
import java.awt.Dimension;

public class DescubrirMusica extends JPanel {
	
	private Musico musico;
	private ArrayList<Musico> musicos;
	
	public DescubrirMusica(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		setLayout(null);
		//musicos = gestion.devolverMusicos();
		
		setSize(new Dimension(704, 603));
//		JPanel panel = new JPanel();
//		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
//		panel.setBackground(new Color(255, 255, 255));
//		panel.setBounds(34, 65, 568, 133);
//		add(panel);
//		panel.setLayout(null);
		
		JList<JPanel> list = new JList<JPanel>();
		JScrollPane scrollArtista = new JScrollPane(list);
		scrollArtista.setSize(445, 396);
		scrollArtista.setLocation(34, 65);
		//scrollArtista.setLayout(null);
		add(scrollArtista);
		DefaultListModel<JPanel> panelImagenes = new DefaultListModel<JPanel>();
		
		for (int i = 0; i < 7; i++) {
			JPanel panelArtista = new JPanel();
			panelArtista.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
			panelArtista.setBackground(new Color(255, 255, 255));
			//panelArtista.setBounds(34, 65, 568, 133);
			panelArtista.setSize(150, 396);
			panelArtista.setLayout(null);
			panelImagenes.add(i, panelArtista);
		}

		list.setModel(panelImagenes);


	}
}
