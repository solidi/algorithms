# CTCI

A listing of associated key strategies to apply when solving problems.

## Todo

1. Implement a HashMap
1. Implement an ArrayList
1. Implement a StringBuilder

## General

1. Start with conditionals first to focus on the core algorithm.
1. When concatenating many strings, use a StringBuilder.
1. Solve problems in numerous languages to understand idiomatic differences.
1. Build number positions with number * 10, number * 100, number * 1000.
1. Extract number positions by number % 10 -> number / 10.
1. Return more than one value in recursive function by using a Class.
1. Use ArrayList<> to store numerous objects with generics.

## Arrays

1. Convert down to ASCII integer values for comparison.
1. To conserve space, use bit vectors.
1. Count characters in a string using a hash table.
1. Clarify permutations. Changing order is one definition.
1. It is easier to replace characters in an array by working backward.
1. Palindromes operate on even and odd number of characters.
1. To optimize space, use the transformation matrix as storage.

## Linked Lists

1. Duplicates can be removed in a singly linked list by using a slow and fast pointer.
1. Operations on a linked list typically include three parts: head, middle, and tail.
1. Shifting values instead of nodes can be more efficient.
1. Sort linked lists by using temporary lists and merge them.

## Stacks & Queues

1. Use linked lists to back data presentation with minimal code logic.

## Graphs

1. Trees are graphs.
1. Trees can have many children. They cannot contain cycles.
1. Trees that only have two nodes is a binary tree.
1. Trees that have values as left descendents <= n < right descendents are binary search trees.
1. A node that has no children is a leaf.
1. A complete binary tree contain all nodes except the last level.
1. A full binary tree has all nodes with zero or two nodes.
1. A perfect binary tree all nodes filled.
1. A binary tree can be traversed inorder, preorder, or postorder.
1. Preorder traversal contains the root node first.
1. Postorder traversal contains the root node last.
1. BinaryMaxHeap and BinaryMinHeap are typically backed by arrays.
1. array[(currentNodeIndex - 1) / 2]  Returns the parent node.
1. array[(2 * currentNodeIndex) + 1]  Returns the left child node.
1. array[(2 * currentNodeIndex) + 2]  Returns the right child node.
1. Tries, also known as Prefix Tree, is an efficient string look up O(k) and identifies strings that begin with.
1. Graphs can be directed or undirected. 
1. Graphs are typically stored in adjacency list or adjacency matrices.

## Takeaways

1. ABC's of programming. Thirty minutes of day has lasting effects.
1. Stop, think, and walk through the problem verbally first.
1. Do not overthink the solution. Think Occam's razor. Go with the simplest solution.
1. Attempt to solve first, then optimize later.
1. When a solution is unclear, visualize the steps to implement.
1. There is joy in solving problems.

## Resources

[Sorting algos visualized](https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html)
[OpenDataStructures](https://opendatastructures.org/ods-java/)
