package io.github.bobfrostman.springbootexample.config;

import io.github.bobfrostman.config.WrappedElements;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wrappedelements.page.InventoryPage;
import wrappedelements.page.LoginPage;

@Configuration
public class WrappedElementsConfig {

    @Bean
    public LoginPage loginPage() {
        return WrappedElements.initPage(LoginPage.class);
    }

    @Bean
    public InventoryPage inventoryPage() {
        return WrappedElements.initPage(InventoryPage.class);
    }

}
