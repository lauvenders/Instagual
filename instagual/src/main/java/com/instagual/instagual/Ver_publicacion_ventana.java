package com.instagual.instagual;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

/** 
 * !! DO NOT EDIT THIS FILE !!
 * 
 * This class is generated by Vaadin Designer and will be overwritten.
 * 
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class Ver_publicacion_ventana extends VerticalLayout {
	protected Button back;
	protected HorizontalLayout usuarioPublicacion;
	protected Image fotoPerfil;
	protected TabSheet tabSheet;
	protected HorizontalLayout opcionesImagen;
	protected Button me_gusta;
	protected Button comentar;
	protected Button eliminarEtiqueta;
	protected Button eliminarPublicacion;
	protected Button compartir;

	public Ver_publicacion_ventana() {
		Design.read(this);
	}
}
