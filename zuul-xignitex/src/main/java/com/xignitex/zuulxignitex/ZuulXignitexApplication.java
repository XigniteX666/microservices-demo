package com.xignitex.zuulxignitex;

import com.xignitex.zuulxignitex.filters.ErrorFilter;
import com.xignitex.zuulxignitex.filters.PostFilter;
import com.xignitex.zuulxignitex.filters.PreFilter;
import com.xignitex.zuulxignitex.filters.RouteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableZuulProxy
public class ZuulXignitexApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulXignitexApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}

}
