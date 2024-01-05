package com.myweb.www.config;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer { // WebCOnfig inimplemented 해주기

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ServletConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		// 처음 열렸을때 기본경로
		return new String[] {"/"};
	}

	
	
	// EncodingFilter 설정
	@Override
	protected Filter[] getServletFilters() {
		// 필터설정
		CharacterEncodingFilter encoding = new CharacterEncodingFilter();
		encoding.setEncoding("UTF-8");
		encoding.setForceEncoding(true); // 외부로 나가는 데이터도 인코딩 설정
		
		return new Filter[] {encoding};
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		// 그외 사용자 설정
		// multpartConfig
		// 사용자 지정 익셉션 처리 지정
		
		super.customizeRegistration(registration);
	}
	
	

}
