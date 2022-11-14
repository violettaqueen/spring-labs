package com.cydeo.repository;

import com.cydeo.entity.Category;
import com.cydeo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //Write a derived query to get top 3 product order by price desc
    List<Product> findTop3ByOrderByPriceDesc();

    //Write a derived query to get product by specific name
    List<Product> findFirstByName(String name);

    //Write a derived query to get product by specific category
    List<Product> findFirstByCategoryListContaining(Category category);

    //Write a derived query to get count by price greater than specific amount
    Integer countProductByPriceGreaterThan(BigDecimal amount);

    //Write a derived query to get all product by quantity greater than or equal specific count
    List<Product>findAllByQuantityGreaterThanEqual(Integer quantity);

    //Write a native query to get all product by price greater than specific amount and quantity lower than specific count
    @Query(value = "select * from product p where p.price > ?1 and p.remaining_quality < ?2 ",nativeQuery = true)
    List<Product> retrieveAllProductsByPriceGreaterThanAndQuantityLessThan(BigDecimal priceAmount, Integer remainingQuantity);


    //Write a native query to get all product by specific categoryId
    @Query(value = "select * from product p join product_category_rel pcr on pcr.p_id = p.id where pcr.c_id =?1", nativeQuery = true)
    List<Product> retrieveAllByCategoryId(Long categoryId);

    //Write a native query to get all product by specific categoryId and price greater than specific amount
     @Query(value = "select * from product p join product_category_rel pcr on pcr.p.id = p.id where pcr.c_id in (?1)" +
             "where c_id = ?1 and p.price = ?2", nativeQuery = true)
    List<Product> retrieveAllProductsByCategoryIdAndPriceGreaterThan(Long id, BigDecimal price);

}