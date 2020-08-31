package user_interface;
import com.instagual.instagual.*;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;

import user_interface.*;

public class Iniciar_sesion extends Iniciar_sesion_ventana {
	Buscar__inv_ buscarInvitado = new Buscar__inv_();
	Listado_de_publicaciones_populares_inv_ listadoPublicacionesInv = new Listado_de_publicaciones_populares_inv_();
	Ver_listado_de_publicaciones listadoPublicaciones = new Ver_listado_de_publicaciones();
	public Usuario_Sin_Registrar _usuario_Sin_Registrar;
	public Iniciar_sesion() {
		mainLayout.addComponent(listadoPublicacionesInv);
		mainLayout.addComponent(listadoPublicaciones);
		listadoPublicacionesInv.setVisible(false);
		listadoPublicaciones.setVisible(false);
		buttonIniciarSesionInv.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
				iniciarSesionInv();
			}
		});
		
		buttonIniciarSesion.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
				iniciarSesion();
			}
		});
		
		recuperarpass.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
				RecuperarPass();
			}
		});
		
		btnRegistrar.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {

				Registrar();
				
			}
		});
		
		
	}
	
	void iniciarSesionInv() {
		imagenPrincipal.setVisible(false);
		loginVertLayout.setVisible(false);
		mainLayout.removeStyleName("LoginPricipalLayout");
		dataLayout.setVisible(false);
		botonesLayout.setVisible(false);
		buscarInvitado.setVisible(false);
		listadoPublicacionesInv.setVisible(true);		
		//buttonIniciarSesion.addComponent();
	}
	
	void iniciarSesion() {
		imagenPrincipal.setVisible(false);
		loginVertLayout.setVisible(false);
		mainLayout.removeStyleName("LoginPricipalLayout");
		dataLayout.setVisible(false);
		botonesLayout.setVisible(false);
		listadoPublicaciones.setVisible(true);
	}
	void RecuperarPass() {
		imagenPrincipal.setVisible(false);
		loginVertLayout.setVisible(false);
		mainLayout.removeStyleName("LoginPricipalLayout");
		dataLayout.setVisible(false);
		botonesLayout.setVisible(false);
		mainLayout.addComponent(new Recuperar_contrasena());
	}
	
	void Registrar() {
		imagenPrincipal.setVisible(false);
		loginVertLayout.setVisible(false);
		mainLayout.removeStyleName("LoginPricipalLayout");
		dataLayout.setVisible(false);
		botonesLayout.setVisible(false);
		mainLayout.addComponent(new Registrarse());
	}
}