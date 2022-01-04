package guice.web.servlet.demo;

import com.google.inject.servlet.ServletModule;

public class GuiceModule extends ServletModule {
	@Override
	protected void configureServlets() {
		serve("/GuiceServlet").with(GuiceServlet.class);
		serve("/login").with(LoginServlet.class);
		serve("/register").with(RegisterServlet.class);
	}

}
