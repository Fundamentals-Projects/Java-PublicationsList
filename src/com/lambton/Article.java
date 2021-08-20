package com.lambton;
/**
 * Simulation for a publications system that can save the Book/Article title
 * and the number of available copies
 *
 * @author  Omairys Uzcategui
 * @version 1.0
 * @since   2021-07-20
 */
public class Article extends Publication{
    private double wage;
    private String magazineName;
    private double numOfPages;
    static double PERCENT = 0.10;

    public Article(int number, String title,  String name, String lastName, double wage, String magazineName, double numOfPages) {
        super(number, title, name, lastName);
        this.wage = wage;
        this.magazineName = magazineName;
        this.numOfPages = numOfPages;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public String getMagazineName() {
        return magazineName;
    }

    public void setMagazineName(String magazineName) {
        this.magazineName = magazineName;
    }

    public double getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(double numOfPages) {
        this.numOfPages = numOfPages;
    }

    @Override
    public double calcIncome() {
        return ((wage * PERCENT) * numOfPages);
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "Article{" +
                "wage='" + wage + '\'' +
                ", magazineName='" + magazineName + '\'' +
                ", numOfPages=" + numOfPages +
                '}';
    }
}
