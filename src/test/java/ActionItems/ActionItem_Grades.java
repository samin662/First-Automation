package ActionItems;


import java.util.Scanner;
public class ActionItem_Grades {
    public static void main(String[] args) {
        int grade;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the grade");
        grade = input.nextInt();

                if (grade >= 90 &&  grade <= 100) {
                    System.out.print("Your grade is A"); }
                else if (grade >= 80 && grade < 90) {
                    System.out.println("Your grade is B ");
                }
                else if (grade >= 70 && grade < 80) {
                    System.out.println("Your grade is C");
                }
                else if (grade >= 60 && grade < 70) {
                    System.out.println("Your grade is D ");
                }
                else {
                    System.out.println("Your grade is F ");
                }
            }
        }



