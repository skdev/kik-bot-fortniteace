package sk96.dev.kik.bot.command.fortnite;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ImageCreator {
    private static final String[] BASE_IMAGES = {
            "./base-images/base-1.png",
            "./base-images/base-3.png",
            "./base-images/base-5.png",
            "./base-images/base-7.png",
            "./base-images/base-8.png",
            "./base-images/base-9.png",
            "./base-images/base-10.png",
            "./base-images/base-11.png",
            "./base-images/base-12.png"
    };
    private BufferedImage image;

    public ImageCreator() throws IOException {
        final Random random = new Random();
        final int index = random.nextInt(BASE_IMAGES.length);
        image = ImageIO.read(new File(BASE_IMAGES[index]));
    }

    public ImageCreator write(String message, int x, int y, float fontSize) {
        Graphics g = image.getGraphics();
        g.setFont(g.getFont().deriveFont(fontSize).deriveFont(Font.BOLD));
        g.drawString(message, x, y);
        g.dispose();
        return this;
    }

    public ImageCreator save(String path) throws IOException{
        ImageIO.write(image, "jpg", new File(path.replace("%20", " ")));
        return this;
    }
}