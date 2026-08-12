package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShopRepositoryTest {

    @Test
    void shouldRemoveExistingProduct() {
        ShopRepository repository = new ShopRepository();

        Product product1 = new Product(1, "Телефон", 50000);
        Product product2 = new Product(2, "Ноутбук", 100000);

        repository.add(product1);
        repository.add(product2);

        repository.removeById(1);

        Product[] actual = repository.findAll();

        Product[] expected = {product2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldThrowNotFoundExceptionWhenProductNotFound() {
        ShopRepository repository = new ShopRepository();

        Product product = new Product(1, "Телефон", 50000);

        repository.add(product);

        assertThrows(
                NotFoundException.class,
                () -> repository.removeById(2)
        );
    }
}