package com.instagual.instagual;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import user_interface.Iniciar_sesion;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("instagual_style")
public class instagual extends UI {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void init(VaadinRequest vaadinRequest) {
    	Iniciar_sesion ventanaInicio = new Iniciar_sesion();
        final VerticalLayout layout = new VerticalLayout();
        
        /*final TextField name = new TextField();
        name.setCaption("Type your name here:");
        final TextField name2 = new TextField();
        name2.setCaption("Type your name here:");

        Button button = new Button("pulsa");
        button.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"));
        });
        
        layout.addComponents(name, button,ventanaInicio);
        ventanaInicio.setVisible(true);*/
       // layout.addComponent(ventanaInicio);
        
        //setContent(layout);
    	setContent(new  Iniciar_sesion());
    }

    @WebServlet(urlPatterns = "/*", name = "instagualServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = instagual.class, productionMode = false)
    public static class instagualServlet extends VaadinServlet {
    	private static final long serialVersionUID = 1L;
    }
}
