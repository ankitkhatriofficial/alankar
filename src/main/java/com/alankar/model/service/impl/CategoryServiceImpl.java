package com.alankar.model.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alankar.common.Utils;
import com.alankar.common.constant.ResponseCode;
import com.alankar.common.converter.CategoryConverter;
import com.alankar.handler.model.BaseException;
import com.alankar.model.dto.CategoryDto;
import com.alankar.model.entity.Category;
import com.alankar.model.repository.CategoryRepostiory;
import com.alankar.model.service.CategoryService;

/**
 * @author ankitkhatri
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	private final String PREFIX_ID = "CAT-";

	@Autowired
	private CategoryRepostiory categoryRepo;
	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public CategoryDto saveToDB(CategoryDto dto) {
		if (dto.getId() == null || dto.getId().trim().isEmpty()) {
			dto.setId(Utils.generateNewID(PREFIX_ID, categoryRepo));
		}
		return categoryConverter.entityToPojo(categoryRepo.save(categoryConverter.pojoToEntity(dto)));
	}

	@Override
	public CategoryDto update(CategoryDto dto) {
		CategoryDto savedObject = getById(dto.getId());
		BeanUtils.copyProperties(dto, savedObject);
		return categoryConverter.entityToPojo(categoryRepo.save(categoryConverter.pojoToEntity(savedObject)));
	}

	@Override
	public CategoryDto createOrUpdate(CategoryDto dto) {
		if (dto.getId() == null)
			return saveToDB(dto);
		else
			return update(dto);
	}

	@Override
	public CategoryDto getById(String id) {
		Optional<Category> optional = categoryRepo.findById(id);
		if (optional.isPresent()) {
			return categoryConverter.entityToPojo(optional.get());
		} else {
			throw new BaseException(ResponseCode.ENTITY_NOT_FOUND);
		}
	}

	@Override
	public List<CategoryDto> getAll() {
		return categoryConverter.toDtoList(categoryRepo.findAll());
	}

	@Override
	public void remove(String id) {
		Optional<Category> optional = categoryRepo.findById(id);
		if (optional.isPresent()) {
			categoryRepo.deleteById(id);
		} else {
			throw new BaseException(ResponseCode.ENTITY_NOT_FOUND);
		}
	}

}
