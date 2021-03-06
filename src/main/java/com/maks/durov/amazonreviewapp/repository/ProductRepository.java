package com.maks.durov.amazonreviewapp.repository;

import com.maks.durov.amazonreviewapp.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query(value = "SELECT review_products.id, count(*) AS c FROM review_products "
            + "JOIN reviews ON review_products.id = reviews.product_id "
            + "GROUP BY review_products.id "
            + "ORDER BY c DESC LIMIT ?1 OFFSET ?2", nativeQuery = true)
    List<Product> findMostReviewedProducts(int limit, int offset);

}
