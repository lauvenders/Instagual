package user_interface;

import com.instagual.instagual.Ver_notificaciones_ventana;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

public class Ver_notificaciones extends Ver_notificaciones_ventana {
	public Usuario _usuario;
	public Ver_actividad _ver_actividad;
	public Listado_de_notificaciones _listado_de_notificaciones;

	public Ver_notificaciones() {
		TabSheet tb = new TabSheet();
		tb.setStyleName("centered-tabs");
		VerticalLayout v1 = new VerticalLayout();
		v1.setMargin(false);
		v1.setSpacing(false);
		v1.addComponent(new Listado_de_notificaciones(this));
		
		VerticalLayout v2 = new VerticalLayout();
		v2.setMargin(false);
		v2.setSpacing(false);
		v2.addComponent(new Listado_de_notificaciones(this));
		
		tb.addTab(v1, "Notificaciones");
		tb.addTab(v2, "Actividad");
		
		mainLayout.addComponent(tb);
		
	}
	
	public void mainLayoutClear () {
		mainLayout.removeAllComponents();
	}
	
	public void mainLayoutAddComponent (Component component) {
		mainLayout.addComponent(component);
	}
}