package productmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.productmanagement.entity.Product;
import com.example.productmanagement.repository.ProductRepository;
import com.example.productmanagement.service.ProductService;
import com.example.productmanagement.service.ProductServiceImpl;

class ProductServiceTest {

	private final ProductRepository productRepository = mock(ProductRepository.class);
	private final ProductService productService = new ProductServiceImpl(productRepository);

	@Test
	void testAddProduct() {
		Product product = new Product( "Laptop", "Gaming Laptop", 1000.0);
		when(productRepository.save(Mockito.any(Product.class))).thenReturn(product);
		Product savedProduct = productService.addProduct(product);
		assertNotNull(savedProduct);
		assertEquals("Laptop", savedProduct.getName());
	}

	@Test
	void testGetProductById() {
		Product product = new Product( "Laptop", "Gaming Laptop", 1000.0);
		when(productRepository.findById(1L)).thenReturn(Optional.of(product));
		Product fetchedProduct = productService.getProductById(1L);
		assertNotNull(fetchedProduct);
		assertEquals("Laptop", fetchedProduct.getName());
	}

	@Test
	void testDeleteProduct() {
		doNothing().when(productRepository).deleteById(1L);
		productService.deleteProduct(1L);
		verify(productRepository, times(1)).deleteById(1L);
	}
}
