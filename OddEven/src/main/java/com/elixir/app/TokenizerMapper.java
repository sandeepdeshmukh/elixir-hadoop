package com.elixir.app;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public  class TokenizerMapper 
       extends Mapper<Object, Text, Text, IntWritable>{
    
   // private final static IntWritable one = new IntWritable(1);
    private Text num = new Text();
      
    public void map(Object key, Text value, Context context
                    ) throws IOException, InterruptedException {
      
    	int a=Integer.parseInt(value.toString());
    	
    	if(a%2==0){
    		num.set("even");
    	}
    	else{
    		num.set("odd");
    	}
    	context.write(num, new IntWritable(1));
       }
}
