//package uz.lab.tutor.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.jfinal.plugin.redis.IKeyNamingPolicy;
//import com.jfinal.plugin.redis.serializer.FstSerializer;
//
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
//
//@Configuration
//public class JedisConfig extends CachingConfigurerSupport {
//
//
//	private static final Logger logger = LoggerFactory.getLogger(JedisConfig.class);
//
//
//	@Value("${spring.redis.host}")
//    private String host;
//	@Value("${spring.redis.password}")
//    private String password;
//
//    @Value("${spring.redis.port}")
//    private int port;
//
//    @Value("${spring.redis.timeout}")
//    private int timeout;
//
//    @Value("${spring.redis.pool.max-active}")
//    private int maxActive;
//
//    @Value("${spring.redis.pool.max-idle}")
//    private int maxIdle;
//
//    @Value("${spring.redis.pool.min-idle}")
//    private int minIdle;
//
//    @Value("${spring.redis.pool.max-wait}")
//    private long maxWaitMillis;
//
//    @Bean
//    public JedisPool redisPoolFactory() {
//    	JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
////    	jedisPoolConfig.setMaxIdle(maxIdle);
////    	jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
////    	jedisPoolConfig.setMaxTotal(maxActive);
////    	jedisPoolConfig.setMinIdle(minIdle);
//    	JedisPool jedisPool = new JedisPool(jedisPoolConfig,host,port,timeout,password);
//
//    	     logger.info ("============== Инъекция JedisPool выполнена успешно!");
//    	     logger.info ("============== redis address:" + host + ":" + port);
//    	return jedisPool;
//    }
//
//    @Bean
//    public IKeyNamingPolicy IKeyNamingPolicyStart() {
//    	return IKeyNamingPolicy.defaultKeyNamingPolicy;
//    }
//
//    @Bean
//    public FstSerializer FstSerializerStart() {
//    	return new FstSerializer();
//    }
//}