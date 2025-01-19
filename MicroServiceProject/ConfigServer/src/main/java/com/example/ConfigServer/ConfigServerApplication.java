package com.example.ConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
//import org.springframework.cloud.config.ser

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	// add a repo on server of git
//	create one config file
//	add some config
//	add profile till the repo name of git url
//	restart http://localhost:8080/application/default
//			in above apllication is file and default is type of app.property
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
