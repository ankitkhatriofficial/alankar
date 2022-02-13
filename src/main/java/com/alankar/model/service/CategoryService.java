package com.alankar.model.service;

import java.util.List;

import com.alankar.model.dto.CategoryDto;

/**
 * @author ankitkhatri
 */
public interface CategoryService {

	public CategoryDto saveToDB(CategoryDto dto);

	public CategoryDto update(CategoryDto dto);

	public CategoryDto createOrUpdate(CategoryDto dto);

	public CategoryDto getById(String id);

	public List<CategoryDto> getAll();

	public void remove(String id);

}
