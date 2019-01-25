principle = 1000
rate = 0.05
compounding_rate = 4
years = 10

amount = principle * ( 1 + rate / compounding_rate ) ** ( compounding_rate * years)

print("Ending Balance is ", amount)
