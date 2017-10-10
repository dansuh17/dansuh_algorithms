from collections import deque
"""
백준 문제 2468번 '안전 영역'
https://www.acmicpc.net/problem/2468

BFS 기초

time - O(n^2 * h)
space - O(n^2)

where
n = length of edge of map
h = possible range of rain hights
"""


def safe_area():
    n = int(input().strip())
    flood_map = []
    height_set = set()
    height_set.add(0)
    for _ in range(n):
        row = [int(a) for a in input().strip().split()]
        for h in row:
            height_set.add(h)
        flood_map.append(row)

    # no need to check all possible range of hights - only land heights
    height_sorted = sorted(height_set)
    offsets = [(0, 1), (0, -1), (1, 0), (-1, 0)]

    # calculate number of safe areas per raining height
    max_areas = 0
    for height in height_sorted:
        coordinates = ((x, y) for x in range(n) for y in range(n))
        num_area = 0
        # create new 'visited' map
        visited = [[False] * n for _ in range(n)]

        for coord in coordinates:
            if visited[coord[0]][coord[1]] or flood_map[coord[0]][coord[1]] <= height:
                continue

            # perform BFS from this coordinate
            q = deque()
            q.append(coord)
            visited[coord[0]][coord[1]] = True

            while len(q) > 0:
                this_coord = q.popleft()
                for offset in offsets:
                    next_coord_x = this_coord[0] + offset[0]
                    next_coord_y = this_coord[1] + offset[1]

                    if (0 <= next_coord_x < n and 0 <= next_coord_y < n
                        and not visited[next_coord_x][next_coord_y]
                        and flood_map[next_coord_x][next_coord_y] > height):
                        visited[next_coord_x][next_coord_y] = True
                        q.append((next_coord_x, next_coord_y))

            # update number of area
            num_area += 1
        max_areas = max(max_areas, num_area)
    return max_areas


if __name__ == '__main__':
    print(safe_area())
