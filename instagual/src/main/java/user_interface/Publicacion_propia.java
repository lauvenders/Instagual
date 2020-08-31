package user_interface;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class Publicacion_propia extends Publicacion {

	public Publicacion_propia(Ver_listado_de_publicaciones ver_listado_de_publicaciones,
			Ver_listado_de_publicaciones_propias ver_listado_de_publicaciones_propias) {
		super(ver_listado_de_publicaciones, ver_listado_de_publicaciones_propias);

	}

	public Ver_listado_de_publicaciones_propias _ver_listado_de_publicaciones_propias;
	public Acciones_publicacion_propia _acciones_publicacion_propia;

}