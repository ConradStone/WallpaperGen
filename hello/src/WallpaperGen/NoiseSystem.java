package WallpaperGen;

public class NoiseSystem {
	
	int width;
	int height;
	double[][] map;
	ImprovedNoise sys = new ImprovedNoise();
	
	private double[][] Noise(int w, int h) {
		width = w;
		height = h;
		
		map = new double[width][height];
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				map[i][j] = sys.noise(i/3f, j/3f, 1/3f);
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
