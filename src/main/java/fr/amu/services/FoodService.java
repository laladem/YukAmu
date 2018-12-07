package fr.amu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.amu.models.Food;
import fr.amu.models.FoodDAO;

@Service
public class FoodService{
	
	@Autowired
	FoodDAO foodDAO;
	
	public void addFood(Food food) {
		foodDAO.add(food);
	}

	
	  public List<Food> getAllFoods() {
		return foodDAO.findAll();
	}
	
	public void removeFood(int id) {		
		foodDAO.delete(id);
	}

	 public Food getFoodById(int id) {
			return foodDAO.findById(id);
		}
	 
	 public List<Food> getFoodsByDone(boolean bool) {
			return foodDAO.findByDone(bool);
		} 
	
	 
	 public void updateFood(Food food) {
		  foodDAO.update(food);
	 }
	
}