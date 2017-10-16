from sys import setrecursionlimit
setrecursionlimit(100001)
"""
백준 문제 2270번 '풀다만 하노이'
https://www.acmicpc.net/problem/2270

time - O(n^2)
space - O(n^2)
"""


def another_hanoi():
    n = int(input().strip())
    _ = input()
    disk_pos = [0] * n
    for peg_num in range(3):
        disks = [int(c) for c in input().strip().split()]
        for disk in disks:
            disk_pos[disk - 1] = peg_num
    min_moves = hanoi(disk_pos[n - 1], disk_pos[n - 1], n - 1, disk_pos)
    return disk_pos[n - 1] + 1, min_moves


def hanoi(src, dst, n, disk_pos):
    if n == 0:
        if src == dst:
            return 0
        else:
            disk_pos[n] = dst
            return 1

    if src == dst:
        # no need to move nth disk
        moves_to_other = 0
        # the next source is the current position of next disk
        moves_to_dst = hanoi(disk_pos[n - 1], dst, n - 1, disk_pos)
    else:
        other = 3 - (src + dst)
        moves_to_other = hanoi(disk_pos[n - 1], other, n - 1, disk_pos)
        disk_pos[n] = dst
        moves_to_other += 1
        moves_to_dst = n ** 2 - 1

    return (moves_to_other + moves_to_dst) % 1000000


if __name__ == '__main__':
    for ans in another_hanoi():
        print(ans)
