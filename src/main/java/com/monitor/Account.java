package com.monitor;

import java.util.concurrent.locks.Lock;

/*
 * 
 * 
 class Account {
 private lock myLock;

 private int balance = 0
 invariant balance >= 0

 public method boolean withdraw(int amount)
 precondition amount >= 0
 {
 myLock.acquire();
 try
 if balance < amount then return false
 else { balance = balance - amount ; return true }
 finally
 myLock.release();
 }

 public method deposit(int amount)
 precondition amount >= 0
 {
 myLock.acquire();
 try
 balance = balance + amount
 finally
 myLock.release();
 }
 }
 * 
 * 
While a thread is executing a method of a thread-safe object, it is said to occupy the object, by holding its mutex (lock). Thread-safe objects are implemented to enforce that at each point in time, at most one thread may occupy the object. The lock, which is initially unlocked, is locked at the start of each public method, and is unlocked at each return from each public method.
Upon calling one of the methods, a thread must wait until no other thread is executing any of the thread-safe object's methods before starting execution of its method. Note that without this mutual exclusion, in the present example, two threads could cause money to be lost or gained for no reason. For example two threads withdrawing 1000 from the account could both return true, while causing the balance to drop by only 1000, as follows: first, both threads fetch the current balance, find it greater than 1000, and subtract 1000 from it; then, both threads store the balance and return.
 * 
 */

public class Account {
	private int balance = 0;
	private Lock myLock;

	public boolean withdraw(int amount) {
		if (amount >= 0) {
			myLock.lock();
			try {
				if (balance < amount)
					return false;
				else {
					balance = balance - amount;
					return true;
				}
			} finally {
				myLock.unlock();
			}
		}
		return false;
	}

	public void deposit(int amount) {
		if (amount >= 0) {
			myLock.lock();
			try {
				balance = balance + amount;
			} finally {
				myLock.unlock();
			}
		}
	}
}
