package com.alankar.model.entity;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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
	private String category;

	@Field(name = Columns.IMAGE_URL)
	private String imageUrl;

	@Transient
	public static Set<String> categoryCache = new HashSet<>();
}
