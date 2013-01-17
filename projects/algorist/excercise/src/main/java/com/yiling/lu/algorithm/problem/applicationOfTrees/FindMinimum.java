package com.yiling.lu.algorithm.problem.applicationOfTrees;

/**
 * 3-11. [5] Suppose that we are given a sequence of n values x1, x2, ..., xn
 * and seek to quickly answer repeated queries of the form: given i and j, find
 * the smallest value in xi, . . . , xj . (a) Design a data structure that uses
 * O(n2) space and answers queries in O(1) time. (b) Design a data structure
 * that uses O(n) space and answers queries in O(log n) time. For partial
 * credit, your data structure can use O(n log n) space and have O(log n) query
 * time.
 * 
 * 1. Take all elements between i and j inclusive. Build a tree by comparing 
 * i and i+1, i+2 and i+3, i+4 and i+5, then build higher level from there, then the
 * root will be the smallest number, the height of the tree is logN, N being j-i, the 
 * additional nodes with by N, as the internal nodes are half the size of the the leaves.
 * 
 * @author ylu
 * 
 */
public class FindMinimum {

}
