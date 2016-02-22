package com.hanains.aoptest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	
	@Before( "execution(ProductVo com.hanains.aoptest.ProductService.findProduct(String))" )
	public void before() {
		System.out.println( "before advice called..." );
	}
	
	@After( "execution(* com.hanains.aoptest.ProductService.findProduct(..))" )
	public void after() {
		System.out.println( "after advice called..." );
	}

	@Around( "execution(* com..ProductService.findProduct(..))" )
	public void around( ProceedingJoinPoint pjp ) throws Throwable {
		System.out.println( "around:before advice called..." );
		
		//Object[] params = { "Camera" };
		pjp.proceed();
		
		System.out.println( "around:after advice called..." );
	}
	
	@AfterReturning( "execution(* com..*.findProduct(..))" )
	public void afterReturning() {
		System.out.println( "after returning advice called..." );
	}

	@AfterThrowing( value="execution(* com..*.*(..))", throwing="ex" )
	public void afterThrowing( Throwable ex ) {
		System.out.println( "after throwing advice called..." + ex );
	}
	
}
