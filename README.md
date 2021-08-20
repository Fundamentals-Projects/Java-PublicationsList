# Java-PublicationsList

We have information about publications of two types: book and article, where each of them has a number, title, author (first name, last name). The book has a price, publisher and number of copies, the article has a wage, and magazine name, number of pages.
When enter the details of the publication the user must enter the full name of the author as one String but the system will divide it into first name and last name.
Besides creating the constructors, getters, setters and toString we need to create a method for calculating the author income as following:
For the book its price*number of copies - 20% gotes to the publisher
For the article it's 10% of the wage * number of pages

In the application create a list of publications (books and articles) and let the user enter their data, you should use ArrayList not array. Then do the following:
1.	Let the user enter a last name of an author and print out the details of all their publications either a book or an article. 
2.	Using a recursive method find the total income for all authors.
3.	Enter a publication number, find it then if its a book print the publisher, if an article print the magazine name.
4.	Print out first and last name of any author has an article with more than 20 pages.
