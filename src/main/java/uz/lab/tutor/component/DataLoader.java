package uz.lab.tutor.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    @Qualifier("redisSlaveTemplate")
    RedisTemplate redisSlaveTemplate;

    @Override
    public void run(String... args) {
        redisTemplate.opsForValue().set("key", "value");
        Object add1 = redisSlaveTemplate.opsForValue().get("key");
        System.out.println(add1);
    }


}