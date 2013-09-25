package china.zhouyiren.heapsort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class heapsort {
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
		HeapSort(nums);  //���ж����� heap sort
		long end = System.nanoTime();	 //������ʱ end timing
		long useTime = end - start;
		
		FileWriter fw=new FileWriter(new File("output_heapsort.txt"));
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
	//main

	public static int[] HeapSort(int[] args){ //������ heap sort
		BuildMaxHeap(args);
		heapsortx(args);
		return args;
	}
	//heap sort
	
	public static void BuildMaxHeap(int[] args){ //�������� build max heap
		for(int i=args.length/2;i>=0;i--){
			MaxHeapify(args,args.length,i);
		}
	}
	//build max heap
	
	public static void MaxHeapify(int[] args,int HeapSize,int i){ //����� max heap
		if(i<HeapSize){
			int lchild=2*i+1;
			int rchild=2*i+2;
			int k=i;
			if(lchild<HeapSize&&args[lchild]>args[i]){
				k=lchild;
			}
			if(rchild<HeapSize&&args[rchild]>args[k]){
				k=rchild;
			}
			if(k!=i){
				Exchange(args,i,k);
				MaxHeapify(args,HeapSize,k);
			}
		}
	}
	//max heap
	
	public static void Exchange(int[] args, int i, int j){ //���� exchange
		int k=args[j];
		args[j]=args[i];
		args[i]=k;
	}
	//exchange
	
	public static void heapsortx(int[] args){ //�������� do heap sort
		int[] temp=args;
		for(int i=temp.length-1;i>=1;i--){
			Exchange(temp,i,0);
			MaxHeapify(temp,i,0);
		}
		args=temp;
	}
	//do heap sort
}

