package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {
    private final ProductManager manager = new ProductManager(new ProductRepository());
    private final Book longWalk = new Book(1, "long", 250, "first");
    private final Book whiteFlag = new Book(2, "flag", 400, "first");
    private final Book blackFlag = new Book(3, "flag", 150, "three");
    private final Smartphone iphone13 = new Smartphone(1, "iphone", 500, "phone1");

    @Test
    void shouldSaveOneItem() {

        manager.saveProduct(longWalk);

        Product[] expected = new Product[]{longWalk};
        Product[] actual = manager.findAllProducts();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveOneItem2() {

        manager.saveProduct(whiteFlag);

        Product[] expected = new Product[]{whiteFlag};
        Product[] actual = manager.findAllProducts();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveOneItem3() {

        manager.saveProduct(iphone13);

        Product[] expected = new Product[]{iphone13};
        Product[] actual = manager.findAllProducts();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveOneItem4() {

        manager.saveProduct(blackFlag);

        Product[] expected = new Product[]{blackFlag};
        Product[] actual = manager.findAllProducts();

        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldFindAllItems() {

        manager.saveProduct(longWalk);
        manager.saveProduct(whiteFlag);
        manager.saveProduct(iphone13);
        manager.saveProduct(blackFlag);

        Product[] expected = new Product[]{longWalk, whiteFlag, iphone13, blackFlag};
        Product[] actual = manager.findAllProducts();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByString() {

        manager.saveProduct(longWalk);
        manager.saveProduct(whiteFlag);
        manager.saveProduct(iphone13);
        manager.saveProduct(blackFlag);

        Product[] expected = new Product[]{longWalk};
        Product[] actual = manager.searchBy("long");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByString2() {

        manager.saveProduct(longWalk);
        manager.saveProduct(whiteFlag);
        manager.saveProduct(iphone13);
        manager.saveProduct(blackFlag);

        Product[] expected = new Product[]{iphone13};
        Product[] actual = manager.searchBy("iphone");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByString3() {

        manager.saveProduct(longWalk);
        manager.saveProduct(whiteFlag);
        manager.saveProduct(iphone13);
        manager.saveProduct(blackFlag);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("two");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByString4() {

        manager.saveProduct(longWalk);
        manager.saveProduct(whiteFlag);
        manager.saveProduct(iphone13);
        manager.saveProduct(blackFlag);

        Product[] expected = new Product[]{whiteFlag, blackFlag};
        Product[] actual = manager.searchBy("flag");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {

        manager.saveProduct(longWalk);
        manager.saveProduct(whiteFlag);
        manager.saveProduct(iphone13);
        manager.saveProduct(blackFlag);

        Product[] expected = new Product[]{longWalk, iphone13, blackFlag};
        Product[] actual = manager.removeByIdProducts(2);

        assertArrayEquals(expected, actual);
    }

}
