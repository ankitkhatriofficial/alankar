package com.alankar.common.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.alankar.model.dto.CategoryDto;
import com.alankar.model.entity.Category;

/**
 * @author ankitkhatri
 */
@Component
public class CategoryConverter {

	/** Helper function to convert the current dto object to entity object */
	public Category pojoToEntity(CategoryDto dto) {
		Category entity = new Category();
		BeanUtils.copyProperties(dto, entity);
		return entity;
	}

	/** Helper function to convert the current entity object to dto object */
	public CategoryDto entityToPojo(Category entity) {
		if (entity == null)
			return null;
		CategoryDto dto = new CategoryDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	/** Helper function to convert the given list entity to list dto */
	public List<CategoryDto> toDtoList(List<Category> entities) {
		if (entities == null)
			return new ArrayList<>();
		return entities.stream().map((entity) -> entityToPojo(entity)).collect(Collectors.toList());
	}

}
