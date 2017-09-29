import math

"""
백준 문제 1865번 '웜홀'
https://www.acmicpc.net/problem/1865

Checking negative cycles in a graph using Bellman-Ford algorithm.

time complexity : O(nm)
space complexity : O(n + m)
n = number of nodes, m = number of edges
"""


def wormhole():
    n, m, w = [int(c) for c in input().strip().split()]

    edges = []
    for _ in range(m):
        start, end, time = [int(c) for c in input().strip().split()]
        edges.append((start - 1, end - 1, time))
        edges.append((end - 1, start - 1, time))

    for _ in range(w):
        start, end, time = [int(c) for c in input().strip().split()]
        edges.append((start - 1, end - 1, -time))

    # first iterate n - 1 times, to calculate the shortest paths to each nodes
    dist = [math.inf] * n
    dist[0] = 0
    for _ in range(n - 1):
        for start, end, time in edges:
            dist[end] = min(dist[start] + time, dist[end])  # note that min() takes some time...

    # iterate once more to check the existence of negative cycle
    for start, end, time in edges:
        if min(dist[start] + time, dist[end]) != dist[end]:
            print('YES')
            return
    else:
        print('NO')
        return


if __name__ == '__main__':
    t = int(input().strip())
    for _ in range(t):
        wormhole()
