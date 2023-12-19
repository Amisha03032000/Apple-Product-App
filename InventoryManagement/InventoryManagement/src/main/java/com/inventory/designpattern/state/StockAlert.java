package com.inventory.designpattern.state;

import com.inventory.designpattern.facade.SendMessage;
import com.inventory.model.Product;
import com.inventory.repository.ProductRepository;

public class StockAlert extends StateAPI{

	Product product;
	ProductRepository productRepo;
	
	public StockAlert(Product product, ProductRepository productRepo) {
		this.product = product;
		this.productRepo = productRepo;
	}

	@Override
	public void action(State state,int stock) {
		SendMessage.message("\n******\nLOW STOCK for "+product.getProductName()+"\n*****\n");
		product.setQuantity(stock);
		productRepo.update(product);
	}

}
