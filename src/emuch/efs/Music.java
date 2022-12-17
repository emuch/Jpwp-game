package emuch.efs;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Music{
    public static void playMusic() {
        File muzyka = new File("C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/sounds/World of Knights.wav");
        playSound(muzyka);
    }
    
    static void playSound(File Sound) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            
            //if (System.){
            //Thread thread.Thread_stop();
            //}
        }
        catch(Exception e){
        }
    }
}

//To Do:
//wyłaczenie muzyki przez kilknięcie "X". 
