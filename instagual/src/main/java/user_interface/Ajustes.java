package user_interface;

import com.instagual.instagual.Ajustes_ventana;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

public class Ajustes extends Ajustes_ventana {
	public Ver_usuario_propio _ver_usuario_propio;
	public Modificar_perfil _modificar_perfil = new Modificar_perfil(this);
	public Eliminar_cuenta _eliminar_cuenta = new Eliminar_cuenta();
	public Notificaciones _notificaciones;
	public Listado_de_bloqueados _listado_de_bloqueados = new Listado_de_bloqueados();
	public Privacidad _privacidad;
	
	public Ajustes(Ver_usuario_propio ver_usuario_propio) {
		
		this._ver_usuario_propio = ver_usuario_propio;
		
		modificar_perfil.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				ModificarPerfil();			
			}
		});
		
		eliminar_cuenta.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				EliminarCuenta();
				
			}
		});
		
		cerrar_sesion.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO cerrar sesión
				getParent().getParent().getParent().getParent().getParent().setVisible(false);
				((AbstractOrderedLayout) getParent().getParent().getParent().getParent().getParent().getParent())
					.addComponent(new Iniciar_sesion());
			}
		});
		
		usuarios_bloqueados.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				ListadoBloqueados();
			}
		});
	}
	
	public void EliminarCuenta() {
		VerticalLayout subContent = new VerticalLayout();
		subContent.setMargin(true);
		subContent.addComponent(_eliminar_cuenta);
		Window window = new Window();
    	window.setContent(subContent);
        //window.setWidth("100%");
        window.setResizable(false);
        window.setDraggable(false);
        window.center();
        window.setModal(true);
        // Add it to the root component
        UI.getCurrent().addWindow(window);
	}
	
	public void ListadoBloqueados() {
		this.ajustesMain.setVisible(false);
		//((AbstractOrderedLayout) this.getParent()).addComponent(_listado_de_bloqueados);
		_ver_usuario_propio.clear();
		_ver_usuario_propio.mainLayoutAddComponent(_listado_de_bloqueados);
	}
	
	public void ModificarPerfil() {
		this.ajustesMain.setVisible(false);
		//((AbstractOrderedLayout) this.getParent()).addComponent(_modificar_perfil);
		_ver_usuario_propio.clear();
		_ver_usuario_propio.mainLayoutAddComponent(_modificar_perfil);
	}
	
}