package it.training.spring;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScans({
        @ComponentScan("it.training.spring")
})
@EnableAspectJAutoProxy
@EnableCaching
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
