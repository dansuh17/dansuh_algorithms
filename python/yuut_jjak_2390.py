from collections import Counter

def yut_nori():
    for _ in range(3):
        throw = input().strip()
        count = Counter(throw)

        num_ups = count['0']
        if num_ups == 0:
            print('E')
        elif num_ups == 1:
            print('A')
        elif num_ups == 2:
            print('B')
        elif num_ups == 3:
            print('C')
        elif num_ups == 4:
            print('D')

if __name__ == '__main__':
    yut_nori()

