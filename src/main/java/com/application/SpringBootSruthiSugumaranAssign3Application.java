package com.application;

import java.util.Date;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.models.*;
import com.services.*;



@ComponentScan({"com.application","com.controller","com.models","com.services","config"})
@SpringBootApplication
public class SpringBootSruthiSugumaranAssign3Application implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSruthiSugumaranAssign3Application.class, args);
		System.out.println("Spring Boot App Started");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}

	@Bean
	public ApplicationRunner seekersInitializer(SeekerService seekerService) {
		return args -> {
			seekerService.addSeeker(new Seeker(1001,"Sruthi","Sugumaran",20,"female","A positive","Scarborough",Long.parseLong("4169488034")));
			seekerService.addSeeker(new Seeker(1002,"Vishwa","Sugumaran",17,"male","A positive","Toronto",Long.parseLong("7034991541")));
			seekerService.addSeeker(new Seeker(1003,"Bashkar","Sampath",23,"male","B positive","Toronto",Long.parseLong("6472004440")));
			seekerService.addSeeker(new Seeker(1004,"Sneka","Sampath",26,"female","B positive","Mississauga",Long.parseLong("6473360711")));
		};
	}
	
	@Bean
	public ApplicationRunner bloodBanksInitializer(BloodBankService bloodBankService) {
		return args -> {
			bloodBankService.addBloodBank(new BloodBank(20001,"Canadian Blood Services","2 Bloor Street East","Toronto",Long.parseLong("8888236628"),"www.canadianbloodservices.ca","cbsBloor@gmail.com"));
			bloodBankService.addBloodBank(new BloodBank(20002,"Create Cord Blood Bank","790 Bay Street","Toronto",Long.parseLong("4168713470"),"www.createcord.ca","createcord@gmail.com"));
			bloodBankService.addBloodBank(new BloodBank(20003,"Insception Lifebank - Sunnybrook","2075 Bayview Ave","Toronto",Long.parseLong("8660622790"),"www.insceptionlifebank.ca","insceptionlifebank@gmail.com"));
			bloodBankService.addBloodBank(new BloodBank(20004,"Insception Lifebank - Mount Sinai","700 University Ave","Toronto",Long.parseLong("8866062790"),"www.insceptionlifebank.ca","insceptionlifebank@gmail.com"));
		};
	}
	
	@Bean
	public ApplicationRunner bloodStocksInitializer(BloodStockService bloodStockService) {
		return args -> {
			bloodStockService.addBloodStock(new BloodStock(200001,"A positive",4,new Date(),"available"));
			bloodStockService.addBloodStock(new BloodStock(200002,"A negative",8,new Date(),"available"));
			bloodStockService.addBloodStock(new BloodStock(200003,"B positive",17,new Date(),"available"));
			bloodStockService.addBloodStock(new BloodStock(200004,"B negative",6,new Date(),"available"));
			bloodStockService.addBloodStock(new BloodStock(200005,"AB positive",13,new Date(),"available"));
			bloodStockService.addBloodStock(new BloodStock(200006,"AB negative",19,new Date(),"available"));
			bloodStockService.addBloodStock(new BloodStock(200007,"O positive",20,new Date(),"available"));
			bloodStockService.addBloodStock(new BloodStock(200008,"O negative",5,new Date(),"available"));
			bloodStockService.addBloodStock(new BloodStock(200009,"A positive",20,new Date(),"available"));
			bloodStockService.addBloodStock(new BloodStock(200010,"O positive",5,new Date(),"available"));
		};
	}
}
