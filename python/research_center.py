from collections import deque
from itertools import combinations
from copy import deepcopy

"""
백준 문제 14502번 '연구소'
https://www.acmicpc.net/problem/14502

Brute force + BFS
"""


def research_center():
    n, m = [int(a) for a in input().strip().split()]

    viruses = []
    empty_cells = []

    map = []
    for i in range(n):
        row = [int(a) for a in input().strip().split()]
        map.append(row)

        for j, status in enumerate(row):
            if status == 0:
                empty_cells.append((i, j))
            elif status == 2:
                viruses.append((i, j))

    # pick three walls - combinations() function VERY useful!!
    max_num_empty = 0
    for three_walls in combinations(empty_cells, 3):
        new_map = deepcopy(map)

        for wall in three_walls:
            new_map[wall[0]][wall[1]] = 1

        num_empty = bfs(new_map, viruses, n, m)
        max_num_empty = max(num_empty, max_num_empty)

    return max_num_empty


# BFS for certain map configuration (put three walls)
def bfs(map, viruses, n, m):
    # CAUTION: visited[[False] * m] * n => will produce WRONG results
    visited = [[False] * m for _ in range(n)]
    offsets = [(0, 1), (1, 0), (0, -1), (-1, 0)]

    # conduct bfs on all virus coordinates
    queue = deque()
    for virus in viruses:
        queue.append(virus)

    while len(queue) > 0:
        infected = queue.popleft()
        for offset in offsets:
            new_x = infected[0] + offset[0]
            new_y = infected[1] + offset[1]

            if 0 <= new_x < n and 0 <= new_y < m:
                if map[new_x][new_y] == 0 and not visited[new_x][new_y]:
                    queue.append((new_x, new_y))
                    visited[new_x][new_y] = True
                    map[new_x][new_y] = 2

    # count the number of remaining clean area
    free_space = 0
    for row in map:
        free_space += row.count(0)

    return free_space


if __name__ == '__main__':
    print(research_center())
