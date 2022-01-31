package it.training.spring;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScans({
        @ComponentScan("it.training.spring")
})
@EnableAspectJAutoProxy
@EnableCaching
@EnableTransactionManagement
public class MyConfiguration {

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("default","cache2","cache3");
    }

    @Bean
    public String hello() {
        return "Hello, World!";
    }


}
