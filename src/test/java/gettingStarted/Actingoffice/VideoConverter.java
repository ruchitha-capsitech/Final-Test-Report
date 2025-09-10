package gettingStarted.Actingoffice;


import java.io.IOException;

public class VideoConverter {
    public static void convertAviToMp4(String aviPath, String mp4Path) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(
                "ffmpeg", "-i", aviPath, "-vcodec", "libx264", "-acodec", "aac", mp4Path
        );
        pb.inheritIO();
        Process process = pb.start();
        process.waitFor();
    }
}
