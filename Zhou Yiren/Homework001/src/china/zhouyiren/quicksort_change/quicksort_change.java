package china.zhouyiren.quicksort_change;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class quicksort_change {
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
		QuickSort(nums,0,nums.length-1);  //���п������� quick sort
		long end = System.nanoTime();	 //������ʱ end timing
		long useTime = end - start;
		
		FileWriter fw=new FileWriter(new File("output_quicksort_change.txt"));
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

	public static void QuickSort(int[] args,int begin, int end){ //�������� quick sort
		if(begin<end){
			int i=Dichotomy(args,begin,end);
			//�ݹ� recursion
			QuickSort(args,begin,i-1);
			QuickSort(args,i+1,end);
		}
	}	
	//quick sort
	
	public static int Dichotomy(int[] args,int begin,int end){ //���� dichotomy
		int i=begin;
		int k;
		for(int j=begin;j<end;j++){
			if(args[j]<args[end]){
				k=args[i];
				args[i]=args[j];
				args[j]=k;
				i++;
			}
		}
		k=args[end];
		args[end]=args[i];
		args[i]=k;
		return i;
	}
	//dichotomy
}
