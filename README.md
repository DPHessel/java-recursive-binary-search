
# Java Recursive Binary Search

A Java console program demonstrating **recursive binary search** on a sorted array. Developed as part of CIST 2372 Java 2 coursework at Gwinnett Technical College.

## Overview

Binary search locates a target value by examining the middle element of a sorted search range. Each recursive call continues in the half that could contain the target. If the range becomes empty, the method returns `-1` to indicate that the value was not found.

## Programming Concepts

- Java methods and recursion
- Arrays and index-based searching
- Base cases and recursive calls
- Comparison and conditional logic
- Debugging recursive calls in IntelliJ IDEA

## Testing and Debugging

| Search Target | Expected Outcome |
| --- | --- |
| 8 | Target found; inspect the returned index |
| 11 | Target not found; method returns -1 |

To follow the search in IntelliJ IDEA:

1. Open the Java source file containing `recursiveBinarySearch`.
2. Set a breakpoint at the calculation of the middle index.
3. Start the program in Debug mode.
4. Enter 8 and inspect `left`, `right`, `middle`, and `target`.
5. Use Step Into to follow the recursive calls.
6. Repeat with 11 to observe the base case and -1 result.

**Note:** Binary search requires a sorted array. Comparisons must match the array's sorting order.

## How to Run

1. Clone or download this repository.
2. Open the project in IntelliJ IDEA.
3. Locate the Java class containing the `main` method.
4. Run the program.
5. Enter a search target when prompted.

If the repository includes a Maven `pom.xml`, allow IntelliJ IDEA to import the Maven project.

## Project Files

The Java source files contain the recursive binary search implementation. File names and package structure follow the original IntelliJ project.

## Author

**Deuane Hessel**  
Computer Programming — Gwinnett Technical College  
GitHub: https://github.com/DPHessel

## Note

Confirm that the uploaded source code matches the described behavior before presenting the project as completed.
