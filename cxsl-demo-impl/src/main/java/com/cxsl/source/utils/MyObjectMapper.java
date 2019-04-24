package com.cxsl.source.utils;

import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.InitializingBean;

public class MyObjectMapper extends ObjectMapper implements InitializingBean{
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.setDateFormat(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"));
//		this.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")); 
		//this.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
	}

}
