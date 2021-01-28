package com.demo.malls2basic.service;

/**
 * redis 常用操作
 * 对象和数组用json存储
 */
public interface RedisService {

    /**
     * 存储数据
     */
    void set(String key, String value);

    /**
     * 获取数据
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 设置超时时间
      * @param key
     * @return
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     * @param key
     */
    void remove(String key);

    /**
     * 自增
     * @param key
     * @param delta 步长
     * @return
     */
    long increment(String key, long delta);
}
