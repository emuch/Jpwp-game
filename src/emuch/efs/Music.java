package emuch.efs;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
/**
Klasa odpowiedzialna za muzyke
 */
class Music extends Thread{
    Menu menu;
    boolean playing = true;
    String soundpath;

    
    /** 
     * @throws IOException
     */
    /**
    Odtwarzanie muzyki
    */
    void playMusic() throws IOException {
        this.soundpath = new File("sounds").getCanonicalPath().toString();
        File muzyka = new File(this.soundpath + "/World of Knights.wav");
        playSound(muzyka);
    }
    
    
    /** 
     * @param Sound
     */
    /**
    Wczytanie pliku audio i zapetlenie
    */
    void playSound(File Sound) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-20);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch(Exception e){
        }
    }
}