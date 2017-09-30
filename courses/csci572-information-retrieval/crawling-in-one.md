# Crawlers and Crawling

## What is web crawler/Spider/Robot?

A web crawler is a computer program that visit web pages in an organized way. For example, Google's **googlebot**, Yahoo's **Yahoo!Slurp**, Bing's **Bingbot, Adidxbot, MSNbot, MSBBotMedia, BingPreview**.

## What is crawling issues?

### How to crawl?

+ **_Quality_** : how to find the best page first? 
+ **_Efficiency_** : how to avoid duplication(or near duplication)
+ **_Etiquette_** : behave politely by not disturbing a website's performance

### How much to crawl? How much to index?

+ **_Coverage_** : What percentage of the web should be covered?
+ **_Relative Coverage_** : How much do competitors have?

### How often to crawl?

+ **_Freshness_** : How much has changed? How much has really changes?

# Simplest Crawler Operation (Crawling Algorithm Version 01)

Begin with known "**seed**" page, fetch and parse a page(extract the URLs within the page and put them on a queue), fetch each URL on the queue and repeat.

![](/assets/IMG_47F4FC4A34C7-1.jpeg)

# Complications

+ crawling the entire page isn't feasible with one machine ==> multiple threads, distributed
+ avoiding **malicious** pages : spam, spider traps(dynamically generated pages) 

[avoid-spider-traps](#avoid-spider-traps)

[Handling Spam](#handling-spam)
+ latency/bandwidth to remote server can vary widely
+ **Robots.txt** can prevent page from visiting
+ avoiding mirrors and duplicate pages [avoid-page-duplication](#avoid-page-duplication)
+ **maintain politeness - don't hit a server too often**

## Robots.txt

defines the **limitations** for a web crawler as it visit a website.
The website announces its request on what can/can't be crawled by placing a **robots.txt** file in the root directory.

# Basic Search Strategies

## Breadth first search

BFS crawling brings in high quality pages early in the crawl.

## Depth first search

![](/assets/04 CrawlingInOne.png)

How the new links are added to the queue determines the search strategy.

+ **FIFO**(append to end of Q) gives breadth-first-search.
+ **LIFO**(append to front of Q) gives depth-first-search.
+ Heuristically ordering the Q gives a "**focused crawler**"
  - Move forward URLs whose **In-degree is large**
  - Move forward URLs whose **PageRank** is large
  
# Avoid Page Duplication

A crawler must detect that when revisiting a page that has already been crawled. Therefore, a crawler must **efficiently index URLs as well as already visited pages**.

The web is a graph not a tree.

+ determine **if a URL** has already been seen [representing-urls](#representing-urls)
  - store URL in standard format
  - develop a fast way to check if a URL has already been seen
+ determine **if a new page** has been seen
  - develop a fast way to determine if an **_identical_** or _**near-identical**_ page was already indexed

## Link Extraction

1. Must find all links in a page and extract URLs
2. Relative URL's must be completed, using current page URL or **\base\** tage

### Two anomalies
1. Some anchor don't have links
2. SOme anchor produce dynamic pages which can lead to looping

### Representing URLs

#### One Proposed Method

1. First **hash on host/domain name**
2. then, use a **trie data structure** to determine if the path/resource is the same on one in the database

##### Trie for URL Exact Matching 

Characteristics of tries 

+ They **share the same prefix** among multiple "words"
+ Each path from the root to a leaf corresponds to one "word"
+ EndMarker symbol `$` at the ends of words:
  To avoid confusion between words with almost identical elements
+ For `n` URLs and maximum length `k`, time is $$O(\log_kn)$$

#### Another Proposed Method

URLs are sorted lexicographically and then stored as a **delta-encoded** test file

+ Each entry is stored as the difference(delta) between the current and previous URL; this **substantially reduces storage**
+ However, the restoring the actual URL is **slower**
+ TO improve speed, checkingpointing(storing the full URL) is done periodically

### Why Normalizing URLs is Important?

People can type URL in different way but they all point to the same place. e.g. `http://www.google.com` and `google.com`

#### Normalizing URLs(4 rules)

1. Convert scheme and host to lower case.
2. Capitalize letters in escape sequences.
3. Decode precent-encoded octets of unreserved characters.
4. Remove the default port.

# Avoid Spider Traps

A spider trap is when a crawler re-visits the same page over and over again. The most well-known spider trap is the one created by the use of **Session ID**

![](/assets/IMG_C8CE5A662D11-1.jpeg)

# Handling Spam

1. First Generation : consisted of pages with a high number of repeated terms
2. Second Generation : _**cloaking**_ ==> return different pages to crawler and users
3. Third Generation : **_doorway page_** ==> contain highly ranked text and metadata

# The Mercator Web Crawler 

![](https://ws4.sinaimg.cn/large/006tNc79gy1fk1fxk6csbj31kw16o1kx.jpg)




