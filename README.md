# CommonLetterSubjectSorter
<h3>Recruitment task</h3>

This project provides functionality for finding and sorting subjects based on the number of common letters between the subject name and the instructor's name. It can be used to analyze a list of subjects, calculate the number of common letters in their names and instructors' names, and return the top N subjects with the most common letters.

## Features

- **Calculate common letters**: Compares the subject name and instructor name to calculate the number of common letters.
- **Find top N subjects**: Sorts subjects by the number of common letters in ascending order and returns the top N subjects.

## Requirements

- **Java 16** or higher is required to run this project.

## Tech Stack

- **Java 21**
- **Maven 4.0.0**
- **jUnit 5.9.1**
- **Stream API**
- **Records**
- **Intellij IDEA**

## Structure of the code

- **Subject**: A class representing a subject, containing fields for the subject name and instructor's name.
- **SubjectResult**: A class representing a result, containing a Subject object and the number of common letters.
- **LetterCounter**: A utility class that calculates the number of letters in string.
- **CommonLetterCounter**: A utility class that calculates the number of common letters between two strings.
- **SubjectComparator**: A class that contains the main logic for finding the top subjects based on common letters.
