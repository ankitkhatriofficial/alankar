package com.alankar.common.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.alankar.common.Utils;
import com.alankar.model.dto.ProductDto;
import com.alankar.model.entity.Product;

/**
 * @author ankitkhatri
 */

@Component
public class ProductConverter {

	/** Helper function to convert the current dto object to entity object */
	public Product pojoToEntity(ProductDto dto) {
		Product entity = new Product();
		BeanUtils.copyProperties(dto, entity);
		entity.setImages(Utils.listToString(dto.getImages()));
		return entity;
	}

	/** Helper function to convert the current entity object to dto object */
	public ProductDto entityToPojo(Product entity) {
		if (entity == null)
			return null;
		ProductDto dto = new ProductDto();
		BeanUtils.copyProperties(entity, dto);
		dto.setImages(Utils.stringToList(entity.getImages(), String.class));
		return dto;
	}

	/** Helper function to convert the given list entity to list dto */
	public List<ProductDto> toDtoList(List<Product> entities) {
		if (entities == null)
			return null;
		return entities.stream().map((entity) -> entityToPojo(entity)).collect(Collectors.toList());
	}

	/** Helper function to convert the given page entity to list dto */
	public List<ProductDto> toDtoList(Page<Product> entities) {
		if (entities == null)
			return new ArrayList<>();
		return entities.stream().map((entity) -> entityToPojo(entity)).collect(Collectors.toList());
	}
}
