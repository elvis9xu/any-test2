package com.xjd.test.any.db.mongo.mapper;

import org.bson.Document;

/**
 * @author elvis.xu
 * @since 2018-09-06 16:07
 */
public class Test3 {
	public static void main(String[] args) {
		Mapper<TestBean> mapper = Mappers.of(TestBean.class);
		TestBean testBean = new TestBean();
		Document document = new Document();

		DocumentWrapper2<TestBean> doc = mapper.wrap2(document);
		{
			// setter
			doc.append(TestBean::getId, testBean.getId());
			doc.append(TestBean::getName, testBean.getName());

			DocumentWrapper2<TestBean.Address> addressDocument = (DocumentWrapper2) Mappers.of(TestBean.Address.class).wrap(new Document());
			addressDocument.append(TestBean.Address::getFormat, testBean.getAddress().getFormat());
			addressDocument.append(TestBean.Address::getCode, testBean.getAddress().getCode());

			doc.append(TestBean::getAddress, addressDocument);

			doc.append(mapper.prop(p -> p.getAddress().getFormat()).key() + "_suffix", "HELLO");
		}
		{
			testBean.setId(doc.getString(TestBean::getId));
			testBean.setName(doc.getString(TestBean::getName));

			DocumentWrapper2<TestBean.Address> addressDocument = (DocumentWrapper2) Mappers.of(TestBean.Address.class).wrap(new Document());
			TestBean.Address address = new TestBean.Address();
			address.setFormat(addressDocument.getString(TestBean.Address::getFormat));
			address.setCode(addressDocument.getString(TestBean.Address::getCode));

			testBean.setAddress(address);

			doc.getString(mapper.prop(p -> p.getAddress().getFormat()).key() + "_suffix");
		}
	}
}
