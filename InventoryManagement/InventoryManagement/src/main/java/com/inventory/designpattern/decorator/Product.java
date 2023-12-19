package com.inventory.designpattern.decorator;

import com.inventory.InventoryCartAPI;

public class Product implements InventoryCartAPI{

	double totalCost;
	
	public Product() {
		this.totalCost = 0;
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return this.totalCost;
	}

}
