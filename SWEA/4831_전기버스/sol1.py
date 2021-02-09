import sys
sys.stdin = open("input.txt")

T = int(input())


for tc in range(1, T+1):
    busstop = list(map(int, input().split()))
    K = busstop[0]
    N = busstop[1]
    M = busstop[2]
    # 정류소 저장
    has = [0]*(N+3)
    stop = list(map(int, input().split()))
    # 정류소가 위치한 곳을 1로 저장해둠
    for i in range(len(stop)) :
        has[stop[i]] = 1

    idx = 0
    # 총 충전기 값
    cnt = 0

    # 모든 길 지나가기
    while idx<N-K :
        ch = False
        # 정류소 앞부분 탐색
        for i in range(idx+K, idx, -1):
            if has[i]==1:
                idx = i
                cnt += 1
                ch = True
                break
        # 앞부분을 다 탐색했는데도 정류소가 없을 때
        if ch==False:
            cnt = 0
            break

    print("#{} {}".format(tc, cnt))

