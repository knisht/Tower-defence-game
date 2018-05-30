package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;


import javafx.scene.image.Image;

public class Maps {
	public static Map<String, Image> images;
	private static String imageDir = World.imgDir;
	static File log = new File("log.txt");
	static public OutputStreamWriter errs;
	static public FileOutputStream errsStream;
	
	static {
		images = new HashMap<>();
		if (!log.exists()) {
			try {
				log.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void storeImage(String src) {
		try {
			images.put(src, new Image(new FileInputStream(new File(imageDir+File.separator+src))));
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static Image getImage(String src) {
		if (images.containsKey(src)) {
			return images.get(src);
		} else {
			return null;
		}
	}
	
}
