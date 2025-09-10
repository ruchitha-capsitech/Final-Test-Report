package gettingStarted.Actingoffice;

import org.monte.screenrecorder.ScreenRecorder;
import java.awt.*;
import java.io.File;

public class VideoRecorder {
    private static ScreenRecorder screenRecorder;
    private static String currentFilePath;

    public static void startRecording(String methodName) throws Exception {
        File file = new File("target/videos/");
        if (!file.exists()) {
            file.mkdirs();
        }

        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        screenRecorder = new SpecializedScreenRecorder(gc, gc.getBounds(), file, methodName);
        currentFilePath = "target/videos/" + methodName + ".avi";
        screenRecorder.start();
    }

    public static String stopRecording() throws Exception {
        if (screenRecorder != null) {
            // Stop recording in the same thread
            screenRecorder.stop();

            // Wait until the file is fully written
            File aviFile = new File(currentFilePath);
            int attempts = 0;
            while (attempts < 20) {
                if (aviFile.exists() && aviFile.length() > 0) {
                    // Sometimes the file is still being flushed; check size stabilizes
                    long size1 = aviFile.length();
                    Thread.sleep(500);
                    long size2 = aviFile.length();
                    if (size1 == size2) break;
                } else {
                    Thread.sleep(500);
                }
                attempts++;
            }

            return currentFilePath;
        }
        return null;
    }
}
