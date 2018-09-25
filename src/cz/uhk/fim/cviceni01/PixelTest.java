package cz.uhk.fim.cviceni01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class PixelTest {

    private JFrame window; //hlavní okno
    private JPanel panel; // panel, do kterého umísťujeme BufferedImage
    private BufferedImage img; //objekt, do kterého kreslíme

    public PixelTest() {
        //základní vytvoření okna
        window = new JFrame();
        //oknu se musí ručně nastavit, jak se chovat při pokusu o uzavření
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(800, 600);

        panel = new JPanel();
        window.add(panel);

        img = new BufferedImage(800,600,BufferedImage.TYPE_INT_BGR);

        window.setVisible(true);
        drawPixel(100,50, Color.GREEN.getRGB());

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drawPixel(e.getX(), e.getY(), Color.GREEN.getRGB());
            }
        });
    }

    private void drawPixel(int x, int y, int color) {
        img.setRGB(x,y,color);
        panel.getGraphics().drawImage(img, 0,0,null);
    }

    public static void main(String[] args) {
        new PixelTest();
    }
}
