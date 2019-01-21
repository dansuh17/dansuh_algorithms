"""
문제 설명
사랑하는 조카 진호와 동물원에 왔습니다.
진호는 토끼와 고양이를 무척이나 좋아합니다.
그래서 오늘은 토끼와 고양이만 살고 있는 테마 동물원에 왔습니다.


동물원에는 0부터 N-1까지의 N 마리의 동물들이 있습니다.
동물들의 키는 모두 각각 다릅니다.(키가 같은 동물은 없습니다.)



진호는 토끼와 고양이를 구별하기 위해 각각의 동물에게 다음과 같은 질문을 했습니다.

"너와 같은 종 중에서 너보다 키가 큰 동물은 몇 마리야?"



토끼는 자기보다 키가 더 큰 토끼의 수를 말해주고,
고양이는 자기보다 키가 더 큰 고양이의 수를 말해줬습니다.



answers의 i번째 요소는 i번째 동물이 한 대답입니다.
자신과 같은 종인 동물 중 자신보다 키가 큰 동물의 수를 의미 합니다.



모든 동물들이 한 대답을 기반으로 가능한 동물 구성의 가짓수를 리턴하세요.

※ i번째 동물이 토끼인 구성과 i번째 동물이 고양이인 구성은 서로 다른 구성인것을 유의하세요.

참고 / 제약 사항
answers의 요소의 개수는 1 개 이상 40 개 이하입니다.
answers의 각 요소는 0 이상 40 이하의 정수입니다.
"""
from collections import Counter


class Solution:
    def solution(self, answers):
        max_num = max(answers)
        if max_num < 0:
            return 0

        counts = Counter(answers)
        prev_count = counts[max_num]

        if prev_count > 2:
            return 0

        mult = 2
        for num_larger in range(max_num - 1, -1, -1):
            num_larger_count = counts[num_larger]
            if num_larger_count <= 0 or num_larger_count > 2:  # impossible case
                return 0
            elif num_larger_count < prev_count:  # impossible - number of larger animals cannot be reduced
                return 0

            if num_larger_count > prev_count:
                prev_count = num_larger_count

            mult *= num_larger_count
        return mult
