import sys
sys.stdin = open("input.txt")

T = int(input())

for tc in range(1, T+1):
    N = int(input())
    numbers = list(map(int, input().split()))
    # 첫번째 값으로 초기화 한다
    min_num = numbers[0]
    max_num = numbers[0]
    # 두번째부터 값을 비교한다.
    for i in range(1, N):
        if min_num>numbers[i]:
            min_num = numbers[i]
        if max_num<numbers[i]:
            max_num = numbers[i]

    result = max_num-min_num
    print("#{} {}".format(tc, result))

