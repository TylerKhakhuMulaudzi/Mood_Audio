package com.moodifyx;
import javax.sound.sampled.*;
import java.io.File;

public class SongPlayer 
{
    private static Clip clip;

    public static void play(String filePath) 
    {
        try 
        {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } 
        catch (Exception e) 
        {
            System.out.println("Error playing the song: " + e.getMessage());
        }
        
    }
    
    public static void stop() 
    {
        if (clip != null && clip.isRunning()) 
        {
            clip.stop();
            clip.close();
        }
    }
}