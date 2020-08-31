package user_interface;

import java.util.Vector;
import user_interface.publicacion_etiquetada__propio_;

public class publicaciones_etiquetadas_propio_ extends Ver_listado_de_publicaciones_propias {
	public publicaciones_etiquetadas_propio_(Ver_usuario_propio ver_usuario_propio) {
		super(ver_usuario_propio);
		// TODO Auto-generated constructor stub
	}
	public Ver_usuario_propio _ver_usuario_propio;
	public Vector<publicacion_etiquetada__propio_> _list_publicacion_etiquetada__propio_ = new Vector<publicacion_etiquetada__propio_>();
}