package com.elixir.app;

import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public class ChromoPartitioner extends Partitioner<Text,IntWritable>{

	@Override
	public int getPartition(Text arg0, IntWritable arg1, int numOfReducers) {
		String []temp=arg0.toString().split(" ");
		int ChrNum=Integer.parseInt(temp[0]);
		return ChrNum%numOfReducers;
	}

}
