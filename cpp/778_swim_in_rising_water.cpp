#include <queue>

using namespace std;

/**
 * Leetcode 778. Swim in Rising Water
 */
class Solution {
public:
  int swimInWater(vector<vector<int>>& grid) {
    int ans = 0;
    int n = grid.size();
    bool vis[n * n + 1];
    for (int i = 0; i <= n * n; i++) {
      vis[i] = false;
    }

    int r[] = {1, -1, 0, 0};
    int c[] = {0, 0, 1, -1};

    // heap
    priority_queue<pair<int, int>> pq;
    pq.push({-grid[0][0], 0});

    // dijkstra
    while (!pq.empty()) {
      pair<int, int> t = pq.top();
      pq.pop();

      // decode coordinates
      int i = t.second / n;
      int j = t.second % n;

      ans = max(ans, grid[i][j]);

      if (i == n - 1 && j == n - 1) break;

      for (int k = 0; k < 4; k++) {
        int ni = i + r[k];
        int nj = j + c[k];

        if (ni >= 0 && ni < n && nj >= 0 && nj < n && !vis[ni * n + nj]) {
          vis[ni * n + nj] = true;
          // encode coordinates
          pq.push({-grid[ni][nj], ni * n + nj});
        }
      }
    }
    return ans;
  }
};

int main() {
}

