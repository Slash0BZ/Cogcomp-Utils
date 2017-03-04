import random

def genData(example_size, feature_size):
	examples = list()
	for i in range (0, example_size):
		example = list()
		for j in range (0, feature_size):
			example.append(random.uniform(-100, 100))
		examples.append(example)
	return examples

def classifyData(examples, noise):
	ret = list()
	correctNum = float(len(examples)) * (1.0 - float(noise))
	count = 0
	for e in examples:
		s = 0.0
		count = count + 1
		for i in range (0, len(e)):
			s = s + float(i) * e[i]
		if (count > correctNum):
			if (s >= 0):
				e.append(0.0)
			else:
				e.append(1.0)
		else:
			if (s >= 0):
				e.append(1.0)
			else:
				e.append(0.0)
		ret.append(e)
	return ret

def shuffleData(examples):
	random.shuffle(examples)

def writeData(example_num, feature_num, noise_percentage, output_file):
	data = classifyData(genData(example_num, feature_num), noise_percentage)
	shuffleData(data)
	fp = open(output_file, 'w')
	for d in data:
		fp.write(str(d) + "\n")
	fp.close()

writeData(500, 100, 0.2, 'data_500_100_0.2')

