package project.winesupplystore.web;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.winesupplystore.domain.ManufacturerRepository;
import project.winesupplystore.domain.Product;
import project.winesupplystore.domain.ProductRepository;

@Controller
public class ProductController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ManufacturerRepository manufacturerRepository;

	// login page
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@GetMapping({ "/", "/productlist" })
	public String productlist(Model model) {
		log.info("Get all products from db");
		List<Product> products = (List<Product>) productRepository.findAll();
		model.addAttribute("products", products);
		return "productlist";
	}

	@GetMapping("/deleteproduct/{id}")
	public String deleteProduct(@PathVariable("id") Long productId) {
		productRepository.deleteById(productId);

		return "redirect:/productlist";
	}

	@RequestMapping(value ="/edit/{id}")
	public String editProduct(@PathVariable("id") Long productId, Model model) {
		model.addAttribute("products", productRepository.findById(productId));
    	model.addAttribute("manufacturers", manufacturerRepository.findAll());
		return "editproduct";
	}
	
	@RequestMapping(value = "/add")
    public String addProduct(Model model){
    	model.addAttribute("product", new Product());
    	model.addAttribute("manufacturers", manufacturerRepository.findAll());
        return "addProduct";
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(Product product){
        productRepository.save(product);
        return "redirect:productlist";
    }
	
}
