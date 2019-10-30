package matyja.projects.console;

import matyja.projects.config.AppConfig;
import matyja.projects.Game;
import matyja.projects.MessageGenerator;
import matyja.projects.NumberGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
            log.info("Guess the number game");

        //Create context (container)
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        //Get number generator from container
        NumberGenerator numberGenerator =
                context.getBean(NumberGenerator.class);

        //Call method next() to get a random number
        int number = numberGenerator.next();

        //Logg generated number
        log.info("GENERATED NUMBER = {}", number);

        //Get game bean from container
        Game game = context.getBean(Game.class);

        //Create Message Generator
        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);

        String message = messageGenerator.getMainMessage();
        System.out.println(message);



        //close context
        context.close();

    }
}

