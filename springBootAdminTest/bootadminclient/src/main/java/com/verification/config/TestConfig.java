package com.verification.config;

import com.verification.test.MyAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.Marshaller;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Configuration
@Slf4j
//@EnableAspectJAutoProxy
public class TestConfig {
//    @Bean
//    public MyAspect exeTimeAspect() {
//        return new MyAspect();
//    }

//    @Bean
//    public Calculator calculator() {
//        return new RecCalculator();
//    }
//    @Bean(name = "restTemplate")
//    public RestTemplate restTemplate() {
//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        factory.setConnectTimeout(3000);
//        factory.setReadTimeout(3000);
//        RestTemplate restTemplate = new RestTemplate(factory);
//        restTemplate.setMessageConverters(buildMessageConverters());
//        return restTemplate;
//    }
//
//    private List<HttpMessageConverter<?>> buildMessageConverters() {
//        List<HttpMessageConverter<?>> converters = new ArrayList<>();
//        converters.add(marshallingMessageConverter());
//        converters.add(new MappingJackson2HttpMessageConverter());
//        converters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8));
//        return converters;
//    }
//
//    @Bean
//    public MarshallingHttpMessageConverter marshallingMessageConverter() {
//        return new MarshallingHttpMessageConverter(jaxb2Marshaller());
//    }
//
//    @Bean
//    public Jaxb2Marshaller jaxb2Marshaller() {
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setPackagesToScan("com.nkia.cygnus");
//        Map<String, Object> marshallerProperties = new HashMap<>();
//        marshallerProperties.put(Marshaller.JAXB_ENCODING, "UTF-8");
//        marshaller.setMarshallerProperties(marshallerProperties);
//
//        return marshaller;
//    }

}
