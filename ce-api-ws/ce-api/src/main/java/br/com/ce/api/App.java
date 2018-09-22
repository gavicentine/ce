package br.com.ce.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class App 
{
	
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "App - main() - Inicializando spring boot" );
        SpringApplication.run(App.class, args);
    }
}
