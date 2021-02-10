import sys
sys.stdin = open("input.txt")

T = int(input())


for tc in range(1, T+1):
    # N : 버스노선
    N = int(input())
    # N 만큼 버스 노선 종류 저장
    busline = [0]*5001 # 버스 노선은 0~ 5000사이이기 때문에

    for i in range(N):
        # A,B 받기
        A, B = map(int, input().split())
        # A~B 영역 체크, A는 B보다 같거나 큼
        for j in range(A, B+1):
            # 겹치는 것을 파악하기 위해 누적합으로 받음
            busline[j] += 1

    # p개의 버스 정류장 받기
    P = int(input())
    answer = list()
    for i in range(P):
        # 어떤 구간 원하는지
        bus = int(input())
        # 해당 구간에 몇개의 버스 노선이 지나가는 지 저장
        answer.append(str(busline[bus]))

    result = " ".join(answer)
    print("#{} {}".format(tc, result))
