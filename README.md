# dansuh's Algorithm Practices

###Problem types and notation:

- 기본 알고리즘 / 기초 구현 (문제 x) : basics

- 백준 Online Judge : baekjoon

- Kakao coding challenges learning : kakao

- Kakao 2017 채용 모의고사 : kakao-mock

## Finding Rules || Brute Force

- baekjoon 2965 - 캥거루 세마리 [java](src/ThreeKangaroos.java) ([문제](https://www.acmicpc.net/problem/2965))

- baekjoon 2577 - 숫자의 개수 [java](src/HelloWorld10.java) ([문제](https://www.acmicpc.net/problem/2577))

- baekjoon 1065 [python3.6](python/hansu_1065.py) ([문제](https://www.acmicpc.net/problem/1065))

자릿수가 등차수열을 이루는 경우 찾기

- __baekjoon 10875 - 뱀__ [python3.6](python/snake_10875.py) ([문제](https://www.acmicpc.net/problem/10875))

뱀 게임에서 뱀이 언제 죽는지를 맞추는 문제

- __kakao 157 - 하노이의 탑__ [java](src/HanoiTower.java)
 ([문제](https://www.welcomekakao.com/learn/challenge_codes/157))

그 유명한 하노이의 탑 문제

## Data Structures

### Sets

- kakao-mock 7 - 스티커 떼기 [java](src/WordPuzzle.java)

String 조각을 가지고 전체 string을 최소한의 조각을 사용해서 만든다.

### Priority Queue

- baekjoon 1766 - 문제집 [java](src/PracticeBook.java) ([문제](https://www.acmicpc.net/problem/1766))

### Deque

- baekjoon 5430 - AC [java](src/AC.java) ([문제](https://www.acmicpc.net/problem/5430))

### Tree

- baekjoon 1991 - 트리 순회 [java](src/TraverseTree.java) ([문제](https://www.acmicpc.net/problem/1991))

- baekjoon 11725 - 트리의 부모 찾기 [java](src/FindingTreesParent.java) ([문제](https://www.acmicpc.net/problem/11725))

- baekjoon 1167 - 트리의 지름 [java](src/RadiusOfTree.java) [python3.6](python/radius_of_tree_1167.py)
([문제](https://www.acmicpc.net/problem/1167)) #BFS

트리에서 가장 거리가 먼 node 사이의 거리를 구하는 문제

- baekjoon 1967 - 트리의 지름 [java](src/RadiusOfTree2.java) ([문제](https://www.acmicpc.net/problem/1967))

- baekjoon 2250 - 트리의 넓이와 깊이 [java](src/TreeHeightWidth.java) ([문제](https://www.acmicpc.net/problem/2250))

- __baekjoon 1693 - 트리 색칠하기__ [java](src/ColoringTree.java) ([문제](https://www.acmicpc.net/problem/1693))

- __baekjoon 1289 - 트리의 가중치 (Putevi)__ [java](src/Putevi.java) ([문제](https://www.acmicpc.net/problem/1289))


### Union-Find

- baekjoon 10216 - Count Circle Groups (Union-Find implementation) [java](src/CountCircleGroups2.java)
 ([문제](https://www.acmicpc.net/problem/10216))

그래프에서 서로 연결되어 있는 다른(disjoint) 그래프의 개수를 세는 문제. Disjoint set의 개수를 구하는 문제이므로
Union-Find 자료구조를 활용해 풀었다.

## Sorting


### Quicksort

- basics - quicksort [python3.6](python/quicksort.py) [java](src/QuickSort.java)

### Insertion Sort

- baekjoon 9426 - 중앙값 측정 [java](src/MeasuringMedian.java) ([문제](https://www.acmicpc.net/problem/9426))

## Graph

### Breadth-First Search (BFS)

- kakao 591 [java](src/KakaoFriendsColoringBook.java) ([문제](https://www.welcomekakao.com/learn/challenges/591))

컬러링북에서 같은 색으로 연결된 영역의 크기 및 영역의 개수를 

- baekjoon 1890 - 점프 [java](src/Jump.java) ([문제](https://www.acmicpc.net/problem/1890))

지도의 왼쪽 끝부터 오른쪽 끝까지 점프해서 이동할 수 있는 경우의 수 계산 - BFS 구현 버전 (TIMEOUT 에러)

- baekjoon 2468 - 안전 영역 [python3.6](python/safe_area_2468.py) ([문제](https://www.acmicpc.net/problem/2468))

지도를 보고 물에 잠기지 않는 안전 영역의 개수를 구하는 문제

- baekjoon 1325 - 효율적인 해킹 [java](src/EffectiveHacking.java) ([문제](https://www.acmicpc.net/problem/1325))

가장 많은 컴퓨터를 감염시킬 수 있는 노드 찾기

- baekjoon 1167 - 트리의 지름 [java](src/RadiusOfTree.java) [python3.6](python/radius_of_tree_1167.py)
([문제](https://www.acmicpc.net/problem/1167)) #BFS #Tree

트리에서 가장 거리가 먼 node 사이의 거리를 구하는 문제

- baekjoon 10216 - Count Circle Groups [java](src/CountCircleGroups.java) ([문제](https://www.acmicpc.net/problem/10216))

그래프에서 서로 연결되어 있는 다른 그래프의 개수를 세는 문제

- baekjoon 14502 - 연구소 (삼성SW역량기출) [python3.6](python/research_center.py)
 ([문제](https://www.acmicpc.net/problem/14502))

벽을 3개 세워 바이러스 침투를 막을 때, 가장 많은 공간을 구할 수 있도록 하는 방법을 계산하는 문제 

### Topological Sorting

[baekjoon 2252 - 줄 세우기](src/LineUp.java) ([문제](https://www.acmicpc.net/problem/2252))

[baekjoon 1516 - 게임 개발](src/GameDevelopment.java) ([문제](https://www.acmicpc.net/problem/1516))

[baekjoon 1766 - 문제집](src/PracticeBook.java) ([문제](https://www.acmicpc.net/problem/1766))

## Dynamic Programming

[baekjoon 2293 - 동전 1](src/CoinOne.java) ([문제](https://www.acmicpc.net/problem/2293))

[baekjoon 9251 - Longest Common Subsequence](src/LCS.java) Basic ([문제](https://www.acmicpc.net/problem/9251))

[baekjoon 9252 - Longest Common Subsequence 2](src/LCS2.java) Basic ([문제](https://www.acmicpc.net/problem/9252))

__baekjoon 11066 - 파일 합치기__ [java](src/MergingFiles.java) ([문제](https://www.acmicpc.net/problem/11066))

baekjoon 1890 - 점프 [java](src/JumpDp.java) ([문제](https://www.acmicpc.net/problem/1890))

지도의 왼쪽 끝부터 오른쪽 끝까지 점프해서 이동할 수 있는 경우의 수 계산 - 다이나믹 프로그래밍으로 구현한 버전.

kakao 76 - 최적 행렬 곱셈 [java](src/MatrixMultOpt.java) ([문제](https://www.welcomekakao.com/learn/challenge_codes/76))

__kakao-mock 4 - 정사각형__ [java](src/LargestSquare.java)

0과 1로 이루어진 표에서 1로 이루어진 가장 큰 정사각형을 찾는 문제

kakao-mock 5 - 땅따먹기 [java](src/LandWar.java)

kakao-mock 6 - 스티커 떼기 [java](src/StickerSum.java)

스티커 줄에서 스티커를 몇 개 떼어 떼어낸 스티커의 합을 구하는 문제. 1차원 스티커가 원형으로 (cyclic) 연결되어 있고, 인접한 스티커는 뗄 수 없다.

kakao-mock 7 - String 만들기 [java](src/WordPuzzle.java)

String 조각을 가지고 전체 string을 최소한의 조각을 사용해서 만든다.

baekjoon 14501 - 퇴사 (삼성SW역량기출) [python3.6](python/twesa_14501.py)
 ([문제](https://www.acmicpc.net/problem/14501))

퇴사 하기 전 n 일동안 상담을 최대한 빡세게 진행해서 가장 많은 돈을 벌었을 때 그 수익 계산.

__kakao 73 - 올바른 괄호__ [java](src/RightParens.java) ([문제](https://www.welcomekakao.com/learn/challenge_codes/73))

N개의 괄호쌍을 가지고 가능한 '올바른 괄호'의 조합의 개수를 구하는 문제.

__baekjoon 1693 - 트리 색칠하기__ [java](src/ColoringTree.java) ([문제](https://www.acmicpc.net/problem/1693))


## Shortest Path Algorithms

### Bellman-Ford

baekjoon 11657 - 타임머신 [python3.6](python/time_machine_11657.py) ([문제](https://www.acmicpc.net/problem/11657))

도시 1부터 나머지 도시까지 가장 가까운 거리를 찾는 문제. 타임머신을 타고 갈 수 있어 음수 시간이 걸릴 수 있다.
음수 cycle이 존재하는 경우도 찾아낸다.

baekjoon 1865 - 웜홀 [python3.6](python/wormhole_1865.py) ([문제](https://www.acmicpc.net/problem/1865))

웜홀을 이용해 출발 지점까지 과거로 돌아갈 수 있는지를 판단하는 문제.

## Math

__kakao 73 - 올바른 괄호__ [java](src/RightParens.java) 카탈란수 (Catalan Number)
 ([문제](https://www.welcomekakao.com/learn/challenge_codes/73))

N개의 괄호쌍을 가지고 가능한 '올바른 괄호'의 조합의 개수를 구하는 문제.
카탈란수의 다른 표현이다. 카탈란수는 n + 1의 leaf node를 가진 binary tree의 개수이다.

## Easy

- baekjoon 8393 - 합 [kotlin](kotlin/src/sum.kt) ([문제](https://www.acmicpc.net/problem/8393))

- baekjoon 11720 - 숫자의 합 [go](go/sum_11720.go) ([문제](https://www.acmicpc.net/problem/11720))

- baekjoon 11721 - 열 개씩 끊어 출력하기 [go](go/split_11721.go) ([문제](https://www.acmicpc.net/problem/11721))


## 2017 Kakao Coding Test

### 1차 코딩테스트

[#1 비밀지도](src/SecretMap.java)

[#2 캐쉬](src/Cache.java)

아주 단순한 LRU 캐쉬 구현

[#3 카카오 다트 게임](src/KakaoDartGame.java)

[#4 뉴스 클러스터링](src/NewsClustering.java) - wrong answer

두 string 사이의 자카드 유사도(size(문자열 교집합) / size(문자열 합집합))를 구하는 문제

[#5 프렌즈 4 블록](src/Friends4Block.java) - wrong answer

2 x 2 블록이 같으면 터지는 게임에서 최종적으로 터지게 되는 칸 개수

[#6 셔틀버스](src/ShuttleBus.java) - wrong answer

주기적으로 운행되는 셔틀버스를 탈 수 있는 가장 늦은 시간을 구하는 문제

[#7 추석 트래픽](src/ChoosukTraffic.java)

추석 기간 동안 발생한 로그 목록 분석
