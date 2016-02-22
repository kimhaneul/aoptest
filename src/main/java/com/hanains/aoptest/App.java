package com.hanains.aoptest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ) {
    	ApplicationContext applicationContext = 
    			new ClassPathXmlApplicationContext( "config/applicationContext.xml" );
    	
    	ProductService productService = (ProductService)applicationContext.getBean( "productService" );
    	
    	productService.findProduct( "TV" );
    	
    	( ( AbstractApplicationContext ) applicationContext ).close();
    }
}
