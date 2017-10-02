# Information Retrieval 

## What is Information Retrieval?

**Information retrieval (IR)** has been a computer science subject for many decades
- Traditionally it deals with the **indexing** of a given set of textual documents and the **retrieval** of relevant documents given a query
- Relatively recently **searching for pages **on the World Wide Web has become the “killer app.”

There has been a great deal of research on
- How to **index** a set of documents (a corpus)
- How to efficiently **retrieve** relevant documents

# IR History

+ 2000's
  + Link analysis for Web Search
  + Extension to retrieval of multimedia: images, music, video
  + **Question Answering** : return an actual answer rather than a ranked list of documents
  
# Areas Related to But Different than Information Retrieval

+ Database Management 
+ Library and Information Science
+ Artificial Intelligence
  + Focused on the representation of knowledge, reasoning, and intelligent action.
  + Formalisms for representing knowledge and queries:
    + First-order Predicate Logic 
    + Bayesian Networks
  + Recent work on **web ontologies** and intelligent information agents brings it closer to IR
+ Natural Language Processing
+ Machine Learning
  + Focused on the development of computational systems that **improve their performance with experience**
  + Machine learning is distinct from data mining, which focuses onthe discovery of previously unknown properties of the given data

# A More Detailed IR Architecture
![](/assets/06 IntroToInfoRetrieval-1.png)

# Defining Terms

Parsing forms index words (tokens) and includes:
- **Stopword** removal
  + See http://www.ranks.nl/tools/stopwords.html for google stopwords
  + **Stemming**: reducing a word to its root
+ **_Indexing_** constructs an **inverted index** of word to document pointers.
+ **_Searching_** retrieves documents that contain a given query token from the inverted index。
+ **_Ranking_** scores all retrieved documents according to a relevance metric.

# Retrieval Models

A retrieval model specifies the details of: 
+ Document representation
+ Query representation
+ Retrieval function

Determines a notion of relevance : 
+ Notion of relevance can be **binary** or **continuous** (i.e. rankedretrieval)

Three major Information **Retrieval Models** are:
+ **Boolean models** (set theoretic)
+ **Vector space models** (statistical/algebraic)
+** Probabilistic models**

## Common Pre-Processing Steps

1. **Strip unwanted characters/markup** (e.g. HTML tags, punctuation, numbers, etc.).
2. **Break into tokens (keywords) or whitespace**.
3. **Stem** tokens to “root” words.
   + computational ==> comput 
4. **Remove common stopwords** (e.g. a, the, it, etc.).
5. Detect **common phrases** (possibly using a domain specific dictionary).
6. Build **inverted index** (keyword ==> list of docs containing it).

## Boolean Model

A document is represented as a **set** of keywords.

**Queries are Boolean expressions of keywords**

+ **Pros**:
  - Easy to understand for simple queries. 
  - Clean formalism.
  - Boolean models can be extended to include ranking ? 
  - Reasonably efficient implementations possible for normal queries.


+ **Cons**:
  - Very **rigid**: AND means all; OR means any
  - Difficult to express **complex user requests**
  - Difficult to **control the number of documents retrieved**
    + All matched documents will be returned
  - Difficult to **rank output**
    + All matched documents logically satisfy the query
  - Difficult to **perform relevance feedback**
    + If a document is identified by the user as relevant or irrelevant, how should the query be modified? 
    
  ![](/assets/06 IntroToInfoRetrieval-2.png)
  
   
## The Vector-Space Model

Assume `t` distinct terms remain after preprocessing; call them index **terms** or the **vocabulary**

These “orthogonal” terms form a vector space :

$$
size of the vocabulary = Dimension = t = |vocabulary|
$$
A document $$D_i$$ is represented by a vector of index terms

$$ D_i = (d_{i1}, d_{i2}, ..., d_{it})$$

Both documents and queries are expressed as `t-dimensional` vectors

A collection of `n` documents can be represented in the vector space model by a `term-document matrix`.

An **entry** in the matrix corresponds to **the “weight” of a term in the document**; **zero means the term has no significance in the document or it simply doesn’t exist in the document**; but we still need a way to compute the weight

![](https://ws3.sinaimg.cn/large/006tKfTcgy1fk4fm7gyz2j30im0cc0tg.jpg)

### Term Weights: Term Frequency

Assumption: the **more frequent terms** in a document are more important, i.e. more indicative of the topic.

$$f_{ij} = frequency \ of \ term \ i \ in \ document \ j$$

May want to **normalize** **term frequency (tf)** across the entire corpus:$$tf_{ij} = f_{ij} / max\{f_{ij}\} $$

### Term Weights: Inverse Document Frequency

Terms that appear in **many different documents** are **less indicative** of overall topic
$$
df_i = document \ frequency \ of \ term \ i = number \ of \ documents \ containing \ term \ i
$$

of course $$df_i$$ is always `<= N (total number of documents)`
$$
idf_i = inverse \ document \ frequency \ of \ term \ i,\\= \log_2\frac{N}{df_i}(N: total number of documents)
$$
An indication of a term’s **discrimination power**

**Log is used to dampen the effect relative to `df` ** 

![](https://ws4.sinaimg.cn/large/006tKfTcgy1fk4gjsqa27j31kw0w27b1.jpg)



### TF-IDF Weighting

$$w_{ij} = tf_{ij} * idf_i = (1 + log tf_{ij} ) * log_{10}\frac{N}{df_i}$$

+ increase with the number of occurrances within a document
+ increase with the rarity of the term in the collection
+ A term occurring frequently in the document but rarely in the rest of the collection is given high weight.

Many other ways of determining term weights have been proposed.•  Experimentally, $$tf.idf$$ has been found to work well 


![](https://ws1.sinaimg.cn/large/006tKfTcgy1fk4h1puolzj31kw0uf7b2.jpg)

Given a query `q`, then we score the query against a document `d` using the formula
$$Score (q, d) = ∑(tf.idf_{t,d}) \ where \ t \ is \ in \  q ∩ d$$

### Cosine Similarity

Distance between vectors $$d_1$$ and $$d_2$$ is captured by the **cosine of the angle $$x$$** between them.

A similarity measure is a function that computes **the degree of similarity** between two vectors

Using a **similarity measure** between the query and each document has positive aspects:
+ It is possible to r**ank the retrieved documents** in the order of presumed relevance.
+ It is possible to **enforce a certain threshold so that the size of the retrieved set can be controlled**. 

### Normalized Vectors

A vector can be normalized **(given a length of 1)** by dividing each of its components by the vector's length
+ This maps vectors** onto the unit circle**:
+ Then, $$ |\vec{d_j}| =\sqrt{\sum^n_{i = i}w_{i,j}} = 1$$
+ Longer documents don’t get more $$weight_{i,j}$$
+ For **normalized vectors**, the cosine is simply the dot product:
$$ 
cos(\vec{d_j},\vec{d_k})=\vec{d_j} \cdot \vec{d_j}
$$

### Similarity Measure for Document and Query

Similarity between vectors for the document $$d_i$$ and query $$q$$ can be computed as the vector inner product:
![](https://ws2.sinaimg.cn/large/006tKfTcgy1fk4hntklbpj310m096406.jpg)

### Limitations of the Inner Product

+ Favors long documents with a large number of unique terms.
+ Measures how many terms matched but not how many terms are not matched. 

# Naïve Implementation
![](/assets/06 IntroToInfoRetrieval-41.png)

# Efficient Cosine Ranking

+ Ranking consists of computing the k docs in the corpus“nearest” to the query ⇒ **k largest query-doc cosines**.
+ To do efficient ranking one must:
  + Compute a single cosine efficiently.
  + Choose the k largest cosine values efficiently. 
  
![](/assets/06 IntroToInfoRetrieval-43.png)

# Summary of Algorithm for Vector Space Ranking

+ Represent the query as a weighted tf.idf vector
+ represent each document as a weighted tf.idf vector
+ compute the **cosine similarity score** for the query vector and each document vector
+ Rank documents with respect to the query by score
+ Return the top K (e.g. k=10) to the user 

## Use Heap for Selecting Top k

Heap : Binary tree in which each node’s value > values ofchildren

Takes `2n` operations to construct, then each of $$klogn$$ “winners” read off in $$2log n$$ steps.

## Bottleneck

+ Still need to first compute cosines from query toeach of n docs → several seconds for n = 1M
+ Can select from only non-zero cosines
  + Need union of postings lists accumulators (<<1M)
+ Can further limit to documents with non-zero cosines on rare (high idf) words
+ Enforce conjunctive search (a la Google): non-zero cosines on all words in query
+ But still potentially expensive

## A Pre-Processing Strategy

+ **Preprocess**: Pre-compute, for each term, its k nearest docs.
  - (Treat each term as a 1-term query)
  - lots of preprocessing
  - Result: “preferred list” for each term.
+ **Search**:
  - For a t-term query, take the union of their t preferred lists – call this set S.
  - Compute cosines from the query to only the docs in S, and choose top k.

## Comments on Vector Space Model

+ Simple, mathematically based approach.
+ Considers both local (tf) and global (idf) word occurrence frequencies.
+ Provides partial matching and ranked results.
+ Tends to work quite well in practice despite obvious weaknesses.
+ Allows efficient implementation for large document collections.

### Problems with Vector Space Model
+ Missing semantic information (e.g. word sense).
+ Missing syntactic information (e.g. phrase structure, word order, proximity information).
+ Assumption of term independence
+ Lacks the control of a Boolean model (e.g., requiring a term to appear in a document).
  + Given a two-term query “A B”, may prefer a document containing A frequently but not B, over a document that contains both A and B, but both less frequently. 
