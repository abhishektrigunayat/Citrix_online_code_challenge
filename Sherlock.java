import java.io.*;
import java.util.Scanner;
public class Sherlock {
	/*
	private static int N=10;
	private static int L=3;
	private static String K[]={"ont","nt "," aP","Gaa"," d ","oM ","MrM","ak ","t 3","ie "};
	private static String D[]={"1","2","3","4","5","6","AM","And","At","Get","Go","Hat","Home","Main","Marina","Market","Mission","Pat","PM","Sam","Sat","Star","Street","Time","To","Ton"};
	
	*/
	private static boolean t = false;
	private static StringBuilder msg;
	private static int d;
	private static int N;
	private static int L;
	private static String K[];
	private static String D[];

    public static void main(String args[] ) throws Exception {
		msg = new StringBuilder();
		getInput();
		//printInput();
		String M[] = new String[L];
		for(int i=0;i<L;i++){
			M[i] = new String();
		}
		char temp_arr[] = K[0].toCharArray();
		for(int i=0;i<L;i++){
			M[i] = String.valueOf(temp_arr[i]);
		}
		process(0,M);
		System.out.println(msg);
	
    }
	public static void getInput(){
		Scanner in = new Scanner(System.in).useDelimiter("\n");
		N = in.nextInt();
		L = in.nextInt();
		K = new String[N];
		for(int i=0;i<N;i++){
			K[i] = in.next();
			/*
            if(K[i].charAt(0) == '"'){
              //  K[i] = K[i].substring(1, K[i].length()-1);
            }
            else{
             //   K[i] = K[i].substring(3, K[i].length()-1);
            }
*/
			while(K[i].length()<L){
				K[i] = K[i] + " ";
			}
		}
		d = in.nextInt();
		D = new String[d];
		for(int i=0;i<d;i++){
			D[i] = in.next();
            //D[i] = D[i].substring(1, D[i].length()-1);
		}
	}
	
	public static void printInput(){
		System.out.println("N : " + N);
		System.out.println("L : " + L);
		System.out.println("K :");
		for(int i=0;i<N;i++){
			System.out.println(K[i] + " ");
		}
		System.out.println("d : " + d);
		System.out.println("D : ");
		for(int i=0;i<d;i++){
			System.out.println(D[i] + " ");
		}
	}
	
	public static void process(int currentIndex,String message[]){
		
		
		if(message[0].length() == N){
			if(!t){
				for(int i=0;i<L;i++){
					msg.append(message[i]);
                    if(i != L-1){
                        msg.append("\n");
                    }
				}
				t=true;
				return;
			}

		}
		
		boolean lookup_failed = false;
		if(currentIndex == N){
			return;
		}
		boolean skip = false;
		for(int i=0;i<message[0].length();i++){
			String temp = "";
			for(int j=0;j<L;j++){
				temp = temp + message[j].charAt(i);
			}
			if(temp.toLowerCase().equals(K[currentIndex].toLowerCase())){
				skip = true;
				break;
			}
		}
		
		if(skip){
			process(currentIndex + 1, message);
		}
		
		for(int i=0;i<K[currentIndex].length();i++){
			String temp = message[i] + String.valueOf(K[currentIndex].charAt(i));
			if(!lookup(temp)){
				lookup_failed = true;
				break;
			}
		}
		if(lookup_failed == false){
			for(int i=0;i<K[currentIndex].length();i++){
				message[i] = message[i] + String.valueOf(K[currentIndex].charAt(i));
			}
			process(0,message);
		}
		else{
		}
		
		lookup_failed = false;
		for(int i=0;i<K[currentIndex].length();i++){
			String temp = String.valueOf(K[currentIndex].charAt(i)) + message[i] ;
			if(!lookup(temp)){
				lookup_failed = true;
				break;
			}
			else{
			}
		}
		if(lookup_failed == false){
			for(int i=0;i<K[currentIndex].length();i++){
				message[i] = String.valueOf(K[currentIndex].charAt(i)) + message[i];
			}
			process(0,message);
		}
		process(currentIndex + 1, message);
		
	}
	
	public static boolean lookup(String str){
		String[] temp=str.split(" ");
		boolean found = false;
		for(int i=0;i<temp.length;i++){
			found = false;
			for(int j=0;j<D.length;j++){
				if(!temp[i].equals("")){
				if(D[j].toLowerCase().indexOf((temp[i].toLowerCase())) != -1){
					found = true;
					break;
				}
				}
			}
			if(found == false){
				break;
			}
		}
		return found;
	}
	


}