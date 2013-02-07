//package com.xc.taosku.kernel.cache;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import java.util.concurrent.Future;
//import net.spy.memcached.AddrUtil;
//import net.spy.memcached.MemcachedClient;
//import net.spy.memcached.transcoders.Transcoder;
//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.InitializingBean;
//
//public class CacheUtils implements InitializingBean {
//	private KeyHash keyHash;
//	private static final Log log = LogFactory.getLog(CacheUtils.class);
//	private static final Object lockObj = new Object();
//	private Map<Integer, MemcachedClient> memcachedClientMap;
//	private boolean address;
//	private List<String> cacheServerAddress;
//
//	public CacheUtils() {
//		this.keyHash = new KeyHashModImpl();
//		this.memcachedClientMap = new HashMap();
//	}
//
//	public <T> Future<Boolean> add(String key, int exp, T o, Transcoder<T> tc) {
//		return getMemcachedClient(key).add(key, exp, o, tc);
//	}
//
//	public Future<Boolean> add(String key, int exp, Object o) {
//		return getMemcachedClient(key).add(key, exp, o);
//	}
//
//	public <T> Future<Boolean> set(String key, int exp, T o, Transcoder<T> tc) {
//		return getMemcachedClient(key).set(key, exp, o, tc);
//	}
//
//	public Future<Boolean> set(String key, int exp, Object o) {
//		return getMemcachedClient(key).set(key, exp, o);
//	}
//
//	public <T> Future<Boolean> replace(String key, int exp, T o, Transcoder<T> tc) {
//		return getMemcachedClient(key).replace(key, exp, o, tc);
//	}
//
//	public Future<Boolean> replace(String key, int exp, Object o) {
//		return getMemcachedClient(key).replace(key, exp, o);
//	}
//
//	public Future<Boolean> append(long cas, String key, Object val) {
//		return getMemcachedClient(key).append(cas, key, val);
//	}
//
//	public <T> Future<Boolean> append(long cas, String key, T val, Transcoder<T> tc) {
//		return getMemcachedClient(key).append(cas, key, val, tc);
//	}
//
//	public <T> T get(String key, Transcoder<T> tc) {
//		return getMemcachedClient(key).get(key, tc);
//	}
//
//	public Object get(String key) {
//		return getMemcachedClient(key).get(key);
//	}
//
//	public Future<Boolean> delete(String key) {
//		return getMemcachedClient(key).delete(key);
//	}
//
//	public long incr(String key, int by) {
//		return getMemcachedClient(key).incr(key, by);
//	}
//
//	public long decr(String key, int by) {
//		return getMemcachedClient(key).decr(key, by);
//	}
//
//	public long incr(String key, int by, long def, int exp) {
//		return getMemcachedClient(key).incr(key, by, def, exp);
//	}
//
//	public long decr(String key, int by, long def, int exp) {
//		return getMemcachedClient(key).decr(key, by, def, exp);
//	}
//
//	public long incr(String key, int by, long def) {
//		return getMemcachedClient(key).incr(key, by, def);
//	}
//
//	public long decr(String key, int by, long def) {
//		return getMemcachedClient(key).decr(key, by, def);
//	}
//
//	private MemcachedClient getMemcachedClient(String key) {
//		if (this.address) {
//			int intKey = hashKey(key);
//			if (log.isDebugEnabled())
//				log.debug(key + " hash via  " + this.keyHash.getName() + " to " + intKey + " !");
//			return ((MemcachedClient) this.memcachedClientMap.get(Integer.valueOf(intKey)));
//		}
//		return null;
//	}
//
//	private int hashKey(String key) {
//		int addressSize = this.cacheServerAddress.size();
//		return this.keyHash.hashKey(key, addressSize);
//	}
//
//	public void setCacheServerAddress(List<String> cacheServerAddress) {
//		this.cacheServerAddress = cacheServerAddress;
//	}
//
//	private void init() {
//		int i = 0;
//		for (int cacheServerAddresSize = this.cacheServerAddress.size(); i < cacheServerAddresSize; ++i)
//			this.memcachedClientMap.put(Integer.valueOf(i), getClient(i));
//	}
//
//	private MemcachedClient getClient(int i) {
//		String cacheServerAddre = (String) this.cacheServerAddress.get(i);
//		if (StringUtils.isNotBlank(cacheServerAddre))
//			try {
//				return new MemcachedClient(AddrUtil.getAddresses(cacheServerAddre));
//			} catch (Exception e) {
//				log.error("init memcached client error " + cacheServerAddre, e);
//			}
//
//		return null;
//	}
//
//	public void afterPropertiesSet() {
//		this.address = ((this.cacheServerAddress != null) && (this.cacheServerAddress.size() > 0));
//		if (this.address)
//			try {
//				init();
//			} catch (Exception e) {
//				log.error("init memcached client error!", e);
//			}
//
//		else
//			log.error("no memcached address!");
//	}
//
//	public void setKeyHash(KeyHash keyHash) {
//		this.keyHash = keyHash;
//	}
//
//	public void shutdown() {
//		for (Iterator i$ = this.memcachedClientMap.keySet().iterator(); i$.hasNext();) {
//			Integer key = (Integer) i$.next();
//			try {
//				MemcachedClient memcachedClient = (MemcachedClient) this.memcachedClientMap.get(key);
//				memcachedClient.shutdown();
//			} catch (Exception e) {
//				log.debug("Memcached shutdown error!", e);
//			}
//		}
//	}
//}