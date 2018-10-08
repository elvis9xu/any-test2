package com.xjd.test.any.base.bytes;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

import org.apache.commons.text.StringEscapeUtils;


/**
 * @author elvis.xu
 * @since 2018-09-17 17:25
 */
public class HexStringToBinary {

	public static void main(String[] args) throws UnsupportedEncodingException {
//		String s = "\\x12\\x0f352016800060410\\x18\\x04 \\x01)\\x00\\x00\\x00\\x00\\x00\\x008@1\\x00\\x00\\x00\\x00\\x00\\x00" +
//				".@9\\xb8\\x1e\\x85\\xebQ85@A\\x00\\x00\\x00\\x00\\x00\\x00$@I\\n\\xd7\\xa3p=\\x8a*@Q\\x00\\x00\\x00\\x00\\x00\\x000@Y\\x00\\x00\\x00\\x00\\x00\\x00\\x00@affffff" +
//				"\\\"@i^~~\\xe6e\\x01\\x00\\x00q\\x00\\x00\\x00\\x00\\x00@W@y\\x00\\x00\\x00\\x00\\x00\\x90\\x95@\\x81\\x01\\x00\\x00\\x00\\x00\\x00 " +
//				"\\x9c@\\x89\\x01\\xb8q~\\xe6e\\x01\\x00\\x00\\x91\\x01\\xf8\\xe8\\x99\\xe6e\\x01\\x00\\x00\\x98\\x01\\x04\\xa1\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\xa8" +
//				"\\x01\\x06\\xb1\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\\"@\\xb9\\x01\\x00\\x00\\x00\\x00\\x00\\xc0r@\\xc1\\x01\\x00\\x00\\x00\\x00\\x00\\x00^@\\xc9\\x01\\x00\\x00" +
//				"\\x00\\x00\\x00\\x00\\x00@\\xd1\\x01\\x00\\x00\\x00\\x00\\x00\\x00 @\\xd8\\x01\\x9c3\\xf0\\x01\\x16\\xf8\\x01\\x00";
		String s = "\\x12\\x0f868909033251383\\x18\\x00 \\x011\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00A{\\x14\\xaeG\\xe1z\\xd4?I\\xa4p=\\n\\xd7\\xa3\\x11@Q\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00Y\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00aH\\xe1z\\x14\\xaeG!@i>E1\\xe6e\\x01\\x00\\x00q\\x00\\x00\\x00\\x00\\x00@Q@y\\x00\\x00\\x00\\x00\\x00\\b\\x87@\\x81\\x01\\x00\\x00\\x00\\x00\\x00\\b\\x87@\\x89\\x018\\xd8$\\xe6e\\x01\\x00\\x00\\x91\\x01\\xf0\\x1e0\\xe6e\\x01\\x00\\x00\\x98\\x01\\x00\\xa1\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\xa8\\x01\\x00\\xb1\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\xb9\\x01\\x00\\x00\\x00\\x00\\x00@V@\\xc1\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x18@\\xc9\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\xd1\\x01\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\x00\\xd8\\x01\\x9c\\x97\\xd9\\x01\\xf0\\x01\\xb7\\x01\\xf8\\x01\\x00";
//		String s = "Spark \\xe5\\x92\\x8c Hadoop \\xe4\\xbd\\xa0\\xe5\\xa5\\xbd";
		byte[] bytes = hex2Binary(s);
		System.out.println(new String(bytes, "utf8"));
	}

	public static byte[] hex2Binary(String hex) {
		ByteArrayOutputStream bout = new ByteArrayOutputStream(hex.length());
		StringBuilder sb = new StringBuilder(hex.length() * 4);

		StringBuilder csb = new StringBuilder(2);
		int status = -1;
		for (int i = 0; i < hex.length(); i++) {
			char c = hex.charAt(i);
			if (status == -1) {
				if (c == '\\') {
					status = 0;
					continue;
				} else {
					bout.write((int) c);
					sb.append(leftPad8(Integer.toBinaryString(c)));
					continue;
				}
			}
			if (status == 0) {
				if (c == 'x') {
					status = 1;
					continue;
				} else {
					String sc = StringEscapeUtils.unescapeJava("\\" + c);
					if (sc.length() > 1) {
						throw new RuntimeException("2");
					} else {
						c = sc.charAt(0);
						bout.write((int) c);
						sb.append(leftPad8(Integer.toBinaryString(c)));
						status = -1;
						continue;
					}
				}
			}
			if (status == 1) {
				csb.append(c);
				status = 2;
				continue;
			}
			if (status == 2) {
				csb.append(c);
				status = -1;
				bout.write(Integer.valueOf(csb.toString(), 16) & 0xff);
				sb.append(leftPad8(Integer.toBinaryString(Integer.valueOf(csb.toString(), 16))));
				csb.deleteCharAt(1).deleteCharAt(0);
				continue;
			}
		}

		System.out.println(sb.toString());

		return bout.toByteArray();
	}

	protected static String leftPad8(String s) {
		int n = 8 - s.length();
		if (n > 0) {
			String append = "";
			for (int i = 0; i < n; i++) {
				append += "0";
			}
			return append + s;
		}
		return s;
	}



//	protected static String formatBinary(String s) {
//		StringBuilder sb = new StringBuilder(s.length() + s.length() / 4);
//
//		for (int i = 0; i < s.le; i++) {
//
//		}
//	}

}
