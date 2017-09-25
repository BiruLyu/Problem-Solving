# Defining precision/recall

**Precision**  
= \#\(relevant items retrieved\) / \#\(all retrieved items\)  
= tp / \(tp + fp\)  
= A ∩ B / B

**Recall**  
 = \#\(relevant items retrieved\) / \#\(all relevant items\)  
 = tp / \(tp + fn\)  
 = A ∩ B / A

_A is set of relevant documents, B is set of retrieved documents_

|  | Relevant | Nonrelevant |
| :--- | :--- | :--- |
| Retrieved | True Positive **tp** | False Positive **fp** |
| Not Retrieved | False Negative **fn** | True Negative **tn** |

* Mean Average Precision

# Harmonic Mean and F Measure

## Pythagorean Mean:

1. arithmetic mean  
   $$
   \frac{x_1 + x_2 + \cdots + x_n}{n}
   $$
2. geometric mean
   $$
   \sqrt[n]{x_1 \cdot x_2 \cdots x_n}
   $$
3. **harmonic mean**
   $$
   H=\frac{n}{\frac{1}{x_1} + \frac{1}{x_2} + \cdots + \frac{1}{x_n}} = \frac{n}{\sum_{i = 0} ^ n \frac{1}{x_i}}
   $$

## F Measure

an aggregated performance score for the evaluation of algorithms and systems.  
The harmonic mean of the precision and the recall.


  $$ F = \frac{2}{\frac{1}{R} + \frac{1}{P}} = \frac{2RP}{R + P} $$
  $$ F_\beta  = \frac{(\beta^2 + 1)RP}{R + \beta^2P} $$


$$\beta$$ is a parameter that control the relative importance of recall and precision

## Calculating Recall/Precision at Fixed Positions

## Average Precision of the Relevant Documents

## Averaging Across Queries Mean Average Precision(MAP)

**Mean Average Precision(MAP)**
      $$ 
      MAP = \frac{\sum_{q = 1} ^ Q AveP(q)}{Q} 
      $$
   Q is the number of queries
   
## Difficulties in Using Precision/Recall

# Discounted Cumulative Gain

$$
DCG_p = rel_1 + \sum_{i = 2} ^ p \frac{rel_i}{\log_2(i)}
$$
$$p$$ : postion p at a particular rank
$$rel_i$$ : is the graded relevance of the result at position i
Typical Discount is $$\frac{1}{\log rank}$$

# How Evaluation is Done at Web Search Engines

+ Elements of Good Search Results

# Google's Search Quality Guidelines

Understanding mobile User 

## six rating scale categories

## 4-step process for changing their search algorithm

# A/B tesing

# Using user clicks for evaluation

# Using log files for evaluation

## typical contents of the query log files

# Google's enhancements for good search results 







