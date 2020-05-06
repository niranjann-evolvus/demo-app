package com.evolvus.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/home")
	public String home(final Model model, final Principal principal) {
		intialize(model, principal);
		return "home";
	}

	@GetMapping("/")
	public String index(final Model model, final Principal principal) {
		intialize(model, principal);
		return "home";
	}

	public void intialize(final Model model, final Principal principal) {
		HomeController.LOG.info("Begin home  controller");
		String name = principal.getName();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		var roles = auth.getAuthorities();
		var authName = auth.getName();
		model.addAttribute("name", name);
		model.addAttribute("authName", authName);
		model.addAttribute("roles", roles);
		HomeController.LOG.info("Principal name  ", name);
		HomeController.LOG.info("End  home  controller");
	}
}
