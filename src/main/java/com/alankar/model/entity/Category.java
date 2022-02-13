package com.alankar.model.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.alankar.common.constant.CategoryConst;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ankitkhatri
 */
@Getter
@Setter
@Document(collection = Category.Columns.TABLE)
public class Category extends BaseEntity {

	interface Columns {
		String TABLE = "categories";
		String CATEGORY = "category";
		String IMAGE_URL = "image_url";
	}

	@Field(name = Columns.CATEGORY)
	private CategoryConst category;

	@Field(name = Columns.IMAGE_URL)
	private String imageUrl;

}
