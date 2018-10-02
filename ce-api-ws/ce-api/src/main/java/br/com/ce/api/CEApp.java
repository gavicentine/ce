package br.com.ce.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// TODO: Auto-generated Javadoc
/**
 * The Class CEApp.
 */
@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class CEApp 
{
	
    /**
     * The main method.
     *
     * @param args the arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception
    {
        System.out.println( "CE App - main() - Spring boot inicializando.");
        SpringApplication.run(CEApp.class, args);
    }
}
