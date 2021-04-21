package bowling.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_NAME = "플레이어 이름은(3 english letters)?: ";
    private static final String INPUT_PIN_COUNT = "%s 프레임투구 : ";
    private static final String INPUT_PLAYER_COUNT = "How many people? ";
    private final Scanner scanner = new Scanner(System.in);
    
    public String inputName() {
        System.out.print(INPUT_NAME);
        return scanner.next();
    }

    public int inputPinCount(int frameNumber) {
        System.out.print(String.format(INPUT_PIN_COUNT, frameNumber));
        return scanner.nextInt();
    }

    public int inputPlayerCount() {
        System.out.print(INPUT_PLAYER_COUNT);
        return scanner.nextInt();
    }
}
