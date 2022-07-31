package com.alankar.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alankar.model.entity.Category;

/**
 * @author ankitkhatri
 */
public interface CategoryRepostiory extends MongoRepository<Category, String> {

}
