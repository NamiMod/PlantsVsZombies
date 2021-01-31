import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException, LineUnavailableException, UnsupportedAudioFileException {

       Load_Gui p = new Load_Gui(new GameSettings());

    }
}
