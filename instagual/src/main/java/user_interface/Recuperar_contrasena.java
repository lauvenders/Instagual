package user_interface;

import com.instagual.instagual.Recuperar_contrasena_ventana;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;

public class Recuperar_contrasena extends Recuperar_contrasena_ventana {
	/*private event _recuperar;
	private TextField _correoTF;
	public Usuario_Sin_Registrar _usuario_Sin_Registrar;
	public Enviar_correo_de_recuperacion _enviar_correo_de_recuperacion;*/
	
	public Recuperar_contrasena() {
		recuperarBtn.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				Recuperar_contrasena_action();
			}
		});
	}

	public void Recuperar_contrasena_action() {
		// TODO: recuperar contraseña
		imagenPrincipal.setVisible(false);
		emailVertLayout.setVisible(false);
		mainLayout.addComponent(new Iniciar_sesion());
		EnviarCorreoRecuperacion();
	}

	public void EnviarCorreoRecuperacion() {
		throw new UnsupportedOperationException();
	}
}