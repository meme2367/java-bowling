package bowling_step3.domain.state;

import bowling_step3.domain.Pitch;
import bowling_step3.exception.PitchOverBoundException;

public abstract class Finished implements State {

    protected Pitch firstPitch;

    protected Pitch secondPitch;

    @Override
    public State pitch(int fallenPins) {
        throw new PitchOverBoundException();
    }

    @Override
    public boolean isFinish() {
        return true;
    }
}