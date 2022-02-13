package com.alankar.model.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

/**
 * @author ankitkhatri
 */

@Data
public class BaseEntity {
	
	interface Columns{
		String ID = "_id";
		String STATUS = "status";
		String CREATED_AT = "created_at";
		String UPDATED_AT = "updated_at";
		String META_INFO = "metainfo";
	}

	@Id
	@Field(name = Columns.ID)
	private String id;
	
	@Field(name = Columns.STATUS)
	private String status;

	@Field(name = Columns.CREATED_AT)
	private Date createdAt;
	
	@Field(name = Columns.UPDATED_AT)
	private Date updatedAt;
	
	@Field(name = Columns.META_INFO)
	private String metainfo;

}
