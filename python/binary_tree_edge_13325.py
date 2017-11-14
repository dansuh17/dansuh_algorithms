"""
백준 문제 13325번 '이진 트리'
https://www.acmicpc.net/problem/13325

점화식을 세워 dynamic programming과 유사하게 풀면 끝.

time - O(V)
space - O(V)
auxilliary space - O(V)
V = number of nodes (== number of edges + 1)
"""
def tree_bin():
    k = int(input().strip())
    edge_weights = [int(c) for c in input().strip().split()]
    num_nodes = 2 ** (k + 1) - 1
    # root node = 0 (no weight)
    node_weights = [0] + edge_weights
    max_path = [0] * num_nodes

    # parent -> child : 2n + 1, 2n + 2, n == parent index
    # max_path(n) = max(max_path(left_child) + weight(left_child), max_path(right_child) + weight(right_child))
    for i in range(num_nodes - 1, -1, -1):
        if (i * 2 + 1) > (num_nodes - 1):
            # leaf nodes
            continue

        left_idx = i * 2 + 1
        right_idx = i * 2 + 2
        max_path_to = max(max_path[left_idx] + node_weights[left_idx],
                max_path[right_idx] + node_weights[right_idx])

        max_path[i] = max_path_to
        node_weights[left_idx] = max_path_to - max_path[left_idx]
        node_weights[right_idx] = max_path_to - max_path[right_idx]

    return sum(node_weights)

if __name__ == '__main__':
    print(tree_bin())
