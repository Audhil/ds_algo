package _999SOLID;

public class SOLID {

    //  based on: https://www.youtube.com/watch?v=27dhFPYBcIw&t=235s&ab_channel=WhatIsIT%3FbyRamilaMurugan
    /*
     * 1. Single Responsibility Principle - each class/method should do only one operation
     * */
    //  for eg., onBindViewHolder() - should display items - avoid formatting texts inside it
    //  wrong
    private static class Employee {

        private void getEmployeeNo() {
        }

        private void generateReport() {
            //  this should not be here - we can have this separate class
        }
    }

    //  correct
    private static class EmployeeC {
        private void getEmployeeNo() {
        }
    }

    private static class Report {
        private void generateReport() {
        }
    }

    /*
     * 2. Open-Close - open for extension & closed for modification
     * */
    //  wrong way
    private static class Account {
        private int accNo;
        private float balance;

        private float calcInterest(String accType) {
            if (accType == "Regular")
                return balance * 5;
            else if (accType == "Salary")
                return balance * 3;
            else if (accType == "Kids")
                return balance * 15;
            else
                return 0;
        }
    }

    //  correct way
    private interface IAccount {
        void balance();

        float calcInterest();
    }

    //  regular account
    private class RegularAcc implements IAccount {

        @Override
        public void balance() {

        }

        @Override
        public float calcInterest() {
            return 0;
        }
    }

    //  salary account
    private class SalaryAcc implements IAccount {

        @Override
        public void balance() {

        }

        @Override
        public float calcInterest() {
            return 0;
        }
    }

    //  kids account
    private class KidsAcc implements IAccount {

        @Override
        public void balance() {

        }

        @Override
        public float calcInterest() {
            return 0;
        }
    }

    /*
     * 3. Liskov's substitution principle
     * */
    //  wrong
    private static class Apple {

        String getColor() {
            return "RED";
        }
    }

    private static class Orange extends Apple {

        @Override
        String getColor() {
            return "Orange";
        }
    }

//    public static void main(String[] args) {
//        Apple apple = new Orange();
//        System.out.println("yup color: " + apple.getColor());
//    }

    //  correct
    //  abstract class or interface
    private static abstract class Fruit {
        abstract String getColor();
    }

    //  apple
    private static class AppleIs extends Fruit {

        @Override
        String getColor() {
            return "Red";
        }
    }

    //  orange
    private static class OrangeIs extends Fruit {

        @Override
        String getColor() {
            return "Orange";
        }
    }

    public static void main(String[] args) {
        Fruit apple = new AppleIs();
        System.out.println("yup apple color is : " + apple.getColor());
        Fruit orange = new OrangeIs();
        System.out.println("yup orange color is : " + orange.getColor());
    }

    /*
     * 4. Interface segregation principle
     * */
    //  wrong
    private interface IPrinterTask {
        void print();

        void scan();

        void fax();

        void printDuplex();
    }

    private class HPLaserPrinter implements IPrinterTask {

        @Override
        public void print() {
            System.out.println("yup: print");
        }

        @Override
        public void scan() {
            System.out.println("yup: scan");

        }

        @Override
        public void fax() {
            System.out.println("yup: fax");

        }

        @Override
        public void printDuplex() {
            System.out.println("yup: printDuplex");
        }
    }

    //  this printer can do only print, scan not others
    private class InkJetPrinter implements IPrinterTask {

        @Override
        public void print() {
            System.out.println("yup: print");
        }

        @Override
        public void scan() {
            System.out.println("yup: scan");
        }

        @Override
        public void fax() {
            //throw new NotImplementedException();
        }

        @Override
        public void printDuplex() {
            //throw new NotImplementedException();
        }
    }

    //  correct
    private interface IPrinterTaskk {
        void print();

        void scan();
    }

    private interface IFaxTask {
        void fax();
    }

    private interface IPrintDuplexTask {
        void printDuplex();
    }

    private class HPLaserPrinterr implements IPrinterTaskk, IFaxTask, IPrintDuplexTask {

        @Override
        public void print() {
            System.out.println("yup: print");
        }

        @Override
        public void scan() {
            System.out.println("yup: scan");

        }

        @Override
        public void fax() {
            System.out.println("yup: fax");

        }

        @Override
        public void printDuplex() {
            System.out.println("yup: printDuplex");
        }
    }

    //  this printer can do only print, scan not others
    private class InkJetPrinterr implements IPrinterTaskk {

        @Override
        public void print() {
            System.out.println("yup: print");
        }

        @Override
        public void scan() {
            System.out.println("yup: scan");
        }
    }

    /*
     * 5. dependency inversion principle
     * */
    //  wrong
    private class Email {

        private void sendEmail() {

        }
    }

    //  email obj is created only after Notification constructor is executed - it is tightly coupled
    private class Notification {

        private Email email;

        public Notification() {
            email = new Email();
        }

        private void sendNotif() {
            email.sendEmail();
        }
    }

    //  correct
    private interface Notifier {
        void sendEmail();
    }

    private class Emaill implements Notifier {

        @Override
        public void sendEmail() {

        }
    }

    private class Notificationn {

        Notifier notifier;

        public Notificationn() {
            notifier = new Emaill();
        }

        private void sendNotif() {
            notifier.sendEmail();
        }
    }
}
