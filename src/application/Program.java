package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;
import service.CalculationService;

public class Program {
	
	public static final String PATH = "/home/scaziti/Desktop/products.txt";
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		List<Product> list = new ArrayList<>();
		
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))){
			String line = bufferedReader.readLine();
			
			while(line != null) {
				String[] fields = line.split(",");
				
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				
				line = bufferedReader.readLine();
			}
			
			System.out.println("PRODUCT \t PRICE");
			System.out.println();
			for (Product p : list) {
				System.out.println(p);
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		System.out.println("\nThe most expensive product: ");
		System.out.println(CalculationService.max(list));
	}

}
