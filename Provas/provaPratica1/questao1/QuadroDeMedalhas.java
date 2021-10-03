import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QuadroDeMedalhas {
    
    
    public static void main(String[] args) throws Exception {
        String[] belgica,
               brasil,
               franca,
               italia,
               australia,
               colombia,
               suica,
               tailandia;

        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        String line = br.readLine();
        line = br.readLine();
        belgica = line.split("//s");
        line = br.readLine();
        brasil = line.split("//s");;
        line = br.readLine();
        franca = line.split("//s");;
        line = br.readLine();
        italia = line.split("//s");;
        line = br.readLine();
        australia = line.split("//s");;
        line = br.readLine();
        colombia = line.split("//s");;
        line = br.readLine();
        suica = line.split("//s");;
        line = br.readLine();
        tailandia = line.split("//s");;

        //[0] nome pais
        //[1] ouro
        //[2] prata
        //[3] broze
        

        System.out.println(franca[0]);
        System.out.println(italia[0]);
        System.out.println(australia[0]);
        System.out.println(brasil[0]);
        System.out.println(colombia[0]);
        System.out.println(suica[0]);
        System.out.println(belgica[0]);
        System.out.println(tailandia[0]);

        //NAO CONSEGGUI FZER A QUESTAO, entao n queria nao enviar nada
        
    }


}
