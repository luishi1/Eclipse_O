package CrudGestion.controller;

import CrudGestion.model.Product;
import CrudGestion.service.IProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private IProductService service;
	
	@GetMapping("/listar")
	public String list(Model model) {
		List<Product>products=service.list();
		model.addAttribute("products",products);
		return "index";
	}
	
	@GetMapping("/new")
	public String add(Model model) {
		model.addAttribute("product", new Product());
		return "form";
	}
	@PostMapping("/save")  
	public String save(@Valid Product p, Model model) {
		service.save(p);
		return "redirect:/listar";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		Optional<Product>product=service.listById(id);
		model.addAttribute("product", product);
		return "form";
	}
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";
	}
}