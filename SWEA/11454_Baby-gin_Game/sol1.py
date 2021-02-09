import sys
sys.stdin = open("input.txt")

T = int(input())

def babygin(numbers):
    cnt = [0] * 12;
    rrun = 0
    triplet = 0

    for number in numbers:
        cnt[number]+=1
    # 3장씩 비교
    i = 0
    while i < 10:
        # triplet?
        if cnt[i] >= 3:
            cnt[i] -= 3
            triplet += 1
            continue
        # run? 연속적인 번호를 갖는 경우
        if cnt[i] and cnt[i + 1] and cnt[i + 2]:
            cnt[i] -= 1
            cnt[i + 1] -= 1
            cnt[i + 2] -= 1
            rrun += 1
            continue
        i += 1

    if rrun + triplet == 2:
        return 1
    else:
        return 0
for tc in range(1, T+1):
    cards = list(map(int,input()))
    result = babygin(cards)
    # 주어진 6장의 카드로 만들 수 있는 카드 만들기(카운터 배열 이용)
    print("#{} {}".format(tc, result))

