package com.ty.bootfoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.bootfoodapp.dao.FoodOrderDao;
import com.ty.bootfoodapp.dto.FoodOrder;
import com.ty.bootfoodapp.dto.Item;

@Service
public class FoodOrderService {

	@Autowired
	FoodOrderDao foodOrderDao;

	public FoodOrder SaveFoodOrder(FoodOrder foodOrder) {
		List<Item> items = foodOrder.getItems();
		double sum = 0;
		for (Item item : items) {
			sum += item.getCost() * item.getQuantity();
			item.setFoodOrder(foodOrder);

		}
		foodOrder.setCost(sum);
		return foodOrderDao.SaveFoodOrder(foodOrder);
	}

	public List<FoodOrder> getAllFoodOrder() {
		return foodOrderDao.getAllFoodOrder();
	}

	public FoodOrder getFoodOrderById(FoodOrder foodOrder, int id) {
		return foodOrderDao.getFoodOrderById(foodOrder, id);	
	}

}
