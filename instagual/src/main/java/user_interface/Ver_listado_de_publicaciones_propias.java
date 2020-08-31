package user_interface;

import java.util.Vector;
import user_interface.Publicacion_propia;
import com.instagual.instagual.*;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;

public class Ver_listado_de_publicaciones_propias extends Ver_listado_de_publicaciones_propias_ventana {
	public Ver_usuario_propio _ver_usuario_propio;
	public Vector<Publicacion_propia> _list_Publicacion_propia = new Vector<Publicacion_propia>();
	public Vector<String> imagenesSrc = new Vector<String>();

	public Ver_listado_de_publicaciones_propias(Ver_usuario_propio ver_usuario_propio) {
		this._ver_usuario_propio = ver_usuario_propio;
		inicializar();

	}

	public void inicializar() {
		publicacionesPerfil.removeAllComponents();
		int i = 0;
		datosPrueba();

		for (String src : imagenesSrc) {
			ThemeResource resource = new ThemeResource(src);
			Image image = new Image();
			image.setSizeFull();
			image.setStyleName("gridBorder");
			image.setSource(resource);
			image.setId(String.valueOf(i));
			image.addClickListener(e -> {
				selectImagen(image);
			});
			publicacionesPerfil.addComponent(image);

		}

	}

	public void datosPrueba() {
		for (int i = 0; i < 11; i++) {
			imagenesSrc.add("images/ejemplo.jpeg");
		}
	}
	
	public void selectImagen(Image img) {
		try {
			this._ver_usuario_propio.clear();
			this._ver_usuario_propio.mainLayoutAddComponent(new Publicacion_propia(null, this));
		} catch (Exception e) {
			this.getParent().getParent().setVisible(false);
			((AbstractOrderedLayout) this.getParent().getParent().getParent()).addComponent(new Publicacion(null, null));
		}
	}
		
}