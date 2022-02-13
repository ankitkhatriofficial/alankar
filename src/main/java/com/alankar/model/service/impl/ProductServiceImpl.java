package com.alankar.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alankar.common.Utils;
import com.alankar.common.constant.ResponseCode;
import com.alankar.common.converter.ProductConverter;
import com.alankar.handler.model.BaseException;
import com.alankar.model.dao.impl.ProductFilterRepository;
import com.alankar.model.dto.ProductDto;
import com.alankar.model.dto.filter.ProductFilterDto;
import com.alankar.model.entity.Product;
import com.alankar.model.repository.ProductRepository;
import com.alankar.model.service.ProductService;

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
		if (dto.getId() == null || dto.getId().trim().isEmpty()) {
			dto.setId(Utils.generateNewID(PREFIX_ID, productRepo));
		}
		return productConverter.entityToPojo(productRepo.save(productConverter.pojoToEntity(dto)));
	}

	@Override
	public ProductDto update(ProductDto dto) {
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
	public List<ProductDto> getByFilters(ProductFilterDto productFilterDto) {
		return productConverter.toDtoList(
				productFilterRepository.getFilteredEntity(productFilterDto, Utils.getPageable(productFilterDto)));
	}

}
