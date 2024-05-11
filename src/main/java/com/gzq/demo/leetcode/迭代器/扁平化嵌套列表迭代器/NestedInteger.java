package com.gzq.demo.leetcode.迭代器.扁平化嵌套列表迭代器;

import java.util.List;

public interface NestedInteger {
    public boolean isInteger();

    public Integer getInteger();

    public List<NestedInteger> getList();
}
