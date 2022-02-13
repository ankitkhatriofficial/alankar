package com.alankar.model.service;

import java.util.List;

import com.alankar.model.dto.ProductDto;
import com.alankar.model.dto.filter.ProductFilterDto;

/**
 * @author ankitkhatri
 */

public interface ProductService {

	public ProductDto saveToDB(ProductDto dto);

	public ProductDto update(ProductDto dto);

	public ProductDto createOrUpdate(ProductDto dto);

	public ProductDto getById(String id);

	public List<ProductDto> getAll();

	public List<ProductDto> getByFilters(ProductFilterDto productFilterDto);

	public void remove(String id);

}
