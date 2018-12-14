package ru.omsu.imit.course3.main.multithreading.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentHashMap<K, V> {
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;


    class Entry<K, V>{
        K key;
        volatile V value;
        int hash;
        Entry<K, V> next;

        Entry(K key, V value, int hash, Entry<K, V> next) {
            this.key = key;
            this.hash = hash;
            this.next = next;
            this.value = value;
        }
    }

    class Segment<K, V>{
        volatile Entry<K, V>[] table;
        volatile int count;
        final int capacity;
        final float loadFactor;

        Segment(int initialCapacity, float loadFactor){
            count = 0;
            this.loadFactor = loadFactor;
            capacity = initialCapacity;
            this.table = new Entry[initialCapacity];
        }

        Segment(){
            this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
        }

        void add(K key, V value, int hash){
            Lock lock = locker.writeLock();
            lock.lock();
            int place = hash % table.length;

            if(table[place] == null) {
                table[place] = new Entry(key, value, hash, null);
                count++;

                if(count >= table.length * loadFactor)
                    segmentResize();
            }
            else{
                Entry<K, V> temp = table[place];
                while(temp.next != null)
                    temp = temp.next;
                temp.next = new Entry(key, value, hash, null);
            }
            lock.unlock();
        }

        private boolean add(Entry<K, V> entry, Entry<K, V>[] table){
            int place = entry.hash % table.length;

            if(table[place] == null) {
                table[place] = entry;
            }
            else{
                Entry<K, V> temp = table[place];
                while(temp.next != null)
                    temp = temp.next;
                temp.next = entry;
                return true;
            }
            return false;
        }

        V get(K key, int hash){
            int place = hash % table.length;
            Lock lock = locker.writeLock();
            lock.lock();

            if(table[place] == null)
                throw new NoSuchElementException("Table doesn't contains this key");
            else{
                Entry<K, V> temp = table[place];
                while(temp.next != null)
                    if(temp.key.equals(key))
                        return temp.value;
                    temp = temp.next;

            }
            lock.unlock();
            return null;
        }

        void segmentResize(){
            Lock readLock = locker.readLock();
            Lock writeLock = locker.writeLock();
            readLock.lock();
            writeLock.lock();

            Entry<K, V>[] newTable = new Entry[(int) (capacity + capacity * loadFactor)];
            count = 0;

            for(Entry<K, V> entry: table){
                if(add(entry, newTable))
                    count++;
            }

            readLock.unlock();
            writeLock.unlock();
        }
    }

    private Segment<K, V>[] segments;
    private volatile Map<Integer, Integer> segmentIntegerMap; // K - segment number, V - hash
    private ReadWriteLock locker;
    private int count;
    private final float loadFactor;


    public ConcurrentHashMap(){
        this.segments = new Segment[16];
        loadFactor = DEFAULT_LOAD_FACTOR;
        count = 0;
        segmentIntegerMap = new HashMap();
        locker = new ReentrantReadWriteLock();
    }

    public void add(K key, V value){
        int hash = key.hashCode();
        int place = hash % segments.length;

        if(count >= segments.length * loadFactor)
            resize();

        if(segments[place] == null) {
            segments[place] = new Segment(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
            count++;
        }

        segments[place].add(key, value, hash);
        segmentIntegerMap.put(place, hash);
    }

    private boolean add(Entry<K, V> entry, Segment<K, V>[] segments){
        int place = entry.hash % segments.length;
        boolean flag = false;

        if(segments[place] == null) {
            segments[place] = new Segment(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
            flag = true;
        }

        segments[place].add(entry.key, entry.value, entry.hash);
        segmentIntegerMap.put(place, entry.hash);

        return flag;
    }

    public V get(K key){
        int hash = key.hashCode();
        int place = hash % segments.length;

        if(segments[place] == null)
            throw new NoSuchElementException("Table doesn't contains this key");

        return segments[place].get(key, hash);
    }

    private void resize(){
        Lock readLock = locker.readLock();
        Lock writeLock = locker.writeLock();
        readLock.lock();
        writeLock.lock();

        Segment<K, V>[] newSegments = new Segment[(int) (segments.length + segments.length * loadFactor)];
        count = 0;
        segmentIntegerMap.clear();

        for(Segment<K, V> segment: segments){
            for(Entry<K, V> entry: segment.table) {
                if (add(entry, newSegments)) {
                    count++;
                }
            }
        }

        readLock.unlock();
        writeLock.unlock();
    }
}
