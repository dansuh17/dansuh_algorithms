import sys

PEG_MAX_SIZE = 3
DISK_MAX_SIZE = 20

# Description:
# Time complexity:
# Space complexity:
def find(pegs_given):
    # find the target peg to build tower on
    all_disks = sorted(sum(pegs_given, []))
    max_disk = max(all_disks)
    from_peg = []
    other_peg = []

    # from-peg contains largest disk
    from_peg_idx = 0
    for idx, peg in enumerate(pegs_given):
        if len(peg) > 0 and peg[-1] == max_disk:
            from_peg_idx = idx
            from_peg = peg

    total_num_moves = 0
    to_peg_idx = 0
    while True:  # need some condition
        lowest_disk, next_disk_num, depth = find_continuous_disk(from_peg, max_disk, all_disks)
        if next_disk_num < 0:
            break  # done!

        # find from_peg
        from_peg = pegs_given[from_peg_idx]

        # find to_peg
        for i, peg in enumerate(pegs_given):
            if all_disks[next_disk_num] in peg:
                to_peg = peg
                to_peg_idx = i

        # find other peg
        for i, peg in enumerate(pegs_given):
            if i not in (to_peg_idx, from_peg_idx):
                other_peg = peg

        print(from_peg, to_peg, other_peg)

        # find number of moves to build hanoi tower from -> to
        num_moves = hanoi(depth, from_peg, to_peg, other_peg)
        print(from_peg, to_peg, other_peg, num_moves, end='\n\n')
        total_num_moves += num_moves
        from_peg_idx = to_peg_idx
        from_peg = pegs_given[from_peg_idx]

    return total_num_moves


def find_continuous_disk(peg, max_disk, all_disks):
    disk_num = all_disks.index(max_disk)
    depth = 0
    for disk in reversed(peg):
        if all_disks[disk_num] == disk:
            disk_num -= 1
            depth += 1
        else:
            break

    return all_disks[disk_num], disk_num, depth  # returns last disk that is continuously decreasing


def hanoi(n, start_peg, end_peg, other_peg):
    # move n
    if n == 1:
        end_peg.append(start_peg.pop())
        return 1

    num_moves = hanoi(n - 1, start_peg, other_peg, end_peg)
    end_peg.append(start_peg.pop())
    num_moves += 1
    num_moves += hanoi(n - 1, other_peg, end_peg, start_peg)

    return num_moves


def main():
    pegs_given = []

    for i in range(PEG_MAX_SIZE):
        pegs_given.append([])
        line = sys.stdin.readline()
        if not line:
            continue
        for num in line.split():
            pegs_given[i].append(int(num))

    print(find(pegs_given))

if __name__ == '__main__':
    main()