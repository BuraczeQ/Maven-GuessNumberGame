package matyja.projects.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {

    private int maxNumber = 100;
    private int guessCount = 5;

    //== Bean Method =
    @Bean
    public int maxNumber(){
        return maxNumber;
    }
    @Bean
    public int guessCount(){
        return guessCount;
    }
}
