package guru.springframework.controllers;

import guru.springframework.services.HelloWorldService;
import guru.springframework.services.HelloWorldServiceGermanImpl;

public class GreetingController {

    private HelloWorldService helloWorldService;
    private HelloWorldService helloWorldServiceGerman;
    private HelloWorldService helloWorldServiceFrench;
    private HelloWorldService helloWorldServicePolish;
    private HelloWorldService helloWorldServiceRussian;

    public void setHelloWorldService(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    public void setHelloWorldServiceGerman(HelloWorldServiceGermanImpl helloWorldServiceGerman){
        this.helloWorldServiceGerman = helloWorldServiceGerman;
    }

    public void setHelloWorldServiceFrench(HelloWorldService helloWorldServiceFrench){
        this.helloWorldServiceFrench = helloWorldServiceFrench;
    }

    public void setHelloWorldServicePolish(HelloWorldService helloWorldServicePolish){
        this.helloWorldServicePolish = helloWorldServicePolish;
    }

    public void setHelloWorldServiceRussian(HelloWorldService helloWorldServiceRussian){
        this.helloWorldServiceRussian = helloWorldServiceRussian;
    }

    public String sayHello(){

        String greeting = helloWorldService.getGreeting();
        System.out.println(greeting);

        System.out.println(helloWorldServiceGerman.getGreeting());
        System.out.println(helloWorldServiceFrench.getGreeting());
        System.out.println(helloWorldServicePolish.getGreeting());
        System.out.println(helloWorldServiceRussian.getGreeting());

        return greeting;
    }
}
