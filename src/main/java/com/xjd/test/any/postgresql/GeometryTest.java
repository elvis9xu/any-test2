package com.xjd.test.any.postgresql;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author elvis.xu
 * @since 2018-08-31 17:45
 */
public class GeometryTest {
	public static void main(String[] args) throws IOException {
		String str = "[{\"lng\":120.163629,\"lat\":30.259207},{\"lng\":120.163599,\"lat\":30.259802},"
				+ "{\"lng\":120.163617,\"lat\":30.259803},{\"lng\":120.163647,\"lat\":30.259207}]";
		System.out.println(str);
		String lng;
		String lat;
		StringBuffer sb = new StringBuffer();
		ObjectMapper objectMapper = new ObjectMapper();
		List list = objectMapper.readValue(str, List.class);
		for (int i = 0; i < list.size(); i++) {
			Map map = (Map) list.get(0);
			lng = ((Double) map.get("lng")).toString();
			lat = ((Double) map.get("lat")).toString();
			sb.append(lng).append(" ").append(lat).append(",");
		}
		String polygon = sb.toString();
		if (polygon.endsWith(",")) {
			polygon = polygon.substring(0, polygon.lastIndexOf(","));
			System.out.println(String.format("POLYGON ((%s))", polygon));
		}
//		      [{"lng":120.163629,"lat":30.259207},{"lng":120.163599,"lat":30.259802},{"lng":120.163617,"lat":30.259803},{"lng":120.163647,"lat":30.259207}]
//		      POLYGON ((120.163629 30.259207,120.163599 30.259802,120.163617 30.259803,120.163647 30.259207))

//		String str = "[{\"lng\":120.163629,\"lat\":30.259207},{\"lng\":120.163599,\"lat\":30.259802},"
//				+ "{\"lng\":120.163617,\"lat\":30.259803},{\"lng\":120.163647,\"lat\":30.259207}]";
//
//		ObjectMapper objectMapper = new ObjectMapper();
//		Object object = objectMapper.readValue(str, Object.class);
//		System.out.println(object.getClass());
//		System.out.println(((List) object).get(0).getClass());
	}
}
