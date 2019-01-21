"""
=== 문제 설명 ===
재환이는 흰색과 검정색 타일로 된 사각 체스판을 가지고 있습니다.
체스판의 각 행과 열의 위치를 표현할 때, 편의상 맨앞의 행과 열을 0번째로 표현합니다.

i번째 행과 j번째 열에 있는 타일의 색은 (i + j) 가 짝수일 경우 검정색이고, (i + j)가 홀수일 경우 흰색 입니다.



어떤 타일에는 체스말이 놓여있을 수 있습니다.
체스판을 표현하는 문자열 배열 board가 주어집니다.
체스말이 놓여 있을경우, board의 i번째 문자열의 j번째 문자는 'X' 로 표현됩니다.
놓여 있지 않은경우, 문자는 '.' 로 표현됩니다.



재환이는 L자 모양의 타일을 무한하게 가지고 있습니다.
L자 모양의 타일은 아래 그림과 같이 3개의 정사각형으로 구성되어 있으며,
각 정사각형의 크기는 재환이가 가지고 있는 체스판 타일의 크기와 같습니다.

■ ■
■


재환이는 아래와 같은 규칙을 만족하는 방법으로 L자 모양의 타일들을 놓고 싶습니다.
- 필요하다면, 90도 각도로 여러번 회전시켜서 놓을 수 있습니다.
- 놓여지는 L자 모양의 타일은 정확히 체스판 3개의 타일 위에 위치해야 합니다.
- L자 모양의 타일은 서로 겹칠 수 없습니다.
- 이미 체스말이 놓여있는 타일에는 놓을 수 없습니다.
- L자 모양 타일의 모서리 부분은 반드시 검정색 타일에 놓여야 합니다.



위의 규칙을 만족하며 L자 타일을 놓을때 최대로 놓을 수 있는 개수를 리턴하세요.

=== 참고 / 제약 사항 ===
board의 요소의 개수는 1개 이상 47개 이하 입니다.
board의 각 요소인 문자열의 길이는 1이상 47이하 입니다.
board의 모든 문자열 요소는 같은 길이를 가지고 있습니다.

=== 테스트 케이스 ===
1)
board = ["X.X","...","X.X"]
리턴(정답): 1

L자 모양 타일의 모서리가 위치 할 수 있는 검정색 타일은 정 가운데 한곳 밖에 없습니다.

2)
board = ["...","...","..."]
리턴(정답): 2

3)
board = ["......X.X.XXX.X.XX."]
리턴(정답): 0

4)
board = ["X.....XXX.XX..XXXXXXXXX...X.XX.XX....X",".XXXX..X..XXXXXXXX....XX.X.X.X.....XXX","....XX....X.XX..X.X...XX.X..XXXXXXX..X","XX.XXXXX.X.X..X..XX.XXX..XX...XXX.X..."]
리턴(정답): 13
"""


class Solution:
    def solution(self, board):
        return 0