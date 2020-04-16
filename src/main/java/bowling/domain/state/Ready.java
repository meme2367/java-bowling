package bowling.domain.state;

import static bowling.Constants.*;

public class Ready implements State {

    private static final String TEXT = "";

    @Override
    public State play(int newFelledPin) {
        assertFirstFelledPin(newFelledPin);

        if(newFelledPin == MAX_FELLED_PIN_COUNT) {
            return new Strike();
        }
        if(newFelledPin == ZERO) {
            return new Gutter();
        }

        return new Playing(newFelledPin);
    }

    @Override
    public boolean isEndedState() {
        return false;
    }

    @Override
    public String getString() {
        return TEXT;
    }

    private void assertFirstFelledPin(int felledPin) {
        if(felledPin > MAX_FELLED_PIN_COUNT || felledPin < MIN_FELLED_PIN_COUNT) {
            throw new IllegalArgumentException(WRONG_FELLED_PIN);
        }
    }
}