package matyja.projects.console;

import matyja.projects.Game;
import matyja.projects.MessageGenerator;
import matyja.projects.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess  {
    // == Constants ==
    public static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    // == Fields ==

    @Autowired
    private Game game;

    @Autowired
    private MessageGenerator messageGenerator;



    // == Events ==
    @EventListener
    public void start(ContextRefreshedEvent contextRefreshedEvent) {

        game.reset();
        log.info("Start() ---> Container Ready For USE");

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();

            game.setGuess(guess);
            game.check();

            if(game.isGameVon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again? Y/N");

                String playAgainString = scanner.nextLine().trim();
                if(!playAgainString.equalsIgnoreCase("y")){
                    break;
                }
                game.reset();
            }
        }
    }
}
