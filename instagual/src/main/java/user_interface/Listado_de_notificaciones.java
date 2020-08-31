package user_interface;

import java.util.Vector;

import com.instagual.instagual.Listado_de_notificaciones_ventana;
import com.vaadin.ui.AbsoluteLayout;

import user_interface.Notificacion;

public class Listado_de_notificaciones extends Listado_de_notificaciones_ventana {
	public Ver_notificaciones _ver_notificaciones;
	public Vector<Notificacion> _list_Notificacion = new Vector<Notificacion>();
	
	public Listado_de_notificaciones() {}

	public Listado_de_notificaciones(Ver_notificaciones ver_notificaciones) {
		this._ver_notificaciones = ver_notificaciones;
		datosPrueba();

		AbsoluteLayout aux = new AbsoluteLayout();
		aux.setHeight("50px");
		mainLayout.addComponent(aux);
	}

	private void datosPrueba() {
		mainLayout.addComponent(new Notificacion("comentario", "usuario1", "Comentario prueba", this));
		
		mainLayout.addComponent(new Notificacion("seguir", "usuario2", null, this));
		
		mainLayout.addComponent(new Notificacion("seguir privado", "usuario3", null, this));
		
		mainLayout.addComponent(new Notificacion("me gusta", "usuario4", null, this));
		
		mainLayout.addComponent(new Notificacion("etiqueta", "usuario5", null, this));
	}
}