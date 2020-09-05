n = [float(input()), float(input()), float(input())]
n.sort()
a = n[-1] - n[0]
if a.is_integer():
    print(int(n[-1] - n[0]))
else:
    print(n[-1] - n[0])
