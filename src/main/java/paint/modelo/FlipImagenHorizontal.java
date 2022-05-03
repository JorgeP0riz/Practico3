package paint.modelo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FlipImagenHorizontal extends Transformar{


    public FlipImagenHorizontal(Imagen img) {
        this.imagen= img;
    }

    @Override
    public void transformar() {
        imagen.transformada();
    }

    public static BufferedImage horizontalFlip(BufferedImage img) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage flippedImage = new BufferedImage(w, h, img.getType());
        Graphics2D g = flippedImage.createGraphics();
        g.drawImage(img, 0, 0, w, h, w, 0, 0, h, null);
        g.dispose();
        return flippedImage;
    }
}
