
Enter `git --version` at the command line to check if you already have Git installed.

# Update your configuration file

When you install Git, it comes with a configuration file that you update with your personal settings from a command window.
1. Enter the following command to configure your username, replacing Emma's name with your own. (Copy and paste the line after the $ and press enter.)
```
$ git config --global user.name "Emma Paris"
```
2. Enter the following command to configure your email address, replacing Emma's email address with your own.
```
$ git config --global user.email "eparis@atlassian.com"
```
3. Configure Git to handle line endings properly so that Bitbucket doesn't think files have changed when the actual content hasn't changed. We recommend this setting if you're collaborating on repositories with others who have different operating systems.
```
$ git config --global core.autocrlf input
```

# Branching and Merging

To create a branch and switch to it at the same time, you can run the `git checkout` command with the `-b` switch:

``` 
$ git checkout -b iss53
Switched to a new branch "iss53"
```
This is shorthand for:
```
$ git branch iss53
$ git checkout iss53
```
**merge** it back into your `master` branch to deploy to production. You do this with the `git merge` command:
```
$ git merge hotfix
Updating f42c576..3a0874c
Fast-forward
 index.html | 2 ++
 1 file changed, 2 insertions(+)
```

```
BiruLyu:atlas-jira BiruLyu$ git push
fatal: The current branch birulyu has no upstream branch.
To push the current branch and set the remote as upstream, use

    git push --set-upstream origin birulyu

BiruLyu:atlas-jira BiruLyu$ git push --set-upstream origin birulyu
git status

Counting objects: 31, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (23/23), done.
Writing objects: 100% (31/31), 8.54 KiB | 0 bytes/s, done.
Total 31 (delta 8), reused 1 (delta 0)
remote: Resolving deltas: 100% (8/8), completed with 6 local objects.
To https://github.com/pbehghader/atlas-jira
 * [new  How to delete a commit?]      birulyu -> birulyu
Branch birulyu set up to track remote branch birulyu from origin.
```

#  How to delete a commit?


- clone the repo to your machine
```
BiruLyu:~ BiruLyu$ git clone https://github.com/BiruLyu/Software-Quality-Evolution-Analysis
```
- find commit id of the commit which comes just before the commit which you want to delete.
You can use the command `git log -n 10` for that.

- then use this command.
```
git rebase -i commit_id
```

Your text editor will open with a file that lists all the commits which come afer your selected commit_id, and in front of each commit there is the word **pick**

in that list **remove the commit** which you want to delete and save it.

- Force-push to remote repo
```
git push -f origin master
```
- check github, it should be updated.


# How to move repository from Bitbucket to Github?

Short notes on what we did to migrate from BitBucket to GitHub, mainly not to lose this information.

create repo on github (from web interface)

move the repository, going through a bare repository in a local folder:

``` 
git clone --mirror https://bitbucket.org/aiida_team/aiida_core.git
cd aiida_core.git
git remote set-url --push origin =git@github.com:giovannipizzi/aiida_core_test.git=
git push --mirror
```

move issues: This must be done only once, starting from a new repository without issues or pull requests, to keep the numbering. If something goes wrong, then delete the repository and start again from the very beginning.

We used the script from this repository, but we modified it to keep a mapping between different usernames, and to reassign assignees for open issues (code is in the helpers_aiida repository accessible to AiiDA developers, folder /helpers/migration_to_github/run_migration.sh).

**NOTE**
https://stackoverflow.com/questions/2643502/git-permission-denied-publickey

In a word, if your intent is to clone-only a repo, use HTTPS URL **(https://github.com/{user_name}/{project_name}.git)** instead of SSH URL (git@github.com:{user_name}/{project_name}.git), which avoids (unnecessary) public key validation.






