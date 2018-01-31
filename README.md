# dansuh's Algorithm Practices

###Problem types and notation:

- 기본 알고리즘 / 기초 구현 (문제 x) : basics

- 백준 Online Judge : baekjoon

- Kakao coding challenges learning : kakao

- Kakao 2017 채용 모의고사 : kakao-mock

## RTFM - the best algorithm

read the fucking manual

## Finding Rules || Brute Force

- __kakao 68 - n queen problem__ [python3.6](python/n_queen.py) ([문제](https://www.welcomekakao.com/learn/challenge_codes/68))

크기 n x n짜리 체스판에 퀸을 n개 놓을 수 있는 경우의 수 구하기

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

### Bubble Sort

- basics - bubble sort [python3.6](python/bubble_sort.py)

### Insertion Sort

- basics - insertion sort [python3.6](python/insertion_sort.py)

- baekjoon 9426 - 중앙값 측정 [java](src/MeasuringMedian.java) ([문제](https://www.acmicpc.net/problem/9426))

### Quicksort

- basics - quicksort [python3.6](python/quicksort.py) [java](src/QuickSort.java)

### Merge Sort

- basics - merge sort [python3.6](python/merge_sort.py)

### Heap Sort

- basics - heap sort [python3.6](python/heap_sort.py)

### Selection Sort

- basics - selection sort [python3.6](python/selection_sort.py)

## Graph

### Breadth-First Search (BFS)

- kakao 591 [java](src/KakaoFriendsColoringBook.java) ([문제](https://www.welcomekakao.com/learn/challenges/591))

컬러링북에서 같은 색으로 연결된 영역의 크기 및 영역의 개수를 

- baekjoon 1890 - 점프 [java](src/Jump.java) ([문제](https://www.acmicpc.net/problem/1890))

지도의 왼쪽 끝부터 오른쪽 끝까지 점프해서 이동할 수 있는 경우의 수 계산 - BFS 구현 버전 (TIMEOUT 에러)

- baekjoon 1167 - 트리의 지름 [java](src/RadiusOfTree.java) [python3.6](python/radius_of_tree_1167.py)
([문제](https://www.acmicpc.net/problem/1167)) #BFS #Tree

트리에서 가장 거리가 먼 node 사이의 거리를 구하는 문제

- baekjoon 10216 - Count Circle Groups [java](src/CountCircleGroups.java) ([문제](https://www.acmicpc.net/problem/10216))

그래프에서 서로 연결되어 있는 다른 그래프의 개수를 세는 문제

- baekjoon 14502 - 연구소 (삼성SW역량기출) [python3.6](python/research_center.py)
 ([문제](https://www.acmicpc.net/problem/14502))

벽을 3개 세워 바이러스 침투를 막을 때, 가장 많은 공간을 구할 수 있도록 하는 방법을 계산하는 문제 

### Topological Sorting

- baekjoon 2252 - 줄 세우기 [java](src/LineUp.java) ([문제](https://www.acmicpc.net/problem/2252))

- baekjoon 1766 - 문제집 [java](src/PracticeBook.java) ([문제](https://www.acmicpc.net/problem/1766))

## Dynamic Programming

- baekjoon 2293 - 동전 1 [java](src/CoinOne.java) ([문제](https://www.acmicpc.net/problem/2293))

- baekjoon 9251 - Longest Common Subsequence [java](src/LCS.java) Basic ([문제](https://www.acmicpc.net/problem/9251))

- baekjoon 9252 - Longest Common Subsequence 2 [java](src/LCS2.java) Basic ([문제](https://www.acmicpc.net/problem/9252))

- __baekjoon 11066 - 파일 합치기__ [java](src/MergingFiles.java) ([문제](https://www.acmicpc.net/problem/11066))

- baekjoon 1890 - 점프 [java](src/JumpDp.java) ([문제](https://www.acmicpc.net/problem/1890))

지도의 왼쪽 끝부터 오른쪽 끝까지 점프해서 이동할 수 있는 경우의 수 계산 - 다이나믹 프로그래밍으로 구현한 버전.

- kakao 76 - 최적 행렬 곱셈 [java](src/MatrixMultOpt.java) ([문제](https://www.welcomekakao.com/learn/challenge_codes/76))

__kakao-mock 4 - 정사각형__ [java](src/LargestSquare.java)

0과 1로 이루어진 표에서 1로 이루어진 가장 큰 정사각형을 찾는 문제

- kakao-mock 7 - String 만들기 [java](src/WordPuzzle.java)

String 조각을 가지고 전체 string을 최소한의 조각을 사용해서 만든다.

- baekjoon 14501 - 퇴사 (삼성SW역량기출) [python3.6](python/twesa_14501.py)
 ([문제](https://www.acmicpc.net/problem/14501))

퇴사 하기 전 n 일동안 상담을 최대한 빡세게 진행해서 가장 많은 돈을 벌었을 때 그 수익 계산.

__kakao 73 - 올바른 괄호__ [java](src/RightParens.java) ([문제](https://www.welcomekakao.com/learn/challenge_codes/73))

N개의 괄호쌍을 가지고 가능한 '올바른 괄호'의 조합의 개수를 구하는 문제.

__baekjoon 1693 - 트리 색칠하기__ [java](src/ColoringTree.java) ([문제](https://www.acmicpc.net/problem/1693))


## Basic divide and conquer

- baekjoon 7459 - k번째 숫자 *시간초과* [python3.6](python/kth_number_7459.py) ([문제](https://www.acmicpc.net/problem/7459))

큰 배열에서 k번째 숫자를 찾아내는 문제.

### Quickselect

- basics - quickselect [python3.6](python/quickselect.py)

## Shortest Path Algorithms

### Dijkstra's Shortest Path

- basics - Dijkstra [python3.6](python/dijkstra.py)

### Bellman-Ford

- basics - Bellman-Ford Algorithm [python3.6](python/bellman_ford.py)

- baekjoon 11657 - 타임머신 [python3.6](python/time_machine_11657.py) ([문제](https://www.acmicpc.net/problem/11657))

도시 1부터 나머지 도시까지 가장 가까운 거리를 찾는 문제. 타임머신을 타고 갈 수 있어 음수 시간이 걸릴 수 있다.
음수 cycle이 존재하는 경우도 찾아낸다.

- baekjoon 1865 - 웜홀 [python3.6](python/wormhole_1865.py) ([문제](https://www.acmicpc.net/problem/1865))

웜홀을 이용해 출발 지점까지 과거로 돌아갈 수 있는지를 판단하는 문제.

## Math

- swap with no temporary variables [c (arithmetic)](cpp/swap_notemp.c) [c (XOR)](cpp/swap_notemp_xor.c)

__kakao 73 - 올바른 괄호__ [java](src/RightParens.java) 카탈란수 (Catalan Number)
 ([문제](https://www.welcomekakao.com/learn/challenge_codes/73))

N개의 괄호쌍을 가지고 가능한 '올바른 괄호'의 조합의 개수를 구하는 문제.
카탈란수의 다른 표현이다. 카탈란수는 n + 1의 leaf node를 가진 binary tree의 개수이다.

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
