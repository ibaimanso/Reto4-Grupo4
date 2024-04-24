package modeloPaneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import logica.GestionDeLaInformacion;
import view.VistaPopUp;

public class CondicionesYTerminosDeUso extends JPanel{
	

	public CondicionesYTerminosDeUso(VistaPopUp popup,GestionDeLaInformacion gestion) {
		setLayout(null);
		setSize(450,400);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 430, 233);
		add(scrollPane);
		
		JTextPane txtpnTrminosYCondiciones = new JTextPane();
		txtpnTrminosYCondiciones.setText("Términos y Condiciones de Uso para Yfitops\r\n1. Aceptación de los Términos\r\nAl acceder o usar Yfitops, aceptas cumplir con estos Términos y Condiciones de Uso (\"Términos\"). Si no estás de acuerdo con estos Términos, debes dejar de usar la aplicación.\r\n2. Descripción del Servicio\r\nYfitops es una aplicación de música que permite a los usuarios escuchar canciones, crear listas de reproducción y descubrir nuevos artistas. Con una licencia premium, los usuarios pueden disfrutar de música sin anuncios y cambiar de canciones más rápidamente.\r\n3. Registro y Cuentas de Usuario\r\nRequisitos de Registro: Para acceder a la licencia premium, debes registrarte y crear una cuenta. Debes proporcionar información precisa y mantenerla actualizada.\r\nResponsabilidad del Usuario: Eres responsable de la seguridad de tu cuenta y contraseña. Si sospechas que tu cuenta ha sido comprometida, notifícanos de inmediato.\r\nUso No Autorizado: No debes compartir tu cuenta con otros ni permitir el uso no autorizado de tu cuenta.\r\n4. Uso del Servicio\r\nUso Autorizado: La licencia premium está diseñada para uso personal. No puedes redistribuir ni revender acceso a la aplicación ni usarla para actividades comerciales no autorizadas.\r\nProhibiciones: No puedes usar la aplicación para actividades ilegales, ofensivas o que infrinjan derechos de terceros.\r\n5. Tarifas y Pagos\r\nEstructura de Tarifas: El costo de la licencia premium es de $9.99 al mes. Los pagos se realizan a través de tarjeta de crédito o servicios de pago en línea autorizados.\r\nReembolsos y Cancelaciones: Puedes cancelar tu suscripción premium en cualquier momento. No ofrecemos reembolsos por períodos parcialmente usados.\r\n6. Privacidad y Recolección de Datos\r\nPolítica de Privacidad: Consulta nuestra [Política de Privacidad] para saber cómo recopilamos, usamos y protegemos tus datos personales.\r\nConsentimiento del Usuario: Al usar Yfitops, consientes la recopilación y uso de datos según la política de privacidad.\r\n7. Propiedad Intelectual\r\nDerechos del Usuario: Tú posees los derechos sobre el contenido que creas (como listas de reproducción personalizadas).\r\nDerechos de la Compañía: Yfitops posee todos los derechos sobre el software, diseño y contenido de la aplicación, incluidos los derechos de propiedad intelectual y marcas registradas.\r\n8. Limitación de Responsabilidad\r\nYfitops no se hace responsable por daños indirectos, incidentales, o pérdidas resultantes del uso de la aplicación. No garantizamos un tiempo de servicio ininterrumpido ni la ausencia de errores.\r\n9. Resolución de Disputas\r\nLey Aplicable: Estos términos se rigen por las leyes del estado de California, EE. UU.\r\nResolución de Disputas: Las disputas se resolverán a través de arbitraje en San Francisco, California, o en los tribunales locales si el arbitraje no es posible.\r\n10. Cambios a los Términos\r\nYfitops puede actualizar estos términos en cualquier momento. Te notificaremos a través de la aplicación o por correo electrónico cuando haya cambios importantes. Al continuar usando Yfitops, aceptas los términos actualizados.\r\n11. Disposiciones Generales\r\nDivisibilidad: Si alguna parte de estos términos se considera inválida, el resto permanecerá en vigor.\r\nAcuerdo Completo: Estos términos representan el acuerdo completo entre Yfitops y el usuario, y reemplazan cualquier acuerdo anterior.\r\n");
		scrollPane.setViewportView(txtpnTrminosYCondiciones);
		
		JButton btnNewButton = new JButton("Atras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popup.cambiarDePanel(1);
				
			}
		});
		btnNewButton.setBounds(167, 255, 89, 23);
		
			
		
		add(btnNewButton);
	}
}
