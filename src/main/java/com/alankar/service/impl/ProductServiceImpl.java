package com.alankar.service.impl;

import java.util.List;
import java.util.Optional;

import com.alankar.model.dto.ProductFilterResponse;
import com.alankar.model.entity.Category;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.alankar.common.Utils;
import com.alankar.common.constant.ResponseCode;
import com.alankar.common.converter.ProductConverter;
import com.alankar.handler.model.BaseException;
import com.alankar.dao.impl.ProductFilterRepository;
import com.alankar.model.dto.ProductDto;
import com.alankar.model.dto.filter.ProductFilterDto;
import com.alankar.model.entity.Product;
import com.alankar.repository.ProductRepository;
import com.alankar.service.ProductService;

/**
 * @author ankitkhatri
 */

@Service
public class ProductServiceImpl implements ProductService {

	private final String PREFIX_ID = "PRD-";

	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private ProductConverter productConverter;
	@Autowired
	private ProductFilterRepository productFilterRepository;

	@Override
	public ProductDto saveToDB(ProductDto dto) {
		if(dto.getCategory() == null || !Category.categoryCache.contains(dto.getCategory())){
			throw new BaseException(ResponseCode.INVALID_CATEGORY_PASSED);
		}
		if (dto.getId() == null || dto.getId().trim().isEmpty()) {
			dto.setId(Utils.generateNewID(PREFIX_ID, productRepo));
		}
		return productConverter.entityToPojo(productRepo.save(productConverter.pojoToEntity(dto)));
	}

	@Override
	public ProductDto update(ProductDto dto) {
		if(dto.getCategory() == null || !Category.categoryCache.contains(dto.getCategory())){
			throw new BaseException(ResponseCode.INVALID_CATEGORY_PASSED);
		}
		ProductDto savedObject = getById(dto.getId());
		BeanUtils.copyProperties(dto, savedObject);
		return productConverter.entityToPojo(productRepo.save(productConverter.pojoToEntity(savedObject)));

	}

	@Override
	public ProductDto createOrUpdate(ProductDto dto) {
		if (dto.getId() == null)
			return saveToDB(dto);
		else
			return update(dto);
	}

	@Override
	public ProductDto getById(String id) {
		Optional<Product> optional = productRepo.findById(id);
		if (optional.isPresent()) {
			return productConverter.entityToPojo(optional.get());
		} else {
			throw new BaseException(ResponseCode.ENTITY_NOT_FOUND);
		}
	}

	@Override
	public List<ProductDto> getAll() {
		return productConverter.toDtoList(productRepo.findAll());
	}

	@Override
	public void remove(String id) {
		Optional<Product> optional = productRepo.findById(id);
		if (optional.isPresent()) {
			productRepo.deleteById(id);
		} else {
			throw new BaseException(ResponseCode.ENTITY_NOT_FOUND);
		}
	}

	@Override
	public ProductFilterResponse getByFilters(ProductFilterDto productFilterDto) {
		Pageable pageable = Utils.getPageable(productFilterDto);
		List<ProductDto> list = productConverter.toDtoList(
				productFilterRepository.getFilteredEntity(productFilterDto, pageable));
		ProductFilterResponse response = ProductFilterResponse.builder()
				.totalCount(productRepo.count())
				.filteredCount(Long.valueOf(list.size()))
				.pageNumber(pageable.getPageNumber())
				.pageSize(pageable.getPageSize())
				.data(list)
				.build();
		return response;
	}

}
