def shorten():
    s = input().strip().split('-')
    result_str = ''
    for name in s:
        result_str += name[0]
    return result_str


if __name__ == '__main__':
    print(shorten())
