package user_interface;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.instagual.instagual.Modificar_perfil_ventana;
import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;

import user_interface.Subir_publicacion.ImageUploader;

public class Modificar_perfil extends Modificar_perfil_ventana {
	//private event _modificar;
	public Ajustes _ajustes;
	public File file;
    final Embedded image = new Embedded("Uploaded Image");
    ImageUploader receiver = new ImageUploader();
	
	public Modificar_perfil(Ajustes ajustes) {
		this._ajustes = ajustes;
		
		confirmarBtn.addClickListener(new Button.ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Modificar();
			}
		});
		
		cambiarFotoBtn.addClickListener(new Button.ClickListener() {
			
			public void buttonClick(ClickEvent event) {
				addElement();
			}
		});
	}

	public void Modificar() {
		mainLayout.setVisible(false);
		//((AbstractOrderedLayout) this.getParent().getParent().getParent()).addComponent(new Ver_usuario_propio(), 0);
		_ajustes._ver_usuario_propio.clear();
		_ajustes._ver_usuario_propio.mainLayoutAddComponent(new Ver_usuario_propio(
				_ajustes._ver_usuario_propio._ver_listado_de_publicaciones));
	}
	
	public void addElement() {
		// Show uploaded file in this placeholder
		
		
		

		// Create the upload with a caption and set receiver later
		Upload upload = new Upload("Upload Image Here", receiver);
		upload.setButtonCaption("Seleccionar imagen");
		upload.addSucceededListener(receiver);

		// Put the components in a panel
		Panel panel = new Panel("Subir Imágenes");
		Layout panelContent = new VerticalLayout();
		panelContent.addComponents(upload,image);
		panel.setContent(panelContent);
		
		Window window = new Window();
    	window.setContent(panel);
        //window.setWidth("-1");
        window.setResizable(false);
        window.setDraggable(false);
        window.center();
        window.setModal(true);

        // Add it to the root component
        UI.getCurrent().addWindow(window);
	}
	
	class ImageUploader implements Receiver, SucceededListener {

	    
	    String basepath = VaadinService.getCurrent()
	            .getBaseDirectory().getAbsolutePath();
	    public OutputStream receiveUpload(String filename,
	                                      String mimeType) {
	        // Create upload stream
	        FileOutputStream fos = null; // Stream to write to
	        try {
	            // Open the file for writing.
	            file = new File(basepath+"/WEB-INF/images/" + filename);
	            fos = new FileOutputStream(file);
	        } catch (final java.io.FileNotFoundException e) {
	            new Notification("Could not open file<br/>",
	                             e.getMessage(),
	                             Notification.Type.ERROR_MESSAGE)
	                .show(Page.getCurrent());
	            return null;
	        }
	        return fos; // Return the output stream to write to
	    }
		@Override
		public void uploadSucceeded(SucceededEvent event) {
			// TODO Auto-generated method stub
			
		}


	};
}