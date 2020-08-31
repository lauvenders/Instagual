package user_interface;
import com.instagual.instagual.*;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class Ver_usuario_inv_ extends Ver_usuario_inv_ventana {
	public Acciones_de_publicacion_inv_ _acciones_de_publicacion_inv_;
	public Listado_de_publicaciones_usuario_inv_ _listado_de_publicaciones_usuario_inv_;
	Ver_listado_de_publicaciones_propias publicaciones = new Ver_listado_de_publicaciones_propias(null);
	public Ver_usuario_inv_() {
		mainLayout.addComponent(publicaciones);
		busquedaLayout.setVisible(false);
		
		AbsoluteLayout aux = new AbsoluteLayout();
		aux.setHeight("50px");
		mainLayout.addComponent(aux);
		
		publicaciones.setVisible(true);
		//this.botonOpciones.setVisible(false);
		//this.seguirBtn.setVisible(false);
		
		this.numSeguidores.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				mainLayout.setVisible(false);
				addComponent(new Ver_listado_seguidores());
				
			}
		});
		
		this.numSeguidos.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				mainLayout.setVisible(false);
				addComponent(new Ver_listado_usuarios_seguidos());
			}
			
		});
		
		this.seguirBtn.setCaption("Seguir");
		this.seguirBtn.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				if (seguirBtn.getCaption() == "Seguir") {
					// TODO: seguir
					seguirBtn.setCaption("Siguiendo");
					seguirBtn.setStyleName("siguiendo small");
				} else {
					seguirBtn.setCaption("Seguir");
					seguirBtn.setStyleName("primary small");
				}
			}
		});
	}
	
}