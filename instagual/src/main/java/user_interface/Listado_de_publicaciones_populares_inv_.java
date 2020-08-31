package user_interface;

import java.util.Vector;
import user_interface.Publicacion_inv_;
import com.instagual.instagual.*;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
public class Listado_de_publicaciones_populares_inv_ extends Listado_de_publicaciones_populares_inv_ventana {
	public Vector<Publicacion> _list_Publicacion = new Vector<Publicacion>();
	public Invitado _invitado;
	String tipoUsuario ="invitado";
	
	public Listado_de_publicaciones_populares_inv_() {
		listaPublicaciones.addComponent(new Publicacion_inv_(null, null));
		listaPublicaciones.addComponent(new Publicacion_inv_(null, null));
		listaPublicaciones.addComponent(new Publicacion_inv_(null, null));
		btnHome.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
				goHome();
			}
		});
		btnSearch.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
				guestSearch();
			}
		});
	}
	public void goHome() {
		contentLayout.removeAllComponents();
		contentLayout.addComponent(listaPublicaciones);
	}
	
	public void guestSearch() {
		contentLayout.addComponent( new Buscar__inv_());
	}
}