COMS W4701 - Artificial Intelligence 
Jonathan Voris

Josh Lieberman
jal2238
Assignment 2 - Sokoban Search Algorithm 

Programming Language Used: JavaSE-1.6
Development Environment Used: Eclipse Kepler (Build id: 20130614-0229)
Code tested on these environments: Eclipse, CLIC Lab Machines

Usage:
Make sure your puzzle file is named puzzle.txt and is in the same directory as 
the Java class files.  Compile all Java files and run SokobanTester.

jal2238@brussels:~/cs4701/assignment2$ ll
total 128
drwx------ 2 jal2238 student  4096 Oct 24 23:22 ./
drwx------ 3 jal2238 student  4096 Oct 23 23:33 ../
-rw------- 1 jal2238 student 35399 Oct 24 23:22 Actions.java
-rw------- 1 jal2238 student  5251 Oct 24 23:22 AStarEuc.java
-rw------- 1 jal2238 student  5531 Oct 24 23:22 AStarMan.java
-rw------- 1 jal2238 student  4318 Oct 24 23:22 BFS.java
-rw------- 1 jal2238 student  4315 Oct 24 23:22 DFS.java
-rw------- 1 jal2238 student   905 Oct 24 23:22 Euclidean.java
-rw------- 1 jal2238 student  4925 Oct 24 23:22 GBFSEuc.java
-rw------- 1 jal2238 student  5308 Oct 24 23:22 GBFSMan.java
-rw------- 1 jal2238 student   883 Oct 24 23:22 Manhattan.java
-rw------- 1 jal2238 student    46 Oct 24 23:22 puzzle.txt
-rw------- 1 jal2238 student   119 Oct 24 23:22 Search.java
-rw------- 1 jal2238 student  2953 Oct 24 23:22 SokobanTester.java
-rw------- 1 jal2238 student   330 Oct 24 23:22 SortQueueViaLowestCost.java
-rw------- 1 jal2238 student  2586 Oct 24 23:22 State.java
-rw------- 1 jal2238 student  4178 Oct 24 23:22 UCS.java
jal2238@brussels:~/cs4701/assignment2$ javac *.java
Note: Some input files use unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
jal2238@brussels:~/cs4701/assignment2$ ll
total 212
drwx------ 2 jal2238 student  4096 Oct 24 23:22 ./
drwx------ 3 jal2238 student  4096 Oct 23 23:33 ../
-rw------- 1 jal2238 student 12876 Oct 24 23:22 Actions.class
-rw------- 1 jal2238 student 35399 Oct 24 23:22 Actions.java
-rw------- 1 jal2238 student  4598 Oct 24 23:22 AStarEuc.class
-rw------- 1 jal2238 student  5251 Oct 24 23:22 AStarEuc.java
-rw------- 1 jal2238 student  4620 Oct 24 23:22 AStarMan.class
-rw------- 1 jal2238 student  5531 Oct 24 23:22 AStarMan.java
-rw------- 1 jal2238 student  4021 Oct 24 23:22 BFS.class
-rw------- 1 jal2238 student  4318 Oct 24 23:22 BFS.java
-rw------- 1 jal2238 student  4026 Oct 24 23:22 DFS.class
-rw------- 1 jal2238 student  4315 Oct 24 23:22 DFS.java
-rw------- 1 jal2238 student   913 Oct 24 23:22 Euclidean.class
-rw------- 1 jal2238 student   905 Oct 24 23:22 Euclidean.java
-rw------- 1 jal2238 student  4368 Oct 24 23:22 GBFSEuc.class
-rw------- 1 jal2238 student  4925 Oct 24 23:22 GBFSEuc.java
-rw------- 1 jal2238 student  4357 Oct 24 23:22 GBFSMan.class
-rw------- 1 jal2238 student  5308 Oct 24 23:22 GBFSMan.java
-rw------- 1 jal2238 student   867 Oct 24 23:22 Manhattan.class
-rw------- 1 jal2238 student   883 Oct 24 23:22 Manhattan.java
-rw------- 1 jal2238 student    46 Oct 24 23:22 puzzle.txt
-rw------- 1 jal2238 student   166 Oct 24 23:22 Search.class
-rw------- 1 jal2238 student   119 Oct 24 23:22 Search.java
-rw------- 1 jal2238 student  2688 Oct 24 23:22 SokobanTester.class
-rw------- 1 jal2238 student  2953 Oct 24 23:22 SokobanTester.java
-rw------- 1 jal2238 student   542 Oct 24 23:22 SortQueueViaLowestCost.class
-rw------- 1 jal2238 student   330 Oct 24 23:22 SortQueueViaLowestCost.java
-rw------- 1 jal2238 student  2302 Oct 24 23:22 State.class
-rw------- 1 jal2238 student  2586 Oct 24 23:22 State.java
-rw------- 1 jal2238 student  3982 Oct 24 23:22 UCS.class
-rw------- 1 jal2238 student  4178 Oct 24 23:22 UCS.java
jal2238@brussels:~/cs4701/assignment2$ java SokobanTester
Loading file puzzle.txt...
File loaded!
Welcome to Josh's Sokoban searcher!
1) Breadth first search
2) Depth first search
3) Uniform cost search
4) Greedy best first search - Manhattan Distance
5) Greedy best first search - Euclidian Distance
6) A* search - Manhattan Distance
7) A* search - Euclidian Distance
Please enter your selection:
1
Reached goal state!
Nodes generated: 338
nodes containing states that were generated previously: 0
Nodes on fringe: 140
Nodes on explored list: 338
Run time in seconds: 0.113467
Path: r, r, d, l, d, l, u, u, u, 

Classes:
Actions.java
Contains action functions, such as copying the board ArrayList, getting the 
player position, moving the player up, down, left, or right, and getting the 
box and goal locations.

AStarEuc.java
Implementation of A* search using the Euclidian Distance heuristic.

AStarMan.java
Implementation of A* search using the Manhattan Distance heuristic.

BFS.java
Implementation of Breadth First Search.

DFS.java
Implementation of Depth First Search.

Euclidean.java
Contains my Euclidean heuristic function.

GBFSEuc.java
Implementation of Greedy Best First Search using the Euclidian Distance heuristic.

GBFSMan.java
Implementation of Greedy Best First Search using the Manhattan Distance heuristic.

Manhattan.java
Contains my Manhattan Distance heuristic function.

Search.java
My search interface.

SokobanTester.java
Tester class.  Loads the text file and allows the user to select a search algorithm.

SortQueueViaLowestCost.java
Sorts a queue from lowest cost to highest.

State.java
Defines a State Object.

UCS.java
Implementation of Uniform Cost Search.

Function:
My program attempts to solve Sokoban puzzles using the required algorithms.
Unfortunatly, my implementation uses ArrayLists which causes Java to frequently
run out of memory as the program explores around 40,000 nodes.  As seen int the
test file, simple puzzles can be solved with BFS easily, but more complex
puzzles are unsolvable due to this memory issues and my node cap.  I hope that
I am able to at least receive partial credit for my algorithms.

Search cap:
I set my Search cap at 40,000 nodes.  This seemed like a good DFS cap because my 
program isunable to keep track of the max depth value.  Due to Java memory 
restrictions I was forced to implement this cap for all of my algorithms.

Heuristics:
I chose to use Manhattan Distance and Euclidian Distance as my two search 
heuristic algorithms.  My Manhattan Distance code calculates the Manhattan 
distance between all of the boxes and goals in the State, and returns the best 
possible average value (the closest box-goal combination).  My Euclidian 
Distance algorithm calcuates the Euclidian Distance by squaring the average 
values, finding the square root, and returning the best possible box-goal 
distance combination.

I believe my implementation of each search algorithm demonstrate my knowledge 
of the algorithms, but due to Java memory locations, I am unable to print out a
result for every puzzle.