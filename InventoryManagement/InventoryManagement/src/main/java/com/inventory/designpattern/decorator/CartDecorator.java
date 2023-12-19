package com.inventory.designpattern.decorator;

import com.inventory.InventoryCartAPI;

public class CartDecorator implements InventoryCartAPI{
	
	InventoryCartAPI cart;
		
	public CartDecorator(InventoryCartAPI cart) {
		this.cart = cart;
	}

	@Override
	public double getCost() {
		return this.cart.getCost();
	}

}
