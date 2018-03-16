package guru.springframework.didemo.services;

public class GreetingServiceImpl implements GreetingService {

    public static final String HELLO_MESSAAGE ="Hello Gurus!!!";

    @Override
    public String sayGreeting() {
        return HELLO_MESSAAGE;
    }
}
