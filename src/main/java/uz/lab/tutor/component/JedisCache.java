//package uz.lab.tutor.component;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//
//import com.jfinal.plugin.redis.IKeyNamingPolicy;
//
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//
//@Component
//@SuppressWarnings("static-access")
//public class JedisCache {
//
//	@Autowired
//	private JedisPool jedisPool;
//
//	@Autowired
//	private IKeyNamingPolicy keyNamingPolicy;
//
//	@Autowired
//	private SerializerUtil serializer;
//
//	 // установить значение для ключа
//	public void set(String key, Object value) {
//		Jedis client = getJedis();
//		try {
//			byte[] keyBytes = serializer.serializeKey(keyNamingPolicy.getKeyName(key));
//			byte[] valueBytes = serializer.serializeValue(value);
//			client.set(keyBytes, valueBytes);
//		} finally {
//			returnJedis(client);
//		}
//
//	}
//
//	 // получить значение на основе ключа
//	public Object get(String key) {
//		Jedis client = getJedis();
//		try {
//			byte[] keyBytes = serializer.serializeKey(keyNamingPolicy.getKeyName(key));
//			byte[] valueBytes = client.get(keyBytes);
//			return serializer.deserializeValue(valueBytes);
//		} finally {
//			returnJedis(client);
//		}
//	}
//
//	 // получаем значение на основе значения ключа
//	public Object hashGet(String key, String field) {
//		Jedis client = getJedis();
//		try {
//			byte[] keyBytes = serializer.serializeKey(keyNamingPolicy.getKeyName(key));
//			byte[] fieldBytes = serializer.serializeKey(field);
//			byte[] valueBytes = client.hget(keyBytes, fieldBytes);
//			return serializer.deserializeValue(valueBytes);
//		} finally {
//			returnJedis(client);
//		}
//
//	}
//
//	public void hashSet(String key, String field, Object value) {
//		Jedis client = getJedis();
//		try {
//			byte[] keyBytes = serializer.serializeKey(keyNamingPolicy.getKeyName(key));
//			byte[] fieldBytes = serializer.serializeKey(field);
//			byte[] valueBytes = serializer.serializeValue(value);
//			client.hset(keyBytes, fieldBytes, valueBytes);
//		} finally {
//			returnJedis(client);
//		}
//	}
//
//	public Map<String, Object> hashAllGet(String key) {
//		Jedis client = getJedis();
//		try {
//			byte[] keyBytes = serializer.serializeKey(keyNamingPolicy.getKeyName(key));
//			Map<byte[], byte[]> map = client.hgetAll(keyBytes);
//			Map<String, Object> valueMap = new HashMap<>();
//			Set<Map.Entry<byte[], byte[]>> valueSet = map.entrySet();
//			for (Map.Entry<byte[], byte[]> entry : valueSet) {
//				valueMap.put(serializer.deserializeKey(entry.getKey()), serializer.deserializeValue(entry.getValue()));
//			}
//			return valueMap;
//		} finally {
//			returnJedis(client);
//		}
//
//	}
//
//	 // определить, существует ли ключ
//	public boolean existKey(String key) {
//		Jedis client = getJedis();
//		try {
//			byte[] keyBytes = serializer.serializeKey(keyNamingPolicy.getKeyName(key));
//			return client.exists(keyBytes);
//		} finally {
//			returnJedis(client);
//		}
//	}
//
//	 // удалить
//	public void delKey(String key) {
//		Jedis client = getJedis();
//		try {
//			byte[] keyBytes = serializer.serializeKey(keyNamingPolicy.getKeyName(key));
//			client.del(keyBytes);
//		} finally {
//			returnJedis(client);
//		}
//	}
//
//	 // получить ссылку джедая
//	private Jedis getJedis() {
//		Jedis jedis = jedisPool.getResource();
//		jedis.auth("rq1433");
//		return jedis;
//	}
//
//	 // закрыть джедаев
//	public void returnJedis(Jedis jedis) {
//		if (jedis != null) {
//			jedis.close();
//		}
//	}
//
//}