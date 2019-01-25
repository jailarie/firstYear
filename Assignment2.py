# -----------------------------------------+
# Jamie Winter                             |
# CSCI 107, Assignment 2                   |
# Last Updated: January 24, 2019           |
# -----------------------------------------|
# Business card allowing for input for the |
# first name, last name, job title, and    |
# email.                                   |
# -----------------------------------------+



first_name = input("What is your first name? ")
last_name = input("What is your last name? ")
job_name = input("What is your job title? ")

print(last_name + ", " + first_name)

#name = "Daniel"
# print (name.center(20))
# print (name.rjust(20))
#total is 50

name = last_name + ", " + first_name
print("12345678901234567890123456789012345678901234567890")
print("+------------------------------------------------+")
print("|                                                |")
print("|                WINTER, JAMIE                   |")
print("|  ____DB___/|   Summer Intern                   |")
print("|   (_|||_) \|   Daily Bugle                     |")
print("|                                                |")
print("|                39 Second Avenue                |")
print("|                STE 1200                        |")
print("|                NYC, NY 10019                   |")
print("|                                                |")
print("|                Email: jamie@dbugle.com         |")
print("|                                                |")
print("+------------------------------------------------+")

print("+------------------------------------------------+")
print("|".ljust(50) + "|".rjust(50))
#print("|".ljust(0) + name.center(48) + "|".rjust(50))
