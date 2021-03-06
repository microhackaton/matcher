package com.ofg.microservice
import com.ofg.infrastructure.environment.EnvironmentSetupVerifier
import groovy.transform.TypeChecked
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy

@TypeChecked
@Configuration
@EnableAutoConfiguration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = ["com.ofg.microservice", "com.mangofactory.swagger"])
class Application {

    static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application)
        application.addListeners(new EnvironmentSetupVerifier(Profiles.all()))
        application.run(args)
    }
}
