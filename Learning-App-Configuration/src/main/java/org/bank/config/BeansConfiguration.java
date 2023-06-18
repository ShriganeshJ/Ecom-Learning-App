package org.bank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import services.Account.Factory.AccountFactory;
import services.Account.Factory.IAccountFactory;

@Configuration
public class BeansConfiguration {
    @Bean
    public IAccountFactory iAccountFactory()
    {
        return new AccountFactory();
    }
}
