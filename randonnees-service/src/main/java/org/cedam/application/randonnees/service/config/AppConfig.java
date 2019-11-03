package org.cedam.application.randonnees.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScans(value = { @ComponentScan("org.cedam.application.randonnees.service") })
public class AppConfig {


}
