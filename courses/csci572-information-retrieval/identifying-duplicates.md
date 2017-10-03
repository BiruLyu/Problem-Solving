# De-duplication

## what is De-duplication?

**De-duplication** —— the process of identifying and avoiding essentially identical web pages.

In _cloud computing_, only a single copy of a file is stored and mutiple links to the single file are managed

With respect to web crawling, de-duplication essentially refers to  the identification of identical or nearly identical web pages and indexing only a single version to return as a search result.

How can two URLs differ yet still point to the same page?
+ the URL's host name can be distinct(virtual hosts)
+ the URL's protocol can be distinct(http,https)
+ the URL's path and/or page name can be distinct

**Mirroring** is the systematic replication of web pages across hosts.

## Why Detect Exact/Near Duplicates?

![](/assets/05_1.png)
![](/assets/05_2.png)

## Solving the Duplicate/Near-Duplicate

### Detection Problem

+ Duplicate: Exact match
  + Solution: compute **fingerprints using cryptographic hashing**
  + **SHA-1 and MD5** are the two most popular cryptographic hashing methods
  + Most useful for URL matching, but also works for detecting identical web pages
+ Near-Duplicate: Approximate match
  + Solution: compute the **syntactic similarity with an edit-distance measure**, and
  + Use a **similarity threshold** to detect near-duplicates– e.g., Similarity > 80% => Documents are “near duplicates”

### Using a Cryptographic Hash Function to Convert a Web Page to a Number

A **cryptographic hash function** is a hash function which takes an input (or 'message') and returns a **fixed-size alphanumeric string**, which is called the **hash value** (sometimes called a **message digest**, **digital fingerprint**, **digest** ora **checksum**).

#### The cryptographic hash function has four main properties:
1. It is extremely easy to calculate a hash for any given data.
2. It is extremely computationally difficult to calculate an alphanumeric text that has a given hash.
3. A small change to the text yields a totally different hash value.
4. It is extremely unlikely that two slightly different messages will have the same hash.


+ The **MD5 message-digest algorithm** is a widely used cryptographic hash function producing a **128-bit (16-byte)** hash value, typically expressed in text format as a **32 digit hexadecimal number**.
+ The **SHA-1, SHA-2** are also quite popular (**160 bit, 20 byte value**)
  + SHA-1 was recently broken; suggestion is to now use SHA-2 family of algorithms, see – https://en.wikipedia.org/wiki/SHA-2
  • E.g. see Chrome, Settings, Advanced, https, Manage certificates, certificates, Verisign
  
# Identifying Identical Web Pages(Four Approaches)
1. Compare character by character
2. Hash just the first few characters and compare only those documents that hash to the same bucket
3. Use a hash function that examines the entire document
4. Better approach - pick some fixed random positions for all documents and make the hash function depend only on these
5. Even better approach: Compute the cryptographic hash (SHA-2 or MD5) of eachweb page and maintain in sorted order, O(log n) to search

# Identifying Near Identical Web Pages - Two Approaches

1. **Produce fingerprints and test for similarity** 
   - Treat web documents as a set of features, constituting an **n-dimensional** vector, and transform this vector into an **f-bit fingerprint** of a small size
   - Use **Simhash and Hamming Distance** to compute the fingerprint
   - Compare fingerprints and look for a difference in at most k bits
   – E.g. see Manku et al., WWW 2007, Detecting Near-Duplicates for Web Crawling, http://www2007.org/papers/paper215.pdf
2. Compute **Shingles** and test for similarity
  - Compute **w-shingling** 
  - Broder et al., WWW 1997, Finding Near Duplicate Documents 
  
# General Paradigm

1. Define a function `f` that captures the contents of each document in a number
   - E.g. hash function, signature, or a fingerprint
2. Create the pair `<f(doci), ID of doci>` for all `doci`
3. Sort the pairs
4. Documents that have the same **f-value or an f-value within a small threshold** are believed to be duplicates 

# General Properties of Distance Measures

A distance measure must satisfy 4 properties :

1. No negative distances
2. `D(x,y) = 0` iff x=y
3. `D(x,y) = d(y,x)` symmetric
4. `D(x,y) <= d(x,z) + d(z,y)` triangle inequality

There are several **distance measures** that can play a role in locating duplicate and near-duplicate documents

+ **Euclidean distance**
  $$ D([x1...xn], [y1,...,yn]) = sqrt(Sum(xi-yi)^2) i=1...n$$
  
+ **Jaccard distance**
  $$D(x,y) = 1 - SIM(x,y)$$ or 1 minus the ratio of the sizes of the intersection and union of sets x and y

+ **Cosine distance**
  the cosine distance between two points (two n element vectors) is the angle that the vectors to those points make; in the range 0 to 180 degrees

+ **Edit distance** 
   the distance between two strings is **the smallest number** of insertions and deletions of single characters that will convert one string into the other
   
+ **Hamming distance**
  between two vectors is the number of components in which they differ (usually used on Boolean vectors)
  
# Computing Jaccard Similarity from Sets Containing Shingles

Definition of **Shingle**:
**a contiguous subsequence of words in a document** is called a shingle;

![](/assets/20_05.png)

# Shingling Modeling Choices

**Shingling** : convert documents, emails, etc. to sets

![](/assets/21_05.png)

# Mapping Shingles to Numbers
![](/assets/22_05.png)
![](/assets/23_05.png)
![](/assets/24_05.png)
![](/assets/25_05.png)
![](/assets/26_05.png)
![](/assets/27_05.png)

# Simhash by Moses Charikar A Locally Sensitive Hash Function

![](/assets/28_05.png)
![](/assets/29_05.png)
![](/assets/30_05.png)
![](/assets/31_05.png)
![](/assets/32_05.png)
![](/assets/33_05.png)














