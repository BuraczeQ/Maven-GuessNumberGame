package matyja.projects.service;

public interface GameService {
    boolean isGameOver();

    String getMainMessage();

    String getResultMessage();

    void checkGuess(int i);

    void reset();


}
