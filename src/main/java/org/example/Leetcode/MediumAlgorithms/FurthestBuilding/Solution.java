package org.example.Leetcode.MediumAlgorithms.FurthestBuilding;

import java.util.PriorityQueue;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        // collection ( priority queue ) store height buildings heap
        // need to skip step when next building less current
        // need to start calculating and comparing from building N = ladders.
        // it means that I need to have pool of buildings in queue before start calc with bricks
        // if in queue the highest build use ladder else bricks
        // exit when bricks will have negative value

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 1; i < heights.length; i++){
            if (heights[i] > heights[i - 1]) {
                minHeap.add(heights[i] - heights[i - 1]);
                if (minHeap.size() > ladders) {
                    bricks = bricks - minHeap.poll();
                    if (bricks < 0)
                        return i - 1;
                }
            }
        }
        return heights.length - 1;
    }
}
