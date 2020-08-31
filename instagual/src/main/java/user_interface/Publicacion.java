package user_interface;

import java.util.ArrayList;

import javax.persistence.PersistenceException;

import org.orm.*;

import com.instagual.instagual.publicacion_ventana;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.jsclipboard.JSClipboard;
import com.vaadin.shared.Connector;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import database.Configuraciones;

import com.vaadin.ui.Button.ClickEvent;

public class Publicacion extends publicacion_ventana {
	public Ver_listado_de_publicaciones_propias _ver_listado_de_publicaciones_propias;
	public Ver_listado_de_publicaciones _ver_listado_de_publicaciones;
	public Ver_publicacion _ver_publicacion;
	public Acciones_publicacion _acciones_publicacion;

	String usuario = "prueba";// cargar de la base de datos
	String imagen = "";
	String descripcion = "";
	ArrayList<String> etiquetas = new ArrayList<String>();
	ArrayList<String> hashtags = new ArrayList<String>();
	int idAutor;
	int imgId;

	public Usuario Cargar_usuario() throws PersistenceException {
		// TODO
		return null;
	}
	/*
	public Publicacion() {
		init();
	}*/

	public Publicacion(Ver_listado_de_publicaciones ver_listado_de_publicaciones, 
			Ver_listado_de_publicaciones_propias ver_listado_de_publicaciones_propias) {

		this._ver_listado_de_publicaciones = ver_listado_de_publicaciones;
		this._ver_listado_de_publicaciones_propias = ver_listado_de_publicaciones_propias;
		
		init();

	}
	
	private void init() {
		publicacionBusquedaLayout.setVisible(false);
		idAutor = 0;// cargar de la base de datos
		imgId = 001;
		
		mainLayout.addComponent(new Acciones_publicacion());
		AbsoluteLayout aux = new AbsoluteLayout();
		aux.setHeight("50px");
		mainLayout.addComponent(aux);

		linkUsuario.setCaption("@" + usuario);
		linkUsuario.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {

				goToUser(idAutor);
			}
		});
		
	}

	public void goToUser(int idAutor) {
		//this.getParent().setVisible(false);
		//((AbstractOrderedLayout) this.getParent().getParent()).addComponent(new Ver_usuario());
		
		
		if(this._ver_listado_de_publicaciones != null) {
			this._ver_listado_de_publicaciones.clear();
			this._ver_listado_de_publicaciones.mainLayoutAddComponent(new Ver_usuario());
		}	
		
		else if (this._ver_listado_de_publicaciones_propias != null) {
			this._ver_listado_de_publicaciones_propias._ver_usuario_propio.clear();
			this._ver_listado_de_publicaciones_propias._ver_usuario_propio.mainLayoutAddComponent(new Ver_usuario());
		}
		
		else {
			this.getParent().setVisible(false);
			((AbstractOrderedLayout) this.getParent().getParent()).addComponent(new Ver_usuario());
		}

	}
	
}