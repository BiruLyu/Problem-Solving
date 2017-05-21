# Problem-Solving

> ## Data Structure
> >* Arrays
> >* Linked
> >* [Trees](#Trees)
> >* Graphs
> >
> ## Algorithms 
> >* Greedy
> >* Dynamic Programming 
> >* Divide and Conquer 
> >* Network Flow

***

### <a name = "Trees"></a> Trees

#### Tree Traversals
:

Option name         | recursive           | Stack     | Morris|
--------------------|------------------|-----------------------|---|
Preorder (Root, Left, Right) |    |    |
Inorder  (Left, Root, Right) |    |    |
Postorder(Left, Right, Root) |    |    |
Time Complexity      | O(n)  | O(n)    | O(n) |
Space Complexity     | O(n)    | O(n)  | **O(1)**|

  
 ##### <a name = "Preorder1"></a>recursive method
  
 ```c++
  void preOrder(TreeNode *root) {
    if(root == NULL)
        return;
    cout << root->val << endl;
    preOrder(root->left);
    preOrder(root->right);
}

```

```c++
void inOrder(TreeNode *root) {
    if(root == NULL)
        return;
    inOrder(root->left);
    cout << root->val << endl;
    inOrder(root->right);
}
```

```c++
void postOrder(TreeNode *root) {
    if(root == NULL)
        return;
    postOrder(root->left);
    postOrder(root->right);
    cout << root->val << endl;
}
```

 ##### <a name = "stack"></a>Stack
 ##### <a name = "morris"></a>Morris


Reference Linked: http://www.wengweitao.com/er-cha-shu-de-san-chong-bian-li-fang-shi-di-gui-fei-di-gui-he-morrisbian-li.html

 
