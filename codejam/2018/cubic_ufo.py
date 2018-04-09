import math

sqrt_2 = math.sqrt(2)
ninety_deg_radian = math.pi / 2
ff_deg = math.pi / 4

def coords_to_string(xy, xz, yz):
    ret = ''
    ret += '{} {} {}\n'.format(xy[0], xy[1], xy[2])
    ret += '{} {} {}\n'.format(xz[0], xz[1], xz[2])
    ret += '{} {} {}'.format(yz[0], yz[1], yz[2])
    return ret

def solve(a):
    # if a <= sqrt_2:
    theta = math.asin(a / sqrt_2) - ff_deg
    xz_center = (math.cos(ninety_deg_radian - theta) / 2, math.sin(ninety_deg_radian - theta), 0)
    yz_center = (math.cos(theta) / -2, math.sin(theta) / 2, 0)
    xy_center = (0, 0, 0.5)
    return coords_to_string(xz_center, yz_center, xy_center)

t = int(input())
for i in range(1, t + 1):
    a = float(input())
    ret = solve(a)
    print('Case #{}:\n{}'.format(i, ret))
