package org.casadocodigo2.loja.conf;

import org.casadocodigo2.loja.controllers.HomeController;
import org.casadocodigo2.loja.daos.PostagemDAO;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, PostagemDAO.class}) // Anotação que serve para que o spring encontre os pacotes controller e daos

public class AppWebConfiguration { // Aqui é configurado para procurar por todas as views aqui: src/main/webapp/WEB-INF/views/
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){ 
//Todas as vezes que realizamos uma configuração para a Servlet do Spring, precisamos transformá-la em um bean, 
//nesse caso, criamos o método InternalResourceViewResolver e o anotamos com @Bean.
		
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/"); // define local da views
		resolver.setSuffix(".jsp"); // define extensão das views
		return resolver;
	}
	@Bean
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(1);
		
		return messageSource;
	}
}
