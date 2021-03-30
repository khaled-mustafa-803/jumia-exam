package com.khaled.jumia.exam.util;

public final class Constant {
	private Constant() {
		throw new IllegalAccessError("Utilty class");
	}

	public static final String UGANDA_PHONE_REGEX = "\\(256\\)\\ ?\\d{9}$";
	public static final String MOZAMBIQUE_PHONE_REGEX = "\\(258\\)\\ ?[28]\\d{7,8}$";
	public static final String MOROCCO_PHONE_REGEX = "\\(212\\)\\ ?[5-9]\\d{8}$";
	public static final String ETHIOPIA_PHONE_REGEX = "\\(251\\)\\ ?[1-59]\\d{8}$";
	public static final String CAMEROON_PHONE_REGEX = "\\(237\\)\\ ?[2368]\\d{7,8}$";
	public static final String UGANDA_CODE = "256";
	public static final String MOZAMBIQUE_CODE = "258";
	public static final String MOROCCO_CODE = "212";
	public static final String ETHIOPIA_CODE = "251";
	public static final String CAMEROON_CODE = "237";
	
	public static final String UGANDA_COUNTRY_NAME = "Uganda";
	public static final String MOZAMBIQUE_COUNTRY_NAME = "Mozambique";
	public static final String MOROCCO_COUNTRY_NAME = "Morocco";
	public static final String ETHIOPIA_COUNTRY_NAME = "Ethiopia";
	public static final String CAMEROON_COUNTRY_NAME = "Cameroon";

}
