import sys
sys.stdin = open("input.txt")

T = int(input())


for tc in range(1, T+1):
    str = list(map(int, input().split()))
    N = str[0]
    M = str[1]
    numbers = list(map(int, input().split()))

    # 초기값 세팅
    pre_sum = sum(numbers[0:M])
    max_sum = sum(numbers[0:M])
    min_sum = sum(numbers[0:M])

    # 마지막것 더하고 맨 앞에 빼는 식으로 구현
    # 최대, 최소 갱신
    for i in range(M, N):
        cur_sum = pre_sum+numbers[i]-numbers[i-M]
        if max_sum < cur_sum:
            max_sum = cur_sum
        if min_sum > cur_sum:
            min_sum = cur_sum
        pre_sum = cur_sum


    result = max_sum-min_sum

    print("#{} {}".format(tc, result))

