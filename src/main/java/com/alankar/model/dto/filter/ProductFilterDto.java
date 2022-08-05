package com.alankar.model.dto.filter;

import com.alankar.common.constant.CategoryConst;
import com.alankar.common.constant.MetalQualityTypeConst;
import com.alankar.common.constant.MetalTypeConst;
import com.alankar.common.constant.PersonConst;
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
public class ProductFilterDto extends BaseFilterDto {

	private CategoryConst category;
	private PersonConst personFor;
	private MetalTypeConst metalType;
	private MetalQualityTypeConst metalQualityType;

}
