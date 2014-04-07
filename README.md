Problem-of-Introduction
=======================

Degree of Separation

The Introduction Problem

In genteel 18th/19th century British manners, it was extremely
impolite to speak to someone without previously having been formally
introduced.  In order for two persons Algernon and Bunbury to be
formally introduced, it required a third party Cecily -- who had
already been introduced to both Algernon and Bunbury -- to introduce
them to each other.

Given a set of people, two people X and Y out of that set who wish to
speak to each other, and a list of pairs of people who are acquainted
(i.e. have already been formally introduced), find the smallest set of
people required to perform the (series of) introductions necessary to
allow X and Y to speak to each other.

Write a program embodying your solution to the problem, which runs as follows:

<PROGRAM> <INPUT.TXT> <X> <Y>

The first argument is a plain text file of acquaintance relationships
in the format:

NAME:NAME
NAME:NAME
...

The other two arguments are two names X and Y.  The program should
print the smallest number of other people required to perform the
introductions in order for X and Y to be acquainted.  (If X and Y are
already acquainted, print 0.)

Sample input file:
robert:cora
kevin:billy
cora:steve
kevin:steve