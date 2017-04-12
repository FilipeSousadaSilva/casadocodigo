package org.casadocodigo2.loja.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller //identifica a classe como controller 
public class HomeController { // classe responsável por atender a página inicial do sistema
	@RequestMapping("/")
    public String index(){
        System.out.println("Entrando na home da CDC");
		return "home";
    }
}
