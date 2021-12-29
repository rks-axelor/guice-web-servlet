package guice.web.servlet.demo;

import javax.servlet.annotation.WebListener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

@WebListener
public class GuiceListner extends GuiceServletContextListener{
	@Override
	protected Injector getInjector() {
		
		return Guice.createInjector(new GuiceModule());
	}

}
