package com.alankar.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.alankar.model.dto.filter.ProductFilterDto;
import com.alankar.model.entity.Product;
import com.alankar.repository.ProductRepository;

/**
 * @author ankitkhatri
 */

@Component
public class ProductFilterRepository {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Product> getFilteredEntity(ProductFilterDto productFilterDto, Pageable pageable) {

		/* If no Filter is provided */
		if (ObjectUtils.isEmpty(productFilterDto)) {
			return productRepository.findAll();
		}

		Query query;
		if(Boolean.TRUE.equals(productFilterDto.getIsIgnorePagination())){
			query = new Query().with(Pageable.unpaged());
		}else{
			query = new Query().with(pageable);
		}
		final List<Criteria> criteria = new ArrayList<>();

		if (!ObjectUtils.isEmpty(productFilterDto.getCategory())) {
			criteria.add(Criteria.where("category").is(productFilterDto.getCategory()));
		}
		
		if (!ObjectUtils.isEmpty(productFilterDto.getPersonFor())) {
			criteria.add(Criteria.where("personFor").is(productFilterDto.getPersonFor()));
		}
		
		if (!ObjectUtils.isEmpty(productFilterDto.getMetalType())) {
			criteria.add(Criteria.where("metalType").is(productFilterDto.getMetalType()));
		}
		
		if (!ObjectUtils.isEmpty(productFilterDto.getMetalQualityType())) {
			criteria.add(Criteria.where("metalQualityType").is(productFilterDto.getMetalQualityType()));
		}

		if (!criteria.isEmpty())
			query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));

		return mongoTemplate.find(query, Product.class);
	}

}
