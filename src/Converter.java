public class Converter {
    static float convertStepToKm(int countSteps) {
        return countSteps / 75.f * 100;
    }

    static float convertStepToKkal(int countSteps) {
        return (countSteps * 50.f / 1000);
    }
}
