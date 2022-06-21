package com.ty.bootfoodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.bootfoodapp.dto.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer>{

}
