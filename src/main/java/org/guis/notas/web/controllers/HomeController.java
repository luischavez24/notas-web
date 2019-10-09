package org.guis.notas.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class HomeController {
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("/home/index.html");
		modelAndView.addObject("pageTitle", "Sistema de Notas - Bienvenido");
		return modelAndView;
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("/home/login.html");
		modelAndView.addObject("pageTitle", "Sistema de Notas - Login");
		return modelAndView;
	}
}
