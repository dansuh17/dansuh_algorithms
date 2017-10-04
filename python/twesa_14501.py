"""
백준 문제 14501번 '퇴사'
https://www.acmicpc.net/problem/14501

Dynamic Programming - 인덱싱 주의!
time : O(n)
space : O(n)
"""


def twesa():
    n = int(input().strip())

    schedule = []
    for _ in range(n):
        day, price = [int(a) for a in input().strip().split()]
        schedule.append((day, price))

    # 정산은 그 다음 날에 된다고 친다
    # 예를 들어 day == 1인 날 상담을 해줬다면, 그 다음 날에 그 price가 더해진 값이 반영된다
    max_earn = [0] * (n + 1)

    for i in range(n + 1):
        if i > 0:
            max_earn[i] = max_earn[i - 1]

        for days_back in range(1, 6):
            prev_date = i - days_back

            if prev_date >= 0:
                day, price = schedule[prev_date]

                if day != days_back:  # 상담이 "끝난" 날이 아니므로 벌이가 없다
                    price = 0

                max_earn[i] = max(max_earn[i], max_earn[i - days_back] + price)
    return max_earn[n]


if __name__ == '__main__':
    print(twesa())
