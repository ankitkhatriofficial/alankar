package com.alankar.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alankar.common.constant.PersonConst;
import com.alankar.model.entity.Product;

/**
 * @author ankitkhatri
 */

public interface ProductRepository extends MongoRepository<Product, String> {

	List<Product> findByCategory(String category);

	List<Product> findByPersonFor(PersonConst personFor);

}
