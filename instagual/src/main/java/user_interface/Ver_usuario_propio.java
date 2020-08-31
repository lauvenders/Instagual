package user_interface;

import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;

public class Ver_usuario_propio extends Ver_usuario_inv_ {
	public Usuario_propio _usuario_propio;
	public Ver_listado_de_publicaciones _ver_listado_de_publicaciones;
	public Ver_listado_de_publicaciones_propias _ver_listado_de_publicaciones_propias = 
			new Ver_listado_de_publicaciones_propias(this);
	//public Ver_listado_usuarios_seguidos _ver_listado_usuarios_seguidos;
	//public Ver_listado_seguidores _ver_listado_seguidores = new Ver_listado_seguidores();
	public publicaciones_etiquetadas_propio_ _publicaciones_etiquetadas_propio_ = 
			new publicaciones_etiquetadas_propio_(this);
	public actividades_usuario _actividades_usuario = new actividades_usuario(null);
	public Ajustes _ajustes = new Ajustes(this);
	
	public Ver_usuario_propio(Ver_listado_de_publicaciones ver_listado_de_publicaciones) {
		this._ver_listado_de_publicaciones = ver_listado_de_publicaciones;
		
		init();		
		
	}
	
	private void init() {
		seguirLayout.setVisible(false);
		this.botonOpciones.setVisible(true);
		botonOpciones.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
				userOptions();
			}
		});
		//Tabsheet con distintos tipos de publicaciones
		publicaciones.setVisible(false);
		TabSheet tabsheet = new TabSheet();
		tabsheet.addStyleNames("centered-tabs compact-tabbar tabsheetPerfil");
		publicaciones.setCaption("Publicaciones");
		tabsheet.addTab(_ver_listado_de_publicaciones_propias).setCaption("Publicaciones");
		//publ.removeAllComponents();
		tabsheet.addTab(_publicaciones_etiquetadas_propio_).setCaption("Etiquetas");
		tabsheet.addTab(_actividades_usuario).setCaption("Actividad");
		mainLayout.addComponent(tabsheet);
		tabsheet.setVisible(true);
		
		AbsoluteLayout aux = new AbsoluteLayout();
		aux.setHeight("50px");
		mainLayout.addComponent(aux);
	}
	
	public void GenerarPublicacionesPropias(){
		
	}
	
	public void userOptions() {
		this.mainLayout.removeAllComponents();
		this.mainLayout.addComponent(_ajustes);
	}
	
	public void clear() {
		//System.out.print("aaa");
		this.mainLayout.removeAllComponents();
		
		_ver_listado_de_publicaciones.getBtnProfile().addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				mainLayout.removeAllComponents();
				mainLayout.addComponent(new Ver_usuario_propio(_ver_listado_de_publicaciones), 0);
			}
		});
	}
	
	public void mainLayoutAddComponent(Component c) {
		this.mainLayout.addComponent(c);
	}
	
}