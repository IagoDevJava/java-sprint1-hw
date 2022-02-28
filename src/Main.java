import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                System.out.println("Введите количество шагов:");
                int countOfSteps = scanner.nextInt();

                System.out.println("Введите номер месяца:");
                int numberOfMonth = scanner.nextInt();

                System.out.println("Введите номер дня:");
                int numberOfDay = scanner.nextInt();

                stepTracker.addCountOfStepsPerDay(numberOfMonth, numberOfDay, countOfSteps);
                if (countOfSteps >= stepTracker.getTargetOfSteps()) {
                    System.out.println("Цель на день выполнена!");
                } else {
                    System.out.println("В следующий попробуем приложить чуть больше усилий ;)");
                }
            }
            if (userInput == 2) {
                System.out.println("Введите номер месяца:");
                int numberOfMonth = scanner.nextInt();
                stepTracker.dataStatistics(numberOfMonth);
            }
            if (userInput == 3) {
                System.out.println("Введите новую цель на день:");
                int targetForDayNew = scanner.nextInt();
                stepTracker.setTargetOfSteps(targetForDayNew);
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?\n" +
                "\t1 - Ввести количество шагов за определённый день;\n" +
                "\t2 - Напечатать статистику за определённый месяц;\n" +
                "\t3 - Изменить цель по количеству шагов в день;\n" +
                "\t0 - Выйти из приложения.");
    }
}

