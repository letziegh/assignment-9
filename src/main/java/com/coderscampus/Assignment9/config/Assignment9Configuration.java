package com.coderscampus.Assignment9.config;

import com.coderscampus.Assignment9.service.FileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;



@Configuration
public class Assignment9Configuration {
    @Bean
  public FileService fileService() throws IOException {return new FileService();}

}
