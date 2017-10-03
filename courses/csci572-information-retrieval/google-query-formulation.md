# The Power of Google’s Query Box 

+ Boolean Queries
+ Put Exact Phrases in Quotes
+ Boolean OR
  + ORhashigherprecedencethanAND
+ Google/Bing queries are not case sensitive.
+ full- word wildcards.
  + it’s +a * world,
  + The + before a is required because it is a stop word and would otherwise be ignored
  
+  Google Advanced Operators
   ![](https://ws2.sinaimg.cn/large/006tKfTcgy1fk4rfpi6dej31aw0ws46u.jpg)
+ Even More Special Features of the Google Query Box
![](https://ws3.sinaimg.cn/large/006tKfTcgy1fk4rl0jtiej31ay0wkgwp.jpg)
+ More Google Query Box Parameters
![](https://ws2.sinaimg.cn/large/006tKfTcgy1fk4rlr0w9hj31aw0xu7in.jpg)

+ A Failed Google Experiment 
  + phonebook: operator
  + Reading Level Examples
  + The Wonder Wheel
  + Google Code Search
+ Special Content Search Engines
  + Google Patents
  + Google Books
  + Google Scholar
  
# Relevance Feedback & Query Expansion 
# Google Related Searches
# Auto-Completion

**Auto-completion** is the process of predicting a word or phrase that the user wants to type in without the user actually typing it in completely

Auto-completion is a form of relevance feedback
+ This feature is effective when it is easy to predict the word being typed, e.g.when a browser fills in your name, address and/or email in a form;
+ Search engines may use **past history, phonetic Soundex algorithms, and spelling corrections algorithms** to assist in making guesses;
The challenge is to search a large index or a long list of popular queries **in a very short amount of time** so the results pop up while the user is typing 

# Judging the Quality of Answers: Mean Reciprocal Rank (MRR) Scoring

The **mean reciprocal rank** is a statistical measure for evaluating any process that produces a list of possible responses to a sample of queries, ordered by probability of correctness.

The **reciprocal rank** of a query response is the multiplicative inverse of the rank of the first correct answer

# Context-Sensitive Query (Auto-Completion – Bar-Yossef, Kraus)

**_MostPopularCompletion_** algorithm makes suggestions based on the most popular user queries in the past
+ After the first character, the MostPopularCompletion average MRR is only0.187
+ Solution: use the user’s context (previous queries), but this method relies on the existence of re-occurring query sequences, and in practice this rarely occurs
+ There is a long-tail distribution of query frequencies

**NearestCompletionA lgorithm**
+ Given a user input x and a context y, the algorithm suggests to the user the completions of x that are most similar to y
+ The context y is used to produce a tree of relevant query completions, where nodes are represented as n-grams

**HybridCompletion Algorithm**

![](https://ws3.sinaimg.cn/large/006tKfTcgy1fk4soy636oj31b00wsqev.jpg)
![](https://ws4.sinaimg.cn/large/006tKfTcgy1fk4spayhplj31aw0z4tjb.jpg)