package com.lambton;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Simulation for a publications system that can save the Book/Article title
 * and the number of available copies
 *
 * @author  Omairys Uzcategui
 * @version 1.0
 * @since   2021-07-20
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Publication> publications = new ArrayList<>();
        int option;

        /*menu that allows you to select the type of publication*/
        do {
            System.out.println("\n\n          Publication Menu");
            System.out.println("--------------------------------------");
            System.out.println("1 - Add a Book");
            System.out.println("2 - Add a Article");
            System.out.println("3 - Find by Author");
            System.out.println("4 - Print all publications");
            System.out.println("5 - Find by number");
            System.out.println("6 - Article with more than 20 pages");
            System.out.println("7 - Total income");
            System.out.print("\nSelect a Menu Option or Any other to exit: ");
            try {
                Scanner sc=new Scanner(System.in);
                option = Integer.parseInt(sc.next());
                fillData(option, publications);
            } catch (NumberFormatException e) {
                option = 0;
                System.out.println(e);
            }

        } while (option == 1  || option == 2 || option == 3 || option == 4 || option == 5 || option == 6 || option == 7 );
    }

    private static double totalIncome(ArrayList<Publication> publications, int size) {
        if (size <= 0){
            return 0;
        }
        return totalIncome(publications, size - 1) + publications.get(size-1).calcIncome();
    }

    private static void fillData(int option, ArrayList<Publication> publications) {
        switch (option){
            case 1:
                insertBook(publications);
//                publications.add(new Book(11, "blancanieves", "omairys", "uzcategui", 1000.0, "disney", 20));
//                publications.add(new Book(12, "frozen", "matias", "matias", 950.75, "planeta", 50));
//                publications.add(new Book(13, "enredados", "luis", "mata", 2000.0, "disney", 100));
                break;
            case 2:
                insertArticle(publications);
//                publications.add(new Article(22, "sistema solar", "omar", "uzcategui", 10.2, "discovery", 25));
//                publications.add(new Article(23, "la luna", "jose", "mata", 11.3, "cosmo", 10));
//                publications.add(new Article(24, "la tierra", "jose", "torres", 20.2, "natgeo", 30));
                break;
            case 3:
                findAAuthor(publications);
                break;
            case 4:
                printAllPublications(publications);
                break;
            case 5:
                findByNumber(publications);
                break;
            case 6:
                articleWith(publications);
                break;
            case 7:
                //System.out.println("\nTotal income: " + totalIncome(publications, publications.size()));
                System.out.println("\nTotal income: " + NumberFormat.getCurrencyInstance().format(totalIncome(publications, publications.size())));
                break;
            default:
                break;
        }
    }

    private static void articleWith(ArrayList<Publication> publications) {
        for (Publication pub : publications) {
                if (pub instanceof Article ){
                    if (((Article) pub).getNumOfPages() > 20){
                        System.out.println("The Author: " +((Article) pub).getAuthor());
                        separator();
                    }
                }
            }
    }

    private static void findByNumber(ArrayList<Publication> publications) {
        boolean exist = false;
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter the publication number: ");
        int number = sc.nextInt();
        for (Publication pub : publications) {
            if(pub.getNumber() == number){
                if (pub instanceof Book ){
                    System.out.println("The publisher: " +((Book) pub).getPublisher());
                }else{
                    System.out.println("The Magazine Name: " +((Article) pub).getMagazineName());
                }
                exist = true;
                separator();
            }
        }
        if (!exist){
            System.out.println("The indicated author does not exist");
        }
    }

    private static void printAllPublications(ArrayList<Publication> publications) {
        for(int i = 0; i < publications.size(); i++) {
            System.out.println(publications.get(i).toString());
            separator();
        }
    }

    private static void findAAuthor(ArrayList<Publication> publications) {
        boolean exist = false;
        Scanner sc=new Scanner(System.in);
        System.out.println("\nEnter the author LastName: ");
        String author = sc.nextLine();
        for(int i = 0; i < publications.size(); i++) {
            if(publications.get(i).getAuthor().contains(author)){
                System.out.println(publications.get(i).toString());
                exist = true;
                separator();
            }
        }
        if (!exist){
                System.out.println("The indicated author does not exist");
        }
    }

    private static void separator() {
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    private static void insertBook(ArrayList<Publication> publications) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add a Book");
        separator();
        System.out.println("Insert number: ");
        int number = sc.nextInt();
        System.out.println("Insert title: ");
        String title = inputLine();
        System.out.println("Insert author: ");
        String author = inputLine();
        String[] parts = author.split(" ");
        String name = parts[0];
        String lastName = parts[1];
        System.out.println("Insert price: ");
        double price = sc.nextDouble();
        System.out.println("Insert publisher: ");
        String publisher = inputLine();
        System.out.println("Insert number Of Copies: ");
        int numOfCopies = sc.nextInt();
        publications.add(new Book(number, title, name, lastName, price, publisher, numOfCopies));
    }

    private static void insertArticle(ArrayList<Publication> publications)  {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add a Article");
        separator();
        System.out.println("Insert number: ");
        int number = sc.nextInt();
        System.out.println("Insert title: ");
        String title  = inputLine();
        System.out.println("Insert author: ");
        String author = inputLine();
        String[] parts = author.split(" ");
        String name = parts[0];
        String lastName = parts[1];
        System.out.println("Insert wage: ");
        double wage = sc.nextDouble();
        System.out.println("Insert magazine Name: ");
        String magazineName  = inputLine();
        System.out.println("Insert number Of Copies: ");
        int numOfPages = sc.nextInt();
        publications.add(new Article(number, title, name, lastName, wage, magazineName, numOfPages));
    }

    private static String inputLine() {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        return text;
    }
}
