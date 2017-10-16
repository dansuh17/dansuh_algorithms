import sys

# global variables
graph = []
N = 0
MAX_N = 1000


# Description:
# Time complexity:
# Space complexity:
def solve(preferences, n):
    if trace(0, n - 1, list(), preferences):
        print('O')
    else:
        print('X')


def trace(n, limit_n, seats_taken, all_preferences):
    prefs = all_preferences[n]
    for pref in prefs:
        if n == limit_n:
            if pref not in seats_taken:
                return True
            else:
                continue

        if pref not in seats_taken:
            # take the seat
            seats_taken.append(pref)
            print(seats_taken)

            if not trace(n + 1, limit_n, seats_taken, all_preferences):
                seats_taken.pop()
                continue
            else:
                return True
        else:
            return False
    return False


if __name__ == '__main__':
    T = int(sys.stdin.readline())
    for t in range(T):
        N = int(sys.stdin.readline())
        graph = [[0] * N for _ in range(N)]
        # read inputs
        K = int(sys.stdin.readline())
        preferences = [list() for _ in range(N)]
        for _ in range(K):
            P, S = tuple(int(x) for x in sys.stdin.readline().strip().split(' '))
            graph[P][S] = 1
            preferences[P].append(S)

        print(preferences, end='\n\n')
        solve(preferences, N)
