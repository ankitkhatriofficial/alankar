package com.alankar.model.dto.filter;

import com.alankar.common.Utils;
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
public class BaseFilterDto {

	private boolean isIgnorePagination;

	private String searchKeyword;
	private Integer pageNumber = Utils.DEFAULT_PAGE_NUMBER;
	private Integer pageSize = Utils.DEFAULT_PAGE_SIZE;

}
