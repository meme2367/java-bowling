package bowling.domain.frame;

import bowling.domain.state.*;

import java.util.ArrayList;
import java.util.List;

import static bowling.Constants.*;

public class FinalFrame implements Frame {
    private static final int FINAL_FRAME_NO = 10;

    private State state;
    private final StateHistory stateHistory;

    private FinalFrame(State state, StateHistory stateHistory) {
        this.state = state;
        this.stateHistory = stateHistory;
    }

    public static Frame create() {
        return new FinalFrame(new Ready(), new StateHistory());
    }

    public void play(int felledPin) {
        assertFelledPin(felledPin);
        state = state.play(felledPin);
        stateHistory.add(state);
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public Frame getNext() {
        return null;
    }

    @Override
    public int getFrameNumber() {
        return FINAL_FRAME_NO;
    }

    @Override
    public boolean isEndedFrame() {
        if(getBowledCount() == 1) {
            return isEndedFrameBowledOnce();
        }
        if(getBowledCount() == 2) {
            return isEndedFrameBowledTwice();
        }
        return state.isEndedState();
    }

    private int getBowledCount() {
        return stateHistory.getSize();
    }

    private boolean isEndedFrameBowledOnce() {
        if(state instanceof Strike) {
            return false;
        }
        return state.isEndedState();
    }

    private boolean isEndedFrameBowledTwice() {
        State firstState = stateHistory.get(0);

        if(firstState instanceof Strike) {
            return false;
        }

        if(state instanceof Spare) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isLastFrame() {
        return isEndedFrame();
    }

    @Override
    public StateHistory getStateHistory() {
        return stateHistory;
    }

    private void assertFelledPin(int felledPin) {
        if(felledPin > MAX_FELLED_PIN_COUNT || felledPin < MIN_FELLED_PIN_COUNT) {
            throw new IllegalArgumentException(WRONG_FELLED_PIN);
        }
    }
}