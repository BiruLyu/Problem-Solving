# Lexicon & Text Normalization

This lecture is focused on the issue of **how a search engine creates its database of documents.**

In particular how the search engine determines **what words go into its inverted index, the lexicon**

we begin with a discussion of **word frequency and determining the number of unique words (the vocabulary)**

then we look at some specific operations for normalizing words:
+ tokenization
+ stop words
+ capitalization
+ casefolding
+ Synonyms(thesaurus)
+ Similar sounding words
+ Stemming

##  Power Laws and Zipf’s 

An equation of the form $$y = kx^c$$ is called a **power law** –  k and c are constants

**Zipf’s law** is a power law with c = –1
+ His rule states that the frequency of any word is inversely proportional to its rank in the frequency table
+ Thus the most frequent word will occur approximately twice as often as the second most frequent word, three times as often as the third most frequent word, etc

On a log-log plot, power laws give a straight line with slope c.

We can ask two questions about words in a set of documents:
1.  How is the **frequency of different words distributed**? [heavy tailed](#heavy-tailed)
2.  How fast does **vocabulary size grow with the size of a set of documents**? 
[Vocabulary Growth](#vocabulary-growth)

<a name = "heavy-tailed"></a>**heavy tailed** distribution: 
+ A few words are very common.
+ Most words are very rare.

###  Zipf’s Law Impact on IR
+ Good News: **Stopwords** will account for a large fraction of text so eliminating them greatly reduces inverted-index storage costs.
+ Bad News: For most words, gathering sufficient data for meaningful statistical analysis (e.g. for correlation analysis for query expansion) is difficult since they are extremely rare
  - Implying it is hard to give relevance feedback 
  
### <a name = "vocabulary-growth"></a>Vocabulary Growth

This determines how the size of the inverted index will scale with the size of the corpus.
+ In practice a vocabulary is not really upper-bounded due to **proper names, typos**, etc. 

##  Heaps’ Law

Heap's law describes the **number of distinct words (V) in a set of documents as a function of the document length (n) **
![](https://ws4.sinaimg.cn/large/006tKfTcgy1fk4kisua2bj317s0iq42d.jpg)

###  Heap's Law Conclusion

1. the dictionary size **continues to increase** with more documents in the collection, rather than a maximum vocabulary size being reached
2. the size of the dictionary is quite large for large collections

imply that **dictionary compression** is important to do

# Lexicon Construction

**Lexicon** : A database of the vocabulary of a particular domain (or a language)

It is more than a list of words/phrases. Usually it includes some **linguistic** information: 
+ **Morphology** : manag- e/es/ing/ed → manage
  + description of the structure of a language's units such as root words, parts of speech, intonations, stresses)
+ **Syntactic patterns**: such as Verb-Object or Subject-Verb-Object

Often some semantic information is included:
- Is-a hierarchy, 
  + lion is-a primate is-a mammal; 
  + corvette is-a Chevrolet is-a General Motors car
- Synonyms (e.g. restaurant, café)
- Numbers convert to normal form: Four → 4
- Dates convert to normal form (month/day/year)
- Alternative names converted to explicit form
  + Mr. Carr, Tyler, Presenter → Tyler Carr
  
##  The First Challenge: Determining the Characters

+ Digital documents are typically bytes in a file. The first step of processing is to convert this byte sequence into a **linear sequence of characters**.
  + Plain English text in ASCII encoding poses no problem
  + multi-byte encoding schemes, such as Unicode, UTF-8, or various national orvendor-specific standards are more difficult to identify and process.
  + Determining the correct encoding is a _machine learning classification problem_ but is often handled by heuristic methods or by using provided document metadata such as:–  `<html lang=“en-US”>,<html lang=“fr”>,<Q lang=“he” dir=“rtl”>`
+ Alternately, the characters may have to be decoded out of some binary representation like Microsoft Word DOC files and/or a compressed format such as zip files
+ Even for plain text documents, additional decoding may need to be done. In XML document’s character entities, such as `&amp;`, need to be decoded to give the correct character
+ Finally, the textual part of the document may need to be extracted out of other material, e.g. when handling postscript (PS) or PDF files

**Solution**: This problem is usually solved by licensing a software library that handles decoding document formats and character encodings. 

 ## More Complications: Format/Language
 + Documents being indexed can include items from many different languages
   + A single index may contain terms from many languages.
 + Sometimes a single document or its components can contain multiple language formats, e.g.
   + French email with a German pdf attachment.
   + French email with quoted clauses from an English-languagecontract
   + French email with quoted clauses from an English-languagecontract
   + French email with Arabic or Hebrew phrases (right-to-left)
   
#  Tokenization

**Definition**: The task of **chopping a document unit into pieces**, called tokens, and possibly throwing away certain characters 

A **token** **is an instance of a sequence of characters** in some particular document that are grouped together as **a useful semantic unit**

A **term** is a (possibly normalized) type that is included in the lexicon

**Simple algorithm**: “chop on whitespace and throw away punctuation characters”, but consider

![](https://ws1.sinaimg.cn/large/006tKfTcgy1fk4ld2sjzoj313e09uwi4.jpg)

##  Token Normalization

Token normalization is the process of **canonicalizing tokens** so that matches occur despite superficial differences in the character sequences of the tokens.

The standard way to normalize is to implicitly create **equivalence classes** , which are normally named after one member of the set; this is often called **stemming**;

+ **stemming** is the process for stemming is the process for **reducing inflected (or sometimes derived) words to their stem, base or root form** – generally a written word form – generally a written word form
+ An alternative to creating equivalence classes is to **maintain relations between unnormalized tokens**. This method can be extended to **hand-constructed lists of synonyms** such as car and automobile.

One way is to perform the expansion is during index construction. When the document contains automobile, we index it under car as well (and, usually, also vice-versa)

##  Handling Unusual Specific 

![](/assets/07 ZipfLexicon-20.png)

#  Dropping Common Terms : Stop Words

 **stop words**  : We have already seen that some extremely common words appear to be of little value in helping select documents matching a user need. These words are called stop words .
 
 The general strategy for determining a stop list:
 + is to sort the terms by **collection frequency** (the total number of times each term appears in the document collection), and then to take the most frequent terms as a stop list , the members of which are then **discarded during indexing**.
 
 + Using a stop list significantly **reduces the number of postings** that a system has to store;

**Exception**: phrase searches are an important exception,

![](https://ws3.sinaimg.cn/large/006tKfTcgy1fk4lqn3bhkj31420aedjl.jpg)

For efficiency, stopwords are **stored in a hashtable** to recognize them in constant time.

There is some **storage overhead** for a hash table, but it should fit in main memory

#  Capitalization/Case-Folding

**case-folding** is reducing all letters to lower case.

#  Stemming and Lemmatization

goal : to **reduce multiple forms of a word to a common base form**

**Stemming** usually refers to a crude heuristic process that **chops off the ends of words** in the hope of achieving this goal correctly most of the time

**Lemmatization** usually refers to doing things properly with the **use of a vocabulary and morphological analysis of words**, normally aiming to **remove inflectional endings only** and to return the base or dictionary form of a word, which is known as the **_lemma_**

A stemmer written by **Martin Porter** has become the de-facto standard algorithm used for English stemming

## Typical Rules in Porter’s algorithm

![](/assets/07 ZipfLexicon-27.png)

## Error Metrics

Two error measurements : 
+ **Over-stemming** : two sperate inflected words are stemmed to the same root, but should not have been, a **false positive**
  + Universal, university and universe are stemmed to univers, acase of over-stemming
+ **Under-stemming**: where two separate inflected words should be stemmed to the same root, but are not, a **false negative**
  + alumnus goes to alumnu, alumni goes to alumni, alumna goes to alumna, but all should stem to the same root
  
# Soundex Algorithm

**Soundex** is a phonetic algorithm for **indexing names by their sound** when pronounced in English

The basic aim is **for names with the same pronunciation to be encoded to the same string** so that matching can occur despite minor differences in spelling, e.g.SMITH and SMYTH

**Soundex** is the most widely known of all phonetic algorithms, as it is astandard feature of MySQL, Microsoft SQL Server and Oracle
It was developed by **Robert Russell** and **Margaret Oldell** in 1918 

Soundex – Typical Algorithm: 
+ Turn every token to be indexed into a 4-character reduced form
+ Do the same with query terms
+ Build and search an index on the reduced forms–  (when the query calls for a soundex match)


+ The algorithm mainly encodes **consonants**; a vowel will not be encoded unless it is the first letter.
+ Every Soundex code consists of a letter and three numbers, e.g. W-252;
  + the letter is the first letter of the surname
  + The numbers are assigned to the remaining letters of the surname according to the Soundex guide
  
+ Washington is coded W-252 (W, 2 for the S, 5 for the N, 2 for the G, and remaining letters disregarded
+ Lee is coded L-000 (L the leading letter and since the ee are dropped the zeros are used as padding)

![](/assets/07 ZipfLexicon-32.png) 
![](/assets/07 ZipfLexicon-33.png) 
![](/assets/07 ZipfLexicon-34.png) 

# Postscript: Lucene and Solr

![](/assets/07 ZipfLexicon-35.png)
![](/assets/07 ZipfLexicon-36.png)
![](/assets/07 ZipfLexicon-37.png)
![](/assets/07 ZipfLexicon-38.png)
![](/assets/07 ZipfLexicon-39.png)



