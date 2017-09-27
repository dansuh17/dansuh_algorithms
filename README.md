# dansuh's Algorithm Practices

Problem types and notation:

- 백준 Online Judge : baekjoon

- Kakao coding challenges learning : kakao

- Kakao 2017 채용 모의고사 : kakao-mock

## Finding Rules

[baekjoon 2965 - 캥거루 세마리](src/ThreeKangaroos.java) ([문제](https://www.acmicpc.net/problem/2965))

[baekjoon 2577 - 숫자의 개수](src/HelloWorld10.java) ([문제](https://www.acmicpc.net/problem/2577))

[*kakao 157 - 하노이의 탑](src/HanoiTower.java) ([문제](https://www.welcomekakao.com/learn/challenge_codes/157))

그 유명한 하노이의 탑 문제

## Data Structures

### Sets

[kakao-mock 7 - 스티커 떼기](src/WordPuzzle.java)

String 조각을 가지고 전체 string을 최소한의 조각을 사용해서 만든다.

### Priority Queue

[baekjoon 1766 - 문제집](src/PracticeBook.java) ([문제](https://www.acmicpc.net/problem/1766))

### Deque

[baekjoon 5430 - AC](src/AC.java) ([문제](https://www.acmicpc.net/problem/5430))

### Tree

[baekjoon 1991 - 트리 순회](src/TraverseTree.java) ([문제](https://www.acmicpc.net/problem/1991))

[baekjoon 11725 - 트리의 부모 찾기](src/FindingTreesParent.java) ([문제](https://www.acmicpc.net/problem/11725))

[baekjoon 1167 - 트리의 지름](src/RadiusOfTree.java) ([문제](https://www.acmicpc.net/problem/1167))

[baekjoon 1967 - 트리의 지름](src/RadiusOfTree2.java) ([문제](https://www.acmicpc.net/problem/1967))

[baekjoon 2250 - 트리의 넓이와 깊이](src/TreeHeightWidth.java) ([문제](https://www.acmicpc.net/problem/2250))

[*baekjoon 1693 - 트리 색칠하기](src/ColoringTree.java) ([문제](https://www.acmicpc.net/problem/1693))

[*baekjoon 1289 - 트리의 가중치 (Putevi)](src/Putevi.java) ([문제](https://www.acmicpc.net/problem/1289))


### Union-Find

[baekjoon 10216 - Count Circle Groups (Union-Find implementation)](src/CountCircleGroups2.java)
 ([문제](https://www.acmicpc.net/problem/10216))

그래프에서 서로 연결되어 있는 다른(disjoint) 그래프의 개수를 세는 문제. Disjoint set의 개수를 구하는 문제이므로
Union-Find 자료구조를 활용해 풀었다.

## Sorting

### Insertion Sort

[baekjoon 9426 - 중앙값 측정](src/MeasuringMedian.java) ([문제](https://www.acmicpc.net/problem/9426))

## Graph

### Breadth-First Search (BFS)

[kakao 591](src/KakaoFriendsColoringBook.java) ([문제](https://www.welcomekakao.com/learn/challenges/591))

컬러링북에서 같은 색으로 연결된 영역의 크기 및 영역의 개수를 

[baekjoon 1890 - 점프](src/Jump.java) ([문제](https://www.acmicpc.net/problem/1890))

지도의 왼쪽 끝부터 오른쪽 끝까지 점프해서 이동할 수 있는 경우의 수 계산 - BFS 구현 버전 (TIMEOUT 에러)

[baekjoon 1325 - 효율적인 해킹](src/EffectiveHacking.java) ([문제](https://www.acmicpc.net/problem/1325))

가장 많은 컴퓨터를 감염시킬 수 있는 노드 찾기

[baekjoon 10216 - Count Circle Groups](src/CountCircleGroups.java) ([문제](https://www.acmicpc.net/problem/10216))

그래프에서 서로 연결되어 있는 다른 그래프의 개수를 세는 문제

### Topological Sorting

[baekjoon 2252 - 줄 세우기](src/LineUp.java) ([문제](https://www.acmicpc.net/problem/2252))

[baekjoon 1516 - 게임 개발](src/GameDevelopment.java) ([문제](https://www.acmicpc.net/problem/1516))

[baekjoon 1766 - 문제집](src/PracticeBook.java) ([문제](https://www.acmicpc.net/problem/1766))

## Dynamic Programming

[baekjoon 2293 - 동전 1](src/CoinOne.java) ([문제](https://www.acmicpc.net/problem/2293))

[baekjoon 9251 - Longest Common Subsequence](src/LCS.java) Basic ([문제](https://www.acmicpc.net/problem/9251))

[baekjoon 9252 - Longest Common Subsequence 2](src/LCS2.java) Basic ([문제](https://www.acmicpc.net/problem/9252))

[baekjoon 11066 - 파일 합치기](src/MergingFiles.java) ([문제](https://www.acmicpc.net/problem/11066))

[baekjoon 1890 - 점프](src/JumpDp.java) ([문제](https://www.acmicpc.net/problem/1890))

지도의 왼쪽 끝부터 오른쪽 끝까지 점프해서 이동할 수 있는 경우의 수 계산 - 다이나믹 프로그래밍으로 구현한 버전.

[kakao 76 - 최적 행렬 곱셈](src/MatrixMultOpt.java) ([문제](https://www.welcomekakao.com/learn/challenge_codes/76))

[*kakao-mock 4 - 정사각형](src/LargestSquare.java)

0과 1로 이루어진 표에서 1로 이루어진 가장 큰 정사각형을 찾는 문제

[kakao-mock 5 - 땅따먹기](src/LandWar.java)

[kakao-mock 6 - 스티커 떼기](src/StickerSum.java)

스티커 줄에서 스티커를 몇 개 떼어 떼어낸 스티커의 합을 구하는 문제. 1차원 스티커가 원형으로 (cyclic) 연결되어 있고, 인접한 스티커는 뗄 수 없다.

[kakao-mock 7 - String 만들기](src/WordPuzzle.java)

String 조각을 가지고 전체 string을 최소한의 조각을 사용해서 만든다.

[kakao 73 - 올바른 괄호](src/RightParens.java) ([문제](https://www.welcomekakao.com/learn/challenge_codes/73))

N개의 괄호쌍을 가지고 가능한 '올바른 괄호'의 조합의 개수를 구하는 문제.

[*baekjoon 1693 - 트리 색칠하기](src/ColoringTree.java) ([문제](https://www.acmicpc.net/problem/1693))

## Math

[kakao 73 - 올바른 괄호](src/RightParens.java) 카탈란수 (Catalan Number) ([문제](https://www.welcomekakao.com/learn/challenge_codes/73))

N개의 괄호쌍을 가지고 가능한 '올바른 괄호'의 조합의 개수를 구하는 문제.
카탈란수의 다른 표현이다. 카탈란수는 n + 1의 leaf node를 가진 binary tree의 개수이다.


## 2017 Kakao Coding Test

### 1차 코딩테스트

[#1 비밀지도](src/SecretMap.java)

[#2 캐쉬](src/Cache.java)

아주 단순한 LRU 캐쉬 구현

[#3 카카오 다트 게임](src/KakaoDartGame.java)

[#4 뉴스 클러스터링](src/NewsClustering.java)

두 string 사이의 자카드 유사도(size(문자열 교집합) / size(문자열 합집합))를 구하는 문제

[#5 프렌즈 4 블록](src/Friends4Block.java)

2 x 2 블록이 같으면 터지는 게임에서 최종적으로 터지게 되는 칸 개수

[#6 셔틀버스](src/ShuttleBus.java)

주기적으로 운행되는 셔틀버스를 탈 수 있는 가장 늦은 시간을 구하는 문제

[#7 추석 트래픽](src/ChoosukTraffic.java)

추석 기간 동안 발생한 로그 목록 분석