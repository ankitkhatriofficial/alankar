package com.alankar.model.dto;

import java.util.List;

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
public class ProductDto extends BaseDto {

	private String category;
	private Double weight;
	private String description;
	private String designTypeName; // [baranasi, lucknowi, gujarati, bombaiya]
	private MetalTypeConst metalType; // [silver, gold, bronze, diamond]
	private MetalQualityTypeConst metalQualityType; // [916, 218, 720]
	private Integer quantity;

	private Double orginalPrice;
	private Double makingCharge;
	private Double publicPrice;
	
	private	Double averagePrice;
	private PersonConst personFor;

	private String referenceName;
	private List<String> images;
}
