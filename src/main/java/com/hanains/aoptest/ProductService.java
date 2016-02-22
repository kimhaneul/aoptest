package com.hanains.aoptest;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	public ProductVo findProduct( String name ) {
		System.out.println( "finding " + name + "..." );
		
//		if( 1 == 1 ) {
//			throw new RuntimeException();
//		}
		
		return new ProductVo( name );
	}
}