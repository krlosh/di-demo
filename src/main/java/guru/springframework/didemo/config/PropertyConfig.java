package guru.springframework.didemo.config;

import guru.springframework.didemo.examplebeans.FakeDatasource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

    @Autowired
    Environment env;

    @Value("${guru.username}")
    String user;

    @Value("${guru.username}")
    String password;

    @Value("${guru.username}")
    String url;

    @Bean
    public FakeDatasource fakeDatasource(){
        FakeDatasource fakeDatasource = new FakeDatasource();
        //si la environment property fuera GURU_USERNAME, no sería necesario inyectar Environment por que
        //la variable de entorno GURU_USERNAME sobre-escribiría la definida en datasource.properties.
        String envUser = env.getProperty("USERNAME");
        fakeDatasource.setUsername(envUser);
        fakeDatasource.setPassword(password);
        fakeDatasource.setDburl(url);
        return fakeDatasource;
    }


    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
