package org.casadocodigo2.loja.controllers;


import java.util.List;

import javax.validation.Valid;

import org.casadocodigo2.loja.daos.PostagemDAO;
import org.casadocodigo2.loja.models.Postagem;
import org.casadocodigo2.loja.models.TipoPreco;
import org.casadocodigo2.loja.validation.PostagemValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/postagens")
public class PostagensController { // Controller para cuidar das postagens da aplicação
	
	@Autowired // pedimos para o Spring uma instância do objeto que foi anotado. 
	// Esse recurso é chamado de injeção de dependência e está disponível para qualquer Bean do Spring
	private PostagemDAO postagemDao; 
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new PostagemValidation());
	}
	
	@RequestMapping("form")
	public ModelAndView form(){
		ModelAndView modelAndView = new ModelAndView("postagens/form"); 
		modelAndView.addObject("tipos", TipoPreco.values()); //adiciona o objeto tipos e os valor do enum TipoPreco através do método values para a view 
		// Quando utilizamos o ModelAndView, além retornar uma página, temos a possibilidade de enviar objetos de qualquer 
		// classe para essas páginas. 
		//Em outras palavras, dessa forma somos capazes de exibir, por exemplo, as informações das nossas classes modelos.
		return modelAndView; 
	}
	
	 
	@RequestMapping(value="/postagens",method=RequestMethod.POST) // Mapeamento de url	
	public ModelAndView gravar(@Valid Postagem postagem, BindingResult result, RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			//return form();
			 return new ModelAndView("postagens/form");
		}
		postagemDao.gravar(postagem); // Metodo gravar recebe uma postagem (model)
		redirectAttributes.addFlashAttribute("sucesso", "Postagem cadastrada com sucesso");
		return new ModelAndView("redirect:postagens");
	}
	
	@RequestMapping(value="/postagens",method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Postagem> postagens = postagemDao.listar();
		ModelAndView modelAndView = new ModelAndView("postagens/lista");
		modelAndView.addObject("postagens", postagens);
		return modelAndView;	
	}
	
	
}
