package com.project.SpringBatchProject.config;

import org.springframework.batch.item.ItemProcessor;

import com.project.SpringBatchProject.model.Product;

public class CustomItemProcessor implements ItemProcessor<Product, Product> {
	
	@Override
	public Product process(Product item) throws Exception {
				
		try {
			int discountper = Integer.parseInt(item.getDiscount().trim());
			System.out.println(discountper);
			double originalPrice = Double.parseDouble(item.getPrice().trim());
			System.out.println(originalPrice);
			double discount = (discountper/100)*originalPrice;
			System.out.println(discount);
			double finalPrice = originalPrice - discount;
			System.out.println(finalPrice);
			item.setDiscountedPrice(String.valueOf(finalPrice));
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
				
		return item;
	}

	
	
}
