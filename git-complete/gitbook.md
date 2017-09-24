# 

## Private GitBook by Bitbucket
[Config after creating a book by...](https://lightablue.gitbooks.io/private-gitbook-by-bitbucket/content/chapter1.html)


### 1.1 **By GitBook website**

```
cd ~/GitBook/Library/Import
git clone https://git.gitbook.com/user/book.git
cd ~/GitBook/Library/Import/book
git remote rename origin gitbook
git branch gitbook
git branch bitbucket
create a Bitbucket private repo
git remote add bitbucket https://user@bitbuck.org/user/repo.git
git push bitbucket bitbucket:master
``` 

### 1.2 **By GitBook Editor**

```
cd ~/GitBook/Library/Import/book
git branch gitbook
git branch bitbucket
create a Bitbucket private repo
git remote add bitbucket https://user@bitbuck.org/user/repo.git
git push bitbucket bitbucket:master
create a GitBook repo
git remote add gitbook https://git.gitbook.com/user/book.git
git push -f gitbook gitbook:master
```



## **Change the remote repository url**
https://help.github.com/articles/changing-a-remote-s-url/
```
git remote -v
git remote set-url bitbucket https://bitbucket.org/BiruLyu/PrivateRepository
git remote set-url origin https://bitbucket.org/BiruLyu/PrivateRepository

```

## Run multiple gitbook server
```
gitbook --port 5000 --lrport 5001 serve
```


