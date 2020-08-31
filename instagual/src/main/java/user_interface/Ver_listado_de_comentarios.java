package user_interface;

import java.util.Vector;
import user_interface.Comentario;
import user_interface.Anadir_comentario;

public class Ver_listado_de_comentarios extends Ver_listado_de_comentarios_inv_ {
	public Acciones_publicacion _acciones_publicacion;
	public Vector<Comentario> _list_Comentario = new Vector<Comentario>();
	public Vector<Anadir_comentario> _list_Anadir_comentario = new Vector<Anadir_comentario>();
	public Ver_listado_de_comentarios() {
		//this.comentarios.removeAllComponents();
		loadComents();
		this.addComentLy.setVisible(true);
	}
	
	public void loadComents(){
		datosPrueba();
		this.comentarios.addComponent(new Comentario());
		for(Comentario_inv_ comentario : _list_Comentario_inv_)
			this.comentarios.addComponent(comentario);
		
	}
	
	public void datosPrueba() {
		for(int i = 0; i<5 ; i++) {
			_list_Comentario_inv_.add(new Comentario("@prueba","Texto de prueba"));
		}
	}
}