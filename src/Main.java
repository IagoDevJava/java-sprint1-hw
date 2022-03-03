import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        // Переделать на while(true) - не проблема, а раньше я использовал for(;;) как бесконечный
        // while (userInput != 0) предлагает сам Яндекс в подсказке и мне лично он понравился как раз тем,
        // что уменьшает количество кода и убирает лишний case , оставляя при этом выбор в меню
        while (true) {
            printMenu();
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    System.out.println("Введите количество шагов:");
                    int countOfSteps = scanner.nextInt();
                    System.out.println("Введите номер месяца:");
                    int numberOfMonth = scanner.nextInt();
                    System.out.println("Введите номер дня:");
                    int numberOfDay = scanner.nextInt();
                    stepTracker.addCountOfStepsPerDay(numberOfMonth, numberOfDay, countOfSteps);
                    break;
                case 2:
                    System.out.println("Введите номер месяца:");
                    int numberMonth = scanner.nextInt();
                    stepTracker.dataStatistics(numberMonth);
                    break;
                case 3:
                    System.out.println("Введите новую цель на день:");
                    int targetForDayNew = scanner.nextInt();
                    stepTracker.setTargetOfSteps(targetForDayNew);
                    break;
                case 0:
                    System.out.println("Программа завершена");
                    return;
                default:
                    System.out.println("Такой команды не существует. Повторите ввод:");

            }
        }
    }

    //Вывод на печать меню
    private static void printMenu() {
        System.out.println("Что вы хотите сделать?\n" +
                "\t1 - Ввести количество шагов за определённый день;\n" +
                "\t2 - Напечатать статистику за определённый месяц;\n" +
                "\t3 - Изменить цель по количеству шагов в день;\n" +
                "\t0 - Выйти из приложения.");
    }
}

