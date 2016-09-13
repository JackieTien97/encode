package encode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileEncAndDec {
	private static final int numOfEncAndDec = 0x99;
	private static int dataOfFile = 0;

	public static void main(String[] args) {
		File srcFile = new File("/Users/Slow_Time/Documents/workspace/encode/src/桌面.jpg");
		File encFile = new File("encFile.tif");
		File decFile = new File("decFile.bmp");
		
		try{
			EncFile(srcFile, encFile);
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	private static void EncFile(File srcFile, File encFile) throws Exception {
		if(!srcFile.exists()){
			System.out.println("source file not exist");
			return;
		}
		
		if(!encFile.exists()){
			System.out.println("encrpty file not exist");
			encFile.createNewFile();
		}
		
		InputStream fis = new FileInputStream(srcFile);
		OutputStream fos = new FileOutputStream(encFile);
		
		while((dataOfFile = fis.read()) > -1){
			fos.write(dataOfFile^numOfEncAndDec);
		}
		
		fis.close();
		fos.flush();
		fos.close();
	}

}
