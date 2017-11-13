from collections import Counter

def num_nums():
    A = int(input().strip())
    B = int(input().strip())
    C = int(input().strip())

    prod = A * B * C
    counts = Counter(str(prod))

    for i in range(10):
        if str(i) in counts:
            print(counts[str(i)])
        else:
            print('0')

if __name__ == '__main__':
    num_nums()
