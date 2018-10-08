package com.xjd.test.any.httpclient;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLException;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;

public class HttpClientTestAdvanced2 {
	public static void main(String[] args) {
		//自定义重试策略
		HttpRequestRetryHandler myRetryHandler = new HttpRequestRetryHandler() {

			public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
				//Do not retry if over max retry count
				if (executionCount >= 2) {
					return false;
				}
				//Timeout
				if (exception instanceof InterruptedIOException) {
					return false;
				}
				//Unknown host
				if (exception instanceof UnknownHostException) {
					return false;
				}
				//Connection refused
				if (exception instanceof ConnectTimeoutException) {
					return false;
				}
				//SSL handshake exception
				if (exception instanceof SSLException) {
					return false;
				}

				HttpClientContext clientContext = HttpClientContext.adapt(context);
				HttpRequest request = clientContext.getRequest();
				boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
				//Retry if the request is considered idempotent
				//如果请求类型不是HttpEntityEnclosingRequest，被认为是幂等的，那么就重试
				//HttpEntityEnclosingRequest指的是有请求体的request，比HttpRequest多一个Entity属性
				//而常用的GET请求是没有请求体的，POST、PUT都是有请求体的
				//Rest一般用GET请求获取数据，故幂等，POST用于新增数据，故不幂等
				if (idempotent) {
					return true;
				}

				return false;
			}
		};
		HttpClients.custom().setMaxConnTotal(300).setRetryHandler(myRetryHandler).build();
	}
}
