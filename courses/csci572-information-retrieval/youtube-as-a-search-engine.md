# YouTube as a Search Engine

## Backgroud

[https://www.youtube.com/watch?v=vQ0SKTcxjfI](https://www.youtube.com/watch?v=vQ0SKTcxjfI)

YouTube Search Engine Issues to Consider:
+ What video formats are acceptable for 
  - Uploading
  - Downloading (the YouTube players: desktop, iPhone, android)
+ How does YouTube **identify** videos
+ What does YouTube know about the video
+ How does YouTube **rank** search results
  - What factors are used
  - How are the factors weighed in producing the final ranking
+ YouTube **Recommendation** System
  - How does YouTube determine what to recommend
+ How Does YouTube distribute videos
+ How does YouTube monetize its website
  - YouTube’s ContentID system
  
  
## YouTube is Not a Search Engine in the Conventional Sense

+ YouTube does not crawl the web for videos
+ YouTube only searches the content that has been uploaded
+ YouTube only returns videos, not web pages or pdf files
+ Perhaps YouTube is best thought of as a **content aggregator** 

# Uploading to YouTube


1. Youtube gathers information : title, description, tags,...
2. Translations
3. License and ownership, Syndication,Caption, Embedding, Age restrictions, Categories

YOUTUBE UPLOAD CHARACTERISTICS
+ 8 formats for uploading : MOV, MP4 (MPEG4), AVI, WMV, FLV, 3GP, MPEGPS, WebM 
+** Aspect Ratio**: the standard aspect ratios are: 4:3 or 16:9. When the video is uploaded to the site, YouTube will either leave it as-is (for 16:9) or add vertical black bars (for 4:3)
+ The maximum file size you can upload to YouTube is 128GB.
+ By default, you can upload videos that are up to 15 minutes long, though that can be extended by visiting https://www.youtube.com/verify
+ there is no time limit for videos to remain on YouTube, unless
  + You delete the Video.
  + You delete your account.
  + You violate Copyright or community guidelines 
  
# YouTube provides filters 

+ UPLOAD DATE
+ TYPE
+ DURATION
+ FEATURES
+ SORTBY

#  YouTube Ranking Factors

YouTube uses the following metrics for ranking search results:

1. Meta Data
  - video titles, descriptions and tags are core ranking factors
  - include links to a website and social profiles
2. Video Quality
  - HD ranks higher than low quality videos 
3. Number of views, likes, shares and links
4. Subtitles and Closed Captions
  - captions can be crawled by the YouTube search engine and used for ranking
  
What is not known is how YouTube weights the individual factors to make up their final ranking 

# YouTube Recommendation System

Elements that are considered are the following:
- First, a user’s personal activity is initially determined (watched,favorited, liked, people he subscribes to, videos he watched to the end)
–  Next, an expanding set of videos is produced by traversing the **co-visitation** graph (other videos people watched after watching a given video) 

# Association Rule Mining
![](https://ws1.sinaimg.cn/large/006tKfTcgy1fk4qirrpc5j31as0wmk1m.jpg)


# Google Search is Biased Towards YouTube Videos

A **video rich snippet** means that when someone searches for something on Google, you can have a small tiny video show up next to your result to let the user know that particular result (yours) has a video to help

# Content Delivery Networks

A **content distribution network (CDN)** consists of a large set of content servers and a means for dynamically selecting servers based on knowledge of the location of the user and possibly the content being requested

## YouTube’s Content Distribution Network Basics

![](https://ws2.sinaimg.cn/large/006tKfTcgy1fk4qo6nmmlj31ay0ss7c9.jpg)


# YouTube Upload Architecture
![](https://ws4.sinaimg.cn/large/006tKfTcgy1fk4qq5vsm4j31ay0segsj.jpg)

# Monetizing YouTube

YouTube challenges in the early days:
+ YouTube had no way of making money, and its infrastructure is very expensive
+ YouTube was being sued by content creators, as many of YouTube’s videos were uploaded illegally
+ YouTube solved both problems at once, by
  - Developing a system for spotting copyrighted content
  - Allowing the copyright owner to decide if he wants to keep the content on the site and let ads appear, splitting the revenue with YouTube or taking the content down

## Content ID

+ YouTube’s solution was to create a fingerprint database of copyrighted content, called Content ID
+ ContentID technology creates an** ID Fingerprint File** for copyrighted audio and video material, and stores it in a database.
+ YouTube solicited cooperation from content owners asking them to submit copies of their content so YouTube could fingerprint them
+ There are millions of reference files in YouTube’s Content ID database.
+ When a video is uploaded, it is checked against the database, and flags the video as a copyright violation if a match is found
+ When this occurs, the content owner has the choice of blocking the video to make it unviewable, tracking the viewing statistics of the video, or adding advertisements to the video

![](https://ws2.sinaimg.cn/large/006tKfTcgy1fk4r99t0obj31ay0wsk2f.jpg)



