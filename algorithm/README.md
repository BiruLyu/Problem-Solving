

# Reference：

[笔试面试知识整理](https://hit-alibaba.github.io/interview/basic/algo/Sorting.html)


![](https://ws1.sinaimg.cn/large/006tNc79gy1fjvp96w1uej31kw0cx40k.jpg)

# the sum of subarray    <==> K

1. 53 Maximum subarray (Kadane's)
2. ​     Maximum subMatrix  [Link01](https://www.youtube.com/watch?v=yCQN096CwWM)
3. ​     Maximum subarray no larger than K ( TreeSet O(nlogn))  [answer 01](https://stackoverflow.com/questions/39084147/largest-sum-of-contiguous-subarray-no-larger-than-k) [Answer02](https://softwareengineering.stackexchange.com/questions/319817/finding-longest-subsequence-with-sum-less-than-or-equal-to-a-fixed-number)
4. 363 Maximum subMatrix no larger than K (c^2^rlogr)
5. 325 longest subarray equals K (HashMap, 非负 Sliding Window O(n))
6. ​        longest subarray <= K (非负，sliding window O(n)
7. 209 Minimum size subarray  >=k (sliding window O(n))
8. ​        T/F, longest     % k == 0 (hashmap)

- 求长度最长的subarray, 和为k

  - HashMap

  [325. Maximum Size Subarray Sum Equals k](https://gist.github.com/BiruLyu/502668a87870373cd4970452ed1d1632)

- 求长度最短的subarray，和大于等于k

  - sliding Window(Two Pointers)
  - Binary Search

  [209. Minimum Size Subarray Sum](https://gist.github.com/BiruLyu/610bf8daa1fe7e3970171559d163c801)

# Kadane's Algorithm

Maximum Sum Subarray Problem 53 

Maximum Sum Subarray no longer than K 

Maximum Size Subarray Sum Equals k 325

Maximum Sum Rectangular Submatrix in Matrix dynamic programming/2D kadane 

Max Sum of Rectangle No Larger Than K 363

[Largest sum subarray with at-least k numbers](http://www.geeksforgeeks.org/largest-sum-subarray-least-k-numbers/)

扩展K [pdf](http://www.csie.ntu.edu.tw/~kmchao/papers/2006_TCS_KMAXSUM.pdf)

## isDAG  + Topological Sort

- BFS
- DFS
- Stack

# LinkedList 变换

- - 第奇数个串在一起， 第偶数个串在一起  [328. Odd Even Linked List](https://gist.github.com/BiruLyu/11fcf8b32b51a1ce5b60646f6e220443)
  - 比target大的放在前面 86. Partition List
  - 翻转
    206	Reverse Linked List
    92	Reverse Linked List II
    25	Reverse Nodes in k-Group
  - ​

# Design URL

- new 100 million url per month

- 1 billion request/month

- 10% shortening and 90% redirection

- shortening Request per second is 40条/s , redirection request per second is 360条/s

- 6 new billion urls in 5 years

- 假设 url -> 500bytes, 6bytes -> hash (26个A-Z，26个a-z，10个数字 62 ^6^ = 56 billion )

- all url we need 3TB, 36GB hash

- encoding : 40 (500 + 6) —> 20kb/s

- decoding : 360 (506) —> 180 kb/s

# Longest Increasing Subsequence

DP + Binary Search

 [300. Longest Increasing Subsequence]()
 [354. Russian Doll Envelopes]()


# Resevoir Sampling

[Link01](http://blog.jobbole.com/42550/)

[Link02](https://discuss.leetcode.com/topic/53753/brief-explanation-for-reservoir-sampling)


