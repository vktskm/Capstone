package com.example.sicilia.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.sicilia.security.entity.FileUploadResponse;


@Configuration
public class FileUploadResponseConfig {
	
	@Bean("fileUploadResponseBean")
	@Scope("prototype")
	public FileUploadResponse fileUploadResponse() {
       return new FileUploadResponse();
    }

}
