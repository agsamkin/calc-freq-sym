# Calculation of the frequency of symbols

[![build and test](https://github.com/agsamkin/calc-freq-sym/actions/workflows/build.yml/badge.svg?branch=main)](https://github.com/agsamkin/calc-freq-sym/actions/workflows/build.yml)

### How to use

1. Clone repository
2. Start server

### Input parameters format

The API accepts GET requests to http://localhost:8080/calc with an "input" parameter containing a string to analyse.
The analysed string must meet the following constraints:
- String must not be empty
- String cannot be longer than 20 characters
- String must contain only latin letters

Request example: http://localhost:8080/calc?&input=abbccc

### Output parameters format

API returns a string of keys and values, 
where keys are the characters of the string being analysed and values are the frequency of occurrences of these 
characters in the string. The result is sorted by descending number of occurrences of a character in the given string.

Response example: "c": 3, "b": 2, "a": 1