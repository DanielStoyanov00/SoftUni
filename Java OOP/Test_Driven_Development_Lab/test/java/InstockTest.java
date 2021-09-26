import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest {
    private static final String TEST_LABEL = "test_label";
    private static final double DEFAULT_PRICE = 11.00;
    private static final int DEFAULT_QUANTITY = 5;
    private static final int COUNT_OF_PRODUCTS_IN_GET_PRODUCTS_METHOD = 5;
    private static final int NEGATIVE_INDEX = -1;
    private static final int INDEX_GREATER_THAN_SIZE = Integer.MAX_VALUE;
    private static final int TEST_VARIABLE_FOR_FIND_FIRST_METHODS = 3;
    private static final double LOWER_PRICE_RANGE = 12.00;
    private static final double UPPER_PRICE_RANGE = 15.00;
    private static final double INVALID_LOWER_PRICE_RANGE = Double.MAX_VALUE - 1;
    private static final double INVALID_UPPER_PRICE_RANGE = Double.MAX_VALUE;
    private static final double INVALID_PRICE = 999.999;
    private static final int QUANTITY_TEST = 5;
    private static final int INVALID_QUANTITY = 10000;


    private Product defaultProduct;
    private ProductStock stock;

    @Before
    public void setUp() {
        this.defaultProduct = new Product(TEST_LABEL, DEFAULT_PRICE, DEFAULT_QUANTITY);
        this.stock = new Instock();
    }

    private List<Product> getProducts() {
        return List.of(
                new Product("label1", 11.00, 5),
                new Product("label2", 12.00, 6),
                new Product("label3", 13.00, 5),
                new Product("label4", 14.00, 8),
                new Product("label5", 15.00, 9)
        );
    }

    // contains
    @Test
    public void testContainsShouldReturnTrueOrFalseIfProductIsPresentOrNot() {
        assertFalse(stock.contains(defaultProduct));
        stock.add(defaultProduct);
        assertTrue(stock.contains(defaultProduct));
    }

    // add
    @Test
    public void testAddShouldAddProductInCollectionIfNotPresent() {
        stock.add(defaultProduct);
        assertEquals(1, stock.getCount());
    }

    @Test
    public void testAddShouldNotAddProductInCollectionIfItsPresent() {
        stock.add(defaultProduct);
        stock.add(defaultProduct);
        assertEquals(1, stock.getCount());
    }

    // getCount
    @Test
    public void testGetCountShouldReturnNumberOfElementsInCollection() {
        List<Product> products = getProducts();
        for (Product product : products) {
            stock.add(product);
        }
        assertEquals(COUNT_OF_PRODUCTS_IN_GET_PRODUCTS_METHOD, stock.getCount());
    }

    // find
    @Test
    public void testFindByIndexShouldReturnProductAtGivenIndex() {
        stock.add(defaultProduct);
        assertEquals(defaultProduct, stock.find(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexShouldThrowExceptionIfIndexIsNegative() {
        stock.find(NEGATIVE_INDEX);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexShouldThrowExceptionIfIndexIsGreater() {
        stock.find(INDEX_GREATER_THAN_SIZE);
    }

    // changeQuantity
    @Test
    public void testChangeQuantityShouldChangeProductQuantityIfProductIsInCollection() {
        stock.add(defaultProduct);
        assertEquals(DEFAULT_QUANTITY, defaultProduct.getQuantity());

        stock.changeQuantity(defaultProduct.getLabel(), 10);
        assertEquals(10, defaultProduct.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityShouldThrowExceptionIfProductIsNotPresent() {
        stock.changeQuantity(defaultProduct.getLabel(), 10);
    }

    // findByLabel
    @Test
    public void testFindByLabelShouldReturnTheProductWithTheGivenLabelIfItsPresent() {
        stock.add(defaultProduct);

        assertEquals(TEST_LABEL, defaultProduct.getLabel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelShouldThrowExceptionIfLabelIsNotPresent() {
        stock.findByLabel(TEST_LABEL);
    }

    // findFirstByAlphabeticalOrder
    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnFirstNProductsFromTheCollection() {
        List<Product> products = getProducts();
        for (Product product : products) {
            stock.add(product);
        }

        List<Product> expected = products.stream().
                sorted(Comparator.comparing(Product::getLabel))
                .limit(TEST_VARIABLE_FOR_FIND_FIRST_METHODS)
                .collect(Collectors.toList());

        assertEquals(expected, stock.findFirstByAlphabeticalOrder(TEST_VARIABLE_FOR_FIND_FIRST_METHODS));
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyArrayListIfCountIsGreaterThanSize() {
        assertEquals(new ArrayList<>(), stock.findFirstByAlphabeticalOrder(INDEX_GREATER_THAN_SIZE));
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyArrayListIfCountIsNegativeNumber() {
        assertEquals(new ArrayList<>(), stock.findFirstByAlphabeticalOrder(NEGATIVE_INDEX));
    }

    // findAllInPriceRange
    @Test
    public void testFindAllInPriceRangeShouldReturnProductsWhichAreWithinGivenPrice() {
        List<Product> expected = getProducts().stream()
                .filter(p -> p.getPrice() > LOWER_PRICE_RANGE && p.getPrice() <= UPPER_PRICE_RANGE)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());
        assertNotNull(expected);

        for (Product product : expected) {
            stock.add(product);
        }

        assertEquals(expected, stock.findAllInRange(LOWER_PRICE_RANGE,UPPER_PRICE_RANGE));
    }

    @Test
    public void testFindAllInPriceRangeShouldReturnEmptyCollectionIfPricesAreInvalid(){
        assertEquals(new ArrayList<>(), stock.findAllInRange(INVALID_LOWER_PRICE_RANGE, INVALID_UPPER_PRICE_RANGE));
    }

    // findAllByPrice
    @Test
    public void testFindAllByPriceShouldReturnProductsWithGivenPrice(){
        List<Product> products = getProducts();
        for (Product product : products) {
            stock.add(product);
        }
        stock.add(defaultProduct);

        List<Product> expected = products.stream()
                .filter(p -> p.getPrice() == DEFAULT_PRICE)
                .collect(Collectors.toList());
        expected.add(defaultProduct);

        assertEquals(expected, stock.findAllByPrice(DEFAULT_PRICE));
    }

    @Test
    public void testFindAllByPriceShouldReturnEmptyCollectionIfPriceIsNotPresent(){
       assertEquals(new ArrayList<>(), stock.findAllByPrice(INVALID_PRICE));
    }

    // findFirstMostExpensiveProducts
    @Test
    public void testFindFirstMostExpensiveProductsShouldReturnFirstNExpensiveItems(){
        List<Product> products = getProducts();
        for (Product product : products) {
            stock.add(product);
        }

        List<Product> expected = products
                .stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(TEST_VARIABLE_FOR_FIND_FIRST_METHODS)
                .collect(Collectors.toList());
        assertNotNull(expected);


        assertEquals(expected,stock.findFirstMostExpensiveProducts(TEST_VARIABLE_FOR_FIND_FIRST_METHODS));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsShouldThrowExceptionIfGivenCountIsNegativeNumber(){
        stock.findFirstMostExpensiveProducts(NEGATIVE_INDEX);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsShouldThrowExceptionIfGivenCountIsGreaterThanSize(){
        stock.findFirstMostExpensiveProducts(INDEX_GREATER_THAN_SIZE);
    }

    // findAllByQuantity
    @Test
    public void testFindAllByQuantityShouldReturnAllProductsWithGivenQuantity(){
        List<Product> products = getProducts();
        for (Product product : products) {
            stock.add(product);
        }

        List<Product> expected = products.stream()
                .filter(p -> p.getQuantity() == QUANTITY_TEST)
                .collect(Collectors.toList());

        assertEquals(expected, stock.findAllByQuantity(QUANTITY_TEST));
    }

    @Test
    public void testFindAllByQuantityShouldReturnAnEmptyCollectionIfQuantityIsInvalid(){
        assertEquals(new ArrayList<>(), stock.findAllByQuantity(INVALID_QUANTITY));
    }

    // iterator
    @Test
    public void testIteratorShouldReturnAllElementsInTheCollection(){
        List<Product> expected = getProducts();

        Iterator<Product> iterator = stock.iterator();
        assertNotNull(iterator);

        int index = 0;
        while (iterator.hasNext()){
            Product product = iterator.next();
            assertEquals(expected.get(index++).getLabel(), product.getLabel());
        }
    }


}