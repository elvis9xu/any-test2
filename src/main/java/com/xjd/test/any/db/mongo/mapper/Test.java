package com.xjd.test.any.db.mongo.mapper;

import org.bson.Document;

/**
 * @author elvis.xu
 * @since 2018-09-05 16:18
 */
public class Test {
	public static void main(String[] args) {
		Mapper<TestBean> mapper = Mappers.of(TestBean.class);
		TestBean testBean = new TestBean();
		{
			// bean -> document
			// all
			Document document = mapper.encode(testBean);
			// nonNull
			Document document2 = mapper.encode(testBean, true);
			// only id and name
			Document document3 = mapper.encode(testBean, (p, c) -> {
				c.add(p.getId());
				c.add(p.getName());
			}, false);
			// except id and name
			Document document4 = mapper.encode(testBean, false, (p, c) -> {
				c.add(p.getId());
				c.add(p.getName());
			});
		}
		{
			// customize bean -> document
			Document document = mapper.encode((p, d, m) -> {
				d.append(p.getId(), testBean.getId()).append(p.getAge(), testBean.getAge());
				d.append("customField1", "customValue1");
				d.append("customField2", testBean.getAddress() + "");
				d.append(m.prop(TestBean::getAddressList2).key() + "_mysuffix", testBean.getAddressList2());

				m.propSetting().setTail(-1);
				Mapper.DocumentAppender addressDocument = d.newWrapper();
				addressDocument.append(p.getAddress().getFormat(), testBean.getAddress().getFormat());
				addressDocument.append(p.getAddress().getCode(), testBean.getAddress().getCode());
				m.propSetting().resetTail();
				d.append(p.getAddress(), addressDocument);
			});
		}
		{
			// customize bean -> document At will
			Document document = new Document();
			document.append(mapper.prop(TestBean::getId).key(), testBean.getId());
			document.append(mapper.prop(p -> p.getName()).key(), testBean.getName());
			document.append(mapper.prop(p -> {p.getAge();}).key(), testBean.getAge());

			mapper.propSetting().setTail(-1);
			Document addressDocument = new Document();
			addressDocument.append(mapper.prop(p -> p.getAddress().getFormat()).key(), testBean.getAddress().getFormat());
			addressDocument.append(mapper.prop(p -> p.getAddress().getCode()).key(), testBean.getAddress().getCode());
			mapper.propSetting().resetTail();
			document.append(mapper.prop(TestBean::getAddress).key(), addressDocument);
		}
		{
			// document -> bean
			Document document = new Document();
			// all
			TestBean bean = mapper.decode(document);

			// customize
			TestBean bean2 = new TestBean();
			mapper.decode((p, dg, m) -> {
				Document d = dg.wrap(document);
				bean2.setId(d.getString(p.getId()));
				bean2.setName(d.getString(p.getName()));
				bean2.setAge(d.getInteger(p.getAge()));

				Document addressDocument = dg.wrap(d.get(p.getAddress(), Document.class));
				TestBean.Address address = new TestBean.Address();
				m.propSetting().setTail(-1);
				address.setFormat(addressDocument.getString(p.getAddress().getFormat()));
				address.setCode(addressDocument.getString(p.getAddress().getCode()));
				m.propSetting().resetTail();

				bean2.setAddress(address);
			});

			// customize as will
			TestBean bean3 = new TestBean();
			bean3.setId(document.getString(mapper.prop(TestBean::getId).key()));
			bean3.setName(document.getString(mapper.prop(TestBean::getName).key()));

			Document addressDocument = document.get(mapper.prop(TestBean::getAddress).key(), Document.class);
			TestBean.Address address = new TestBean.Address();
			mapper.propSetting().setTail(-1);
			address.setFormat(addressDocument.getString(mapper.prop(p -> p.getAddress().getFormat()).key()));
			address.setCode(addressDocument.getString(mapper.prop(p -> p.getAddress().getCode()).key()));
			mapper.propSetting().resetTail();

			bean3.setAddress(address);
		}
	}
}
