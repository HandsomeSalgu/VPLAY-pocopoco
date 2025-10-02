package pocopoco_vplay.commom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import pocopoco_vplay.commom.intercepter.CheckAdminInterceptor;
import pocopoco_vplay.commom.intercepter.CheckLoginIntercepter;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CheckLoginIntercepter()).addPathPatterns("/myPage/**").excludePathPatterns("/myPage/creator_page", "/myPage/Pricing");
		registry.addInterceptor(new CheckAdminInterceptor()).addPathPatterns("/admin/**");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/profiles/**").addResourceLocations("file:c:\\profiles\\");
	}
	
	
}
