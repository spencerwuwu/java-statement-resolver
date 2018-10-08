# Benchmarks
We generate and collect reducer benchmarks here.

In ```collected```, we used [searchcode API](https://searchcode.com/api/) to look for reduce programs.
We first filtered out programs with complicate objects and function calls by looking at the packages
imported. Then we discarded programs with the keyword ```sum```, because we found out that a large 
number of the code we could find performs only sum.

```runnable_number``` contains the benchmarks we collected few years ago but without filtering out
```sum```.

```Self-written``` are some interesting reducer written by ourselves.

The C code ```generateor.c``` can produce random programs with if-else branches. We use the program
generated by it to test performance. Feel free to alter the code and use it in your own projects.