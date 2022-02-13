package com.alankar.model.dto;

import com.alankar.common.constant.CategoryConst;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ankitkhatri
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class CategoryDto extends BaseDto {

	private CategoryConst category;
	private String imageUrl;

}
