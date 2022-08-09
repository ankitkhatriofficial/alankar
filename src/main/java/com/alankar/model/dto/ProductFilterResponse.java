package com.alankar.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author ankitkhatri
 */

@Data
@Builder
public class ProductFilterResponse {

    private Long totalCount;
    private Long filteredCount;
    private Integer pageNumber;
    private Integer pageSize;
    private List<ProductDto> data;

}
