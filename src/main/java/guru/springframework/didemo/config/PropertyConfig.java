package guru.springframework.didemo.config;

import guru.springframework.didemo.examplebeans.FakeDatasource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:datasource.properties")
public class PropertyConfig {

    @Value("${guru.username}")
    String user;

    @Value("${guru.username}")
    String password;

    @Value("${guru.username}")
    String url;

    @Bean
    public FakeDatasource fakeDatasource(){
        FakeDatasource fakeDatasource = new FakeDatasource();
        fakeDatasource.setUsername(user);
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
