package com.wipro.files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyingImage {

	public static void main(String[] args) 
	{
		
		try {
			FileInputStream fis=new FileInputStream("E:\\sea.jpg");
			FileOutputStream fos=new FileOutputStream("E:\\copy_sea.jpeg");
			byte[] buffer=new byte[1024];
			int readByte=0;
			
			while((readByte=fis.read(buffer))!=-1)
			{
				fos.write(buffer,0,readByte);
			}
			System.out.println("image is copied");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
