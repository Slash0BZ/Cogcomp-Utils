import random
import shutil
import os

# A file that contains all the file relative paths
# Can be acquired through tar -zxvf outputs.
File_List_Src = './file_list'
File_Src_Path = '20news-18828'

# Target path that stores training and testing data
Train_Files_Path = 'train'
Test_Files_Path = 'test'
Train_Files_Ratio = 0.9


f = open(File_List_Src, 'r')
fileMap = {}
for line in f:
	line = line.rstrip('\n')
	splits = line.split('/')
	if (splits[1] == '' or splits[2] == ''):
		continue
	tag = splits[1]
	fileName = splits[2]
	if tag in fileMap:
		fileMap.get(tag).append(fileName)
	else:
		fileMap[tag] = list()
		fileMap[tag].append(fileName)

for tag in fileMap:
	tagList = fileMap[tag]
	tagSize = len(tagList)
	trainSize = int(tagSize * Train_Files_Ratio)
	random.shuffle(tagList)
	trainList = tagList[0:trainSize]
	testList = tagList[trainSize:tagSize]
	
	for trainItem in trainList:
		copySrcPath = os.getcwd() + '/' + File_Src_Path + '/' + tag + '/' + trainItem
		copyDestDir = os.getcwd() + '/' + Train_Files_Path + '/' + tag
		if not os.path.exists(copyDestDir):
			os.makedirs(copyDestDir)
		copyDestPath = copyDestDir + '/' + trainItem
		shutil.copy2(copySrcPath, copyDestPath)

	for testItem in testList:
		copySrcPath = os.getcwd() + '/' + File_Src_Path + '/' + tag + '/' + testItem
		copyDestDir = os.getcwd() + '/' + Test_Files_Path + '/' + tag
		if not os.path.exists(copyDestDir):
			os.makedirs(copyDestDir)
		copyDestPath = copyDestDir + '/' + testItem
		shutil.copy2(copySrcPath, copyDestPath)

f.close()

