package emuch.efs;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

class Music{
    static void playMusic() {
        File muzyka = new File("C:/Users/Emus/Desktop/Programy Studia/JAVA JDK/Empirefromscratch/sounds/World of Knights.wav");
        playSound(muzyka);
    }
    
    static void playSound(File Sound) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            FloatControl gainControl = 
            (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-6.0f);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch(Exception e){
        }
    }
}

//To Do:
//wyłaczenie muzyki przez kilknięcie "X".
//ściszenie muzyki o 75% - 6dB                  //DONE
