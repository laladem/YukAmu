package fr.amu.controllers;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.amu.services.FoodService;


@Controller
public class IndexController {
	
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	ServletContext context;
	@Autowired
	private HttpSession httpSession;
	@Autowired
	FoodService fs;
	
	final ObjectMapper mapper = new ObjectMapper(); // initialize un mapper qui tranforme un objet Java en JSON pour le graphique de la vue
//	mapper.writeValueAsString( Map<String, Integer> ) //
	
 
	@GetMapping("/") // raccourci pour @RequestMapping( value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {
		String sessionUser= (String) httpSession.getAttribute("user");
		 model.put("Foods", fs.getAllFoods() );
		System.out.println("session user = " + sessionUser);
		return "index";
	}
	
	
    @RequestMapping(value = "/shutdown", method = RequestMethod.GET)
    public void shutdown() {
    	System.exit(0);
    }
    
}