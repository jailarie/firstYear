a = 2
b = 9
c = 1

discriminent = (b * b - 4 * a * c) ** 0.5
print(discriminent)

root_1 = (-b + discriminent) / (2 * a)
root_2 = (-b - discriminent) / (2 * a)

print("root 1 is", root_1)
print("root 2 is", root_2)
