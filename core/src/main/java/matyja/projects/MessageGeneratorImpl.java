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
            return  "You guessed correctly, the number was "+game.getNumber();
        }else if(game.isGameLost()){
            return  "You failed to guess the number you were looking for were " + game.getNumber();
        }else if(game.getRemainingGuessess()==game.getGuessCount()){
            return "Give it a try, what is your first guess? ";
        }else{
            String direction = "Lower";
                    if(game.getGuess()<game.getNumber()){
                        direction = "Higher";
                    }
                    return direction + " try again! You have: "+ game.getRemainingGuessess() +
                            " guesses left";
        }
    }
    private String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }





}
