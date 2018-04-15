package guru.springframework.didemo.services;

public class GreetingFactoryService {

    private GreetingRepository greetingRepository;

    public GreetingFactoryService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public GreetingService createGreetingService(String lang) {
        switch (lang){
            case "en":
                return new PrimaryGreetingService(this.greetingRepository);
            case "de":
                return new PrimaryGermanGreetingService(this.greetingRepository);
            case "es":
                return new SpanishGreetingService(this.greetingRepository);
            default:
                return new PrimaryGreetingService(this.greetingRepository);

        }
    }
}
