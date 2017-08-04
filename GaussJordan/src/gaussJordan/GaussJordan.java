package gaussJordan;

public class GaussJordan {
	double[][] matrix;
	double[][] rrefMatrix;
	
	public GaussJordan(double[][] inputMatrix){
		
		matrix = new double[inputMatrix.length][inputMatrix[0].length];
		rrefMatrix = new double[inputMatrix.length][inputMatrix[0].length];

		//deepcopy array so it doesn't change
		for(int i = 0; i < inputMatrix.length; i++)
		{
			System.arraycopy(inputMatrix[i], 0, matrix[i], 0, inputMatrix[i].length);
		}
		
		rrefMatrix = GaussJordan.rref(matrix);
	}
	
	public double[][] getRREF(){
		double[][] tempMatrix = new double[rrefMatrix.length][rrefMatrix[0].length];
		
		for(int i = 0; i < rrefMatrix.length; i++)
		{
			System.arraycopy(rrefMatrix[i], 0, tempMatrix[i], 0, rrefMatrix[i].length);
		}
		
		return tempMatrix;
	}
	
	public static double[][] rref(double[][] matrix){
		//for each row i, from 0 to m-1; j++ on continue
		for(int i=0, j=0; (i < matrix.length) && (j < matrix[0].length); j++){
			//if matrix[i][j]==0
			if(matrix[i][j] == 0.0d){
				//find subsequent row at col(j) with non-zero
				int nonzero = i;
				do{
					nonzero++;
				}while((nonzero < matrix.length) && (matrix[nonzero][j] != 0.0d));
				//if found, swap that row with current row
				if(nonzero < matrix.length){
					double[] rowTemp = matrix[nonzero];
					matrix[nonzero] = matrix[i];
					matrix[i] = rowTemp;
				}
			}
			//if found above
			if(matrix[i][j] != 0.0d){
				//divide current row by matrix[i][j]
				double divideby = matrix[i][j];
				for(int k=0; k < matrix[i].length; k++){
					matrix[i][k] /= divideby; 
				}
				//for each row(k), excluding row(i)
				for(int k=0; k < matrix.length; k++){
					if(k != i){
						//subtract row(i) matrix[k][j] times from row(k)
						subtract(matrix[i], matrix[k][j], matrix[k]);
					}
				}
				//i++
				i++;
			}
		}
		
			
		//remove this
		return matrix;
	}
	
	private static void subtract(double[] reference, double times, double[] target){
		for(int i=0; i < target.length; i++){
			target[i] -= reference[i]*times;
		}
	}
}
