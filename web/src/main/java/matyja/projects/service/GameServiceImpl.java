package matyja.projects.service;

import lombok.extern.slf4j.Slf4j;
import matyja.projects.Game;
import matyja.projects.MessageGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService {
    //== Fields ==
    private final Game game;
    private final MessageGenerator messageGenerator;

//== Constructor ==
    @Autowired
    public GameServiceImpl(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }


//== Post Construct ==
    @PostConstruct
    public void init(){
        game.reset();
        log.info("number = {}", game.getNumber());
        log.info("Main message --> {}", messageGenerator.getMainMessage());
    }

    // == Methods ==
    @Override
    public boolean isGameOver() {
      return game.isGameLost() || game.isGameVon();
          }

    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(int i) {
    game.setGuess(i);
    game.check();
    }

    @Override
    public void reset() {
    game.reset();
    }
}
