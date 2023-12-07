# Calculation of the frequency of symbols

[![build and test](https://github.com/agsamkin/calc-freq-sym/actions/workflows/build.yml/badge.svg?branch=main)](https://github.com/agsamkin/calc-freq-sym/actions/workflows/build.yml)

Calculating the frequency of occurrence of symbols on the given string.

### How to use

1. Clone repository
2. Run server

### Input parameters format:

The API accepts POST requests to http://localhost:8080/frequency with a "text" parameter containing a string to analyse.
Text size should be between 1 and 300.

### Output parameters format:

API returns a string of keys and values, 
where keys are the characters of the string being analysed and values are the frequency of occurrences of these 
characters in the string. The result is sorted by descending number of occurrences of a character in the given string.

### Request example:

POST http://localhost:8080/frequency
{
    "text": "abbccc"
}

### Response example: 

"c": 3, "b": 2, "a": 1