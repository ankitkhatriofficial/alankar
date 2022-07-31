package com.alankar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alankar.common.constant.RestMappingConst;
import com.alankar.common.response.BaseResponseMessage;
import com.alankar.model.dto.CategoryDto;
import com.alankar.model.dto.filter.CategoryFilterDto;
import com.alankar.service.CategoryService;

/**
 * @author ankitkhatri
 */

@CrossOrigin
@RestController
@RequestMapping(value = RestMappingConst.Category.BASE)
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping(value = RestMappingConst.Category.CREATE)
	public ResponseEntity<?> addNewCategory(@RequestBody CategoryDto categoryDto) {
		return BaseResponseMessage.CREATED(categoryService.saveToDB(categoryDto));
	}

	@GetMapping(path = RestMappingConst.Category.GET)
	public ResponseEntity<?> fetchAllCategory() {
		return BaseResponseMessage.RETURN_DATA(categoryService.getAll());
	}

	@GetMapping(path = RestMappingConst.Category.GET + RestMappingConst.ID_PARAM)
	public ResponseEntity<?> fetchCategoryById(@PathVariable(name = RestMappingConst.ID) String id) {
		return BaseResponseMessage.RETURN_DATA(categoryService.getById(id));
	}

	@PostMapping(path = RestMappingConst.Category.GET_WITH_FILTERS)
	public ResponseEntity<?> fetchProductByCategory(@RequestBody CategoryFilterDto categoryFilterDto) {
		return BaseResponseMessage.RETURN_DATA(categoryService.getByFilters(categoryFilterDto));
	}

	@PatchMapping(path = RestMappingConst.Category.UPDATE)
	public ResponseEntity<?> updateCategory(@RequestBody CategoryDto categoryDto) {
		return BaseResponseMessage.RETURN_DATA(categoryService.update(categoryDto));
	}

	@PostMapping(path = RestMappingConst.Category.CREATE_OR_UPDATE)
	public ResponseEntity<?> createOrUpdateCategory(@RequestBody CategoryDto categoryDto) {
		return BaseResponseMessage.RETURN_DATA(categoryService.createOrUpdate(categoryDto));
	}

	@DeleteMapping(path = RestMappingConst.Category.DELETE + RestMappingConst.ID_PARAM)
	public ResponseEntity<?> removeCategory(@PathVariable(name = RestMappingConst.ID) String id) {
		categoryService.remove(id);
		return BaseResponseMessage.SUCCESS();
	}

}
