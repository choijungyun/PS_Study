import sys
sys.stdin = open("input.txt")

T = int(input())

for tc in range(1, T+1):
    # N과 M을 입력 받는다.
    str = list(map(int, input().split()))
    N = str[0]
    M = str[1]
    numbers = list(map(int, input().split()))
    # 이웃한 M개의 합을 구한다.
    # 각각의 경우마다 합이 큰 경우, 합이 작은 경우 갱신
    max_sum = sum(numbers[0:M])
    min_sum = sum(numbers[0:M])

    # 할 수 있는 모든 부분합을 다 구하면서 값을 갱신한다.
    for i in range(N-M+1):
        cur_sum = sum(numbers[i:i+M])
        if max_sum<cur_sum:
            max_sum = cur_sum
        if min_sum>cur_sum:
            min_sum = cur_sum

    result = max_sum-min_sum

    print("#{} {}".format(tc, result))

