# IHS_MARKIT Assignment

### Problem Statement:

Find all palindromes in a string, and print them, along with their starting position and length, sorted by their length.

### GivenInput:  
```
ABCBAHELLOHOWRACECARAREYOUILOVEUEVOLIIAMAIDOINGGOOD
```
### SampleOutput:
```
ILOVEUEVOLI,26,11
RACECAR,13,7
ABCBA,0,5
IAMAI,37,5
OHO,9,3
ARA,18,3
RAR,19,3
LL,7,2
II,36,2
GG,46,2
OO,48,2
```
### Solution:

* Note - we can solve this problem by using simple for loops. it is easy learn and understand.(Brute Force Approach).
        Best Approach: Using Manacher’s algorithm.

### Sample logic:
```
    for (int i = 0; i < input.length(); i++) {
        for (int j = i + 1; j <= input.length(); j++) {
            if (isPalindrome(input.substring(i, j))) {
                palindromes.add(input.substring(i, j));
            }}}
 ```
Here we are iterating over each character until end.
*Drawback - its time complexity is O(n^3).
             if we have a large input string it takes more time to process as it need to iterate over all elements.
          
### Best Approach:

Here i came across an algorithm i,e "Manacher’s algorithm" it finds the longest palindromic substring in linear time.
so, it is far better than previous bruteforce approach.

Here we have 2 different methods 
* Generate Palindromes
* Filter Palindromes
                                 
#### 1.Generate Palindromes:
```
- Here,with the help of "Manacher’s algorithm" we will iterate over the input String to find the length of the palindrome centered at     position i and store this length in lengths[][].
                         
- one row is for storing odd lengths palindromes and another is for even lengths palindromes.
                        
- Later,we will traverse through the array lengths[][] to calculate the palindromic substrings centered at each position.
                        
- AtLast, we will store the palindromic substrings and their index positions in TreeMap as it maintains Insertion Order.
                        
- we got all palindromic substrings from the given input string.
```

#### 2. Filter Palindromes:
```
- Here, we will filter over all palindromic substrings to get required result.
- for this requirment, we will use ArrayList<String>(keyset of TreeMap)
- we will iterate all strings in the arrayList and then using "contains" method we will achive required result.
                     
```
 
 ### References:

 [IDerserve](https://www.youtube.com/watch?v=nbTSfrEfo6M&t=257s)
 [Baeldung](https://www.baeldung.com/java-palindrome-substrings)
 
                       
