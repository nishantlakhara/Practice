package com.monitor;

import java.util.UUID;
import java.util.concurrent.locks.Lock;

/*
 * 
 * 
global RingBuffer queue; // A thread-unsafe ring-buffer of tasks.
global Lock queueLock; // A mutex for the ring-buffer of tasks.

// Method representing each producer thread's behavior:
public method producer(){
    while(true){
        task myTask=...; // Producer makes some new task to be added.

        queueLock.lock(); // Acquire lock for initial busy-wait check.
        while(queue.isFull()){ // Busy-wait until the queue is non-full.
            queueLock.unlock();
            // Drop the lock temporarily to allow a chance for other threads
            // needing queueLock to run so that a consumer might take a task.
            queueLock.lock(); // Re-acquire the lock for the next call to "queue.isFull()".
        }

        queue.enqueue(myTask); // Add the task to the queue.
        queueLock.unlock(); // Drop the queue lock until we need it again to add the next task.
    }
}

// Method representing each consumer thread's behavior:
public method consumer(){
    while(true){
        queueLock.lock(); // Acquire lock for initial busy-wait check.
        while (queue.isEmpty()){ // Busy-wait until the queue is non-empty.
            queueLock.unlock();
            // Drop the lock temporarily to allow a chance for other threads
            // needing queueLock to run so that a producer might add a task.
            queueLock.lock(); // Re-acquire the lock for the next call to "queue.isEmpty()".
        }
        myTask=queue.dequeue(); // Take a task off of the queue.
        queueLock.unlock(); // Drop the queue lock until we need it again to take off the next task.
        doStuff(myTask); // Go off and do something with the task.
    }
}
 * 
 */
public class SpinWait {
	RingBuffer queue = new RingBuffer(100); // A thread-unsafe ring-buffer of tasks.
	Lock queueLock; // A mutex for the ring-buffer of tasks.

	// Method representing each producer thread's behavior:
	public void producer(){
	    while(true){
	        String myTask= UUID.randomUUID().toString(); // Producer makes some new task to be added.

	        queueLock.lock(); // Acquire lock for initial busy-wait check.
	        while(queue.isFull()){ // Busy-wait until the queue is non-full.
	            queueLock.unlock();
	            // Drop the lock temporarily to allow a chance for other threads
	            // needing queueLock to run so that a consumer might take a task.
	            queueLock.lock(); // Re-acquire the lock for the next call to "queue.isFull()".
	        }

	        queue.put(myTask); // Add the task to the queue.
	        queueLock.unlock(); // Drop the queue lock until we need it again to add the next task.
	    }
	}

	// Method representing each consumer thread's behavior:
	public void consumer(){
	    while(true){
	        queueLock.lock(); // Acquire lock for initial busy-wait check.
	        while (queue.isEmpty()){ // Busy-wait until the queue is non-empty.
	            queueLock.unlock();
	            // Drop the lock temporarily to allow a chance for other threads
	            // needing queueLock to run so that a producer might add a task.
	            queueLock.lock(); // Re-acquire the lock for the next call to "queue.isEmpty()".
	        }
	        String myTask=(String)queue.take(); // Take a task off of the queue.
	        queueLock.unlock(); // Drop the queue lock until we need it again to take off the next task.
	        System.out.println("Mytask : " + myTask); // Go off and do something with the task.
	    }
	}
}

class RingBuffer {
    public Object[] elements = null;

    private int capacity  = 0;
    private int writePos  = 0;
    private int available = 0;

    public RingBuffer(int capacity) {
        this.capacity = capacity;
        this.elements = new Object[capacity];
    }

    public void reset() {
        this.writePos = 0;
        this.available = 0;
    }

    public int capacity() { return this.capacity; }
    public int available(){ return this.available; }

    public int remainingCapacity() {
        return this.capacity - this.available;
    }

    public boolean put(Object element){

        if(available < capacity){
            if(writePos >= capacity){
                writePos = 0;
            }
            elements[writePos] = element;
            writePos++;
            available++;
            return true;
        }

        return false;
    }
    
    public boolean isFull() {
    	return available < capacity;
    }
    
    public boolean isEmpty() {
    	return available == 0;
    }
    

    public Object take() {
        if(available == 0){
            return null;
        }
        int nextSlot = writePos - available;
        if(nextSlot < 0){
            nextSlot += capacity;
        }
        Object nextObj = elements[nextSlot];
        available--;
        return nextObj;
    }
}