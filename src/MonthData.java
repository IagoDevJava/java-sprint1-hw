import java.util.HashMap;

public class MonthData {

    HashMap<Integer, Integer> countOfStepsForMonth = new HashMap<>();

    public MonthData() {
        for (int i = 1; i <= 30; i++) {
            countOfStepsForMonth.put(i, 0);
        }
    }

    void setCountOfMonthData(int day, int number) {
        countOfStepsForMonth.put(day, number);
    }

    void getCountPerEachDay() {
        for (Integer day : countOfStepsForMonth.keySet()) {
            System.out.println(day + " день: " + countOfStepsForMonth.get(day) + ",");
        }
    }

    int maxCountStepsPerMonth() {
        int maxCountSteps = 0;
        for (Integer day : countOfStepsForMonth.keySet()) {
            if (countOfStepsForMonth.get(day) > maxCountSteps) {
                maxCountSteps = countOfStepsForMonth.get(day);
            }
        }
        return maxCountSteps;
    }

    float averageCountStepsPerMonth() {
        float totalStepsForMonth = 0;
        for (Integer day : countOfStepsForMonth.keySet()) {
            totalStepsForMonth += countOfStepsForMonth.get(day);
        }
        return totalStepsForMonth / 30;
    }

    int getCountPerMonth() {
        int totalStepsForMonth = 0;
        for (Integer day : countOfStepsForMonth.keySet()) {
            totalStepsForMonth += countOfStepsForMonth.get(day);
        }
        return totalStepsForMonth;
    }

    float getDistancePerMonth() {
        return Converter.convertStepToKm(getCountPerMonth());
    }

    float getCaloriesBurnedInMonth() {
        return Converter.convertStepToKkal(getCountPerMonth());
    }

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
