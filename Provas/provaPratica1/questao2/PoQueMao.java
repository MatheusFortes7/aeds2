import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;


public class PoQueMao {
    
    
    public static void main(String[] args) throws Exception{
        int N = 0, 
            X = 0, 
            Y = 0, 
            Z = 0;
        int Evolucao = 0;

        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        String line = br.readLine();
        String[] doces = line.split("/n");
        
        line = br.readLine();
        String[] pokemon1 = line.split("/n");

        line = br.readLine();
        String[] pokemon2 = line.split("/n");

        line = br.readLine();
        String[] pokemon3 = line.split("/n");



        N = Integer.parseInt(doces[0]);
        X = Integer.parseInt(pokemon1[0]);
        Y = Integer.parseInt(pokemon2[0]);
        Z = Integer.parseInt(pokemon3[0]);
        
        //System.out.println(N);
        //System.out.println(X);
        //System.out.println(Y);
        //System.out.println(Z);

        if(N >= (X+Y+Z)){
            Evolucao = 3;
        }else if(N >= X || N>= Y || N>= Z){
            if(N >= (X + Y) || N >= (X + Z) || N >= (Z + Y)){
                Evolucao = 2;
            }else{
                Evolucao = 1;
            }
        }
        
        System.out.println(Evolucao);
    
    }    

}



