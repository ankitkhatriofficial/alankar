package com.alankar.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.util.Assert;

import com.alankar.model.dto.filter.BaseFilterDto;

/**
 * @author ankitkhatri
 */

public class Utils {

	/** FINAL VARIABLES (CONSTANTS) */
	public static final int DEFAULT_PAGE_NUMBER = 1;
	public static final int DEFAULT_PAGE_SIZE = 10;

	/**
	 * @param data list of any datatype
	 * @return String (encoded all the values of list in string)
	 */
	public static String listToString(List<?> data) {
		if (data == null || data.size() == 0)
			return "";
		return data.toString();
	}

	/**
	 * @param data String to decode
	 * @param type model in which provided string value is decoded (Integer.clas,
	 *             String.class, Long.class, Float.class, Double.class)
	 * @return List of values wrapped of provided class Model
	 */
	@SuppressWarnings({ "unchecked" })
	public static <T> List<T> stringToList(String data, Class<T> type) {
		List<T> returnData = new ArrayList<>();
		if (data == null || data.trim().isEmpty())
			return returnData;
		data = data.trim();
		String substring;
		if (data.length() >= 2 && data.charAt(0) == '[' && data.charAt(data.length() - 1) == ']') {
			substring = data.substring(1, data.length() - 1);
		} else {
			substring = data;
		}
		List<String> decodedData = Arrays.asList(substring.replaceAll("\\s", "").split(","));
		for (String s : decodedData) {
			returnData.add((T) s);
		}
		return returnData;
	}

	/**
	 * @param prefixId prefix which to be added before newly generated Id
	 * @param repo     repository object
	 * @return String (newly generated id)
	 */
	public static <T extends MongoRepository<?, String>> String generateNewID(String prefixId, T repo) {
		Assert.notNull(prefixId, "prefixId can not be null");
		final int MAX = 999999;
		String generatedId = String.format("%06d", new Random().nextInt(MAX));
		while ((repo.findById(prefixId + generatedId).isPresent())) {
			generatedId = String.format("%06d", new Random().nextInt(MAX));
		}
		return prefixId + generatedId;
	}

	/**
	 * @param filterRequest extends BaseFilterDto
	 * @return Pageable (set the default pageNumber and pageSize if not provided and returns the pageable)
	 */
	public static <T extends BaseFilterDto> Pageable getPageable(T filterRequest) {
		if (filterRequest.getPageNumber() == null)
			filterRequest.setPageNumber(DEFAULT_PAGE_NUMBER);

		if (filterRequest.getPageSize() == null)
			filterRequest.setPageSize(DEFAULT_PAGE_SIZE);

		return PageRequest.of(filterRequest.getPageNumber() - 1, filterRequest.getPageSize());

	}

}
