package com.bam;

import rzp.exceptions.queue.Queue;
import rzp.exceptions.queue.QueueException;

import java.util.List;

public class MyQueue implements Queue{

    private int
            size = 0,
            endIndex = -1,
            maxSize = -1;
    private int []data;


    @Override
    public void init(int maxSize) throws QueueException {

        if(data != null) throw new QueueException("Очередь уже инициализирована!");
        data = new int[maxSize];
        this.maxSize = maxSize;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return maxSize == size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(int item) {
        for (int i : data)
        {
            if(item == i)
            return true;
        }
        return false;
    }

    @Override
    public int peek() throws QueueException {
        if (isEmpty()) throw new QueueException("Очередь пуста!");
        return data[0];
    }

    @Override
    public int poll() throws QueueException {

        if (isEmpty()) throw new QueueException("Очередь пуста!");
        int result = data[0];
        for (int i = 0; i< size-1;i++)
        {
            data[i] = data[i+1];
        }

        data[endIndex] = 0;
        size--;
        endIndex--;

        return result;
    }

    @Override
    public void offer(int item) throws QueueException {

        if (isFull()) throw new QueueException("Очередь переполнена!");

        data[endIndex + 1] = item;
        size++;
        endIndex++;

    }

    public void print()
    {
        for (int i: data)
        {
            System.out.print(i + " ");
        }

    }

}
