import math
"""
Dijkstra's shortest path algorithm 기본 구현

time - O(n^2), n = number of nodes
space - O(n)
auxiliary space - O(1)
"""


def dijkstra(vertices, adj, source):
    dist = []
    prev = []
    nodes = vertices.copy()
    for vertex in vertices:
        dist.append(math.inf)
        prev.append(None)

    dist[source] = 0
    while len(nodes) > 0:
        # pops the minimum distance node
        curr_v, curr_dist = find_min_dist_node(dist, nodes)
        nodes.remove(curr_v)

        for adj_node, length in adj[curr_v]:
            if curr_dist + length < dist[adj_node]:
                dist[adj_node] = curr_dist + length
                prev[adj_node] = curr_v

    return dist


def find_min_dist_node(dist, nodes):
    min_dist = math.inf
    min_node = -1
    for node in nodes:
        if dist[node] < min_dist:
            min_dist = dist[node]
            min_node = node
    return min_node, min_dist


if __name__ == '__main__':
    adj = []
    adj.append([(1, 7), (2, 9), (5, 14)])
    adj.append([(0, 7), (2, 10), (3, 15)])
    adj.append([(0, 9), (1, 10), (5, 2), (3, 11)])
    adj.append([(1, 15), (2, 11), (4, 6)])
    adj.append([(3, 6), (5, 9)])
    adj.append([(0, 14), (2, 2), (4, 9)])
    print(dijkstra([0, 1, 2, 3, 4, 5], adj, 0))
