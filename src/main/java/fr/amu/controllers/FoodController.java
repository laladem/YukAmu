package fr.amu.controllers;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.amu.models.Food;
import fr.amu.services.FoodService;


@Controller
@RequestMapping(value="/food")
public class FoodController {

	private static final Logger log = LoggerFactory.getLogger(FoodController.class);
	
	@Autowired
	ServletContext context;
	@Autowired
	private HttpSession httpSession;
	@Autowired
	FoodService fs;
	
	final ObjectMapper mapper = new ObjectMapper(); // initialize un mapper qui tranforme un objet Java en JSON pour le graphique de la vue
//	mapper.writeValueAsString( Map<String, Integer> ) //
	
	
	@RequestMapping( value = "/add", method = RequestMethod.POST)
	public String add(@Valid HttpServletRequest request, Map<String, Object> model){
		 Food food = new Food();
		 food.setName(request.getParameter("name"));
		 food.setImg(request.getParameter("imgUrl"));
		 fs.addFood(food);
		 model.put("Foods", fs.getAllFoods());
		return "index";
	}
	
	 @RequestMapping( value = "/remove", method= RequestMethod.POST)
		public String remove( HttpServletRequest request, Map<String, Object> model) {
			int id = Integer.valueOf(request.getParameter("foodId"));
			fs.removeFood(id);
			model.put("Foods", fs.getAllFoods());
			return "index";
		}
	 	 
	 
	 @RequestMapping(value="/tagguer", method= RequestMethod.POST) 
		public String tagguer(HttpServletRequest request, Map<String, Object> model) {
			 int id = Integer.valueOf(request.getParameter("tagId"));
			 Food food = fs.getFoodById(id);
			 food.setDone(true);
			 food.setTag(String.valueOf( request.getParameter("SelectedTag")) );
			 fs.updateFood(food);
			 model.put("Foods", fs.getAllFoods() );
			return "index";
		} 
	
}
