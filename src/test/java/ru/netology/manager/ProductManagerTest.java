package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Book book1 = new Book(35, "Долгая проогулка", 350, "Кинг");
    private Smartphone phone1 = new Smartphone(12, "iphone", 500, "apple");
    private Smartphone phone2 = new Smartphone(14, "iphone", 200, "apple");

    @Test
    public void shouldAddedProductToRepository() {

        manager.add(book1);
        manager.add(phone2);

        Product[] expected = new Product[]{book1, phone2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByProducts() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(phone2);

        Product[] expected = {phone2};
        Product[] actual = manager.searchBy("iphone");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void productDoesNotMatchSearchQuery() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(book1);
        manager.add(phone2);

        Product[] expected = {};
        Product[] actual = manager.searchBy("xiaomi");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void multipleProductMatchSameSearchQuery() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);

        manager.add(phone2);
        manager.add(phone1);

        Product[] expected = {phone2, phone1};
        Product[] actual = manager.searchBy("iphone");
        assertArrayEquals(expected, actual);
    }

}