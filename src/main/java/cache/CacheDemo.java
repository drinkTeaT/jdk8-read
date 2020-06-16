package cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Cache<String,String> demoCache = CacheBuilder.newBuilder()
                .expireAfterWrite(120, TimeUnit.MILLISECONDS)
                .build();
        String key = "test";
        demoCache.put(key,"hello world");
        Thread.sleep(121);
        System.out.println(demoCache.get(key, () -> "hahah"));

    }
}
