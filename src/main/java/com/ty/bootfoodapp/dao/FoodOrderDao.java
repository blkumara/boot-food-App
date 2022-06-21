package com.ty.bootfoodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.bootfoodapp.dto.FoodOrder;
import com.ty.bootfoodapp.repository.FoodOrderRepository;

@Repository
public class FoodOrderDao {

	@Autowired
	FoodOrderRepository foodOrderRepository;

	public FoodOrder SaveFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepository.save(foodOrder);
	}

	public List<FoodOrder> getAllFoodOrder() {
		return foodOrderRepository.findAll();
	}

	public FoodOrder getFoodOrderById(FoodOrder foodOrder, int id) {
		Optional<FoodOrder> optional = foodOrderRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		} else {
			return  optional.get();
		}
	}

}
