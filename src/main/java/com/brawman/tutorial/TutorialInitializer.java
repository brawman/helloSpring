package com.brawman.tutorial;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.brawman.tutorial.config.TutorialConfig;

public class TutorialInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		regitsterDispatcherServlet(servletContext);
	}
	
	private void regitsterDispatcherServlet(ServletContext servletContext) {
		WebApplicationContext dispatcherContext = createContext(TutorialConfig.class);
		DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("*.html");
	}
	
	private WebApplicationContext createContext(Class<?>... annotatedClasses) {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(annotatedClasses);
		return context;
		
	}
}
