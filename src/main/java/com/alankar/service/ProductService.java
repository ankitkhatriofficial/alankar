package com.alankar.service;

import java.util.List;

import com.alankar.model.dto.ProductDto;
import com.alankar.model.dto.ProductFilterResponse;
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

	public ProductFilterResponse getByFilters(ProductFilterDto productFilterDto);

	public void remove(String id);

}
