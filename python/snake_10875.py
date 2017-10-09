"""
백준 문제 10875번 '트리의 지름'
https://www.acmicpc.net/problem/10875

뱀게임에서 뱀이 언제 죽을지 맞추는 문제
edge case 및 사소한 계산이 겁나 짜증나는 문제

time - O(n^2)
space - O(n^2)

n = number of instructions

** Checking for 'valid cell' in the map is infeasible since the map size can be up to 10^8,
while memory limit being 256MB.
"""


def snake():
    l = int(input().strip())
    n = int(input().strip())

    instructions = []
    for _ in range(n):
        opts = input().strip().split()
        t = int(opts[0])
        direct = opts[1]
        instructions.append((t, direct))

    out_of_bound_limit = 2 * l + 1

    # if snake not dead after all instructions executed,
    # snake continues to extend until it kills itself by butting the wall
    instructions.append((out_of_bound_limit, 'L'))

    vertical_lines = [
        ((-1, -1), (out_of_bound_limit, -1)),
        ((-1, out_of_bound_limit), (out_of_bound_limit, out_of_bound_limit)),
    ]  # vertical lines that should not be crossed!

    horizontal_lines = [
        ((-1, -1), (-1, out_of_bound_limit)),
        ((out_of_bound_limit, -1), (out_of_bound_limit, out_of_bound_limit)),
    ]  # horizontal lines that should not be crossed!

    moves = [(0, 1), (-1, 0), (0, -1), (1, 0)]
    headed = 0
    moving_horizontal = True
    start_point = (l, l)
    clock = 0

    for inst in instructions:
        t, move_direction = inst
        move_delta = moves[headed]
        end_point = (start_point[0] + t * move_delta[0],
                     start_point[1] + t * move_delta[1])
        newline = (start_point, end_point)

        if moving_horizontal:
            crossing_lines = vertical_lines
            parallel_lines = horizontal_lines
        else:
            crossing_lines = horizontal_lines
            parallel_lines = vertical_lines

        # check for lines Xing
        min_dist = -1
        for line in crossing_lines:
            is_crossing, dist = crosses(line, newline, moving_horizontal, headed)

            if is_crossing:
                if min_dist == -1:
                    min_dist = dist
                else:
                    min_dist = min(min_dist, dist)

        # check for lines aligned parallel
        for line in parallel_lines:
            is_pall_xing, dist = parallel_crosses(
                line, newline, moving_horizontal, headed)

            if is_pall_xing:
                if min_dist == -1:
                    min_dist = dist
                else:
                    min_dist = min(min_dist, dist)

        # snake dead!
        if min_dist != -1:
            return clock + min_dist

        if moving_horizontal:
            horizontal_lines.append(newline)
        else:
            vertical_lines.append(newline)

        clock += t

        # changes direction every time
        moving_horizontal = not moving_horizontal
        headed = change_dir(headed, move_direction)
        start_point = end_point  # end point is the new start point


# function checking parallel lines crossing
def parallel_crosses(l1, l2, moving_horizontal, headed):
    l1_start = l1[0]
    l1_end = l1[1]
    l2_start = l2[0]
    l2_end = l2[1]
    if moving_horizontal:  # horizontal mvmt => same x-coord
        if l1_start[0] == l2_start[0]:
            if headed == 0:  # moving right
                if (l2_start[1] <= l1_start[1] <= l2_end[1]) or (l2_start[1] <= l1_end[1] <= l2_end[1]):
                    return True, min(abs(l1_start[1] - l2_start[1]), abs(l1_end[1] - l2_start[1]))
            elif headed == 2:  # moving left
                if (l2_end[1] <= l1_start[1] <= l2_start[1]) or (l2_end[1] <= l1_end[1] <= l2_start[1]):
                    return True, min(abs(l1_start[1] - l2_start[1]), abs(l1_end[1] - l2_start[1]))
    else:  # vertical mvnt => same y-coord
        if l1_start[1] == l2_start[1]:
            if headed == 1:  # moving up
                if (l2_end[0] <= l1_start[0] <= l2_start[0]) or (l2_end[0] <= l1_end[0] <= l2_start[0]):
                    return True, min(abs(l1_start[0] - l2_start[0]), abs(l1_end[0] - l2_start[0]))
            elif headed == 3:  # moving down
                if (l2_start[0] <= l1_start[0] <= l2_end[0]) or (l2_start[0] <= l1_end[0] <= l2_end[0]):
                    return True, min(abs(l1_start[0] - l2_start[0]), abs(l1_end[0] - l2_start[0]))

    return False, None


# function checking perpendicular lines crossing
def crosses(l1, l2, moving_horizontal, headed):
    # l1 is the test line, l2 is the current move trajectory
    l1_start = l1[0]
    l1_end = l1[1]
    l2_start = l2[0]
    l2_end = l2[1]

    if l1_end == l2_start:
        # connected joint
        return False, None

    if moving_horizontal:  # snake is currently moving horizontal - same x-coord
        l1_y = l1_start[1]
        l2_x = l2_start[0]

        # no chance of crossing if test line (vertical) is out of x-coord range
        if l1_start[0] < l1_end[0] and not l1_start[0] <= l2_x <= l1_end[0]:
            return False, None
        elif l1_start[0] >= l1_end[0] and not l1_end[0] <= l2_x <= l1_start[0]:
            return False, None

        if headed == 0:  # moving right
            if l2_start[1] <= l1_y <= l2_end[1]:
                return True, abs(l1_y - l2_start[1])
        elif headed == 2:  # moving left
            if l2_end[1] <= l1_y <= l2_start[1]:
                return True, abs(l1_y - l2_start[1])
    else:  # snake moving vertically - same y-coord
        l1_x = l1_start[0]
        l2_y = l2_start[1]

        # no chance of crossing if test line (horizontal) is out of y-coordinate range
        if l1_start[1] < l1_end[1] and not l1_start[1] <= l2_y <= l1_end[1]:
            return False, None
        elif l1_start[1] >= l1_end[1] and not l1_end[1] <= l2_y <= l1_start[1]:
            return False, None

        if headed == 1:  # snake moving up
            if l2_end[0] <= l1_x <= l2_start[0]:
                return True, abs(l1_x - l2_start[0])
        elif headed == 3:  # snake moving down
            if l2_start[0] <= l1_x <= l2_end[0]:
                return True, abs(l1_x - l2_start[0])

    return False, None


# change direction
def change_dir(headed, direction):
    if direction == 'L':
        headed = (headed + 1) % 4
    else:
        headed = (headed - 1) % 4
    return headed


if __name__ == '__main__':
    print(snake())
