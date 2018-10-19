def func(a, n):
	
	t = 0
	r = n
	newt = 1
	newr = a
	while newr != 0:
		q = r / newr
		t, newt = newt, t- q*newt
		r,newr = newr, r- q*newr
		
		print r, newr, t, newt, q
	if r > 1:
		return "n"
	
	if t < 0:
		t += n
	
	return t;
	
print func(3, 352)
