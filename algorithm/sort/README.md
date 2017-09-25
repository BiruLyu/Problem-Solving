# Sort  

| Algorithm | Average Time  | Worst Time  | Space |
| :---: | :---: | :---: | :---: |
| 冒泡排序(Bubble Sort) | $$O(n^2)$$ | $$O(n^2)$$ | $$O(1)$$ |
| 选择排序(Selection sort) | $$O(n^2)$$ | $$O(n^2)$$ | $$O(1)$$ |
| 插入排序(Insertion sort) | $$O(n^2)$$ | $$O(n^2)$$ | |
| 快速排序(Quick sort) | $$O(n\log(n))$$ | $$O(n^2)$$ | |
| 归并排序(Merge sort) | $$O(n\log(n))$$ | $$O(n\log(n))$$ | depends |


# Summary 

+ A sequential search is $$O(n)$$ for ordered and unordered lists.
+ A binary search of an ordered list is $$O(n\log(n))$$  in the worst case.
+ Hash tables can provide constant time searching.
+ A bubble sort, a selection sort, and an insertion sort are $$O(n^2)$$ algorithms.
+ A shell sort improves on the insertion sort by sorting incremental sublists. It falls between $$O(n)$$ and $$O(n^2)$$.
+ A merge sort is $$O(n\log(n))$$, but requires additional space for the merging process.
+ A quick sort is $$O(n\log(n))$$, but may degrade to $$O(n^2)$$ if the split points are not near the middle of the list. It does not require additional space.




