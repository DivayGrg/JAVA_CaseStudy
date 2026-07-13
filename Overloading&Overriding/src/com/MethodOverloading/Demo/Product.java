package com.MethodOverloading.Demo;

public class Product {
public void search(String productName) {
	System.out.println("Searching for product: " + productName);
}
public void search(String productName, String brand) {
	System.out.println("Searching for product: " + productName + " in category: " + brand);
}
public void search(String productName, String brand, double price) {
	System.out.println("Searching for product: " + productName + " in category: " + brand + " with price: " + price);
}
public static void main(String[] args) {
	Product product = new Product();
	product.search("Laptop");
	product.search("Smartphone", "APPLE");
	product.search("Headphones", "Lenovo", 99.99);
}
}
