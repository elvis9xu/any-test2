package com.xjd.test.any.db.mongo.mapper;

import org.bson.Document;

/**
 * @author elvis.xu
 * @since 2018-09-06 16:07
 */
public class Test2 {
	public static void main(String[] args) {
		Mapper<TestBean> mapper = Mappers.of(TestBean.class);
		TestBean testBean = new TestBean();
		Document document = new Document();

		TestBean getter = mapper.getter();
		DocumentWrapper doc = (DocumentWrapper) mapper.wrap(document);
		{
			// setter
			doc.append(getter.getId(), testBean.getId());
			doc.append(getter.getName(), testBean.getName());

			DocumentWrapper addressDocument = (DocumentWrapper) mapper.wrap(new Document());
			mapper.propSetting().setTail(-1);
			addressDocument.append(getter.getAddress().getFormat(), testBean.getAddress().getFormat());
			addressDocument.append(getter.getAddress().getCode(), testBean.getAddress().getCode());
			mapper.propSetting().resetTail();

			doc.append(getter.getAddress(), addressDocument);
		}
		{
			// getter
			testBean.setId(doc.getString(getter.getId()));
			testBean.setName(doc.getString(getter.getName()));

			DocumentWrapper addressDocument = (DocumentWrapper) mapper.wrap(doc.get(getter.getAddress(), Document.class));
			TestBean.Address address = new TestBean.Address();
			mapper.propSetting().setTail(-1);
			address.setFormat(addressDocument.getString(getter.getAddress().getFormat()));
			address.setCode(addressDocument.getString(getter.getAddress().getCode()));
			mapper.propSetting().resetTail();

			testBean.setAddress(address);
		}
	}
}
