# Underclassmen Final

https://docs.google.com/document/d/1W8zquidLVS2BwLDJnMzpnLCin3RoEpw_Y43slHuvNpE/edit?usp=sharing


## Overview
You will implement the provided interfaces and then create your own interface and implement it. 

### Book
This assignment is based off the book Java Software Structures 3rd Edition

### Files to complete
You are expected write an implementation for each of the classes listed in **config.Configuration**. As with previous assignments, you must specify which implementation you would like us to grade in this file.

It will almost certainly be useful for you to write additional class files. Any class file you write that is used by your solution MUST  be in the provided src folder. When we test your assignment, all files not included in the src folder will be ignored.

**Note:** You may not use any of the provided Collection classes provided by the java standard API. A list of them can be seen in the “All Known Subinterfaces” and “All Known Implementing Classes” of the following URL: http://docs.oracle.com/javase/7/docs/api/java/util/Collection.html

### Test files
In the test folder, you are provided with several JUnit test cases that will help you keep on track while completing this assignment. It is recommended you run the tests often and use them as a checklist of things to do next. You are not allowed to modify these files for Parts Two and Three. If you have errors in these files, it means the structure of the files found in the src folder have been altered in a way that will cause your submission to lose points.


## Part One: Importing Project into Eclipse

Begin by cloning the project and importing it into your workspace.

You should now have a project called UnderclassmenFinal it is very important that you do not rename this project as it is used during the grading process. If the project is renamed, your assignment may not be graded.

By default, your project should have no errors and contain the following root items:<br>
**src** - The source folder where all code you are submitting must go. You can change anything you want in this folder, you can add new files, etc...<br>
**support** - This folder contains support code that we encourage you to use (and must be used to pass certain tests). You are not allowed to change or add anything in this folder<br>
**test** - The test folder where all of the public unit tests are available<br>
**JUnit 4** - A library that is used to run the test programs<br>
**JRE System Library** - This is what allows java to run

If you are missing any of the above or errors are present in the project, seek help immediately so you can get started on the project right away.

## Part Two: Create an Alien Language 						
Implement the `BlurbInterface`. Both methods must be recursive.

**Hints:** 
- Verifying a blurb might be easier to start with than generating a blurb. It will also make the test cases more helpful.
- Try and come up with good “helper” methods that lend themselves to recursion. You can’t modify the interface, but that doesn’t stop you from adding new methods. You might have a recursive method to generate a Whatzit and another one to generate a Whoozit. Then you could use those two methods to generate your blurb. This strategy can also work with isBlurb. 
- Start with the simple test cases and then try to build your way up. This may help you come up with the base cases and the recursive cases
- If you’re having trouble coming up with a recursive solution, solve it with a for loop and then translate it to a recursive solution

## Part Three: Calculate Capital Gains
**Reminder: COMMIT PART II TO GITHUB BEFORE MOVING ON!!!!!!!!**

When a share of common stock of some company is sold, the capital gain (or, sometimes, loss) is the difference between the share’s selling price and the price originally paid to buy it. This rule is easy to understand for a single share, but if we sell multiple shares of stock bought over a long period of time, then we must identify the shares actually being sold. A standard accounting principle principle for indentifying which shares of a stock were sold in such a case is to use a FIFO protocol - the shares sold are the ones that have been held the longest (this is the default method built into several personal finance software packages). For example, suppose we buy 100 shares at $20 a each on day 1, 20 shares at $24 on day 2, 200 shares at $36 on day 3, and sell 150 shares on day 4 at $30 each. Then applying the FIFO protocol means that of the 150 shares sold, 100 were bought on day 1, 20 were brought on day 2, and 30 were on day 3. The capital gain in this case would therefore be 100 * 10 + 20 * 6 + 30 * (-6), or $940. 

Implement the `CapitalGainsInterface` that allows a user to buy and sell stocks while calculating the capital gains for each sell. Your implementation must use a queue to calculate the capital gains.

**Hints:** 
- It may be helpful to create a class to associate the number of shares with the price (similar to how node associates an element with the pointer to the next node). 
- One of the more difficult test cases to pass will be `multipleBuysMultipleSells`. You’ll have to figure out how to take out part of a share while leaving the rest of the shares in their proper place in the queue. This method must run in O(1) time but think about how a helper method might assist you here. 


## Part Four: Create a Dropout Stack 
**Reminder: COMMIT PART III TO GITHUB BEFORE MOVING ON!!!!!!!!**

In Chapter 3 of L&C, the authors define a class `ArrayStack` that implements their StackADT interface. In this project you will implement a similar class called a dropout stack. A dropout stack is like an ordinary stack except that it has a fixed capacity. When a push would cause the number of elements in the stack to exceed the capacity, the push succeeds as normal but the oldest (bottom) element in the stack is discarded. Remember that conceptually a stack does not have a capacity. In order to ease the writing of test cases, you will define the `DropoutStackInterface` which will serve as the definition for a dropout stack collection.

In order to implement a dropout stack with an array and maintain O(1) time for all five stack operations, you will need to use a circular array. In a circular array x of capacity k, the first element x[0] is thought of as coming immediately after the last element x[k-1]. As we implement a series of pushes and pops without moving the mass of elements in the array, the "top" and "bottom" locations in the array, representing the top and bottom of the stack, will both move around the array in much the same way that the "top" location moves in `ArrayStack`. You can see a circular array implementation of a queue in L&C Chapter 5.

Here goes a suggested path(make a commit after each step):

1. Write a generic interface `DropoutStackInterface<T>` that defines the methods a dropout stack requires. The dropout stack interface must define all of the methods of the `StackInterface` from Postfix Evaluator, and any additional (public) methods, such as resize (see below).

2. Add a getter for `DropoutStackInterface` to the Configuration file. Right now, you can have it return null.

3. Write test cases for `DropoutStackInterface`. Include test cases for the resize method described in Step 7 below. Look at `StackInteraceTest` from PostfixEvaluator as inspiration. Don’t forget to add `NullPointerException` and `StackUnderflowException` tests. 

4. Create a generic class `ArrayDropoutStack<T>` that implements a dropout stack using a circular array. Define the constant DEFAULT_CAPACITY to be 3. This class implements the `DropoutStackInterface`.

5. Write two constructors, a zero-parameter one to create an `ArrayDropoutStack` object with the default capacity, and another with a single int parameter c that creates an object with capacity c. Remember that these constructors, like the one for `ArrayStack` in L&C, will need to use a typecast to create an array of T elements when T is a type variable.

6. Implement the methods for a stack (push, pop, isEmpty, and size) using the `ArrayStack` in Chapter 3 and the circular array queue in Chapter 5 for inspiration.

7. Write a method `public void resize(int newCapacity)` in the `ArrayDropoutStack` class. (Since it’s a public method, you’ll want to include it in the `DropoutStackInterface`). When called, this method should change the capacity of the dropout stack object to newCapacity and copy the relevant parts of old array into a new one of that size. If the new array is larger than the current size of the stack, add null entries for the new spaces. If the new array is smaller, discard enough of the oldest elements to make the rest of the stack fit into the array.

Bonus: Write a class `DynamicArrayDropoutStack` that extends `ArrayDropoutStack`. This class never discards any elements. When a push would bring it over capacity, it should double its capacity, just as `ArrayStack` does. This class provides the “illusion” of a dropout stack, while keeping all of the history. When its resize method is called, the limits of the (virtual) dropout stack change as you would expect, while the underlying array is unchanged. You will need extra variables to keep track of the dropout “window”. For example, if resize is called and the dropout size enlarges, any old data will appear again. If the dropout size shrinks, the oldest data will “drop off”, but will not be deleted. For full credit in this bonus, you must create test cases that tests this new behavior. 

## Part Five: Commit on Github
Make your final commit on Github

