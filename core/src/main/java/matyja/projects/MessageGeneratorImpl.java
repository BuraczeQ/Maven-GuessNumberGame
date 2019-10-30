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


    //== Init ==
    @PostConstruct
    public void init() {
        log.info("game = {}", game);
    }

    // == Public methods ==


    @Override
    public String getStartingMessage() {
        return "Welcome To My Guess Game!\nYour task will be to guess the number between 1 and 100," +
                " are you ready?" ;
    }

    @Override
    public String getMainMessage() {
        return  "The number is between " + game.getSmallest() +
                " and " + game.getBiggest() ;
    }

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






}
