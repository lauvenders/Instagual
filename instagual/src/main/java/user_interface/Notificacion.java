package user_interface;

import com.instagual.instagual.Notificacion_comentario;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class Notificacion extends Notificacion_comentario {
	private String usuario;
	private String comentario;
	public Listado_de_notificaciones _listado_de_notificaciones;
	public Ver_usuario_notificacion _ver_usuario_notificacion;
	public Ver_publicacion_notificacion _ver_publicacion_notificacion;
	public Ver_publicacion_notificacion_etiquetada _ver_publicacion_notificacion_etiquetada;
	
	public Notificacion(String tipo, String usuario, String comentario, Listado_de_notificaciones _listado_de_notificaciones) {
		this._listado_de_notificaciones = _listado_de_notificaciones;
		this.usuario = usuario;
		this.comentario = comentario;
		
		if (tipo == "comentario") {
			this.initComentario();
			
		} else if (tipo == "seguir") {
			this.initSeguir();
			
		} else if (tipo == "seguir privado") {
			this.initSeguirPrivado();
			
		} else if (tipo == "etiqueta") {
			this.initEtiqueta();
			
		} else if (tipo == "me gusta") {
			this.initMeGusta();
			
		}
	}
	
	private void initComentario() {
		notificarComentarioLayout.setVisible(true);
		notificarSeguidorLayout.setVisible(false);
		notificarMeGustaLayout.setVisible(false);
		solicitarSeguirLayout.setVisible(false);
		notificarEtiquetaLayout.setVisible(false);
		
		usuarioComentario.setCaption("@" + usuario);
		usuarioComentario.addClickListener(e -> {
			verUsuario();
		});
		
		try {
			comentarioLbl.setValue(this.comentario);
		} catch (NullPointerException e) {
			System.out.print(e);
		}
		
		// TODO: Set imágenes
		
		fotoUsuarioComentario.addClickListener(e -> {
			verUsuario();
		});
		
		publicacionComentario.addClickListener(e -> {
			verPublicacion();
		});
	}
	
	private void initSeguir() {
		notificarComentarioLayout.setVisible(false);
		notificarSeguidorLayout.setVisible(true);
		notificarMeGustaLayout.setVisible(false);
		solicitarSeguirLayout.setVisible(false);
		notificarEtiquetaLayout.setVisible(false);
		
		usuarioSeguidor.setCaption("@" + usuario);
		usuarioSeguidor.addClickListener(e -> {
			verUsuario();
		});
		
		fotoUsuarioSeguidor.addClickListener(e -> {
			verUsuario();
		});
	}
	
	private void initSeguirPrivado() {
		notificarComentarioLayout.setVisible(false);
		notificarSeguidorLayout.setVisible(false);
		notificarMeGustaLayout.setVisible(false);
		solicitarSeguirLayout.setVisible(true);
		notificarEtiquetaLayout.setVisible(false);
		
		usuarioSolicitud.setCaption("@" + usuario);
		usuarioSolicitud.addClickListener(e -> {
			verUsuario();
		});
		
		fotoUsuarioSolicitud.addClickListener(e -> {
			verUsuario();
		});
		
		confirmarSeguidorBtn.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				initSeguir();
			}
		});
		
		denegarSeguidorBtn.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				confirmarSeguidorBtn.setEnabled(false);
				denegarSeguidorBtn.setEnabled(false);
			}
		});
	}
	
	private void initEtiqueta() {
		notificarComentarioLayout.setVisible(false);
		notificarSeguidorLayout.setVisible(false);
		notificarMeGustaLayout.setVisible(false);
		solicitarSeguirLayout.setVisible(false);
		notificarEtiquetaLayout.setVisible(true);
		
		usuarioEtiqueta.setCaption("@" + usuario);
		usuarioEtiqueta.addClickListener(e -> {
			verUsuario();
		});
		
		fotoUsuarioEtiqueta.addClickListener(e -> {
			verUsuario();
		});
		
		publicacionEtiqueta.addClickListener(e -> {
			verPublicacion();
		});
	}
	
	private void initMeGusta() {
		notificarComentarioLayout.setVisible(false);
		notificarSeguidorLayout.setVisible(false);
		notificarMeGustaLayout.setVisible(true);
		solicitarSeguirLayout.setVisible(false);
		notificarEtiquetaLayout.setVisible(false);
		
		usuarioMeGusta.setCaption("@" + usuario);
		usuarioMeGusta.addClickListener(e -> {
			verUsuario();
		});
		
		fotoUsuarioMeGusta.addClickListener(e -> {
			verUsuario();
		});
		
		publicacionMeGusta.addClickListener(e -> {
			verPublicacion();
		});
	}

	private void verPublicacion() {
		//this.getParent().getParent().getParent().getParent().setVisible(false);
		//((AbstractOrderedLayout) this.getParent().getParent().getParent().getParent().getParent()).addComponent(new Publicacion());
		
		try {
			this._listado_de_notificaciones.setVisible(false);
			this._listado_de_notificaciones._ver_notificaciones.mainLayoutClear();
			this._listado_de_notificaciones._ver_notificaciones.mainLayoutAddComponent(new Publicacion(null, null));
		} catch (Exception e) {
			
		}
	}

	private void verUsuario() {
		//this.getParent().getParent().getParent().getParent().setVisible(false);
		//((AbstractOrderedLayout) this.getParent().getParent().getParent().getParent().getParent()).addComponent(new Ver_usuario());
		
		this._listado_de_notificaciones.setVisible(false);
		this._listado_de_notificaciones._ver_notificaciones.mainLayoutClear();
		this._listado_de_notificaciones._ver_notificaciones.mainLayoutAddComponent(new Ver_usuario());
	}
}