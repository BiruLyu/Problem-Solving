# Crawlers and Crawling

## What is web crawler/Spider/Robot?

A web crawler is a computer program that visit web pages in an organized way. For example, Google's **googlebot**, Yahoo's **Yahoo!Slurp**, Bing's **Bingbot, Adidxbot, MSNbot, MSBBotMedia, BingPreview**.

Google now uses multiple crawlers : 
+ Googlebot
+ Googlebot News
+ Googlebot Images
+ Googlebot Video
+ Google Mobile Smartphone
+ Google Mobile AdSense
+ Google AdsBot
+ Google app crawler
![](/assets/04 CrawlingInOne 9.png)

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

### Complications && More Issues:

+ crawling the entire page isn't feasible with one machine ==> 
  + [multiple threads](#multiple-threaded-crawling)
  + [distributed](#distributed-crawling)
+ latency/bandwidth to remote server can vary widely
+ avoiding **malicious** pages : spam, spider traps(dynamically generated pages) 
  + [avoid-spider-traps](#avoid-spider-traps)
  + [Handling Spam](#handling-spam)
+ **Robots.txt** can prevent page from visiting [robots.txt](#robots.txt)
+ avoiding mirrors and duplicate pages [avoid-page-duplication](#avoid-page-duplication)
+ **maintain politeness - don't hit a server too often**
+ Refresh Strategies [freshness](#freshness)
+ [Speeding up DNS lookup](#DNS-chaching)

### Policies of web crawler
The behavior of a Web crawler is the outcome of a combination of policies : 
+ A **selection policy** that states which pages to download
+ A **revisit policy** that states when to check for changes to the pages
+ A **politeness policy** that states how to avoid overloading websites
+ A **parallelization policy** that states how to coordinate distributed web crawlers.



# Simplest Crawler Operation (Crawling Algorithm Version 01)

Begin with known "**seed**" page, fetch and parse a page(extract the URLs within the page and put them on a queue), fetch each URL on the queue and repeat.

![](/assets/IMG_47F4FC4A34C7-1.jpeg)

# <a name = "robots.txt"></a> Robots.txt

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

# Measuring and Tuning a Crawler reduces to:

+ Improving URL parsing speed
+ Improving network bandwidth speed
+ Improving fault tolerance


# <a name = "DNS-chaching"></a>DNS caching, pre-fetching and resolution

+ **DNS caching** : 
  build a caching server that retains IP-domain name mappings previously discovered
+ Pre-fetching client:
  once the page is parsed immediately make DNS resolution requests to the caching server; if unresolved, use **UDP(User Datagram Protocol)** to resolve from the DNS server.
+ Customize the crawler so it allows issuing of many resolution requests simultaneously; there should be many DNS resolvers.

# <a name = "multiple-threaded-crawling"></a>Multi-Threaded Crawling 

One bottleneck is **network delay** in downloading individual pages.

It is best to have **multiple threads** running in parallel each requesting a page from a different host.
+ **thread** : a thread of execution is the smallest sequence of programmed instructions that can be managed independently by a scheduler. 
+ In most cases, a thread is a component of a process.
+ Multiple threads can exist within the same process and share resources.

# <a name = "distributed-crawling"></a>Distributed Crawling Approache

**Distributed** URL's to threads to guarantee equitable distribution of requests across different hosts __**maximize through-put**__ and avoid overloading any single server.

+ How many crawlers should be running at any time?
  + Scenario 1: A centralized crawler controlling a set of parallel crawlers all running on a LAN
  + Scenario 2: A distributed set of crawlers running on widely distributed machines, with or without cross communication.
  
## Distributed Model

![](/assets/04 CrawlingInOne 3.png)
![](/assets/04 CrawlingInOne 4.png)

Three strategies of Coordination of Distributed Crawling : 
+ **Independent** : no coordination, every process follows its extracted links
+ **Dynamic assignment** : a central coordinator dynamically divides the web into small partitions and assign each partition to a process
+ **Static assignment** : web is partitioned and assigned without a central coordinator before the crawl starts 
  + inter-partition links can be handled in three ways as follow :
    ![](/assets/04 CrawlingInOne 5.png)
    + Firewall mode
    + Cross-over mode
    + Exchange mode(communication required):
      + Batch communications : every process collects some URLs and sends them in a batch
      + Replication: the k most popular URLs are replicated at each process and not exchanged 

### Some ways to partition the Web:

+ **URL-hash based** : this yields many inter-partition links
+ **Site-hash based** : reduces the intern-partition links
+ **Hierarchical** : by TLD(Top-Level-Domain)

## General Conclusions of Cho and Garcia-Molina

+ Firewall crawlers attain good, general coverage with low cost
+ Cross-over ensures 100% quality, but suffer from overlap
+ Replicating URLs and batch communication can reduce overhead

# <a name = "freshness"></a>Freshness

how fresh the page in our database compared to the page out there

Web is very dynamic : many new pages, updated pages and deleted pages, etc.

![](/assets/04 CrawlingInOne 6.png)

## Cho and Garcia-Molina Experiment 

![](/assets/1.png)
![](/assets/2.png)

## Implications for a Web Crawler

![](/assets/04 CrawlingInOne 7.png)

## Change Frequency vs. Optimal Re-visiting

![](/assets/04 CrawlingInOne 8.png)

## Cho and Garcia-Molina

Two simple re-visiting policies:
+ **Uniform policy** : with same frequency
+ **Proportional Policy** : re-visiting more often the pages that change more frequently

**The uniform policy outperforms the proportional policy.**

The explanation for this result comes from the fact that, 
**when a page changes too often, the crawler will waste 
time by trying to re-crawl it too fast and still will not be 
able to keep its copy of the page fresh**. 

To improve freshness, we should **penalize the element that change to fast.**

# SiteMap

A **sitemap** is a list of pages of a web site accessible to crawlers.

+ XML is used as the standard for representing sitemaps. contains `<loc>`, `<lastmod>`, `<changefreq>`, and `<priority>`





