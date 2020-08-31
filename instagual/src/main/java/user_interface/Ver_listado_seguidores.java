package user_interface;

import java.util.Vector;

import com.instagual.instagual.ver_listado_seguidores_ventana;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import user_interface.Usuario_seguidor;
import user_interface.Usuario_seguidor_privado;

public class Ver_listado_seguidores extends ver_listado_seguidores_ventana {
	public Ver_usuario_propio _ver_usuario_propio;
	public Vector<Usuario_seguidor> _list_Usuario_seguidor = new Vector<Usuario_seguidor>();
	public Vector<Usuario_seguidor_privado> _list_Usuario_seguidor_privado = new Vector<Usuario_seguidor_privado>();
	//public Vector<orm_instagual.Usuario> usuarios = new Vector<orm_instagual.Usuario>();
	
	public Ver_listado_seguidores() {
		contentLayout.removeAllComponents();
		datosPrueba();
	}
	
	public void datosPrueba () {
		for (int i = 0; i < 10; i++) {
			orm_instagual.Usuario u = new orm_instagual.Usuario();
			contentLayout.addComponent(new Usuario_seguidor("Nombre", "Apellidos", "usuario" + i, "images/ejemplo.jpeg"), 0);
		}
	}
}