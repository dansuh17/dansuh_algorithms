using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
};

/**
 * 101 Symmetric Tree
 */
class Solution {
public:
  bool isSymmetric(TreeNode* root) {
    if (root == nullptr) return true;
    return testSymmetric(root->left, root->right);
  }

  bool testSymmetric(TreeNode* me, TreeNode* mirror) {
    if (me == nullptr && mirror == nullptr) {
      return true;
    } else if (me == nullptr && mirror != nullptr) {
      return false;
    } else if (me != nullptr && mirror == nullptr) {
      return false;
    } else {
      return testSymmetric(me->left, mirror->right) && (me->val == mirror->val) && testSymmetric(me->right, mirror->left);
    }
  }
};
