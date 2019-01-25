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

name = last_name + ", " + first_name

print("+------------------------------------------------+")
print("|".ljust(50) + "|".rjust(50))
print("|".ljust(50) + name.center(50) + "|".rjust(50))
