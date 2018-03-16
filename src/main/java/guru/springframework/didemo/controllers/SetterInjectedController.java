package guru.springframework.didemo.controllers;

import guru.springframework.didemo.services.GreetingService;

public class SetterInjectedController {

    private GreetingService greetingService;

    public String sayHello(){
        return this.greetingService.sayGreeting();
    }

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}
