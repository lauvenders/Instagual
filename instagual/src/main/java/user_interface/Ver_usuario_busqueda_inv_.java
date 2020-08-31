package user_interface;

import com.vaadin.ui.AbstractOrderedLayout;

public class Ver_usuario_busqueda_inv_ extends Ver_usuario_inv_ {
	public UsuarioEl _usuario;
	
	public Ver_usuario_busqueda_inv_(Usuario u) {
		mainLayout.setVisible(false);
		busquedaLayout.setVisible(true);
		
		usuarioLbl.setValue("@" + u.usuario);
		//nombreUsuario.setValue()
		//fotoPerfil.setSource(source);
		
		fotoPerfil.addClickListener(e -> {
			this.getParent().getParent().getParent().setVisible(false);
			((AbstractOrderedLayout) this.getParent().getParent().getParent().getParent()).addComponent(new Ver_usuario_inv_(), 0);
		});
	}
}