package com.mrs.spaceship.sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class SoundEffect {
    protected String soundFile;
    protected Clip clip;
    protected boolean canPlaySound = true, canPlayMusic = true;

    public SoundEffect(String soundFile) { this.soundFile = soundFile; }

    public void playMusic() {
        if (canPlaySound) {
            try {
                URL resource = getClass().getClassLoader().getResource(this.soundFile);
                File musicFile = new File(resource.toURI());
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(musicFile.toURI()));
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stopMusic() {
        clip.stop();
    }
}
