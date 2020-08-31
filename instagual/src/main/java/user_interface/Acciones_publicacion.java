package user_interface;

import com.instagual.instagual.Acciones_publicacion_ventana;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.jsclipboard.JSClipboard;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

public class Acciones_publicacion extends Acciones_publicacion_ventana {
	/*private event _darQuitar_me_gusta;
	private button _darQuitar_me_gustaB;*/
	public Publicacion _publicacion;
	public Ver_listado_de_comentarios _ver_listado_de_comentarios;
	public Listado_de_usuarios_me_gusta_ _listado_de_usuarios_me_gusta_;
	
	String shareUrl;
	boolean meGusta = false;
	int meGustaNum = 0;
	
	public Acciones_publicacion() {
		
		int imgId = 001;
		shareUrl = "http://example/"+imgId;
		
		compartir.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
				btnShared();
			}
		});
        
        comentar.addClickListener(new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {

						btnComents();

				}
		});
        
        verComentariosBtn.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				btnComents();
				
			}
		});
       
	        me_gusta.addClickListener(new Button.ClickListener() {
					public void buttonClick(ClickEvent event) {
						
						btnLike();
					}
			});
	}
	
	//Funcion del boton de compartir
		public void btnShared() {
			HorizontalLayout subContent = new HorizontalLayout();
			subContent.setMargin(true);
			final JSClipboard clipboard = new JSClipboard();
			//Label con la direccion de la publicacion
			final Label labelTextShare= new Label(shareUrl);
			labelTextShare.setSizeFull();      
			labelTextShare.setId("tocopie-label");
			//Boton de copiar al portapapeles
			Button clipboardbtn = new Button();
			clipboardbtn.setIcon(VaadinIcons.CLIPBOARD);
			clipboard.apply(clipboardbtn,labelTextShare);
			clipboard.addSuccessListener(new JSClipboard.SuccessListener() {

				@Override
				public void onSuccess() {
					Notification.show("Copy to clipboard successful");
				}
			});
			clipboard.addErrorListener(new JSClipboard.ErrorListener() {

				@Override
				public void onError() {
					Notification.show("Copy to clipboard unsuccessful", Notification.Type.ERROR_MESSAGE);
				}
			});  

			subContent.addComponent(labelTextShare);
			subContent.addComponent(clipboardbtn);
			subContent.addComponent(new Label("| "));
			//Creamos una nueva ventana con el contenido generado
	    	Window window = new Window();
	    	window.setContent(subContent);
	        //window.setWidth("-1");
	        window.setResizable(false);
	        window.setDraggable(false);
	        window.center();
	        window.setModal(true);

	        // Add it to the root component
	        UI.getCurrent().addWindow(window);
		}
		
		public void btnComents(){
			VerticalLayout subContent = new VerticalLayout();
			subContent.setMargin(true);
			subContent.addComponent(new Ver_listado_de_comentarios());
			Window window = new Window();
	    	window.setContent(subContent);
	        window.setWidth("100%");
	        window.setResizable(false);
	        window.setDraggable(false);
	        window.center();
	        window.setModal(true);
	        // Add it to the root component
	        UI.getCurrent().addWindow(window);
	        
	        
		}
		
		public void btnLike() {
			
			if(meGusta) {
				me_gusta.setIcon(VaadinIcons.HEART_O);
				meGusta = false;// Establecer en la base de datos
				meGustaNum --;
			}else {
				me_gusta.setIcon(VaadinIcons.HEART);
				meGusta = true;// Establecer en la base de datos
				meGustaNum ++;
			}
			meGustaNumLabel.setValue(String.valueOf(meGustaNum));

		}

	public void Dar_Quitar_me_gusta() {
		throw new UnsupportedOperationException();
	}
}