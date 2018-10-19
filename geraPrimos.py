def isPrimo(num):
	for i in range(2, num):
		if num % i == 0:
			return False
	return True

saida = "{"
for i in range(1, 1000):
	if (isPrimo(i)):
		if i != 100000:
			saida += str(i) + ", "
		else:
			saida += "}"

print saida
