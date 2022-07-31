package com.alankar.service;

import java.util.List;

import com.alankar.model.dto.CategoryDto;
import com.alankar.model.dto.filter.CategoryFilterDto;

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

	public List<CategoryDto> getByFilters(CategoryFilterDto categoryFilterDto);

}
