package chapter05;

import java.util.LinkedList;

/**
 * 测试单线程间的通讯
 * @author gaomeiling
 */
public class EventQueue {

	private final int max;
	
	static class Event{
		
	}
	
	private final LinkedList<Event> eventQueue = new LinkedList<>();
	
	private final static int DEFAUT_MAX_EVENT = 10;
	
	public EventQueue() {
		this(DEFAUT_MAX_EVENT);
	}

	public EventQueue(int max) {
		this.max = max;
	}
	
	public void offer(Event event) {
		synchronized (eventQueue) {
			if(eventQueue.size() >= max) {
				try {
					console("the queue is full."); // 队列满
					eventQueue.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			console("The new event is submitted.");
			eventQueue.addLast(event);
			eventQueue.notify();
		}
	}
	
	public Event take() {
		synchronized (eventQueue) {
			if(eventQueue.isEmpty()) {
				try {
					console("the queue is empty."); // 队列空
					eventQueue.wait();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			Event event = eventQueue.removeFirst();
			this.eventQueue.notify();
			console("the event "+event +"is handled.");
			return event;
		}
	}
	
	private void console(String message) {
		System.out.printf("%s:%s\n",Thread.currentThread().getName(), message);
	}
	
	
}
