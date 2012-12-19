1. Apache Ant build tool is required to run the build.xml script. 
This application is tested using Ant 1.8. Earlier version of Ant should work
as well.

2. Java 1.5 or higher is required to run this application. 

3. Open system console, go to the same directory where build.xml resides, 
and execute command: ant

The default behavior of the build script is to compile the source code
and build an executable jar named mcguide.jar. This jar files is placed in dist
directory.

4. Go to dist directory, run: java -jar mcguide.jar note.txt

5. note.txt file is a test file comes with this distribution. You can replace it 
with your own file and run this application again.

6. This application is developed under Eclipse IDE. You can import this project 
into Eclipse to run the junit tests. 

7. run ant test to execute all test cases.