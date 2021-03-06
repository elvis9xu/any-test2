package test.redisplugin3.serialize;


import org.junit.Test;

import com.xjd.test.any.base.bytes.HexStringToBinary;
import com.xjd.test.any.base.bytes.ObdDriverHabitRedisBean;
import com.xjd.test.any.microservice.dubbo.JsonUtil;
import com.yame.tool.serialize.ProtostuffImpl;

public class TestHexStringToBinary {

	@Test
	public void test() throws Exception {
		//		ISer ser = new ProtostuffSer(ObdDriverHabitRedisBean.class);
		ProtostuffImpl ser = new ProtostuffImpl();
		ObdDriverHabitRedisBean bean = new ObdDriverHabitRedisBean();
		bean.setHotTime(10.3);
		//		byte[] byteArr = ser.toByte(bean);

		//		System.err.println(Byte.toString((byte)20));

		//		System.err.println(((ObdDriverHabitRedisBean) ser.toBean(byteArr)).getHotTime());

		// System.err.println(new String(byteArr, "UTF-8"));
		//		System.err.println(HexStringToBinary.getStr(byteArr));
		//		System.err.println(HashKit.toHex(byteArr));
		//		System.err.println(StrUtil.bytesToAscii(byteArr));

		//		System.err.println(StrUtil.bytesToAscii("123andf234nlkdrt49".getBytes()));

		//		System.err.println(StrUtil.bytesToAscii("123andf234nlkdrt49".getBytes()));

		String s = "\\x12\\x0f352016800060410\\x18\\x04 \\x01)\\x00\\x00\\x00\\x00\\x00\\x008@1\\x00\\x00\\x00\\x00\\x00\\x00.@9\\xb8\\x1e\\x85\\xebQ85@A\\x00\\x00\\x00\\x00\\x00\\x00$@I\\n\\xd7\\xa3p=\\x8a*@Q\\x00\\x00\\x00\\x00\\x00\\x000@Y\\x00\\x00\\x00\\x00\\x00\\x00\\x00@affffff\\\"@i^~~\\xe6e\\x01\\x00\\x00q\\x00\\x00\\x00\\x00\\x00@W@y\\x00\\x00\\x00\\x00\\x00\\x90\\x95@\\x81\\x01\\x00\\x00\\x00\\x00\\x00 \\x9c@\\x89\\x01\\xb8q~\\xe6e\\x01\\x00\\x00\\x91\\x01\\xf8\\xe8\\x99\\xe6e\\x01\\x00\\x00\\x98\\x01\\x04\\xa1\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\xa8\\x01\\x06\\xb1\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\\"@\\xb9\\x01\\x00\\x00\\x00\\x00\\x00\\xc0r@\\xc1\\x01\\x00\\x00\\x00\\x00\\x00\\x00^@\\xc9\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x00@\\xd1\\x01\\x00\\x00\\x00\\x00\\x00\\x00 @\\xd8\\x01\\x9c3\\xf0\\x01\\x16\\xf8\\x01\\x00";
		//		String s = "\\x12\\x0f868909033251383\\x18\\x00 \\x011\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00A{\\x14\\xaeG\\xe1z\\xd4?I\\xa4p=\\n\\xd7\\xa3\\x11@Q\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00Y\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00aH\\xe1z\\x14\\xaeG!@i>E1\\xe6e\\x01\\x00\\x00q\\x00\\x00\\x00\\x00\\x00@Q@y\\x00\\x00\\x00\\x00\\x00\\b\\x87@\\x81\\x01\\x00\\x00\\x00\\x00\\x00\\b\\x87@\\x89\\x018\\xd8$\\xe6e\\x01\\x00\\x00\\x91\\x01\\xf0\\x1e0\\xe6e\\x01\\x00\\x00\\x98\\x01\\x00\\xa1\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\xa8\\x01\\x00\\xb1\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\xb9\\x01\\x00\\x00\\x00\\x00\\x00@V@\\xc1\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x18@\\xc9\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\xd1\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\xd8\\x01\\x9c\\x97\\xd9\\x01\\xf0\\x01\\xb7\\x01\\xf8\\x01\\x00";
		ObdDriverHabitRedisBean beanNew = ser.toBean(HexStringToBinary.hex2Binary(s), ObdDriverHabitRedisBean.class);
		System.err.println(beanNew.getHotTime());
		System.out.println(JsonUtil.toJson(beanNew));
//		System.err.println(JsonKit.toJson(beanNew));
	}

	@Test
	public void toBean() throws Exception {
		ProtostuffImpl ser = new ProtostuffImpl();
		//		ISer ser = new ProtostuffSer(ObdDriverHabitRedisBean.class);
		//		String s = "\\x12\\x0f352016800060410\\x18\\x04 \\x01)\\x00\\x00\\x00\\x00\\x00\\x008@1\\x00\\x00\\x00\\x00\\x00\\x00.@9\\xb8\\x1e\\x85\\xebQ85@A\\x00\\x00\\x00\\x00\\x00\\x00$@I\\n\\xd7\\xa3p=\\x8a*@Q\\x00\\x00\\x00\\x00\\x00\\x000@Y\\x00\\x00\\x00\\x00\\x00\\x00\\x00@affffff\\\"@i^~~\\xe6e\\x01\\x00\\x00q\\x00\\x00\\x00\\x00\\x00@W@y\\x00\\x00\\x00\\x00\\x00\\x90\\x95@\\x81\\x01\\x00\\x00\\x00\\x00\\x00 \\x9c@\\x89\\x01\\xb8q~\\xe6e\\x01\\x00\\x00\\x91\\x01\\xf8\\xe8\\x99\\xe6e\\x01\\x00\\x00\\x98\\x01\\x04\\xa1\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\xa8\\x01\\x06\\xb1\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\\"@\\xb9\\x01\\x00\\x00\\x00\\x00\\x00\\xc0r@\\xc1\\x01\\x00\\x00\\x00\\x00\\x00\\x00^@\\xc9\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x00@\\xd1\\x01\\x00\\x00\\x00\\x00\\x00\\x00 @\\xd8\\x01\\x9c3\\xf0\\x01\\x16\\xf8\\x01\\x00";
		String s = "\\x12\\x0f868909033251383\\x18\\x00 \\x011\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00A{\\x14\\xaeG\\xe1z\\xd4?I\\xa4p=\\n\\xd7\\xa3\\x11@Q\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00Y\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00aH\\xe1z\\x14\\xaeG!@i>E1\\xe6e\\x01\\x00\\x00q\\x00\\x00\\x00\\x00\\x00@Q@y\\x00\\x00\\x00\\x00\\x00\\b\\x87@\\x81\\x01\\x00\\x00\\x00\\x00\\x00\\b\\x87@\\x89\\x018\\xd8$\\xe6e\\x01\\x00\\x00\\x91\\x01\\xf0\\x1e0\\xe6e\\x01\\x00\\x00\\x98\\x01\\x00\\xa1\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\xa8\\x01\\x00\\xb1\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\xb9\\x01\\x00\\x00\\x00\\x00\\x00@V@\\xc1\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x18@\\xc9\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\xd1\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\xd8\\x01\\x9c\\x97\\xd9\\x01\\xf0\\x01\\xb7\\x01\\xf8\\x01\\x00";
		ObdDriverHabitRedisBean beanNew = ser.toBean(HexStringToBinary.hex2Binary(s), ObdDriverHabitRedisBean.class);
		System.err.println(beanNew.getHotTime());
//		System.err.println(JsonKit.toJson(beanNew));
	}
}
