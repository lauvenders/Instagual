package user_interface;

import java.util.ArrayList;

import com.instagual.instagual.publicacion_ventana;
import com.vaadin.ui.AbstractOrderedLayout;

public class Publicacion_busqueda_inv_ extends Publicacion {
	public Listado_de_publicaciones_inv_ _listado_de_publicaciones_inv_;
	public Ver_publicacion_inv_ _ver_publicacion_inv_;
	public Ver_listado_de_publicaciones _ver_listado_de_publicaciones;
	//public Ver_listado_de_publicaciones_propias _ver_listado_de_publicaciones_propias;

	public Publicacion_busqueda_inv_(Ver_listado_de_publicaciones ver_listado_de_publicaciones,
			Ver_listado_de_publicaciones_propias ver_listado_de_publicaciones_propias) {
		super(ver_listado_de_publicaciones, ver_listado_de_publicaciones_propias);
		this._ver_listado_de_publicaciones = ver_listado_de_publicaciones;
		//this._ver_listado_de_publicaciones_propias = ver_listado_de_publicaciones_propias;
		
		publicacionBusquedaLayout.setVisible(true);
		mainLayout.setVisible(false);
	}

	public void setValoresBusqueda(Publicacion p) {

		String des = p.descripcion;
		for (String e : p.etiquetas) {
			des += " #" + e;
		}

		this.descripcionLbl2.setValue(des);

		descripcionLbl2.setValue(des);
		usuarioLbl2.setValue("@" + p.usuario);
		// publicacion2.setSource(source);

		publicacion2.addClickListener(e -> {
			this.getParent().getParent().getParent().setVisible(false);
			((AbstractOrderedLayout) this.getParent().getParent().getParent().getParent()).addComponent(new Publicacion(null, null), 0);
			//_ver_listado_de_publicaciones.clear();
			//_ver_listado_de_publicaciones.mainLayoutAddComponent(new Publicacion(null, null));
		});
	}

}