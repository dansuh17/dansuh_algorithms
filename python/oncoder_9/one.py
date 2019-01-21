"""
문제 설명
현호와 은서는 팀을 이루어 프로그래밍 대회에 참가합니다.



경기 시간은 T 분이며, 몇개의 문제가 주어집니다.

경기 시작 후 T 분이 될때까지, 언제든지 답을 제출할 수 있습니다.
i번째 문제를 해결하는 데 requiredTime의 i번째 요소만큼 시간이 걸립니다.



이 대회의 점수는 승점과 벌점으로 표시합니다.
처음 두 점수는 0입니다.



만약 경기를 시작한지 A 분만에 문제를 풀어 정답을 맞춘다면, 승점은 1만큼 증가하고 벌점은 A 만큼 증가합니다.



대회의 승자를 가리기 위해, 먼저 승점을 비교합니다.
승점이 높은 팀이 고득점자이며, 만약 승점이 같은 경우 벌점이 적은 팀이 고득점자입니다.



가장 높은 점수를 받을 수 있는 정수 배열을 리턴하세요.
리턴하는 정수 배열은 2개의 요소를 가집니다.
첫번째 요소는 승점이며, 두번재 요소는 벌점입니다.



참고 / 제약 사항
T 는 1 이상 100,000 이하의 정수입니다.
requiredTime 의 요소의 개수는 1개 이상 50개 이하입니다.
requiredTime 의 각 요소는 1 이상 100,000 이하의 정수입니다.
"""
class Solution:
    def solution(self, T, requiredTime):
        req_time_sorted = sorted(requiredTime)

        can_solve = []
        total_time = 0
        for t in req_time_sorted:
            total_time += t
            if total_time > T:
                break
            can_solve.append(t)

        num_correct = len(can_solve)
        used_time = 0
        deduce_points = 0
        for t in can_solve:
            used_time += t
            deduce_points += used_time
        return [num_correct, deduce_points]
