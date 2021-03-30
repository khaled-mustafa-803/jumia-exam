package com.khaled.jumia.exam.dto.helper;

import com.khaled.jumia.exam.dto.CustomerDTO;
import com.khaled.jumia.exam.entity.Customer;
import com.khaled.jumia.exam.util.Constant;

public interface CustomerHelper {

	

	public static CustomerDTO convertCustomerEntityToCustomerDTO(Customer entity) {
		CustomerDTO dto = new CustomerDTO();
		dto.setName(entity.getName());
		dto.setPhone(entity.getPhone());
		dto.setCountry(extractCountryNameFromPhone(entity.getPhone()));
		dto.setValid(validatePhone(entity.getPhone()));
		return dto;
	}

	private static boolean validatePhone(String phone) {
		switch (phone.substring(1, phone.indexOf(')'))) {
		case Constant.CAMEROON_CODE:
			return phone.matches(Constant.CAMEROON_PHONE_REGEX);
		case Constant.ETHIOPIA_CODE:
			return phone.matches(Constant.ETHIOPIA_PHONE_REGEX);
		case Constant.MOROCCO_CODE:
			return phone.matches(Constant.MOROCCO_PHONE_REGEX);
		case Constant.MOZAMBIQUE_CODE:
			return phone.matches(Constant.MOZAMBIQUE_PHONE_REGEX);
		case Constant.UGANDA_CODE:
			return phone.matches(Constant.UGANDA_PHONE_REGEX);

		default:
			return false;

		}

	}

	private static String extractCountryNameFromPhone(String phone) {

		switch (phone.substring(1, phone.indexOf(')'))) {
		case Constant.CAMEROON_CODE:
			return Constant.CAMEROON_COUNTRY_NAME;
		case Constant.ETHIOPIA_CODE:
			return Constant.ETHIOPIA_COUNTRY_NAME;
		case Constant.MOROCCO_CODE:
			return Constant.MOROCCO_COUNTRY_NAME;
		case Constant.MOZAMBIQUE_CODE:
			return Constant.MOZAMBIQUE_COUNTRY_NAME;
		case Constant.UGANDA_CODE:
			return Constant.UGANDA_COUNTRY_NAME;

		default:
			return "";

		}

	}
}
