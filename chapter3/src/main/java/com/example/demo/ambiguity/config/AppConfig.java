package com.example.demo.ambiguity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by OL-PC on 2018/03/20.
 */
@Configuration
@Import({ExpressiveConfig.class,DessertConfig.class})
public class AppConfig {
}
