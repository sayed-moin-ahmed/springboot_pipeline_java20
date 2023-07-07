package com.pipeline.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSampleApplication {

	public static void main(String[] args) {
		SpringApplication.from(SampleApplication::main).with(TestSampleApplication.class).run(args);
	}

}
