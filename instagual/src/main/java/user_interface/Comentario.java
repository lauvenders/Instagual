package user_interface;

public class Comentario extends Comentario_inv_ {
	Comentario(String usuario,String texto) {
		super(usuario, texto);
		this.eliminarComentarioButton.setVisible(true);
		// TODO Auto-generated constructor stub
	}
	Comentario(){
		this.eliminarComentarioButton.setVisible(true);
		// this.textoComentario.setValue(" ");
	}

	//private event _dar_Quitar_me_gusta_comentario;
	public Ver_listado_de_comentarios _ver_listado_de_comentarios;

	public void Dar_Quitar_me_gusta_comentario() {
		throw new UnsupportedOperationException();
	}
}