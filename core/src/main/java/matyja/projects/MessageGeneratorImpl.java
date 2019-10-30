package matyja.projects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    //== Constants ==
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    //== Fields ==
    @Autowired
    private Game game;
    private int guessCount = 10;

    //== Init ==
    @PostConstruct
    public void init() {
        log.info("game = {}", game);
    }

    // == Public methods ==

    @Override
    public String getMainMessage() {
        return "This is Guess Game Challenge!!! \n" +
                "The number is between " + game.getSmallest() +
                " and " + game.getBiggest() + " \nCan You Guess It?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameVon()){
            return  "You guessed correctly, the number was "+game.getNumber();
        }else if(game.isGameLost()){
            return  "You failed to guess the number you were looking for were" + game.getNumber();
        }else if(game.getRemainingGuessess()==guessCount){
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






}
