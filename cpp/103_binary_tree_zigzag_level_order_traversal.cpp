#include <queue>
#include <stack>

using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

/**
 * Leetcode 103 - Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
class Solution {
public:
  vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
    queue<TreeNode *> node_q;
    stack<TreeNode *> node_stack;
    vector<vector<int>> order;

    if (root != nullptr) {
      node_q.push(root);
    }

    bool left = false;

    while (true) {
      if (node_stack.empty() && node_q.empty()) {
        break;
      }

      vector<int> v;

      while (!node_q.empty()) {
        TreeNode *node = node_q.front();

        v.push_back(node->val);
        node_stack.push(node);

        node_q.pop();
      }

      order.push_back(v);

      while (!node_stack.empty()) {
        TreeNode *node = node_stack.top();

        if (left) {
          if (node->left != nullptr) {
            node_q.push(node->left);
          }
          if (node->right != nullptr) {
            node_q.push(node->right);
          }
        } else {
          if (node->right != nullptr) {
            node_q.push(node->right);
          }
          if (node->left != nullptr) {
            node_q.push(node->left);
          }
        }

        node_stack.pop();
      }



      left = !left;
    }

    return order;
  }
};

int main() {}
