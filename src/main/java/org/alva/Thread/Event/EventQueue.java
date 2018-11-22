package org.alva.Thread.Event;

import java.util.LinkedList;

import static java.lang.Thread.currentThread;


/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class EventQueue {
    private final int max;

    static class Event {

    }

    private final LinkedList<Event> eventsQueue = new LinkedList<>();

    private final static int DEFAULT_MAX_EVENT = 10;

    public EventQueue() {
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue(int max) {
        this.max = max;
    }

    /*
    public void offer(Event event){
        synchronized (eventsQueue){
            if(eventsQueue.size()>=max){
                try {
                    console(" the queue is full.");
                    eventsQueue.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            console(" the new event is submitted");
            eventsQueue.addLast(event);
            eventsQueue.notify();
        }
    }

    public Event take(){
        synchronized (eventsQueue){
            if(eventsQueue.isEmpty()){
                try {
                    console(" the queue is empty.");
                    eventsQueue.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            Event event = eventsQueue.removeFirst();
            this.eventsQueue.notify();
            console(" the event "+ event + " is handled.");
            return event;
        }
    }
    */

    public void offer(Event event) {
        synchronized (eventsQueue) {
            while (eventsQueue.size() >= max) {
                try {
                    console(" the queue is full.");
                    eventsQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            console(" the new event is submitted");
            eventsQueue.addLast(event);
            eventsQueue.notifyAll();
        }
    }

    public Event take() {
        synchronized (eventsQueue) {
            while (eventsQueue.isEmpty()) {
                try {
                    console(" the queue is empty");
                    eventsQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event = eventsQueue.removeFirst();
            this.eventsQueue.notifyAll();
            console(" the event " + event + "is handled.");
            return event;
        }
    }

    private void console(String message) {
        System.out.printf("%s:%s\n", currentThread().getName(), message);
    }
}
