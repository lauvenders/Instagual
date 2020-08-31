package user_interface;

import java.util.Vector;

import com.instagual.instagual.Ver_listado_de_usuarios_seguidos_ventana;

import user_interface.Usuario_seguido;

public class Ver_listado_usuarios_seguidos extends Ver_listado_de_usuarios_seguidos_ventana {
	public Ver_usuario_propio _ver_usuario_propio;
	public Vector<Usuario_seguido> _list_Usuario_seguido = new Vector<Usuario_seguido>();
	
	public Ver_listado_usuarios_seguidos() {
		contentLayout.removeAllComponents();
		datosPrueba();
	}
	
	public void datosPrueba () {
		for (int i = 0; i < 10; i++) {
			orm_instagual.Usuario u = new orm_instagual.Usuario();
			contentLayout.addComponent(new Usuario_seguido("Nombre", "Apellidos", "usuario" + i, "images/ejemplo.jpeg"), 0);
		}
	}
}