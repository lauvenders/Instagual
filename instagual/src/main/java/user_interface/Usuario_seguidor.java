package user_interface;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.VerticalLayout;

public class Usuario_seguidor extends Ver_usuario {
	public Ver_listado_seguidores _ver_listado_seguidores;
	
	public Usuario_seguidor(String nombre, String apellidos, String usuario, String foto) {
		mainLayout.setVisible(false);
		busquedaLayout.setVisible(true);
		
		nombreUsuario.setValue(nombre + " " + apellidos);
		usuarioLbl.setValue("@" + usuario);
		ThemeResource source = new ThemeResource(foto);
		fotoPerfil.setSource(source);
		
		fotoPerfil.addClickListener(e -> {
			this.getParent().setVisible(false);
			((VerticalLayout) this.getParent().getParent()).addComponent(new Ver_usuario());
		});
	}
}