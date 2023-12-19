package com.inventory.designpattern.decorator;

import com.inventory.InventoryCartAPI;
import com.inventory.model.Product;
import com.inventory.model.ProductPO;

public class CustomDecorator extends CartDecorator {

	int quantity;
	double price;
	
	public CustomDecorator(InventoryCartAPI cart, Product product, ProductPO proPo) {
		super(cart);
		this.quantity = proPo.getQuantity();
		this.price = product.getPrice();
	}
	
	public double getCost() {
		return super.getCost()+(this.quantity * this.price);
	}
}
