package com.alankar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.alankar.model.dto.ProductDto;
import com.alankar.model.dto.filter.ProductFilterDto;
import com.alankar.model.service.ProductService;

/**
 * @author ankitkhatri
 */

@RestController
@RequestMapping(value = RestMappingConst.Product.BASE)
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping(value = RestMappingConst.Product.CREATE)
	public ResponseEntity<?> addNewProduct(@RequestBody ProductDto productDto) {
		return BaseResponseMessage.CREATED(productService.saveToDB(productDto));
	}

	@PatchMapping(path = RestMappingConst.Product.UPDATE)
	public ResponseEntity<?> updateProduct(@RequestBody ProductDto productDto) {
		return BaseResponseMessage.RETURN_DATA(productService.update(productDto));
	}

	@PostMapping(path = RestMappingConst.Product.CREATE_OR_UPDATE)
	public ResponseEntity<?> createOrUpdateProduct(@RequestBody ProductDto productDto) {
		return BaseResponseMessage.RETURN_DATA(productService.createOrUpdate(productDto));
	}

	@GetMapping(path = RestMappingConst.Product.GET)
	public ResponseEntity<?> fetchAllProducts() {
		return BaseResponseMessage.RETURN_DATA(productService.getAll());
	}

	@GetMapping(path = RestMappingConst.Product.GET + RestMappingConst.ID_PARAM)
	public ResponseEntity<?> fetchProductById(@PathVariable(name = RestMappingConst.ID) String id) {
		return BaseResponseMessage.RETURN_DATA(productService.getById(id));
	}

	@PostMapping(path = RestMappingConst.Product.GET_WITH_FILTERS)
	public ResponseEntity<?> fetchProductByCategory(@RequestBody ProductFilterDto productFilterDto) {
		return BaseResponseMessage.RETURN_DATA(productService.getByFilters(productFilterDto));
	}

	@DeleteMapping(path = RestMappingConst.Product.DELETE + RestMappingConst.ID_PARAM)
	public ResponseEntity<?> removeProduct(@PathVariable(name = RestMappingConst.ID) String id) {
		productService.remove(id);
		return BaseResponseMessage.SUCCESS();
	}

}
