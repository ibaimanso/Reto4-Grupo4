package modeloPaneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Login extends JPanel {
	public Login() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\in1dw3\\Downloads\\YFITOPS-23-4-2024(1).png"));
		lblNewLabel.setBounds(253, 46, 274, 134);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\in1dw3\\Downloads\\logoReproductor-removebg-preview.png"));
		lblNewLabel_1.setBounds(-29, 29, 570, 233);
		add(lblNewLabel_1);
	}
}
