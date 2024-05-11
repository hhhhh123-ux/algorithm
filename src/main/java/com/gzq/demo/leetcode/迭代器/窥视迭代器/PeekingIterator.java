package com.gzq.demo.leetcode.迭代器.窥视迭代器;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;

    private Integer nextElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        nextElement = iterator.next();
    }

    public Integer peek() {
        return nextElement;
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }

    @Override
    public Integer next() {
        Integer ret = nextElement;
        nextElement = iterator.hasNext() ? iterator.next() : null;
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        PeekingIterator peekingIterator = new PeekingIterator(list.iterator());
        // 返回 1 ，指针移动到下一个元素 [1,2,3]
        ;    // 返回 2 ，指针未发生移动 [1,2,3]
        ;    // 返回 2 ，指针移动到下一个元素 [1,2,3]
        ;    // 返回 3 ，指针移动到下一个元素 [1,2,3]
        ; // 返回 False
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.peek());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.hasNext());
    }
}
