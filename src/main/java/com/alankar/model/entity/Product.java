package com.alankar.model.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.alankar.common.constant.MetalQualityTypeConst;
import com.alankar.common.constant.MetalTypeConst;
import com.alankar.common.constant.PersonConst;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ankitkhatri
 */

@Getter
@Setter
@Document(collection = Product.Columns.TABLE)
public class Product extends BaseEntity {

	interface Columns {
		String TABLE = "products";

		String CATEGORY = "category";
		String WEIGHT = "weight";
		String DESCRIPTION = "description";

		String DESIGN_TYPE_NAME = "design_type_name";
		String METAL_TYPE = "metal_type";
		String METAL_QUALITY_TYPE = "metal_quality_type";
		String QUANTITY = "quantity";

		String ORIGINAL_PRICE = "original_price";
		String MAKING_CHARGE = "making_charge";
		String PUBLIC_PRICE = "public_price";

		String AVERAGE_PRICE = "average_price";
		String PERSON_FOR = "person_for";
		String REFERENCE_NAME = "reference_name";
		String IMAGES = "images";
	}

	@Field(name = Columns.CATEGORY)
	private String category;
	
	@Field(name = Columns.WEIGHT)
	private Double weight;
	
	@Field(name = Columns.DESCRIPTION)
	private String description;

	@Field(name = Columns.DESIGN_TYPE_NAME)
	private String designTypeName; // [baranasi, lucknowi, gujarati, bombaiya]
	
	@Field(name = Columns.METAL_TYPE)
	private MetalTypeConst metalType; // [silver, gold, bronze, diamond]
	
	@Field(name = Columns.METAL_QUALITY_TYPE)
	private MetalQualityTypeConst metalQualityType; // [916, 218, 720]
	
	@Field(name = Columns.QUANTITY)
	private Integer quantity;

	@Field(name = Columns.ORIGINAL_PRICE)
	private Double orginalPrice;
	
	@Field(name = Columns.MAKING_CHARGE)
	private Double makingCharge;
	
	@Field(name = Columns.PUBLIC_PRICE)
	private Double publicPrice;

	@Field(name = Columns.AVERAGE_PRICE)
	private Double averagePrice;
	
	@Field(name = Columns.PERSON_FOR)
	private PersonConst personFor; // [MALE, FEMALE, BOTH]
	
	@Field(name = Columns.REFERENCE_NAME)
	private String referenceName;

	@Field(name = Columns.IMAGES)
	private String images;
}
