import sys
sys.stdin = open("input.txt")


for tc in range(1, 11):
    cnt = int(input())
    dump = list(map(int, input().split()))
    result = 0


    while cnt>=0:
        max_val = dump[0]
        min_val = dump[0]
        max_idx = 0
        min_idx = 0
        cnt-=1
        # 최대, 최소 갱신
        for i in range(0, len(dump)):
            # 0이면 안옮기기 때문에
            if dump[i]==0 :
                continue
            if max_val < dump[i]:
                max_val = dump[i]
                max_idx = i
            if min_val > dump[i]:
                min_val = dump[i]
                min_idx = i
        # 정답 갱신
        result = dump[max_idx] - dump[min_idx]
        # 덤프를 수행
        dump[min_idx]+=1
        dump[max_idx]-=1
        # 평탄화 완료
        if dump[min_idx]==dump[max_idx]:
            result = dump[max_idx] - dump[min_idx]
            break

    print("#{} {}".format(tc, result))

