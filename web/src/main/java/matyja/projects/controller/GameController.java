package matyja.projects.controller;

import lombok.extern.slf4j.Slf4j;
import matyja.projects.Game;
import matyja.projects.service.GameService;
import matyja.projects.util.AtributeNames;
import matyja.projects.util.GameMappings;
import matyja.projects.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class GameController {
    //== fields ==
    private  GameService gameService;

    // == contrstructor==
    @Autowired
    public GameController (GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping(GameMappings.PLAY)
    public String play(Model model){
        model.addAttribute(AtributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AtributeNames.RESULT_MESSAGE, gameService.getResultMessage());

        log.info("model = {}", model);

        if(gameService.isGameOver()){
            return ViewNames.GAME_OVER;
        }return ViewNames.PLAY;
    }

    @PostMapping(GameMappings.PLAY)
    public String processMessage(@RequestParam int guess){
        log.info("guess = {}, guess");
        gameService.checkGuess(guess);
        return GameMappings.REDIRECT_PLAY;
    }
}
