package china.zhouyiren.insertionsort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class insertionsort {
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException{		
		List list = new ArrayList();
		int[] nums = null;
		String line = null;
		//BufferReader ���뻺����
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		while((line = br.readLine()) != null){
		    list.add(line);
		}
		br.close();
		nums = new int[list.size()];
		for(int i=0;i<list.size();i++){
			String s = (String) list.get(i);
			nums[i] = Integer.parseInt(s);
		}

		long start = System.nanoTime(); //��ʼ��ʱ begin timing
		InsertionSort(nums);  //���в������� insertion sort
		long end = System.nanoTime();	 //������ʱ end timing
		long useTime = end - start;
		
		FileWriter fw=new FileWriter(new File("output_insertionsort.txt"));
		//д��txt�ļ� write txt file
		BufferedWriter  bw=new BufferedWriter(fw);
		for(int i: nums){
            bw.write(i+"\t\n");
        }
		bw.write("UseTime="+useTime+"ns");
        bw.close();
        fw.close();
        System.out.println("UseTime="+useTime+"ns");
	}

	public static int[] InsertionSort(int[] args){ //�������� insertion sort
		for(int i=1;i<args.length;i++){
			int k=args[i];
			int j=i-1;
			while(j>=0&&args[j]>k){
				args[j+1]=args[j];
				j--;
			}
			args[j+1]=k;
		}
		return args;
	}	
	//insertion sort
}

