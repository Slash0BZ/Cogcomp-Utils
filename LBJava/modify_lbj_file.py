# Usage: python modify_lbj_file.py [rounds] [realFeatures?] [Algorithms]
# Note: Need to modify the line numbers and fileName for different lbj files.
import sys
fileName = './lbjava-examples/src/main/lbj/NewsGroupClassifier.lbj'

f = open(fileName, 'r')
lines = f.readlines()
f.close()

rounds = sys.argv[1]
realFeatures = sys.argv[2]
algorithm = sys.argv[3]

lines[40] = "  " + rounds + " rounds\n"

non_real_features = "  using WordFeatures, BigramFeatures\n"
real_features = "  using WordFeatures, BigramFeatures, GaussianRealFeatures\n"
if (realFeatures == 'yes'):
	lines[38] = real_features
else:
	lines[38] = non_real_features

lines[43] = "    baseLTU = new " + algorithm + "();\n"

f = open(fileName, 'w')
f.writelines(lines)

f.close()


