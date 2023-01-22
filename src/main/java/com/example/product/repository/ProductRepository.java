package com.example.product.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.product.model.ProductModel;
@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
	//Optional<ProductModel> findByProduct_name( String pName);

	

	@Query("select pm from ProductModel pm where pm.product_ID = :cid and pm.product_name = :cname")
	Optional<ProductModel> getByIdAndName(@Param("cid") int pId, @Param("cname") String pName);
	}
