package WallpaperGen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class NoiseSystem {
	
	float scaleX = 0;
	float scaleY = 0;
	float offsetX = 0;
	float offsetY = 0;
	
	int width;
	int height;
	float[][] map;
	ImprovedNoise NGen = new ImprovedNoise();
	
	
	public NoiseSystem(int w, int h, float sx, float sy, float ox, float oy) {
		width = w;
		height = h;
		
		scaleX = sx;
		scaleY = sy;
		offsetX = ox;
		offsetY = oy;
		
		GenNoise();
	}
	
	public void RegenNoise(int w, int h, float sx, float sy, float ox, float oy) {
		
		width = w;
		height = h;
		
		scaleX = sx;
		scaleY = sy;
		offsetX = ox;
		offsetY = oy;
		
		GenNoise();
	}
	
	public float[][] GenNoise() {
		
		map = new float[width][height];
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				map[i][j] = (float)NGen.noise(i/scaleX*3f + offsetX, j/scaleY*3f + offsetY, 1/3f);
			}
		}
		return map;
	}
	
	public String toText() {
		
		String s = "";
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				s += map[i][j] + " ";
			}
			s += "\n";
		}
		return s;
	}
	
	public void toImg() {
        
        final BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D)img.getGraphics();
        
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                float c = Math.abs(map[i][j]);
                //g.setColor(new Color(1f,1f,1f));
                g.setColor(new Color(0f, c, c));
                g.fillRect(i, j, 1, 1);
            }
        }

        JFrame frame = new JFrame("Image test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;
                g2d.clearRect(0, 0, getWidth(), getHeight());
                g2d.setRenderingHint(
                        RenderingHints.KEY_INTERPOLATION,
                        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                        // Or _BICUBIC
	                g2d.scale(2, 2);
	                g2d.drawImage(img, 0, 0, this);
	            }
	        };
	        panel.setPreferredSize(new Dimension(width*2, height*2));
	        frame.getContentPane().add(panel);
	        frame.pack();
	        frame.setVisible(true);
	}
	
}
