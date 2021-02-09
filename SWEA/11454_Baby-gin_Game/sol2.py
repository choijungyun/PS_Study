import sys
sys.stdin = open("input.txt")

T = int(input())

def check_babygin(numbers):
    # counter = [0 for _ in range(10)]
    counter = [0]*10
    is_babygin = 0
    for number in numbers:
        counter[number] += 1

    for idx in range(len(counter)):
        # triplet check
        if counter[idx]>=3:
           counter[idx]-=3
           is_babygin += 1

        if idx < 8:
            if counter[idx] and counter[idx+1] and counter[idx+1]:
                counter[idx] -=1
                counter[idx+1] -=1
                counter[idx+2] -=1
                # 베이비진에 한걸음 다가가기
                is_babygin += 1
        # 중간 계산중에 베이비진이 등장했다면
        if is_babygin == 2:
            return 1

    if is_babygin!=2:
        return 0

for tc in range(1, T+1):
    numbers = list(map(int, input()))
    result = check_babygin(numbers)
    print("#{} {}".format(tc, result))