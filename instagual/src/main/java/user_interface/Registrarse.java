package user_interface;

import com.instagual.instagual.Registrarse_ventana;
import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Button.ClickEvent;

public class Registrarse extends Registrarse_ventana {
	
	public Registrarse() {
		check16.addValueChangeListener(new CheckBox.ValueChangeListener<Boolean>() {

			@Override
			public void valueChange(ValueChangeEvent event) {
				if (check16.getValue() == true || textFieldEmail.getValue() == null 
						|| textFieldContrasena.getValue() == null) {
					registrarseBtn.setEnabled(true);
				} else {
					registrarseBtn.setEnabled(false);
				}
			}
		});
		
		registrarseBtn.addClickListener(new NativeButton.ClickListener() {
			
			private static final long serialVersionUID = 1L;

			public void buttonClick(ClickEvent event) {
				Registro();
			}
		});
	}

	public void Registro() {
		// TODO: Registro en BD
		imagenPrincipal.setVisible(false);
		loginVertLayout.setVisible(false);
		botonesLayout.setVisible(false);
		mainLayout.addComponent(new Iniciar_sesion());
		EnviarCorreoConfirmacion();
	}

	public void EnviarCorreoConfirmacion() {
		throw new UnsupportedOperationException();
	}
}