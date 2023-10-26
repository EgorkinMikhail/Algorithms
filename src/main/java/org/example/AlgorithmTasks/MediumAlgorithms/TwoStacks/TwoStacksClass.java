package org.example.AlgorithmTasks.MediumAlgorithms.TwoStacks;

import java.util.ArrayDeque;
import java.util.Queue;

public class TwoStacksClass {
    Queue<Integer> integerQueue;
    public TwoStacksClass() {
        integerQueue = new ArrayDeque<>();
    }

    public void start(String srt) {
        String[] tokens = srt.split(" ");
        int typeCode = Integer.parseInt(tokens[0]);

        switch (typeCode) {
            case (1) -> {
                Integer value = Integer.parseInt(tokens[1]);
                enQueue(value);
            }
            case (2) -> {
                deQueue();
            }
            case (3) -> {
                printQueue();
            }
            default -> {
            }
        }
    }

    public void enQueue(Integer integerElement) {
        integerQueue.add(integerElement);
    }

    public void deQueue() {
        integerQueue.remove();
    }

    public void printQueue() {
        System.out.println(integerQueue.peek());
    }
}
