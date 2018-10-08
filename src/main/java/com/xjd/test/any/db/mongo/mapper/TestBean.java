package com.xjd.test.any.db.mongo.mapper;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author elvis.xu
 * @since 2018-09-05 15:55
 */
@Getter
@Setter
public class TestBean {
	@Property("_id")
	private String id;

	@Property(ignore = true)
	private String name;

	private Integer age;

	@Property(value="addressInfo") //自动
	private Address address;

	@Property(value="otherAddressInfos") // 自动
	private List<Address> addressList;

	@Property(value="otherAddressInfos2", componentClass = Address.class) // 使用 json / map
	private List addressList2; //

	@Getter
	@Setter
	public static class Address {
		private String format;
		private String code;
	}
}
