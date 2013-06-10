package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class MillionIntegers {
	
	public static String prefix = "/Users/romandrapeko/Documents/workspace/GoogleInterview/resources/";

	
	public static Integer readNextInteger(BufferedReader r) throws IOException {
		String line = r.readLine();
		Integer num = null;
		if (line != null && !line.equals("")) {
			num = Integer.parseInt(line);
		}
		return num;
	}

	public static void mergeSortTwoFiles(String filename1, String filename2, String resultFile) throws IOException {
		BufferedReader br1 = new BufferedReader(new FileReader(prefix+filename1));
		BufferedReader br2 = new BufferedReader(new FileReader(prefix+filename2));
		BufferedWriter bw = new BufferedWriter(new FileWriter(prefix+resultFile));

		Integer val1 = readNextInteger(br1);
		Integer val2 = readNextInteger(br2);
		while(val1 != null && val2 != null) {
			if (val1 <= val2) {
				bw.write(val1.toString());
				val1 = readNextInteger(br1);
			} else {
				bw.write(val2.toString());
				val2 = readNextInteger(br2);
			}
			bw.newLine();
		}
		
		while (val1 != null) {
			bw.write(val1.toString());
			bw.newLine();
			val1 = readNextInteger(br1);
		}
		
		while (val2 != null) {
			bw.write(val2.toString());
			bw.newLine();
			val2 = readNextInteger(br2);
		}
		
		br1.close();
		br2.close();
		bw.flush();
		bw.close();
	}
	
	public static void quick(List<Integer> array, Integer low, Integer high) {
		int pivot = array.get((low + high) / 2);
		int i = low;
		int j = high;
		
		do {
			while(array.get(i) < pivot) i++;
			while(array.get(j) > pivot) j--;
			if (i <= j) {
				int tmp = array.get(i);
				array.set(i, array.get(j));
				array.set(j, tmp);
				i++;
				j--;
			}
		} while (i < j);
		if (low < j) quick(array, low, j);
		if (i < high) quick(array, i, high);
	}
	
	public static List<Integer> readFile(String file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(prefix+file));
		List<Integer> result = new ArrayList<Integer>();
	
		Integer val = null;
		while((val = readNextInteger(br)) != null) {
			result.add(val);
		}
		
		return result;
	}
	
	public static void saveFile(String file, List<Integer> array) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(prefix+file));
		for(Integer i : array) {
			bw.write(i.toString());
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	
	public static int splitBigFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(prefix+"initial.data"));
		int maxLines = 10;
		int currLine = 0;
		int currFile = 1;
		
		BufferedWriter bw = null;
		
		Integer val = null;
		while((val = readNextInteger(br)) != null) {
			currLine++;
			if (bw == null) {
				bw = new BufferedWriter(new FileWriter(prefix+currFile+".chunk"));
			}
			
			bw.write(val.toString());
			bw.newLine();
			
			if (currLine % maxLines == 0) {
				bw.flush();
				bw.close();
				bw = null;
				currFile++;
			}
		}
		if (bw != null) {
			bw.flush();
			bw.close();
		}
		
		return currFile;
	}
	
	public static void main(String args []) throws IOException {
		int filesCreated = splitBigFile();
		Stack<String> s = new Stack<String>();

		for (int i = 1; i <= filesCreated; i++) {
			List<Integer> array = readFile(i+".chunk");
			quick(array, 0, array.size() - 1);
			saveFile(""+i, array);
			s.add(""+i);
		}

		try {
			while(true) {
				String name1 = s.pop();
				String name2 = s.pop();
				String newName = name1+"_"+name2;
				mergeSortTwoFiles(name1, name2, newName);
				s.push(newName);
			}
		} catch(EmptyStackException e) {
			System.out.println("finished!");
		}
	}
}
