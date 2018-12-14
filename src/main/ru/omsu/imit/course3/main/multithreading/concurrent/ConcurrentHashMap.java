package ru.omsu.imit.course3.main.multithreading.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentHashMap<K, V> {
    private Map<K, V> map;
    private Lock readLock;
    private Lock writeLock;

    public ConcurrentHashMap(){
        map = new HashMap<>();
        ReadWriteLock locker = new ReentrantReadWriteLock();
        readLock = locker.readLock();
        writeLock = locker.writeLock();
    }

    public V get(K key){
        readLock.lock();
        writeLock.lock();
        V value =  map.get(key);
        readLock.unlock();
        writeLock.unlock();
        return value;
    }

    public void put(K key, V value){
        readLock.lock();
        writeLock.lock();
        map.put(key, value);
        readLock.unlock();
        writeLock.unlock();
    }

    public boolean containsKey(K key){
        writeLock.lock();
        boolean flag = map.containsKey(key);
        writeLock.unlock();
        return flag;
    }

    public boolean containsValue(V value){
        writeLock.lock();
        boolean flag = map.containsValue(value);
        writeLock.unlock();
        return flag;
    }
}
