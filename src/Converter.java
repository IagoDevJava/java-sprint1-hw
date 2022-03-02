public class Converter {
    // перевод шагов в км
    static float convertStepToKm(int countSteps) {
        return countSteps / 75.f * 100;
    }

    // перевод шагов в сожженные калории
    static float convertStepToKkal(int countSteps) {
        return (countSteps * 50.f / 1000);
    }
}
