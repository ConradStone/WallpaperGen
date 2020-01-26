package WallpaperGen;

public class NoiseSystem {
	
	double scaleX = 0;
	double scaleY = 0;
	double offsetX = 0;
	double offsetY = 0;
	int width;
	int height;
	double[][] map;
	ImprovedNoise sys = new ImprovedNoise();
	
	private double[][] Noise(int w, int h) {
		width = w;
		height = h;
		
		map = new double[width][height];
		
		scaleX = 3.1;
		scaleY = 2.3;
		offsetX = 1.1;
		offsetY = 4.7;
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				map[i][j] = sys.noise((scaleX*i)/3f + offsetX, (scaleY*j)/3f + offsetY, 1/3f);
			}
		}
		return map;
	}
	
	public String toText() {
		
		String s = "";
		
		double[][]m = Noise(100,100);
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				s += m[i][j] + " ";
			}
			s += "\n";
		}
		return s;
	}
	
}
