import java.util.Scanner;

/**
 * @author Daniel McCarthy
 * @version 1.0
 */

public class PayStub {
    private String name;
    private int anniversaryMonth;
    private int anniversaryYear;
    private int hours;
    private String title;
    private double rate;


    /**
     * @author dan
     * @version 1.0
     */
    public PayStub() {

    }

    /**
     * new paystub.
     *
     * @param n  name
     * @param am anniversary month
     * @param ay anniversary year
     * @param h  hours
     * @param t  title
     * @param r  rate
     */

    public PayStub(String n, int am, int ay, int h, String t, double r) {
        name = n;
        anniversaryMonth = am;
        anniversaryYear = ay;
        hours = h;
        title = t;
        rate = r;
    }

    /**
     * gets name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * gets month.
     *
     * @return month
     */
    public int getMonth() {
        return anniversaryMonth;
    }

    /**
     * gets the year.
     *
     * @return year
     */
    public int getYear() {
        return anniversaryYear;
        // getter method
    }

    /**
     * gets the title.
     *
     * @return title
     */
    public String getTitle() {
        return title;

    }

    /**
     * gets the pay rate.
     *
     * @return rate
     */
    public double getPayRate() {
        return rate;
    }

    /**
     * gets the hours.
     *
     * @return hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * calculates the months worked.
     *
     * @return monthsWorked
     */

    public int numMonthsWorked() {
        int monthsWorked;
        monthsWorked = (2019 - anniversaryYear) * 12;
        monthsWorked = monthsWorked + (1 - anniversaryMonth);
        // current pay period is January 2019
        return monthsWorked;

    }

    /**
     * calculates vacation hours earned.
     *
     * @return vacaHours
     */
    public double vacationHours() {
        double vacaHours;
        vacaHours = numMonthsWorked() * 8.25;
        return vacaHours;
    }

    /**
     * calculates the gross pay.
     *
     * @return gross
     */
    public double grossPay() {
        double gross;
        gross = getHours() * getPayRate();
        return gross;
    }

    /**
     * calculates the retirement fund.
     *
     * @return ret
     */
    public double retHold() {
        double ret;
        ret = grossPay() * 0.052;
        // retirement is 2.8%
        return ret;
    }

    /**
     * calculates the tax.
     *
     * @return tax
     */
    public double tax() {
        double tax;
        tax = (grossPay() - retHold()) * 0.28;
        // tax is 28%
        return tax;

    }

    /**
     * calculates the net pay.
     *
     * @return net
     */
    public double netPay() {
        double net = grossPay() - retHold() - tax();
        return net;
    }

    /**
     * draws logo.
     */
    public void drawLogo() {
        System.out.println("      Gekko & Co.");
        System.out.println();
        System.out.println("          \"$\"");
        System.out.println("          ~~~");
        System.out.println("         /  \\ `.");
        System.out.println("        /    \\  /");
        System.out.println("       /_ _ _ \\/");
        System.out.println();

    }

    /**
     * prints info.
     */
    public void printInfo() {
        System.out.println("Pay Period:     1/2019");
        System.out.print("Name:           ");
        System.out.println(getName());
        System.out.print("Title:          ");
        System.out.println(getTitle());
        System.out.print("Anniversary:    ");
        System.out.print(getMonth());
        System.out.println("/" + getYear());
        System.out.print("Months Worked:  ");
        System.out.println(numMonthsWorked() + " months");
        System.out.print("Vacation hours: ");
        System.out.printf("%.2f", vacationHours());
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.print("Gross Pay:     $");
        System.out.printf("%7.2f", grossPay());
        System.out.println();
        System.out.print("Retirement:    $");
        System.out.printf("%7.2f", retHold());
        System.out.println();
        System.out.print("Tax:           $");
        System.out.printf("%7.2f", tax());
        System.out.println();
        System.out.println("------------------------");
        System.out.print("Net Pay:       $");
        System.out.printf("%7.2f", netPay());
        System.out.println();
        System.out.println("==========================================");
    }

    /**
     * main method.
     *
     * @param args main
     */
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        // scanner named scnr
        String name;
        String wreck;
        // made so it doesn't skip the next input
        int anniversaryMonth;
        int anniversaryYear;
        int hours;
        String title;
        double rate;
        System.out.print("Enter your Fullname: ");
        name = scnr.nextLine();
        System.out.print("Enter your Anniversary Month(1-12): ");
        anniversaryMonth = scnr.nextInt();
        System.out.print("Enter your Anniversary Year: ");
        anniversaryYear = scnr.nextInt();
        System.out.print("Enter your hours worked this pay period(0-350): ");
        hours = scnr.nextInt();
        wreck = scnr.nextLine();
        System.out.print("Enter your Job Title: ");
        title = scnr.nextLine();
        System.out.print("Enter your pay rate: ");
        rate = scnr.nextDouble();

        PayStub b = new PayStub(name, anniversaryMonth, anniversaryYear, hours, title, rate);
        System.out.println("==========================================");
        b.drawLogo();
        System.out.println("------------------------------------------");
        // prints the logo
        b.printInfo();
        // prints all the info
    }


}
