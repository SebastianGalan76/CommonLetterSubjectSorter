# CommonLetterSubjectSorter
<h3>Recruitment task</h3>

This project provides functionality for finding and sorting courses based on the number of common letters between the course name and the lecturer's name. It can be used to analyze a list of courses, calculate the number of common letters in their names and lecturers' names, and return the top N courses with the most common letters.

## Features

- **Calculate common letters**: Compares the course name and lecturer name to calculate the number of common letters.
- **Find top N courses**: Sorts courses by the number of common letters in ascending order and returns the top N courses.
- **Fetching data from USOS Api**

## Requirements

- **Java 16** or higher is required to run this project.

## Tech Stack

- **Java 21**
- **Maven 4.0.0**
- **jUnit 5.9.1**
- **Stream API**
- **Records**
- **HttpClient**
- **Jackson**
- **Intellij IDEA**

## Structure of the code

- **Course**: A class representing a course, containing fields for the course name and lecturer's name.
- **CourseResult**: A class representing a result, containing a Course object and the number of common letters.
- **LetterCounter**: A utility class that calculates the number of letters in string.
- **CommonLetterCounter**: A utility class that calculates the number of common letters between two strings.
- **CourseResultContainer**: A class that contains the sorted set of CourseResult by value of commonLetters
