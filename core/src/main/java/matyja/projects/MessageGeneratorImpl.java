package matyja.projects;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    //== Constants ==
    private static final String MAIN_MESSAGE2 = "game.main.message";
    private static final String WIN = "game.win";
    private static final String LOSE = "game.lose";
    private static final String INVALID_RANGE = "game.invalid.range";
    private static final String FIRST_GUESS = "game.first.guess";
    private static final String HIGHER = "game.higher";
    private static final String LOWER = "game.lower";
    private static final String REMAINING = "game.remaining";

    //== Fields ==
    @Autowired
    private  Game game;
    @Autowired
    private  MessageSource messageSource;



// == Public methods ==


    @Override
    public String getStartingMessage() {
        return "Welcome To My Guess Game!\nYour task will be to guess the number between "+game.getGuess()+ " and "+ game.getBiggest() +
                " are you ready?" ;
    }


    @Override
    public String getMainMessage() {
      return
        getMessage("game.main.message", game.getSmallest(), game.getBiggest());
 /*"Number is between " +
             game.getSmallest() +
            " and " +
            game.getBiggest() +
            ". Can you guess it?";*/}


    @Override
    public String getResultMessage() {
        if(game.isGameVon()){
            return getMessage(WIN, game.getNumber()); //"You guessed correctly, the number was "+game.getNumber();
        }else if(game.isGameLost()){
            return  getMessage(LOSE,game.getNumber());  //"You failed to guess the number you were looking for were " + game.getNumber();
        }else if(game.getRemainingGuessess()==game.getGuessCount()) {
            return getMessage(FIRST_GUESS);
        }else if (!game.isValidNumberRange()){
             return getMessage(INVALID_RANGE);

        }else{
            String direction = getMessage(LOWER);
                    if(game.getGuess()<game.getNumber()){
                        direction = getMessage(HIGHER);
                    }
                    return getMessage(REMAINING,direction,game.getRemainingGuessess());
        }
    }
    private String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }





}
