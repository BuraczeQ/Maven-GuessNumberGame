package matyja.projects;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class GameImpl implements Game {

    // == Constants ==
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    // == Fields ==
    @Autowired
    private NumberGenerator numberGenerator;
    @Autowired
    private int guessCount;
    private int number;
    private int guess;
    @Autowired
    private int minNumber;
    @Autowired
    private int maxNumber;

    private int remainingGuesses;
    private boolean validNumberRange = true;



    // == Init methods ==

    @Override
    public void reset() {
        minNumber=numberGenerator.getMinNumber();
        guess=numberGenerator.getMinNumber();
        remainingGuesses=guessCount;
        maxNumber= numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("The number is : {}", number);


    }


    // == Public methods ==


    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return minNumber;
    }

    @Override
    public int getBiggest() {
        return maxNumber;
    }

    @Override
    public int getRemainingGuessess() {
        return remainingGuesses;
    }

    @Override
    public int getGuessCount() {
        return guessCount;
    }

    @Override
    public void check() {

        checkValidNumberRange();
        if(validNumberRange){
            if(guess > number){
                maxNumber = guess-1;
            }
            if (guess < number){
                minNumber = guess+1;
            }
        }
        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameVon() {
        return guess==number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameVon() && remainingGuesses<=0;
    }
    // == Private Methods == //

    private void checkValidNumberRange(){
        validNumberRange = ((guess >= minNumber) && (guess <= maxNumber));
    }



}
