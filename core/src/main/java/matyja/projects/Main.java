package matyja.projects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
            log.info("Guess the number game");

        //Create context (container)
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        //Get number generator from container
        NumberGenerator numberGenerator =
                context.getBean("numberGenerator", NumberGenerator.class);

        //Call method next() to get a random number
        int number = numberGenerator.next();

        //Logg generated number
        log.info("GENERATED NUMBER = {}", number);

        //Get game bean from container
        Game game = context.getBean("game", Game.class);

        //Call reset
        game.reset();



        //close context
        context.close();

    }
}

