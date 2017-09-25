## quickSelect + median of medians + quickSort

- 1. Median of Medians

Median of Medians is an approximate median-selection algorithm, that finds an approximate median in linear time, which helps the worst-case complexity of quickselect reducing significantly from qudratic to linear. It also helps buiding an asymptotically optimal worst-case complexity of any selection algorithm.

Median of medians can also be used as a pivot strategy in [quicksort](https://www.wikiwand.com/en/Quicksort), yielding an optimal algorithm, with worst-case complexity O(*n* log *n*). Although this approach optimizes the asymptotic worst-case complexity quite well, it is typically outperformed in practice by instead choosing random pivots for its average O(*n*) complexity for selection and average O(*n* log *n*) complexity for sorting, without any overhead of computing the pivot.

Quickselect is linear-time on average, but it can require quadratic time with poor pivot choices. This is because quickselect is a [divide and conquer](https://www.wikiwand.com/en/Divide_and_conquer_algorithm) algorithm, with each step taking O(*n*) time in the size of the remaining search set. If the search set decreases exponentially quickly in size (by a fixed proportion), this yields a [geometric series](https://www.wikiwand.com/en/Geometric_series) times the O(*n*) factor of a single step, and thus linear overall time. However, if the search set decreases slowly in size, such as linearly (by a fixed number of elements, in the worst case only reducing by one element each time), then a linear sum of linear steps yields quadratic overall time (formally, [triangular numbers](https://www.wikiwand.com/en/Triangular_number) grow quadratically). For example, the worst case occurs when pivoting on the smallest element at each step, such as applying quickselect for the maximum element to already sorted data and taking the first element as pivot each time.



The **median-of-medians algorithm** chooses the pivot in the following way :

1. Divide the list into sublists of length five. (Note that the last sublist may have length less than five.)
2. Sort each sublist and determine its median directly.
3. Use the median of medians algorithm to recursively determine the median of the set of all medians from the previous step.
4. Use the median of the medians from step 3 as the pivot.

This algorithm guarantees that our pivot is not too far from the median.

**Time Complexity : O(n)**

[MEDIAN OF MEDIANS ALGORITHM](https://interviewalgorithm.wordpress.com/sortingordering/median-of-medians-algorithm/)

[MEDIAN OF MEDIANS ALGORITHM02](https://github.com/Sybil-Li/Median-of-Medians/blob/master/Solution.java)

```java
private int findMedian(int[] nums)
    {
        if (nums.length <= 5)
        {
            Arrays.sort(nums);
            return nums[nums.length/2];
        }
        
        int groups = nums.length/5;
        if (nums.length%5 != 0)
            groups += 1;
        int [] medians = new int[groups];
        for (int i = 0; i < nums.length; i += 5)
        {
            if (i+4 < nums.length)
                // i is inclusive, i+5 is exclusive
                medians[i/5] = findMedian(Arrays.copyOfRange(nums, i, i+5));
            else
            {
                if (i == nums.length-1)
                    medians[i/5] = nums[i];
                else
                    medians[i/5] = findMedian(Arrays.copyOfRange(nums, i, nums.length));
            }
        }
        return findMedian(medians);
    }
```

- 1. QuickSelect

