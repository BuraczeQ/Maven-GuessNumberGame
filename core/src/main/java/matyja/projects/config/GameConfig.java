package matyja.projects.config;

import matyja.projects.GuessCount;
import matyja.projects.MaxNumber;
import matyja.projects.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    @Value("${game.maxNumber}")
    private int maxNumber;
    @Value("${game.guessCount}")
    private int guessCount;
    @Value("${game.minNumber}")
    private int minNumber;

    //== Bean Method =
    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }
    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }
    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }
}
