package com.punojsoft.java8practice.stream;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * it provides operations such as accumulating elements
 * into collections and summarizing elements elements
 * according to various criteria
 */

class Product {
    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

public class JavaCollectorsExamples {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<Product>();
        //Adding Products
        productsList.add(new Product(1, "HP Laptop", 25000f));
        productsList.add(new Product(2, "Dell Laptop", 30000f));
        productsList.add(new Product(3, "Lenevo Laptop", 28000f));
        productsList.add(new Product(4, "Sony Laptop", 28000f));
        productsList.add(new Product(5, "Apple Laptop", 90000f));
        productsList.add(new Product(5, "Apple Laptop", 25000f));
        productsList.add(new Product(1, "HP Laptop", 25000f));
        productsList.add(new Product(1, "HP Laptop", 25000f));
        /**
         * case i.collecting the price into list
         */
        productsList.stream().map(product -> product.price).collect(Collectors.toList()).forEach(System.out::println);

        /**
         * case ii.converting data into set/getting distinct
         */
        productsList.stream().collect(Collectors.toSet()).forEach(product -> System.out.println(Objects.toString(product)));

        /**
         * case iii. sum all the price
         */
        System.out.println(productsList.stream().collect(Collectors.summingDouble(product -> product.price)));
        /**
         * case iv. product average price
         */
        System.out.println(productsList.stream().collect(Collectors.averagingDouble(product -> product.price)));
        /**
         * case v.counting example
         */
        System.out.println(productsList.stream().count());
        //or
        System.out.println(productsList.stream().collect(Collectors.counting()));
        /**
         * case vi: printing occurence of each element
         */
        productsList.stream().map(product -> product.name).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });
        //or
        productsList.stream().collect(Collectors.groupingBy(Product::getName)).forEach((s, products) -> {
            System.out.println(s + " : " + products);
        });
        System.out.println("breaking .............................");
        //or multiple grouping
        productsList.stream().collect(Collectors.groupingBy(Product::getName, Collectors.groupingBy(Product::getPrice))).forEach((s, floatListMap) -> {
            System.out.println(s + " : " + floatListMap);
        });
        /**
         *summerizing data
         */
        DoubleSummaryStatistics doubleSummaryStatistics = productsList.stream().collect(Collectors.summarizingDouble(product -> product.getPrice()));
        System.out.println("Average :" + doubleSummaryStatistics.getAverage());
        System.out.println("Sum :" + doubleSummaryStatistics.getSum());
        System.out.println("Min :" + doubleSummaryStatistics.getMin());
        System.out.println("Max :" + doubleSummaryStatistics.getMax());
        System.out.println("Count :" + doubleSummaryStatistics.getCount());
        /**
         *Partitioning data
         */
        Map<Boolean, List<Product>> booleanListMap = productsList.stream().collect(Collectors.partitioningBy(product -> product.getPrice() > 28000));

        System.out.println(booleanListMap);

        /**
         * maxBy examples
         */
        System.out.println("max price example.......");
        Optional<Float> maxPrice = productsList.stream().map(product -> product.price).collect(Collectors.maxBy(Comparator.naturalOrder()));
        maxPrice.ifPresent(System.out::println);
        /**
         *joining price as  [10,201,30]
         */

        String joinedString = productsList.stream().map(product -> String.valueOf(product.getPrice())).collect(Collectors.joining(",", "[", "]"));
        System.out.println("joined String :" + joinedString);
        /**
         * reducing example
         *
         */
        System.out.println("Reducing example.....");
        productsList.stream().collect(Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Product::getPrice)))).ifPresent(System.out::println);
        /**
         *converting Product to ProductDTO using map
         *
         **/
        List<ProductDTO> productDTOList = productsList.stream().map(product -> {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setName(product.getName());
            productDTO.setPrice(String.valueOf(product.getPrice()));
            return productDTO;
        }).collect(Collectors.toList());
        System.out.println(productDTOList);
    }

}

class ProductDTO {
    private String name;
    private String price;

    public ProductDTO() {
    }

    public ProductDTO(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}