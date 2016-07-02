package com.elixir.app;


import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.WritableComparable;

public class SecondrySort {
	public static class IntPair 
    implements WritableComparable<IntPair> {
		
		private int PrimaryKey=0;
		private int SecondryKey=0;
		public int getPrimaryKey() {
			return PrimaryKey;
		}
		
		public void setPrimaryKey(int primaryKey) {
			PrimaryKey = primaryKey;
		}
		
		public int getSecondryKey() {
			return SecondryKey;
		}
		
		public void setSecondryKey(int secondryKey) {
			SecondryKey = secondryKey;
		}

		public void write(DataOutput out) throws IOException {
			out.writeInt(PrimaryKey - Integer.MIN_VALUE);
		      out.writeInt(SecondryKey - Integer.MIN_VALUE);
		}

		public void readFields(DataInput in) throws IOException {
			PrimaryKey = in.readInt()+Integer.MIN_VALUE;
			SecondryKey = in.readInt()+Integer.MIN_VALUE;
		}

		public int compareTo(IntPair arg0) {
			 if (PrimaryKey != arg0.PrimaryKey) {
		        return PrimaryKey < arg0.PrimaryKey ? -1 : 1;
		      } else if (SecondryKey != arg0.SecondryKey) {
		        return SecondryKey < arg0.SecondryKey ? -1 : 1;
		      } else {
		        return 0;
		      }
		    }
	}
}
