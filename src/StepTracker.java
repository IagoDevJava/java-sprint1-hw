import java.util.HashMap;

public class StepTracker {
    HashMap<Integer, MonthData> stepsForMonth = new HashMap<>();
    private int targetOfSteps = 10000;

    public StepTracker() {
        for (int i = 1; i <= 12; i++) {
            stepsForMonth.put(i, new MonthData());
        }
    }

    int getTargetOfSteps() {
        return targetOfSteps;
    }

    void setTargetOfSteps(int targetOfSteps) {
        this.targetOfSteps = Math.abs(targetOfSteps);
    }

    void dataStatistics(int month) {
        //todo
        // В задании сказано, что если текущий день — первый в месяце, то вывод статистики должен работать корректно.
        // Отсюда понимаю, что подразумевается несколько иной вид вывода статистики, но не понимаю какой именно.

        System.out.println("В этом месяце Вы прошли - " + stepsForMonth.get(month).getCountPerMonth());
        System.out.println("Количество пройденных шагов по дням:");
        stepsForMonth.get(month).getCountPerEachDay();
        System.out.println("Максимальное количество шагов в день - " + stepsForMonth.get(month).maxCountStepsPerMonth());
        System.out.println("Среднее количество шагов день - " + stepsForMonth.get(month).averageCountStepsPerMonth());
        System.out.println("Пройденная за месяц дистанция - " + stepsForMonth.get(month).getDistancePerMonth());
        System.out.println("Сожжено кКал за месяц - " + stepsForMonth.get(month).getCaloriesBurnedInMonth());
        System.out.println("Лучшая серия за месяц - " + stepsForMonth.get(month).bestTrainingSeries(getTargetOfSteps()));
    }

    void addCountOfStepsPerDay(int month, int day, int count) {
        stepsForMonth.get(month).setCountOfMonthData(day, count);
        stepsForMonth.put(month, stepsForMonth.get(month));
    }
}
