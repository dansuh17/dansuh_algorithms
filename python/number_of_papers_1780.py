"""
백준 문제 1780번 '종이의 개수'
https://www.acmicpc.net/problem/1780

Recursive Divide and Conquer 문제

time - O(n log n) (from sorting) O(log n) (average for binary search)
space - O(n)
auxillary space - O(1) - can be done in-place
"""
def num_papers():
    n = int(input().strip())
    paper = []
    for i in range(n):
        row = [int(c) for c in input().strip().split(' ')]
        paper.append(row)

    return split_and_count((0, 0), n, paper)


def split_and_count(coord, size, paper):
    is_whole = True
    paper_type = paper[coord[0]][coord[1]]
    for row_off in range(size):
        col_start = coord[1]
        section = paper[coord[0] + row_off][col_start:col_start + size]
        if not (section.count(section[0]) == len(section) and paper_type == section[0]):
            is_whole = False
            break

    type_counts = [0, 0, 0]

    if is_whole:
        type_counts[paper_type + 1] = 1
        return type_counts
    else:
        new_size = size // 3
        for i in range(3):
            for j in range(3):
                new_coord = (coord[0] + i * new_size, coord[1] + j * new_size)
                for idx, type_c in enumerate(split_and_count(new_coord, new_size, paper)):
                    type_counts[idx] += type_c
        return type_counts


if __name__ == '__main__':
    for p in num_papers():
        print(p)
