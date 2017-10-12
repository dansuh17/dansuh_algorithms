"""
카카오 문제 70번 '숫자 블록'
https://www.welcomekakao.com/learn/challenge_codes/70

time - O(nm)
space - O(n + m)

n = max candidate
m = end - begin
"""


def numberBlock(begin, end):
    # finding the largest integer denominator
    max_candidate = 10000000
    to_know = end - begin + 1
    block_signs = [0] * to_know
    block_nums = set(range(begin, end + 1))

    for test_int in range(max_candidate, 0, -1):
        to_remove = []
        for block_num in block_nums:
            if block_num % test_int == 0:
                block_signs[block_num - begin] = test_int
                to_remove.append(block_num)

        for r in to_remove:
            block_nums.remove(r)

        if len(block_nums) == 0:
            break

    return block_signs


# 아래는 테스트로 출력해 보기 위한 코드입니다.
print(numberBlock(99999999999990, 100000000000000))
