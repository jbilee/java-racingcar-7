package racingcar;

import racingcar.validators.CarInputValidator;
import racingcar.validators.RoundInputValidator;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        String carInput = view.getCarInput();

        CarInputValidator carInputValidator = new CarInputValidator();
        carInputValidator.validate(carInput);

        String roundInput = view.getRoundInput();

        RoundInputValidator roundInputValidator = new RoundInputValidator();
        roundInputValidator.validate(roundInput);

        List<String> carNames = Arrays.asList(carInput.split(","));
        List<Car> cars = carNames.stream().map(Car::new).toList();

        System.out.println("\n실행 결과");
        for (int i = 0; i < Integer.parseInt(roundInput); i++) {
            for (Car car : cars) {
                boolean isMovable = car.isMovable(Randomizer.getRandomValue());
                if (isMovable) {
                    car.moveForward();
                }
            }
            cars.forEach(Car::printMoves);
            System.out.println();
        }
    }
}
