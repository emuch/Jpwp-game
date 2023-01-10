package emuch.efs;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

class Music extends Thread{
    Menu menu;
    boolean playing = true;
    String soundpath;

    void playMusic() throws IOException {
        this.soundpath = new File("sounds").getCanonicalPath().toString();
        File muzyka = new File(this.soundpath + "/World of Knights.wav");
        playSound(muzyka);
    }
    
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