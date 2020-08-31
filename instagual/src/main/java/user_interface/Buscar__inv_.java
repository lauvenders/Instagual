package user_interface;
import java.util.Vector;

import com.instagual.instagual.*;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class Buscar__inv_ extends Buscar_inv_ventana {
	/*private TextField _busquedaTF;
	private event _buscar;*/
	public Invitado _invitado;
	public Listado_de_publicaciones_inv_ _listado_de_publicaciones_inv_;
	public Listado_de_usuarios_inv_ _listado_de_usuarios_inv_;
	private Vector<Publicacion> publicaciones = new Vector<Publicacion>();
	private Vector<Usuario> usuarios = new Vector<Usuario>();
	
	public Buscar__inv_() {
		
		usuarioBusquedaLayout.removeAllComponents();
		publicacionBusquedaLayout.removeAllComponents();
		
		crearDatos();
		
		buscarBtn.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				Buscar();
			}
		});
	}
	
	public void Buscar() {
		usuarioBusquedaLayout.removeAllComponents();
		publicacionBusquedaLayout.removeAllComponents();
		String key = textoBusqueda.getValue();
		BuscarUsuarios(key);
		BuscarEtiquetas(key);
	}
	
	public void BuscarUsuarios(String key) {
		for(Usuario u : usuarios) {
			if (u.usuario.contains(key)) {
				usuarioBusquedaLayout.addComponent(new Ver_usuario_busqueda_inv_(u));
				//System.out.println(u);
			}
		}
	}
	
	public void BuscarEtiquetas(String key) {
		for(Publicacion p : publicaciones) {
			for (String etiqueta : p.etiquetas) {
				if (etiqueta.contains(key)) {
					Publicacion_busqueda_inv_ pb = new Publicacion_busqueda_inv_(null,null);
					pb.setValoresBusqueda(p);
					publicacionBusquedaLayout.addComponent(pb);
					//System.out.println(etiqueta);
					continue;
				}
			}
		}
	}
	
	public void crearDatos() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				Publicacion p = new Publicacion(null, null);
				p.usuario = "usuario" + i;
				p.descripcion = "Publicación" + j;
				p.etiquetas.add("etiqueta" + i);
				p.etiquetas.add( "" + i + j);
				p.etiquetas.add("etiqueta");
				publicaciones.add(p);
				
				Usuario u = new Usuario();
				u.usuario = "usuario" + i + j;
				usuarios.add(u);
			}
			
		}
	}
}