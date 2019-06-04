package user_interface;
import com.instagual.instagual.*;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import user_interface.*;

public class Iniciar_sesion extends Iniciar_sesion_ventana {
	Buscar__inv_ buscarInvitado = new Buscar__inv_();
	Listado_de_publicaciones_populares_inv_ listadoPublicaciones = new Listado_de_publicaciones_populares_inv_();
	public Usuario_Sin_Registrar _usuario_Sin_Registrar;
	public Iniciar_sesion() {
		mainLayout.addComponent(listadoPublicaciones);
		buscarInvitado.setVisible(false);
		listadoPublicaciones.setVisible(false);
		buttonIniciarSesionInv.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
				IniciarSesionInv();
			}
		});
		
		
		
	}
	
	void IniciarSesionInv() {
		imagenPrincipal.setVisible(false);
		loginVertLayout.setVisible(false);
		horizontalBotones.setVisible(false);
		mainLayout.removeStyleName("LoginPricipalLayout");
		buscarInvitado.setVisible(false);
		listadoPublicaciones.setVisible(true);
		
		//buttonIniciarSesion.addComponent();
	}
}