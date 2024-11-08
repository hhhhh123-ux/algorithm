package com.gzq.demo.leetcode.每日1题.座位预约管理系统;

import java.util.PriorityQueue;

public class SeatManager {

    private PriorityQueue<Integer> n = new PriorityQueue<>();

    public SeatManager(int n) {

        for (int i = 1; i <=n; i++) {
            this.n.add(i);
        }
    }



    public int reserve() {
        int min = this.n.poll();
        return min;
    }

    public void unreserve(int seatNumber) {
        this.n.offer(seatNumber);
    }

    public static void main(String[] args) {
        SeatManager seatManager = new SeatManager(5);
        System.out.println("Reserving a seat: " + seatManager.reserve());
        System.out.println("Reserving a seat: " + seatManager.reserve());
        seatManager.unreserve(2);
        System.out.println("Reserving a seat after unreserving 2: " + seatManager.reserve());
        System.out.println("Reserving a seat: " + seatManager.reserve());
        System.out.println("Reserving a seat: " + seatManager.reserve());
        System.out.println("Reserving a seat: " + seatManager.reserve());
        seatManager.unreserve(5);
        System.out.println("Reserving a seat after unreserving 5: " + seatManager.reserve());
    }
}
