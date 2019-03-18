
package com.company;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
// this program is meant to allow the user to enter date input of month/day
// user will enter their birth date or one of their choosing
// user will receive answer of how many days until next birthday


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LocalDate today = LocalDate.now();


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");


        String textToday = today.format(formatter);
        System.out.println("Today's date is: " + textToday);


        System.out.println("What month were you born in? (Enter as number: January = 1)");
        int myMonth = scanner.nextInt();
        System.out.println("What day were you born? ");
        int myDay = scanner.nextInt();
        int myYear = today.getYear();
        int thisMonth = today.getMonthValue();


        LocalDate birthday = LocalDate.of(myYear,myMonth,myDay);
        int doy = birthday.getDayOfYear();



        if (doy < today.getDayOfYear()){
            birthday = birthday.plusYears(1);
        }


        String nextBirthday = birthday.format(formatter);

        long daysToBirthday = today.until(birthday, ChronoUnit.DAYS);

        if (myMonth == thisMonth && myDay == today.getDayOfMonth() ){
            System.out.println("Happy Birthday!");
        }
        else {
            System.out.println("Your next birthday is: " + nextBirthday);
            System.out.println("There are " + daysToBirthday + " days till your next birthday!");
        }

    }
}
