package user_interface;

import com.instagual.instagual.Comentario_inv_ventana;

public class Comentario_inv_ extends Comentario_inv_ventana {
	public Ver_listado_de_comentarios_inv_ _ver_listado_de_comentarios_inv_;
	String texto;
	Comentario_inv_(String usuario,String texto){
		this.texto = texto;
		this.eliminarComentarioButton.setVisible(false);
		// this.textoComentario.setValue(usuario+": "+texto);
	}
	Comentario_inv_(){
		this.eliminarComentarioButton.setVisible(false);
		// this.textoComentario.setValue(" ");
	}
}