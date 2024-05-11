package com.gzq.demo.leetcode.迭代器.扁平化嵌套列表迭代器;

import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    private List<NestedInteger> nestedList;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
    }

    @Override
    public Integer next() {
        return null;
    }

    @Override
    public boolean hasNext() {
   return true;
    }


    public static void main(String[] args) {
        System.out.println(new NestedIterator(null));
    }
}

