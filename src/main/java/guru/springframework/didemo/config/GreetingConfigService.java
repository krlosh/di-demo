package guru.springframework.didemo.config;

import guru.springframework.didemo.services.GreetingFactoryService;
import guru.springframework.didemo.services.GreetingRepository;
import guru.springframework.didemo.services.GreetingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class GreetingConfigService {
    @Bean
    GreetingFactoryService greetingFactoryService(GreetingRepository repository){
        return new GreetingFactoryService(repository);
    }


    @Bean
    @Primary
    @Profile({"en","default"})
    public GreetingService primaryGreetingService(GreetingFactoryService factory){
        return factory.createGreetingService("en");
    }

    @Bean
    @Primary
    @Profile({"es"})
    public GreetingService primarySpanishGreetingService(GreetingFactoryService factory){
        return factory.createGreetingService("es");
    }

    @Bean
    @Primary
    @Profile({"de"})
    public GreetingService primaryGermanGreetingService(GreetingFactoryService factory){
        return factory.createGreetingService("de");
    }
}
