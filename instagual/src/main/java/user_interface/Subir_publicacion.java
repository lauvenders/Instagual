package user_interface;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.instagual.instagual.Subir_publicacion_ventana;
import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Image;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;

public class Subir_publicacion extends Subir_publicacion_ventana {
	/*private event _subir;
	public Usuario _usuario;*/
    public File file;
    final Embedded image = new Embedded("Uploaded Image");
    ImageUploader receiver = new ImageUploader();
  
	TabSheet tabsheet;
	
	public Subir_publicacion() {
		  tabSheetContainer.removeAllComponents();
		  tabsheet = new TabSheet();
		this.botonAñadir.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				
				addElement();
			}
		});
		
		this.botonPublicar.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		
		this.hashtagBtn.addClickListener(e -> {
			this.descripcionAreaSubir.setValue(this.descripcionAreaSubir.getValue() + "#");
		});
		
		this.mencionBtn.addClickListener(e -> {
			this.descripcionAreaSubir.setValue(this.descripcionAreaSubir.getValue() + "@");
		});
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

	    public void uploadSucceeded(SucceededEvent event) {
	        // Show the uploaded file in the image viewer
	    	image.setWidth("50px");
	    	image.setHeight("50px");
	        image.setVisible(true);
	        image.setSource(new FileResource(file));
			//Tabsheet con distintos tipos de publicaciones

			//tabsheet.addStyleNames("centered-tabs compact-tabbar tabsheetPerfil");
			Embedded imagenMostrar = image;
			imagenMostrar.setWidth("100%");
			imagenMostrar.setHeight("100%");
			imagenMostrar.setCaption("O");
			tabsheet.addTab(imagenMostrar);
			//publ.removeAllComponents();
			tabSheetContainer.removeAllComponents();
			tabSheetContainer.addComponent(tabsheet);
			tabsheet.setVisible(true);
	    }


	};
	
}

