package user_interface;

import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class Publicacion_inv_ extends Publicacion_busqueda_inv_ {
	public Publicacion_inv_(Ver_listado_de_publicaciones ver_listado_de_publicaciones,
			Ver_listado_de_publicaciones_propias ver_listado_de_publicaciones_propias) {
		super(ver_listado_de_publicaciones, ver_listado_de_publicaciones_propias);
		// TODO Auto-generated constructor stub
	}
	public Listado_de_publicaciones_populares_inv_ _listado_de_publicaciones_populares_inv_;
	public Acciones_de_publicacion_inv_ _acciones_de_publicacion_inv_;
	//public Publicacion_inv_() {
		//me_gusta.setDisableOnClick(true);
	//}
	public void btnComents(){
		VerticalLayout subContent = new VerticalLayout();
		subContent.setMargin(true);
		subContent.addComponent(new Ver_listado_de_comentarios_inv_());
		Window window = new Window();
    	window.setContent(subContent);
        //window.setWidth("-1");
        window.setResizable(false);
        window.setDraggable(false);
        window.center();
        window.setModal(true);

        // Add it to the root component
        UI.getCurrent().addWindow(window);
	}
	public void btnLike() {
		
	}
}