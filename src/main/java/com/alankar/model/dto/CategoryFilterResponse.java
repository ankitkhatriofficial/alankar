package com.alankar.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author anktikhatri
 */

@Data
@Builder
public class CategoryFilterResponse {

    private Long totalCount;
    private Long filteredCount;
    private Integer pageNumber;
    private Integer pageSize;
    private List<CategoryDto> data;
}
