package com.assessment.librarySystem.util;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.assessment.librarySystem.LibrarySystemApplication;

public class ExceptionHandler extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LibrarySystemApplication.class);
	}

}
