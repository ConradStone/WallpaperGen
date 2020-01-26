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
	float[][] mapr;
	float[][] mapg;
	float[][] mapb;
	
	Color weight;
	
	ImprovedNoise NGen = new ImprovedNoise();
	
	public NoiseSystem(int w, int h, float sx, float sy, float ox, float oy, Color wt) {
		width = w;
		height = h;
		
		scaleX = sx;
		scaleY = sy;
		offsetX = ox;
		offsetY = oy;
		
		weight = wt;
		
		GenNoise();
	}
	
	public void RegenNoise(int w, int h, float sx, float sy, float ox, float oy, Color wt) {
		
		width = w;
		height = h;
		
		scaleX = sx;
		scaleY = sy;
		offsetX = ox;
		offsetY = oy;
		
		weight = wt;
		
		GenNoise();
	}
	
	public void GenNoise() {
		
		float rx = (float)Math.random()*10000;
		float ry = (float)Math.random()*10000;
		
		mapr = new float[width][height];
		mapg = new float[width][height];
		mapb = new float[width][height];
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				mapr[i][j] = (weight.getRed()/255f)* (float) NGen.noise(i/scaleX + rx + offsetX, j/scaleY + ry + offsetY, 0f);
				mapg[i][j] = (weight.getGreen()/255f)* (float) NGen.noise(i/scaleX + rx + 2*offsetX, j/scaleY + ry + 2*offsetY, 0f);
				mapb[i][j] = (weight.getBlue()/255f)* (float) NGen.noise(i/scaleX + rx + 3*offsetX, j/scaleY + ry + 3*offsetY, 0f);
			}
		}
	}
	
	public String toText() {
		
		String s = "";
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				//s += map[i][j] + " ";
			}
			s += "\n";
		}
		System.out.println("FUNCTION DISABLED: NoiseSystem.toText()");
		return s;
	}
	
	public void toImg() {
        
        final BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D gr2d = (Graphics2D)img.getGraphics();
        
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
            	
                float r = Math.abs(mapr[i][j]);
                float g = Math.abs(mapg[i][j]);
                float b = Math.abs(mapb[i][j]);
                
                gr2d.setColor(new Color(r, g, b));
                gr2d.fillRect(i, j, 1, 1);
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
