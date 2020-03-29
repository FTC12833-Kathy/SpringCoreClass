package guru.springframework.controllers;

import guru.springframework.services.HelloWorldService;
import guru.springframework.services.HelloWorldServiceFrenchImpl;
import guru.springframework.services.HelloWorldServiceGermanImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Created by jt on 10/26/15.
 */
//@Controller
public class GreetingController {

    private HelloWorldService helloWorldService;
    private HelloWorldService helloWorldServiceGerman;
    private HelloWorldService helloWorldServiceFrench;
    private HelloWorldService helloWorldServicePolish;

    // This will pick up the bean by type from the profile and/or @Primary annotation
    @Autowired
    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    // We can put the implemented type as a parameter - not an excellent choice...
    @Autowired
    public void setHelloWorldServiceGerman(HelloWorldServiceGermanImpl helloWorldServiceGerman){
        this.helloWorldServiceGerman = helloWorldServiceGerman;
    }

    // Back to the interface, but use the default name (same as method name in config) to select the correct bean
    @Autowired
    @Qualifier("helloWorldServiceFrench")
    public void setHelloWorldServiceFrench(HelloWorldService helloWorldServiceFrench){
        this.helloWorldServiceFrench = helloWorldServiceFrench;
    }

    // This one picks up the "name" from the @Bean in the configuration class
    @Autowired
    @Qualifier("polish")
    public void setHelloWorldServicePolish(HelloWorldService helloWorldServicePolish){
        this.helloWorldServicePolish = helloWorldServicePolish;
    }

    public String sayHello(){

        String greeting = helloWorldService.getGreeting();

        System.out.println(greeting);
        System.out.println(helloWorldServiceGerman.getGreeting());
        System.out.println(helloWorldServiceFrench.getGreeting());
        System.out.println(helloWorldServicePolish.getGreeting());

        return greeting;
    }

}
