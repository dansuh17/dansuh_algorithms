import sys
import math

def send_coord(x, y):
    print('{} {}'.format(x, y))
    sys.stdout.flush()
    # read actually prepared coordinate
    x_prep, y_prep = [int(z) for z in input().strip().split()]
    return x_prep, y_prep

def get_dimensions(a):
    if a == 20:
        return (5, 4)
    elif a == 200:
        return (10, 20)
    else:  # create rectangle dimensions
        dim_n = 1
        dim_m = a
        for i in range(1, int(math.sqrt(a))):
            if a % i == 0:
                dim_n = i
                dim_m = a // dim_n
        if dim_n < 3:
            dim_n = 3
        if dim_m < 3:
            dim_m = 3
        return (dim_n, dim_m)

def check_filled(orchard, coord):
    n, m = coord
    not_filled_count = 0
    for x in [n - 1, n, n + 1]:
        for y in [m - 1, m, m + 1]:
            if not orchard[x - 1][y - 1]:  # index counting from 1
                not_filled_count += 1
    return not_filled_count

def coord_to_go(max_c):
    to_go = [x for x in range(2, max_c - 1, 3)]
    if len(to_go) == 0:
        to_go.append(max_c - 1)
    if to_go[-1] != max_c - 1:
        to_go.append(max_c - 1)
    return to_go

def fill_rectangle(a):
    # fill (1, 1) (1, m) (n, 1) (n, m)
    n, m = get_dimensions(a)
    # prepare orchard
    orchard = [[False for _ in range(m)] for _ in range(n)]
    # calculate center coordinates to visit
    center_coordinates = [(x, y) for y in coord_to_go(m) for x in coord_to_go(n)]
    for x, y in center_coordinates:
        not_filled = check_filled(orchard, (x, y))
        while not_filled != 0:
            for _ in range(not_filled):
                ret_x, ret_y = send_coord(x, y)
                if ret_x == 0 and ret_y == 0:
                    # done
                    return
                if ret_x == -1 and ret_y == -1:
                    raise ValueError
                orchard[ret_x - 1][ret_y - 1] = True  # prepared
            # update not_filled count
            not_filled = check_filled(orchard, (x, y))


t = int(input())
for _ in range(t):
    a = int(input())
    fill_rectangle(a)
