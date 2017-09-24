/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    void flatten(TreeNode* root) {
        if (root == NULL){
            return;
        }
        stack<TreeNode*> s;
        if(root->right != NULL){
            s.push(root->right);
        }
        if(root->left != NULL){
            s.push(root->left);
        }
        
        root->left = NULL;
        root->right = NULL;
        
        TreeNode *next = root;          
        
        while(!s.empty()){
            TreeNode *topNode = s.top();
            TreeNode *temp = new TreeNode(topNode->val);
            next->right = temp;
            next = temp;
            s.pop();
            if(topNode->right != NULL){
                s.push(topNode->right);
            }
            if(topNode->left != NULL){
                s.push(topNode->left);
            }
        }
    }
};

