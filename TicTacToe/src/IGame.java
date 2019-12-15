/** 
 * An inteface for the Game class
 */
import javax.swing.*;
import java.util.List;

public interface IGame {
	/**
	 *  Setting the configuration for the frame.
	 * @param frame whose configuration is suppose to happen.
	 */
    void configureFrame(JFrame frame);
    
    /**
     * Setting the state in order to display the scene.
     *
     * @param str string state.
     * 
     */
    void setState(String str);
    
    /**
     * Changes the scene based on the user's selection.
     */
    void changeScene();
    
    /**
     * Setting the history game list.
     *
     * @param savedGameList list of game history.
     */
    void setSavedGameList(List<String> savedGameList);
    
    /**
     * Setting the game that the user wants to load.
     *
     * @param index the index of the game in the list.
     */
    void setLoadGame(int index);
}