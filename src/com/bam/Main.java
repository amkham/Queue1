package com.bam;

import rzp.exceptions.queue.QueueException;

public class Main {

    public static void main(String[] args) throws QueueException {

        MyQueue myQueue = new MyQueue();

        myQueue.init(3);
        myQueue.offer(1);

        myQueue.offer(4);
        myQueue.offer(4);
        myQueue.print();
        System.out.println(myQueue.isEmpty());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        myQueue.print();

        System.out.println(myQueue.contains(5));

    }
}
