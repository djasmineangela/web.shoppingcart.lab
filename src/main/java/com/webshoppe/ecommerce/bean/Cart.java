package com.webshoppe.ecommerce.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
	private Map<String, CartItem> items;

	public Cart() {
		items = new HashMap<>();
	}

	public int countItems() {
		return items.size();
	}

	public void add(CartItem item) {
		if (item == null) {
			throw new IllegalArgumentException("Cart item cannot be null");
		}
		items.put(item.getId().trim(), item);
	}

	public void remove(String id) {
		CartItem item = items.get(id.trim());
		if (item == null) {
			throw new RuntimeException("Item not found");
		}
		items.remove(id.trim());
	}

	public Map<String, CartItem> getItems() {
		return items;
	}

	public List<CartItem> getItemsAsList() {
		return new ArrayList<>(items.values());
	}

	public BigDecimal getGrandTotal() {
		int grandTotal = 0;
		for (CartItem cartItem : this.getItemsAsList()) {
			grandTotal += cartItem.getTotalPrice().intValue();
		}

		return BigDecimal.valueOf(grandTotal);
	}
}
