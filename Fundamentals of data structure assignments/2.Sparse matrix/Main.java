import java.util.*;
class sparse{
    public void convert(int rows,int columns,int[][]matrix){
        int k=1;
        int [][]sparse=new int[10][10];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(matrix[i][j]!=0){ //Making Sparse Matrix
                    sparse[k][0]=i;
                    sparse[k][1]=j;
                    sparse[k][2]=matrix[i][j];
                    k++;
                }
            }
        }
        sparse[0][0]=rows;
        sparse[0][1]=columns;
        sparse[0][2]=k-1;

        System.out.println("\t Rows Columns Values");
        for(int i=0;i<=sparse[0][2];i++){
            System.out.print("\n");
            for(int j=0;j<3;j++){
                System.out.print("\t"+sparse[i][j]);
            }
        }
        System.out.println("\n Transpose of given Sparse Matrix is (Simple Transpose)");
        int [][]transpose=new int[10][3];
         k=1;
        for(int z=0;z<sparse[0][1];z++){
            for(int i=1;i<=sparse[0][2];i++){ //Transpose Sparse Matrix
                if(sparse[i][1]==z){
                    transpose[k][0]=sparse[i][1];
                    transpose[k][1]=sparse[i][0];
                    transpose[k][2]=sparse[i][2];
                    k++;
                }
            }
        }
        transpose[0][0]=sparse[0][1];
        transpose[0][1]=sparse[0][0];
        transpose[0][2]=k-1;
        System.out.println("\t \n Rows Columns Values");
        for(int i=0;i<=sparse[0][2];i++){
            System.out.print("\n");
            for(int j=0;j<3;j++){
                System.out.print("\t"+transpose[i][j]);
            }
        }
        System.out.println(" \n Transpose using fast Transpose method ");
        int loc,i,col_no;
        int [][]result=new int[10][3];
        int []freq_count=new int[sparse.length];
        int []pos=new int[sparse.length+1];
        for(i=0;i<sparse[0][1];i++){
            freq_count[i]=0;
        }
        for(i=1;i<sparse[0][2];i++){
            col_no=sparse[i][1];
            freq_count[col_no]++;
        }
        pos[0]=1;
        for(i=1;i<sparse[0][1];i++){
            pos[i]=pos[i-1]+freq_count[i-1];
        }
        result[0][0]=sparse[0][1];
        result[0][1]=sparse[0][0];
        result[0][2]=sparse[0][2];
        for(i=1;i<=sparse[0][2];i++){
            col_no=sparse[i][1];
            loc=pos[col_no];
            result[loc][0]=sparse[i][1];
            result[loc][1]=sparse[i][0];
            result[loc][2]=sparse[i][2];
            pos[col_no]++;
        }
        System.out.println("\t \n Rows Columns Values");
        for( i=0;i<=result[0][2];i++){
            System.out.print("\n");
            for(int j=0;j<3;j++){
                System.out.print(" \t"+result[i][j]);
            }
        }


    }

}
public class Main {
    public static void main(String[]args){
        System.out.println("Program to perform function on Sparse Matrix");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows and columns");

        int [][] matrix=new int [10][10];
        int rows=sc.nextInt();
        int columns=sc.nextInt();
        System.out.println("Enter the elements of matrix");

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        sparse s=new sparse();
        s.convert(rows,columns,matrix);
    }
}


