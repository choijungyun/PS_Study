import sys
sys.stdin = open("input.txt")

T = int(input())

for tc in range(1, T+1):
    tcnt = int(input())
    grade_cnt = [0]*101
    grades = list(map(int, input().split()))
    for grade in grades:
        grade_cnt[grade]+=1

    #max값 찾기
    max_grade = 0
    max_id = 0

    for i in range(101):
          if max_grade <= grade_cnt[i]:
              max_grade = grade_cnt[i]
              max_id = i
    print("#{} {}".format(tc, max_id))


