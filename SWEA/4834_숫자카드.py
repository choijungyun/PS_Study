import sys
sys.stdin = open("input.txt")

T = int(input())

for tc in range(1, T+1):
    #카드 체크 배열
    cnt_card = [0]*10

    N = int(input())
    cards = input()
    # 해당하는 카드가 있으면 카운트 증가
    for card in cards :
        cnt_card[int(card)]+=1
    # 초기값 세팅
    max_card = cnt_card[0]
    max_idx = 0
    # 현재카드와 비교
    for i in range(1, 10):
        cur = cnt_card[i]
        if max_card <= cur:
            max_card = cur
            max_idx = i

    print("#{} {} {}".format(tc, max_idx, max_card))

