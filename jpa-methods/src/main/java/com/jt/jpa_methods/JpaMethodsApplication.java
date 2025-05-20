package com.jt.jpa_methods;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import lombok.RequiredArgsConstructor;

@SpringBootApplication
@RequiredArgsConstructor
public class JpaMethodsApplication implements CommandLineRunner{
	private final ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(JpaMethodsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var product = Product.builder().productName("Google Pixel 9A").productBrand("Google").productPrice(89899.99).build();

		// productRepository.save(product);

		// productRepository.saveAll(getProducts());

		// System.out.println("Total rows in the table are: "+productRepository.count());

		// System.out.println("Is Google product available: "+productRepository.existsById("41786e80-4a62-48e4-930a-80e224652cd5"));

		productRepository.deleteById("41786e80-4a62-48e4-930a-80e224652cd5");

		List<Product> products = productRepository.findAll();
		// products.forEach(System.out::println);
		List<Product> products2 = productRepository.findAll(Sort.by(Sort.Direction.ASC, "productPrice"));
		// products2.forEach(System.out::println);

		// Pagination
		// Page<Product> products3 = productRepository.findAll(PageRequest.of(0, 3));
		// Page<Product> products3 = productRepository.findAll(PageRequest.of(0, 3, Sort.by(Sort.Direction.ASC, "productPrice")));
		// products3.forEach(System.out::println);

		// Optional<Product> optProduct = productRepository.findById("27c1b6d3-f921-4b62-aa00-0f3a118bf44b");
		// Product existingProduct = optProduct.orElseThrow(() -> new NoSuchElementException("Product not found by id"));
		// System.out.println("Find by id : "+existingProduct);

		// Optional<Product> optProduct = productRepository.findById("27c1b6d3-f921-4b62-aa00-0f3a118bf44b");
		// Product existingProduct = optProduct.orElseThrow(() -> new NoSuchElementException("Product not found by id"));
		// System.out.println("Before updating by id: "+existingProduct);
		// existingProduct.setProductName("Google Pixel 10A Pro");
		// existingProduct.setProductPrice(94699);
		// Product savedProduct = productRepository.save(existingProduct);
		// System.out.println("After updating by id: "+savedProduct);

		// Optional<Product> optProductByName = productRepository.findByProductName("Google Pixel 10A Pro");
		// Product productByName = optProductByName.orElseThrow();
		// System.out.println("Product by name: "+productByName);

		// List<Product> productsBetweenRange = productRepository.findAllByProductPriceBetween(5000.00, 9000.00);
		// System.out.println("Products between price range 5000-9000 are:");
		// productsBetweenRange.forEach(System.out::println);
		
		// List<Product> productsGreaterThanPrice = productRepository.findAllByProductPriceGreaterThan(9000.00, Sort.by(Direction.ASC, "productPrice"));
		// System.out.println("Products greater than 9000.00 are: ");
		// productsGreaterThanPrice.forEach(System.out::println);

		// Optional<Product> optProductPriceANDBrand = productRepository.findByProductPriceAndProductBrand(94699.00, "Google");
		// Product productPriceANDProductBrand = optProductPriceANDBrand.orElseThrow();
		// System.out.println("Product by price and brand: "+productPriceANDProductBrand);

		// Optional<Product> optDistinctProductByName = productRepository.findDistinctByProductName("Google Pixel 10A Pro");
		// System.out.println("Distinct Product by name - 'Google Pixel 10A Pro': "+optDistinctProductByName.orElseThrow());
		
		// Optional<Product> optEqualsProductByName = productRepository.findByProductNameEquals("Google Pixel 10A Pro");
		// System.out.println("Google Pixel 10A Pro equals product: "+optEqualsProductByName.orElseThrow());

		// Optional<Product> optProductByStartingName = productRepository.findByProductNameStartingWith("Google Pixel");
		// System.out.println("Product starting with 'Google Pixel': "+optProductByStartingName.orElseThrow());

		// Optional<Product> optProductByContainingName = productRepository.findByProductNameContaining("Pixel");
		// System.out.println("Product containing 'Pixel': "+optProductByContainingName.orElseThrow());

		List<Product> optProductByOtherBrands = productRepository.findByProductBrandNot("Google");
		System.out.println("Products other than 'Google' are: ");
		optProductByOtherBrands.forEach(System.out::println);
	}

	private List<Product> getProducts(){
		List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9);
		return numbers.stream().map(number -> Product.builder().productName("product: "+number).productBrand("brand: "+number).productPrice(number*1000.50).build()).toList();
	}
}
