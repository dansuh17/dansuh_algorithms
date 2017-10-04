from collections import deque
import operator
"""
백준 문제 1167번 '트리의 지름'
https://www.acmicpc.net/problem/1167

트리의 지름 찾기 - 한 node에서 가장 먼 node까지의 거리
#BFS

time - O(m)
space - O(n + m)
"""


def radius_of_tree():
    v = int(input().strip())

    nodes = []
    for i in range(v):
        nodes.append(Node(i))

    for _ in range(v):
        connection = [int(c) for c in input().strip().split()]
        from_node = connection[0] - 1
        children_info = connection[1:-1]  # crazy input argument...

        for i in range(0, len(children_info), 2):
            to_node = children_info[i] - 1
            length = children_info[i + 1]

            nodes[from_node].add_child(nodes[to_node], length)
            nodes[to_node].add_child(nodes[from_node], length)

    one_end, one_length = bfs(nodes, 0)
    other_end, radius = bfs(nodes, one_end)
    return radius


def bfs(nodes, root):
    distances = [-1] * len(nodes)
    visited = [False] * len(nodes)

    distances[root] = 0
    visited[root] = True

    queue = deque()
    queue.append(root)

    while len(queue) > 0:
        curr_nodenum = queue.popleft()
        curr_node = nodes[curr_nodenum]
        for child_node, edge_len in curr_node.connected:
            child_nodenum = child_node.num

            if not visited[child_nodenum]:
                distances[child_nodenum] = distances[curr_nodenum] + edge_len
                visited[child_nodenum] = True
                queue.append(child_nodenum)

    return max(enumerate(distances), key=operator.itemgetter(1))


class Node:
    def __init__(self, num):
        self.num = num
        self.connected = []

    def add_child(self, to_node, length):
        self.connected.append((to_node, length))


if __name__ == '__main__':
    print(radius_of_tree())
