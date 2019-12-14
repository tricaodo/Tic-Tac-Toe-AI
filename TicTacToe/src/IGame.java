import javax.swing.*;
import java.util.List;

public interface IGame {
    void configureFrame(JFrame frame);
    void setState(String str);
    void changeScene();
    void setSavedGameList(List<String> savedGameList);
    void setLoadGame(int index);
}
