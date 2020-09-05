n = int(input())
play = input()
play = play.split()
play = [int(i) for i in play]
sum = 0
for i in range(0, n):
    if play[i] < 3:
        sum += 1
print(sum // 3)