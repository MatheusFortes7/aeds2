class TP01Q06{
 
 public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    
    public static String isVogal(String s) {
        String z = s.toLowerCase();
        boolean resp = false;
        for(int i = 0; i < z.length(); i++){
            if(z.charAt(i) != 'a' || z.charAt(i) != 'e' || z.charAt(i) != 'i' || z.charAt(i) != 'o' || z.charAt(i) != 'u'){
                i = z.length();
                resp = false;
            } else {
                resp = true;
            }
        }
        if (resp == false){
            return "NAO";
        } else {
            return "SIM";
        }
    }

    public static String isConsoante(String s){
        String z = s.toLowerCase();
        boolean resp = false;
        for(int i = 0; i < z.length();i++){
            if(z.charAt(i) == 'a' || z.charAt(i) == 'e' || z.charAt(i) == 'i' || z.charAt(i) == 'o' || z.charAt(i) == 'u'){
                i = z.length();
                resp = false;
            } else {
                resp = true;
            }
        }
        if (resp == false){
            return "NAO";
        } else {
            return "SIM";
        }
    }

    //FALTA VER SE É INTEIRO (QUE NAO SEI COMO), E QUANDO ELE E U NUMERO REAL <----------------------------------------------------- IMPORTANTE check tipe

    public static void main (String[] args){
        String[] entrada = new String[1000];
        int numEntrada = 0;

        //Leitura da entrada padrao
        do {
           entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--;   //Desconsiderar ultima linha contendo a palavra FIM
  
        //Para cada linha de entrada, gerando uma de saida contendo o numero de letras maiusculas da entrada
        for(int i = 0; i < numEntrada; i++){
           MyIO.println(isVogal(entrada[i]) + isConsoante(entrada[i])  );
        }
     }
}