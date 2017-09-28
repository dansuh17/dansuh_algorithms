import math


"""
백준 문제 11657번 '타임머신'
https://www.acmicpc.net/problem/11657

Finding shortest path using Bellman-Ford algorithm.
"""


def time_machine():
    N, M = [int(c) for c in input().strip().split()]
    bus_map = []
    for _ in range(M):
        a, b, time = [int(c) for c in input().strip().split()]
        bus_map.append((a - 1, b - 1, time))

    # minimum distances from idx 0
    dist = [math.inf] * N
    dist[0] = 0

    # update N - 1 times the distances
    for _ in range(N - 1):
        for a, b, time in bus_map:
            if dist[a] is not math.inf and dist[a] + time < dist[b]:
                dist[b] = dist[a] + time

    # save shortest path
    shortest_path = (dist[t] if dist[t] is not math.inf else - 1 for t in range(1, N))

    # check for negative cycles
    try:
        for _ in range(N - 1):
            for a, b, time in bus_map:
                if dist[a] is not math.inf and dist[a] + time < dist[b]:
                    raise Exception  # negative cycle exists
        for i in shortest_path:
            print(i)
    except:
        print(-1)


if __name__ == '__main__':
    time_machine()
