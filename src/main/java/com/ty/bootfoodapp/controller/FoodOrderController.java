package com.ty.bootfoodapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.bootfoodapp.dto.FoodOrder;
import com.ty.bootfoodapp.dto.Item;
import com.ty.bootfoodapp.dto.Products;
import com.ty.bootfoodapp.service.FoodOrderService;
import com.ty.bootfoodapp.service.ProductService;


@Controller
public class FoodOrderController {

	@Autowired
	FoodOrderService service;

	@Autowired
	ProductService productService;

	
	@RequestMapping("/customerdetails")
	public ModelAndView customerDetails() {
		ModelAndView andView = new ModelAndView("customerdetails.jsp");
		andView.addObject("order", new FoodOrder());
		return andView;
	}
	
	@RequestMapping("/savecustomer")
	public ModelAndView saveCustomer(@ModelAttribute FoodOrder foodOrder , HttpServletRequest req) {
		HttpSession session = req.getSession() ;
		session.setAttribute("order", foodOrder);
		session.setAttribute("itemslist", new ArrayList<Item>());
		ModelAndView andView = new ModelAndView("menu");
		andView.addObject("order", foodOrder);
		return andView;
	}

	@RequestMapping("/menu")
	public ModelAndView displayMenu() {
		List<Products> products = productService.getAllProducts();
		ModelAndView andView = new ModelAndView("menu.jsp");
		andView.addObject("products", products);
		return andView;
	}

	@RequestMapping("/additem")
	public ModelAndView addItem(@RequestParam(name = "id") int id) {
		Products product = productService.getProductById(id);
		Item item = new Item();
		item.setName(product.getName());
		item.setCost(product.getCost());
		ModelAndView andView = new ModelAndView("additem.jsp");
		andView.addObject("item", item);
		return andView;
	}

	@RequestMapping("/addedItems")
	public ModelAndView addedItems(@ModelAttribute Item item ,HttpSession session ) {
		FoodOrder order = (FoodOrder)session.getAttribute("order") ;
		item.setFoodOrder(order);
		item.setCost(item.getCost()*item.getQuantity());
		order.setCost(item.getCost()+ order.getCost());
		List<Item> items = (ArrayList)session.getAttribute("itemslist") ;
		items.add(item);
		ModelAndView andView = new ModelAndView("menu");
		andView.addObject("items", item);
		return andView;
	}
	
	@RequestMapping("/submitorder")
	public ModelAndView submit(HttpSession session ) {
		FoodOrder order = (FoodOrder)session.getAttribute("order") ;
		List<Item> items = (ArrayList)session.getAttribute("itemslist") ;
		order.setItems(items);
		service.SaveFoodOrder(order); 
		session.invalidate();
		ModelAndView andView = new ModelAndView("orderid.jsp");
		andView.addObject("order", order);
		return andView;
	}
	
	@RequestMapping("/allfoodorders")
	public ModelAndView getAllFoodOrders() {
		List<FoodOrder> orders = service.getAllFoodOrder() ;
		ModelAndView andView = new ModelAndView("allfoodorders.jsp");
		andView.addObject("orders", orders);
		return andView;
	}
	
	@RequestMapping("/foodorderbyid")
	public ModelAndView getFoodOrderById(@ModelAttribute FoodOrder order ) {
		FoodOrder order1 = service.getFoodOrderById(order, order.getId()) ;
		ModelAndView andView = new ModelAndView("foodorderbyid.jsp");
		andView.addObject("orders", order1);
		return andView;
	}

}
