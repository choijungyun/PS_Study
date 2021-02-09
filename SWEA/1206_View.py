import sys
sys.stdin = open("input.txt")


for tc in range(1, 11):
    T = int(input())
    #빌딩 저장하기
    building = list(map(int, input().split()))
    #조망권 개수
    ans = 0

    #빌딩 마다 양 옆 확인 하기
    # 앞 뒤 제외
    for i in range(2, T-2):
        # 현재 빌딩 높이
        cur_h = building[i]
        # 양옆 두개 확인
        f = 0
        f_max = 0
        b = 0
        b_max = 0
        # 앞부분 탐색
        for idx in range(i-1, i-3, -1):
            # 앞부분에서 작으면 획득 값 찾기
            if cur_h > building[idx]:
                f+=1
            # 큰 값
            if f_max < building[idx]:
                f_max = building[idx]

        #뒷부분 탐색
        for idx in range(i+1, i+3):
            # 뒷부분에서 작은 값 찾기
            if cur_h > building[idx]:
                b+=1
            # 큰 값 갱신
            if b_max < building[idx]:
                b_max = building[idx]


        # 조망권 확보 확인
        max_val = 0
        if f==2 and b==2:
            if f_max < b_max:
                max_val = b_max
            else:
                max_val = f_max
            ans += cur_h-max_val


    print("#{} {}".format(tc, ans))

