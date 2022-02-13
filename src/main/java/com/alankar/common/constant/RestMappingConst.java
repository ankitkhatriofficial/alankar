package com.alankar.common.constant;

/**
 * @author ankitkhatri
 */

public interface RestMappingConst {

	String CONTEXT_PATH = "/api";
	String ID = "id";
	String ID_PARAM = "/{" + ID + "}";

	/** Rest Mapping for Admin */
	interface Admin {
		String BASE = CONTEXT_PATH + "/a";
	}

	/** Rest Mapping for Customer */
	interface Customer {
		String BASE = CONTEXT_PATH + "/c";
	}

	/** Rest Mapping for CRUD */
	interface CRUD {
		String CREATE = "/create";
		String UPDATE = "/update";
		String CREATE_OR_UPDATE = "/createOrUpdate";
		String DELETE = "/remove";
		String GET = "/get";
		String GET_WITH_FILTERS = "/getWithFilters";
	}

	/** Rest Mapping for Product */
	interface Product {
		String BASE = CONTEXT_PATH + "/products";
		String CREATE = CRUD.CREATE;
		String UPDATE = CRUD.UPDATE;
		String CREATE_OR_UPDATE = CRUD.CREATE_OR_UPDATE;
		String DELETE = CRUD.DELETE;
		String GET = CRUD.GET;
		String GET_WITH_FILTERS = CRUD.GET_WITH_FILTERS;

	}

	/** Rest Mapping for Category */
	interface Category {
		String BASE = CONTEXT_PATH + "/categories";
		String CREATE = CRUD.CREATE;
		String UPDATE = CRUD.UPDATE;
		String CREATE_OR_UPDATE = CRUD.CREATE_OR_UPDATE;
		String DELETE = CRUD.DELETE;
		String GET = CRUD.GET;
		String GET_WITH_FILTERS = CRUD.GET_WITH_FILTERS;
	}
}
