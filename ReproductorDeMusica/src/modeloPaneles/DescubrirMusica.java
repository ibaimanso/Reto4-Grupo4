package modeloPaneles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import logica.GestionDeLaInformacion;
import modelo.Musico;
import view.VistaPrincipal;

public class DescubrirMusica extends JPanel {
	
	private Musico musico;
	private ArrayList<Musico> musicos;
	
	public DescubrirMusica(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		setLayout(null);
		//musicos = gestion.devolverMusicos();
		
		setSize(new Dimension(704, 603));
		
		/**
		 *  Crear un panel para contener los JLabels
		 */
		JPanel panel = new JPanel();
		//panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setLayout(new GridLayout(0,1));
		
		/**
		 *  Agregar JLabels al panel
		 */
		for (int i = 0; i < 40; i++) {
			JPanel panelItem = new JPanel();
			panelItem.setLayout(new GridLayout());
			panelItem.setSize(80, 396); 
			
			// Cargar imagen
//			ImageIcon imageIcon = new ImageIcon("imagenes/cd.jpg");
//			Image image = imageIcon.getImage();
//			Image newImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
//			ImageIcon newImageIcon = new ImageIcon(newImage);
//			JLabel imageLabel = new JLabel(newImageIcon);
//			panelItem.add(imageLabel);

			// Agregar JLabels debajo de la imagen
			JLabel label1 = new JLabel("Nombre: "+i);
			label1.setSize(80,396);;
			panelItem.add(label1);
			//Le damos nombre para identificarlo
			panelItem.setName("panel " + i);
			// Añadir un borde al panelItem
			panelItem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			
			
			// Añadir escuchador al panel
			panelItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			JPanel clickedPanel = (JPanel) e.getSource();
			JOptionPane.showMessageDialog(null, "Has hecho clic en: " + clickedPanel.getName()+"que tiene los labels:"+((JLabel)clickedPanel.getComponent(0)).getText());

			}
			});
			// Agregar panelItem al panel principal
			panel.add(panelItem);
			}
			
		
		JScrollPane scrollArtista = new JScrollPane(panel);
		scrollArtista.getVerticalScrollBar().setUnitIncrement(30);
		scrollArtista.setSize(445, 396);
		scrollArtista.setLocation(34, 65);
		add(scrollArtista);


	}
}
