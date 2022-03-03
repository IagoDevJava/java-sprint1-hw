import java.util.HashMap;

public class StepTracker {
    HashMap<Integer, MonthData> stepsForMonth = new HashMap<>();
    private int targetOfSteps = 10000;

    // создание 12ти месяцев для работы с ними
    public StepTracker() {
        for (int i = 1; i <= 12; i++) {
            stepsForMonth.put(i, new MonthData());
        }
    }

    // получение целевого значения количества шагов на день
    int getTargetOfSteps() {
        return targetOfSteps;
    }

    // ввод нового целевого значения шагов в день
    void setTargetOfSteps(int targetOfSteps) {
        this.targetOfSteps = Math.abs(targetOfSteps);
    }

    // вывод статистики за месяц
    void dataStatistics(int month) {
        System.out.println("В этом месяце Вы прошли - " + stepsForMonth.get(month).getCountPerMonth());
        System.out.println("Количество пройденных шагов по дням:");
        stepsForMonth.get(month).getCountPerEachDay();
        System.out.println("Максимальное количество шагов в день - " + stepsForMonth.get(month).maxCountStepsPerMonth());
        System.out.println("Среднее количество шагов день - " + stepsForMonth.get(month).averageCountStepsPerMonth());
        System.out.println("Пройденная за месяц дистанция - " + stepsForMonth.get(month).getDistancePerMonth());
        System.out.println("Сожжено кКал за месяц - " + stepsForMonth.get(month).getCaloriesBurnedInMonth());
        System.out.println("Лучшая серия за месяц - " + stepsForMonth.get(month).bestTrainingSeries(getTargetOfSteps()));
    }

    // Добавление количества пройденных шагов за указаный день указанного месяца
    void addCountOfStepsPerDay(int month, int day, int count) {
        if ((month > 0 && month <= 12) && (day > 0 && day <= 30) && (count > 0)) {
            stepsForMonth.get(month).setCountOfMonthData(day, count);
            stepsForMonth.put(month, stepsForMonth.get(month));
            if (count >= getTargetOfSteps()) {
                System.out.println("Цель на день выполнена!");
            } else {
                System.out.println("В следующий попробуем приложить чуть больше усилий ;)");
            }
        } else {
            System.out.println("Проверьте ввод, значения некорректны.");
        }
    }
}
