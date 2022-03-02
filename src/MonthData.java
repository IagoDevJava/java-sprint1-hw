import java.util.HashMap;

public class MonthData {

    HashMap<Integer, Integer> countOfStepsForMonth = new HashMap<>();

    //создание каждого из 12ти месяцев и заполнение значений количества шагов нулями
    public MonthData() {
        for (int i = 1; i <= 30; i++) {
            countOfStepsForMonth.put(i, 0);
        }
    }

    // ввод количества пройденных за день заданного месяца шагов
    void setCountOfMonthData(int day, int number) {
        countOfStepsForMonth.put(day, number);
    }

    // получение статистики шагов по дням за месяц
    void getCountPerEachDay() {
        for (Integer day : countOfStepsForMonth.keySet()) {
            System.out.println(day + " день: " + countOfStepsForMonth.get(day) + ",");
        }
    }

    // получение максимального количества шагов в день за месяц
    int maxCountStepsPerMonth() {
        int maxCountSteps = 0;
        for (Integer day : countOfStepsForMonth.keySet()) {
            if (countOfStepsForMonth.get(day) > maxCountSteps) {
                maxCountSteps = countOfStepsForMonth.get(day);
            }
        }
        return maxCountSteps;
    }

    // получение среднего количества шагов в день за месяц
    float averageCountStepsPerMonth() {
        float totalStepsForMonth = 0;
        for (Integer day : countOfStepsForMonth.keySet()) {
            totalStepsForMonth += countOfStepsForMonth.get(day);
        }
        return totalStepsForMonth / 30;
    }

    // получение общего количества шагов за месяц
    int getCountPerMonth() {
        int totalStepsForMonth = 0;
        for (Integer day : countOfStepsForMonth.keySet()) {
            totalStepsForMonth += countOfStepsForMonth.get(day);
        }
        return totalStepsForMonth;
    }

    // получение пройденной за месяц дистанции
    float getDistancePerMonth() {
        return Converter.convertStepToKm(getCountPerMonth());
    }

    // получение сожженных за месяц калорий
    float getCaloriesBurnedInMonth() {
        return Converter.convertStepToKkal(getCountPerMonth());
    }

    // получение лучщей серии из дней, выполняющих условиям целевого знавчения, в месяце
    int bestTrainingSeries(int target) {
        int countDay = 0;
        int countDaySeries = 0;
        for (Integer day : countOfStepsForMonth.keySet()) {
            if (countOfStepsForMonth.get(day) >= target) {
                countDay++;
            } else if (countOfStepsForMonth.get(day) > 0) {
                countDaySeries = countDay;
                countDay = 0;
            }
        }
        return countDaySeries;
    }
}
