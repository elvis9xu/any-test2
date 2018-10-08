package com.xjd.test.any.microservice.dubbo;

import cn.ecpark.service.gis.GeoCoderService;
import cn.ecpark.service.gis.bean.Address;
import cn.ecpark.service.gis.rpc.Rpc;



public class RpcTest {
    public static void main(String[] args) {
        Rpc rpc = Rpc.builder().appName("gis-service-test")
                .registryAddress("zookeeper://10.1.1.209:2181")
                .defaultVersion("1.0.1")
                .defaultAsync(false)
                .timeoutInMillis(1000).build();
        {
            GeoCoderService geoCoderService = rpc.getService(GeoCoderService.class);
            long start = System.currentTimeMillis();
            Address address = geoCoderService.coordinate2Address(114.05986D, 22.545578D, 20, "BD09");
            long cost = System.currentTimeMillis() - start;
            System.out.println("[" + cost + "]: " + JsonUtil.toJson(address));
        }
    }

}