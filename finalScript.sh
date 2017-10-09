#!/bin/bash

# this is high level script for running the experiment

# compiling the java programs
javac NaiveRecursive.java
#javac RandomString.java
#javac generateData.java
javac TimeMeasuring.java
# generating the data set in Data10.txt file
#java generateData
filename="ThousandvshundredAGCT.txt"
IFS='
'
while read STR1
do
    read STR2
    # running the algorithm once to find the longest common subsequence
    #java NaiveRecursive $STR1 $STR2 >> output1.txt
    # this call measures the time
    java TimeMeasuring $STR1 $STR2 >> MemoizedThousandvshundredAGCTOutput.csv
done < "$filename"
