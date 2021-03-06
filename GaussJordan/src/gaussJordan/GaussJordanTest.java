package gaussJordan;

import java.util.ArrayList;

public class GaussJordanTest {
	public static void main(String[] args){
		System.out.println("Bob's rref using the Gauss-Jordan method"/*+ ", following matlab formatting, except you must put a space between each element, including: ';' '[', ']'"*/);
		//System.out.println("Ex: [ 1 2 3 ; 14 15 16 ; 67 258 59 ]");
		//System.out.println("Also, tester only works with argument input.");
		
		//double[][] input = getDouble2D(args);
		//opting to hardcode test case for now -- IO takes a lot of work
		double[][] input1 = new double[3][];
		input1[0] = new double[]{0d, 2d, 3d, 4d};
		input1[1] = new double[]{0d, 4d, 6d, 8d};
		input1[2] = new double[]{3d, 3d, 3d, 3d};
		
		double[][] input2 = new double[4][];
		input2[0] = new double[]{1d, 2d, 3d, 4d, 5d, 6d, 7d};
		input2[1] = new double[]{0d, 0d, 0d, 0d, 0d, -4d, -8d};
		input2[2] = new double[]{5d, 3d, 5d, 3d, 5d, 3d, 5d};
		input2[3] = new double[]{3d, 5d, 3d, 5d, 3d, 5d, 3d};

		System.out.println("example 1:");
		print(input1);
		System.out.println("rref:");
		print(GaussJordan.rref(input1));
		
		System.out.println("example 2:");
		print(input2);
		System.out.println("rref:");
		print(GaussJordan.rref(input2));
	}
	
	private static void print(double[][] matrix){
		for(int i=0; i < matrix.length; i++){
			for(int j=0; j < matrix[i].length; j++){
				System.out.print("" + matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
//	private static double[][] getDouble2D(String[] args){
//		double[][] output;
//		int length = 0;
//		ArrayList<Double> temp = new ArrayList<Double>();
//		for(String input : args){
//			if(input == "["){
//				//do nothing
//			}else if(input == ";"){
//				//commit row
//			}else if(input == "]"){
//				//completed - do nothing
//			}else{
//				//it's a number!
//			    try{
//			    	temp.add(Double.parseInt(input));
//			    } catch (NumberFormatException e) {
//			        System.err.println("Argument" + input + " must be a number (Double).");
//			    }
//		}
//		
//		
//		output = rows.toArray();
//	}
}
