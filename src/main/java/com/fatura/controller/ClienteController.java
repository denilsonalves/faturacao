package com.fatura.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fatura.models.Cliente;
import com.fatura.service.ClienteService;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", "Lista de clientes");
		model.addAttribute("clientes", clienteService.findAll());
		return "listar";
	}
	
	@GetMapping("/form")
	public String criar(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("cliente",  cliente);
		model.put("titulo",  "Formulário de clientes");
		return "form";
	}
	
	@GetMapping("/form/{id}")
	public String editar(@PathVariable(value = "id") Long id, Map<String, Object> model) {
		 Cliente cliente = null;
		 if(id>0) {
			 cliente = clienteService.findOne(id);
		 } else {
			 return "redirect:/listar";
		 }
		 model.put("cliente",  cliente);
		 model.put("titulo", "Editar cliente");
		 return "form";
	}
	
	@PostMapping("/form")
	public String salvar(@Valid Cliente cliente, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulário de clientes");
			return "form";
		}else {
		
		clienteService.save(cliente);
		return "redirect:listar";
		}
	}
}
