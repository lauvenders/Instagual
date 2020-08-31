package user_interface;

import java.util.Vector;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;

import user_interface.Publicacion;
import user_interface.Publicacion_etiquetada;

public class Ver_listado_de_publicaciones extends Listado_de_publicaciones_populares_inv_ {
	public Usuario _usuario;
	public Vector<Publicacion> _list_Publicacion = new Vector<Publicacion>();
	public Vector<Publicacion_etiquetada> _list_Publicacion_etiquetada = new Vector<Publicacion_etiquetada>();
	public Ver_usuario_propio userProfile = new Ver_usuario_propio(this);
	public Ver_listado_de_publicaciones() {
		inicializar();
		btnProfile.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
				userProfile();
			}
		});
		
		this.btnSearch.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
				userSearch();
			}
		});
		this.btnSocial.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
				userSocial();
			}
		});
		
		this.btnUpload.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
				userUpload();
			}
		});
		
		this.btnHome.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				inicializar();
				
			}
		});
	}
	
	
	public void inicializar() {
		listaPublicaciones.removeAllComponents();
		datosPrueba();
		for(Publicacion p:_list_Publicacion) {
			listaPublicaciones.addComponent(p);
		}
	
	}
	
	public void clear() {
		listaPublicaciones.removeAllComponents();
	}
	
	public void mainLayoutAddComponent(Component c) {
		listaPublicaciones.addComponent(c);
	}
	
	public void userProfile() {
		contentLayout.removeAllComponents();
		contentLayout.addComponent(userProfile);
	}
	
	public void datosPrueba() {
		for(int i = 0 ;i<5;i++) {
			_list_Publicacion.add(new Publicacion(this, null));
		}
	}
	
	public void userSearch() {
		contentLayout.removeAllComponents();
		contentLayout.addComponent(new Buscar() );	
	}
	
	public void userSocial() {
		contentLayout.removeAllComponents();
		contentLayout.addComponent(new Ver_notificaciones());
	}
	
	public void userUpload() {
		contentLayout.removeAllComponents();
		contentLayout.addComponent(new Subir_publicacion());
	}
	
	public Button getBtnProfile () {
		return this.btnProfile;
	}

}