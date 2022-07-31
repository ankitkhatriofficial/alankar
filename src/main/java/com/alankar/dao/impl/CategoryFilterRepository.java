package com.alankar.dao.impl;

/**
 * @author ankitkhatri
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.alankar.model.dto.filter.CategoryFilterDto;
import com.alankar.model.entity.Category;
import com.alankar.repository.CategoryRepostiory;

@Component
public class CategoryFilterRepository {

	@Autowired
	private CategoryRepostiory categoryRepostiory;

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Category> getFilteredEntity(CategoryFilterDto categoryFilterDto, Pageable pageable) {

		/* If no Filter is provided */
		if (ObjectUtils.isEmpty(categoryFilterDto)) {
			return categoryRepostiory.findAll();
		}

		Query query;
		if(Boolean.TRUE.equals(categoryFilterDto.getIsIgnorePagination())){
			query = new Query().with(Pageable.unpaged());
		} else{
			query = new Query().with(pageable);
		}

		final List<Criteria> criteria = new ArrayList<>();

		if (!ObjectUtils.isEmpty(categoryFilterDto.getSearchKeyword())) {
			criteria.add(Criteria.where("category").regex(categoryFilterDto.getSearchKeyword()));
		}

		if (!criteria.isEmpty())
			query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));

		return mongoTemplate.find(query, Category.class);
	}

}
