package com.khaled.jumia.exam.config;

import java.sql.Types;

import org.hibernate.dialect.Dialect;
public class SQLiteDataTypesConfig extends Dialect {

	public SQLiteDataTypesConfig() {
		registerColumnType(Types.INTEGER, "integer");
		registerColumnType(Types.VARCHAR, "varchar");
	}

}
