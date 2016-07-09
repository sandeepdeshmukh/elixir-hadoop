package com.elixir.fileCopy;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	public static int BUFFER_SIZE = 16777216; 
    public static void main( String[] args ) throws IllegalArgumentException, IOException
    {
       // Open the file from HDFS
    	FileSystem fs = FileSystem.newInstance((new Path(args[0])).toUri(), new Configuration());
    	FSDataInputStream in = fs.open(new Path(args[0]));
    	
    	FSDataOutputStream os = fs.create(new Path (args[1]));
    	byte [] buffer = new byte[BUFFER_SIZE];
    	int offset =0 ; int len = BUFFER_SIZE;
    	int dataRead;
    	while((dataRead = in.read(buffer, offset, len)) != -1){
    		os.write(buffer);	
    		offset+= dataRead;
    	}
    	in.close();
    	os.close();
    	fs.close();
    	System.out.println ("Data Read: " + offset);
    }
}
