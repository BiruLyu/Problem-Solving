# Link Analysis Algorithms

+ Background on Citation Analysis
+ Google’s PageRank Algorithm
+ Simplified Explanation of PageRank
+ Examples of how PageRank algorithm works
+ Observations about PageRank algorithm
+ Importance of PageRank
+ Kleinberg’s HITS Algorithm 

# History of Link Analysis

**Bibliometrics** :  is a set of methods to **quantitatively** analyze academic literature. Citation analysis and content analysis are commonly used bibliometric methods.


**Citation analysis** is the examination of the frequency, patterns, and graphs of citations in articles and books.

**Impact factor (of a journal)**: frequency with which the average article in a journal has been cited in a particular year or period
+ The impact factor of a journal J in year Y is the average number of citations (from indexed documents published in year Y) to a paper published in J in year Y-1 or Y-2.

**Bibliographic coupling**: two papers that cite many of the same papers

**Co-citation**: two papers that were cited by many of the same papers

#  Citations vs. Web Links

Web links are a bit different than citations:
+ Many links are navigational
+ Many pages with high in-degree are portals not content providers
+ Not all links are endorsements
+ Company websites normally don’t point to their competitors
+ Citations to relevant literature is enforced by peer-review

#  What is PageRank?

PageRank is **a web link analysis algorithm** used by Google

+ PageRank was developed at Stanford University by Google founders **Larry Page and Sergey Brin**
  - The paper describing pagerank was co-authored by Rajeev Motwani and Terry Winograd
+ PageRank is a “**vote**”, by all the other pages on the Web, about how important a page is.

+ A link to a page counts as **a vote of support**.
+ If there’s no link there’s no support (but it’s an abstention from voting rather than a vote against the page).
+ PageRank says nothing about the content or size of a page, the language it’s written in, or the text used in the anchor of a link!
+ Looked at another way, **PageRank is a probability distribution** used to represent the likelihood that a person randomly clicking on links will arrive at any particular page

# PageRank Algorithm

![](https://ws2.sinaimg.cn/large/006tNc79gy1fk5lzoje26j31b20wmdp7.jpg)

![](https://ws3.sinaimg.cn/large/006tNc79gy1fk5lzzx9w5j31ay0x07df.jpg)

**We calculate PR iteratively a number of times until we start converging to the same value.**

Number of iterations required for convergence is **empirically** (but not formally derived) **O(log n)** (where n is the number of links)

The damping factor value and its effect:
+ If too high, more iterations are required
+ If too low, you get repeated over-shoot,–  Both above and below the average – the numbers just swing like pendulum and never settle down. 
+  Both above and below the average – the numbers just swing like pendulum and never settle down. 


# Example

![](/assets/12 PageRank-1.png)
![](/assets/12 PageRank-2.png)
![](/assets/12 PageRank-3.png)
![](/assets/12 PageRank-4.png)
![](/assets/12 PageRank-5.png)
![](/assets/12 PageRank-6.png)
![](/assets/12 PageRank-7.png)
![](/assets/12 PageRank-8.png)
![](/assets/12 PageRank-9.png)
![](/assets/12 PageRank-10.png)
![](/assets/12 PageRank-11.png)

Some Suggestions Based on What We Have Seen in Example : 

Suggestions for improving your page rank
+ **Increasing the internal links** in your site can minimize the damage to your PR when you give away votes by linking to external sites.
+ If a particular page is highly important use a **hierarchical** structure with the important page at the “top”.
+ Where a group of pages may contain outward links – increase the number of internal links to retain as much PR as possible.
+ Where a group of pages do not contain outward links – the number of internal links in the site has no effect on the site’s average PR. You might as well use a link structure that gives the user the best navigational experience.
+ **Use Site Maps**: Linking to a site map on each page increases the number of internal links in the site, spreading the PR out and protecting you against your vote “donations” to other sites 

# Importance of PageRank

+ PageRank is just one factor Google uses to determine a page’s relevance. It assumes that people will link to your page **only if they think the page is good**. But this is not always true.

+ Content is still the king!!!
  - Anchor, body, title tags etc. still are very important for search engines
  
+ PageRank is a multiplier factor.
  + If Google wants to penalize any page they can set the PageRank equal to zero. It will be last on the search results page.


#  Disavowing Backlinks

Google actually provides users with a way to “disavow” backlinks
  - That is, to inform Google you do NOT want certain links pointing to your pages to be counted in their PageRank computation




#  Another Link Analysis Algorithm – HITS by Kleinberg

HITS stands for “**Hyperlink-Induced Topic Search**”

The algorithm is based on the observations that
+ Some pages known as **hubs** serve as large directories of information on a given topic
+ Some pages known as **authorities** serve as the page(s) that best describe the information on a given topic

The algorithm begins by retrieving a set of results to a search query, The HITS algorithm is performed **ONLY on the resulting set**

The algorithm goes through a set of iterations where 
+ an **authority value** is computed as the sum of the scaled hub values that point to that page; 
+ and a **hub value** is the sum of the scaled authority values of the pages it points to 

##  Authorities

**Authorities** are pages that are recognized as providing significant, trustworthy, and useful information on a topic.

**In-degree** (number of pointers to a page) is one simple measure of authority.

However in-degree treats all links as equal.

## Hubs

**Hubs** are index pages that provide lots of useful links to relevant content pages (topic authorities).

![](https://ws1.sinaimg.cn/large/006tNc79gy1fk5mh1ix6tj31b60kgjup.jpg)

## HITS Algorithm

![](https://ws3.sinaimg.cn/large/006tNc79gy1fk5min3lj8j31am0poq9c.jpg)

![](https://ws3.sinaimg.cn/large/006tNc79gy1fk5mk8v5ukj31b60rkwk6.jpg)

# Base Limitations

![](https://ws3.sinaimg.cn/large/006tNc79gy1fk5mme1kxaj31aw0mmn3d.jpg)

![](https://ws2.sinaimg.cn/large/006tNc79gy1fk5mmo2ycyj31b00r2tic.jpg)


![](https://ws2.sinaimg.cn/large/006tNc79gy1fk5mnztctej31au0t0jxk.jpg)

![](https://ws2.sinaimg.cn/large/006tNc79gy1fk5mor8qzyj31b00t4jyq.jpg)

![](https://ws4.sinaimg.cn/large/006tNc79gy1fk5mp0pvctj31aq0imn2u.jpg)




















