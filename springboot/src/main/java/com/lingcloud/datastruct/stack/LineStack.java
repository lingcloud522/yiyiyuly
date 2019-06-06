package com.lingcloud.datastruct.stack;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LineStack<T> implements Stack<T> {

    private T[] elements = (T[])new Object[16];
    private int size = 0;

    private Lock lock = new ReentrantLock();

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Lock lock = this.lock;
        lock.lock();
        for(int i=0; i<elements.length;i++){
            elements[i] = null;
        }
        size = 0;
        lock.unlock();
    }

    @Override
    public T pop() {
        Lock lock = this.lock;
        lock.lock();
        T data = null;
        try{
            if(size == 0)return null;
            data = elements[size-1];
            elements[size-1] = null;
            size--;
        }finally {
            lock.unlock();
        }
        return data;
    }

    @Override
    public boolean push(T data) {
        Lock lock = this.lock;
        lock.lock();
        if(size>elements.length){
            resize();
        }
        elements[size++] = data;
        lock.unlock();
        return true;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public T peek() {
        Lock lock = this.lock;
        lock.lock();
        if(size == 0) return null;
        T data = elements[size-1];
        lock.unlock();
        return data;
    }

    @Override
    public void resize() {
        Lock lock = this.lock;
        lock.lock();
        if(size>elements.length){
            int oldLength = elements.length;
            int newLength = oldLength + (oldLength>>1);
            elements = Arrays.copyOf(elements,newLength);
        }
    }

    @Override
    public int search(T data) {
        Lock lock = this.lock;
        lock.lock();
        int index = -1;
        for(int i=0;i<elements.length;i++){
            if(elements[i].equals(data)){
                index = i;
                break;
            }
        }
        lock.unlock();
        return index;
    }
}
