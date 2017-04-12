package org.casadocodigo2.loja.conf;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{ // classe spring que atende as requisições recebidas pelo servidor

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {AppWebConfiguration.class, JPAConfiguration.class}; //Configuração para que o spring encontre a config. do servidor web e do banco
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
	@Override
		protected Filter[] getServletFilters() {
			// TODO Auto-generated method stub
			CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
			encodingFilter.setEncoding("UTF-8");
			return new Filter[] {encodingFilter};
		}
	
}
