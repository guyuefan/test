package com.uniubi.visitor.common.esign.enums;

import org.apache.http.client.methods.*;

/**
 * @description 请求类型
 * @author bixing
 */
public enum RequestType {

	POST{
		@Override
		public HttpRequestBase getHttpType(String url) {
			return new HttpPost(url);
		}
	},
	GET{
		@Override
		public HttpRequestBase getHttpType(String url) {
			return new HttpGet(url);
		}
	},
	DELETE{
		@Override
		public HttpRequestBase getHttpType(String url) {
			return new HttpDelete(url);
		}
	},
	PUT{
		@Override
		public HttpRequestBase getHttpType(String url) {
			return new HttpPut(url);
		}
	},
	
	;
	
   public abstract HttpRequestBase getHttpType(String url);
}
