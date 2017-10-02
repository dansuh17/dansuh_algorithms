"""
백준 문제 1065번 '한수'
https://www.acmicpc.net/problem/1065

Brute force
"""


def hansu(n):
    hansu_count = 0

    for m in range(1, n + 1):
        n_str = str(m)
        diff = None
        prev_digit = None

        for digit in n_str:
            if prev_digit is None:
                prev_digit = int(digit)
                continue

            if diff is None:
                diff = prev_digit - int(digit)
                prev_digit = int(digit)
                continue

            new_diff = prev_digit - int(digit)
            if new_diff != diff:
                break

            prev_digit = int(digit)
        else:
            hansu_count += 1

    return hansu_count


if __name__ == '__main__':
    n = int(input().strip())
    print(hansu(n))
