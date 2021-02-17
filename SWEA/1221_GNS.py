import sys
sys.stdin = open("input.txt")

# 0~9까지의 값
# 배열에 넣어두고 cnt센후 반복 출력

T = int(input())

for tc in range(1, T+1):
    # 배열에 담아두기
    planet = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]
    t, num = input().split()
    num = int(num)
    cnt = [0]*10
    planetlist = list(input().split())

    for i in range(num):
        for j in range(len(planet)):
            # 같은게 몇번 나오는지 센다
            if planet[j]==planetlist[i]:
                    cnt[j]+=1


    print("#{} ".format(tc, ))
    for i in range(10):
        # 개수만큼 출력한다.
        for j in range(cnt[i]):
            print(planet[i], end=" ")
        print()
