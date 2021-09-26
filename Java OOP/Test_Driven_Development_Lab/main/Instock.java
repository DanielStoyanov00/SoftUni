import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private List<Product> productList;

    public Instock() {
        this.productList = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public boolean contains(Product product) {
        return productList.stream().anyMatch(p -> p.getLabel().equals(product.getLabel()));
    }

    @Override
    public void add(Product product) {
        if (!productList.contains(product)) {
            productList.add(product);
        }
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        productList.stream().filter(p -> p.getLabel().equals(product))
                .findAny()
                .orElseThrow(IllegalArgumentException::new)
                .setQuantity(quantity);
    }

    @Override
    public Product find(int index) {
        return productList.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        return productList.stream()
                .filter(p -> p.getLabel().equals(label))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count < 0 || count >= productList.size()) {
            return new ArrayList<>();
        }

        return productList.stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        List<Product> collect = productList.stream()
                .filter(p -> p.getPrice() > lo && p.getPrice() <= hi)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());

        if (collect.size() == 0) {
            return new ArrayList<>();
        }
        return collect;
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return productList.stream()
                .filter(p -> p.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (count < 0 || count >= productList.size()) {
            throw new IllegalArgumentException();
        }

        return productList
                .stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(count)
                .collect(Collectors.toList());
        }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return productList
                .stream()
                .filter(p -> p.getQuantity() == quantity)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return productList.iterator();
    }
}
