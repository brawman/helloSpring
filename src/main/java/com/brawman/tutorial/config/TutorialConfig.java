package com.brawman.tutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.brawman.tutorial.IndexController;

@Configuration
public class TutorialConfig {
	
	@Bean
	public IndexController indexController() {
		return new IndexController();
	}
}
