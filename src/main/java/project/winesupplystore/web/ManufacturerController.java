package project.winesupplystore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.winesupplystore.domain.Manufacturer;
import project.winesupplystore.domain.ManufacturerRepository;


@Controller
public class ManufacturerController {
	@Autowired
	private ManufacturerRepository manufacturerRepository;
	
	@RequestMapping(value="/manufacturerlist")
	public String manufacturerList(Model model) {
		model.addAttribute("manufacturers", manufacturerRepository.findAll());
		return "manufacturerlist";
	}
	
	@RequestMapping(value = "/addmanufacturer")
    public String addManufacturer(Model model){
    	model.addAttribute("manufacturer", new Manufacturer());
        return "addManufacturer";
    }
	
	@RequestMapping(value = "/savemanufacturer", method = RequestMethod.POST)
    public String saveManufacturer(Manufacturer manufacturer){
        manufacturerRepository.save(manufacturer);
        return "redirect:manufacturerlist";
    }

}