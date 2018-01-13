import java.lang.reflect.Array;
import java.util.Arrays;
import java.io.IOException;

public class BoadMake {
    String[][] block;

    public BoadMake(){

    }

    public void MakeBoad(){
        block = new String[19][19];
        int i,f,g,h,j,k,l,p,t,m;
        for(i=0; i<19 ;i++){
            block[0][i] = "_";
        }
        for(t=1;t<19;t++){
            block[t][0]="|";
        }
        for(g=1;g<19;g=g+2) {
            for (h=1,j=2 ; h < 19; h=h+2,j=j+2) {
                block[g][j] = "|";
                block[g][h] = "　";
            }
        }
        for(k=2;k<17;k=k+2) {
            for (l=2,p=1 ; l < 19; l=l+2,p=p+2) {
                block[k][p] = "-";
                block[k][l] = "+";
            }
        }
        for(m=1;m<19;m++){
            block[m][18]="|";
        }
        for(f=0; f<19 ;f++) {
            block[18][f] = "¯";
        }
        String[] test = block[0];
        String test2 = String.join(",",test);
        String test3 = test2.replace(",","");
        System.out.println(test3);
    }

    public void PrintBoad(){

    }
}

