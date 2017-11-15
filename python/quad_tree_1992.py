"""
백준 문제 1992번 '쿼드트리'
https://www.acmicpc.net/problem/1992

화면을 사분면으로 쪼개 분할정복.

time - O(n^2 log n)
space - O(n^2)
auxilliary space - O(1)  # can be done inline
"""
def quad_tree():
    n = int(input().strip())
    screen = []
    for _ in range(n):
        screen.append([int(c) for c in input().strip()])

    return compress(screen, start_coord=(0, 0), size=n).__str__().replace(',', '').replace(' ', '')


def compress(screen, start_coord, size):
    if is_whole(screen, start_coord, size):
        return screen[start_coord[0]][start_coord[1]]

    size //= 2
    x = start_coord[0]
    y = start_coord[1]
    new_coords = [(x, y), (x, y + size), (x + size, y), (x + size, y + size)]
    return tuple([compress(screen, coord, size) for coord in new_coords])


def is_whole(screen, start_coord, size):
    test_point = screen[start_coord[0]][start_coord[1]]
    for i in range(size):
        row_num = start_coord[0] + i
        test_row = screen[row_num][start_coord[1] : start_coord[1] + size]
        if test_row.count(test_point) != len(test_row):
            return False
    return True


if __name__ == '__main__':
    print(quad_tree())
