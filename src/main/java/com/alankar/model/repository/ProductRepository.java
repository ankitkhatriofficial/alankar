package com.alankar.model.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alankar.common.constant.CategoryConst;
import com.alankar.common.constant.PersonConst;
import com.alankar.model.entity.Product;

/**
 * @author ankitkhatri
 */

//, JpaSpecificationExecutor<Product>
public interface ProductRepository extends MongoRepository<Product, String> {

	List<Product> findByCategory(CategoryConst category);

	List<Product> findByPersonFor(PersonConst personFor);

}
