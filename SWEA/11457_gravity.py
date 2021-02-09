import sys
sys.stdin = open("input.txt")

T = int(input())

def solve(box):
    max_gravity = 0
    for i in range(len(box)):
        # 박스가 없으면 pass
        if box[i]== 0 :
            continue
        # 현재 기준 최대 중력
        box_gravity = len(box) - i - 1
        # 자신의 오른쪽의 상자수와 비교
        # 자신보다 크면 낙하될 수 없기 때문에
        for j in range(i+1, len(box)):
            if box[i]<=box[j]:
                box_gravity-=1
        # 지금까지의 최대 중력과 비교해 갱신
        if box_gravity > max_gravity:
             max_gravity = box_gravity
    return max_gravity

for tc in range(1, T+1):
    N  = int(input())
    box = list(map(int, input().split()))
    result = solve(box)
    print("#{} {}".format(tc, result))

