# Inverted Indexing

+ Definition of an Inverted index
+ Examples of Inverted Indices
+ Representing an Inverted Index
+ Processing a Query on a Linked Inverted Index
+ Skip Pointers to Improve Merging
+ Phrase Queries
+ biwords
+ Grammatical Tagging
+ N-Grams
+ Distributed Indexing

# Creating an Inverted Index

An **inverted index** is typically composed of a **vector** containing all distinct words of the text collection in lexicographical order (which is called the vocabulary) and for each word in the vocabulary, **a list of all documents** (and text positions) in which that word occurs

Terms in the inverted file index may be refined:
+ **Case folding**: converting all uppercase letters to lower case
+ **Stemming**: reducing words to their morphological roots
+ **Stop words**: removing words that are so common they provide no information 

##  Term-Document Incidence Matrix

One way to think about an inverted index is to consider it as a sparse matrix where rows represent terms and columns represent documents
![](https://ws3.sinaimg.cn/large/006tKfTcgy1fk4n0ivo6aj31b00mmq6b.jpg)

## Term-Document Incident Matrices are Naturally Sparse
![](/assets/09 InvertedIndexPhaseOne-9.png)

+ For each term T, we must store a list of all documents that contain T. 
+ Linked lists are generally preferred to arrays–  
  + Dynamic space allocation
  + Insertion of terms into documents easy
  + There is space overhead of pointers, though this is not too serious 

![](https://ws2.sinaimg.cn/large/006tKfTcgy1fk4nc6rmwgj31b20s8dn4.jpg)
  
#  Query Processing Across the Postings List

+ For each term in the query, retrieve its postings.
+ Merge to get the ones in common

 Query Optimization : 
 for term in query **SORT BY INCREASING FREQUENCY**
 Process in order of increasing freq:
 + start with smallest set, then keep cutting further.
 
 Algorithm for the intersection of two postings lists p1 and p2
 ![](/assets/09 InvertedIndexPhaseOne-19.png)
 
 
## To speed up the merging of postings we use the technique of Skip Pointers 

![](/assets/09 InvertedIndexPhaseOne-23.png)


+ skip pointers are added at indexing time; 
+ they are shortcuts, and they only help for **AND queries** and they are useful when the corpus is relatively static
+ where should they be placed?
  + More skips means shorter skip spans, and that we are more likely to skip. But it also means lots of comparisons to skip pointers, and lots of space storing skip pointers. 
  + Fewer skips means few pointer comparisons, but then long skip spans which means that there will be fewer opportunities to skip.
  + The Solution: A simple heuristic for placing skips, which has been found to work well in practice, is that **for a postings list of length P, use sqrt{P} evenly-spaced skip pointers**. This heuristic possibly can be improved upon as it ignores any details of the distribution of query terms. [Moffat and Zobel 1996]
+ how do the algorithms change?
![](https://ws1.sinaimg.cn/large/006tKfTcgy1fk4oev67j2j31b20yqdqa.jpg)

# Phrase Queries

+ Bi-word indexes
+ Positional indexes

## Bi-word indexes

A bi-word (or a 2-gram) is a **consecutive pair of terms** in some text

To improve phrase searching one approach is to index every bi-word in the text

+ Consequences
  - Bi-words will cause an explosion in the vocabulary database
  - Queries longer than 2 words will have to be broken into bi-word segments

+ A Bi-word index that is extended to longer sequences, or even variable length sequences is called a phrase index
  - produce false positive (occurrences of the bi-words, but not the full 4 word query)
+ A Bi-word index that is extended to longer sequences, or even variable length sequences is called a **phrase index**

 
## Positional Indexes

Store, for each term in the index, entries of the form: 
```
<term, number of docs containing term; 
doc1: position1, position2, position3 ... ; 
doc2: position1, position2 ... ;etc.>
```
i.e. for each occurrence of the term in a document its position is stored

Adopting a positional index **expands required postings storage significantly**, even if we compress position values/offsets

### Algorithm for matching a phrase query: ???

1.  **Extract** inverted index entries for each distinct term: e.g. to, be, or, not, to, be
2.  **Merge** their doc:position lists to enumerate all positions with “to be or not to be”.
3.  **Match** those documents that contain the terms in the adjacent positions

![](https://ws4.sinaimg.cn/large/006tKfTcgy1fk4owce2s3j31b00zedok.jpg)

# Grammatical Tagging

![](https://ws4.sinaimg.cn/large/006tKfTcgy1fk4p6vw47qj31b00z8gw1.jpg)

#  Google Relies Upon n-gram Indexes

+ Google has investigated the use of n-grams stored in its index
+ N-grams of all lengths form a **Zipf distribution (power law)** with a few common phrases occurring very frequently and a large number occurring with frequency 1
+ Google has released the set of n-grams it has determined 

