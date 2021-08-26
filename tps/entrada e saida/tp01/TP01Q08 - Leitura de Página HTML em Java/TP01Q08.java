import java.io.*;
import java.net.*;

class TP01Q08 {
    
    public static boolean isFim(String s){
        return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    
    // codigo copiado do github da materia de aeds2
    public static String getHtml(String endereco){
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        try {
            url = new URL(endereco);
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                resp += line + "\n";
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } 

        try {
            is.close();
        } catch (IOException ioe) {
            // nothing to see here
        }

        return resp;
    }

    public static String lerHtml(String html){
        int a = 0, e = 0, i = 0, o = 0, u = 0;
        int aAcento = 0, eAcento = 0, iAcento = 0, oAcento = 0, uAcento = 0;
        int aAcento2 = 0, eAcento2 = 0, iAcento2 = 0, oAcento2 = 0, uAcento2 = 0;
        int aChapeu = 0, eChapeu = 0, iChapeu = 0, oChapeu = 0, uChapeu = 0;
        int aTil = 0, oTil = 0;
        int consoantes = 0;
        int br = 0, table = 0;
        for(int z = 0; z < html.length(); z++){
            if(html.charAt(z) == 'a'){
                a++;
            } else if(html.charAt(z) == 'e'){
                e++;
            } else if(html.charAt(z) == 'i'){
                i++;
            } else if(html.charAt(z) == 'o'){
                o++;
            } else if(html.charAt(z) == 'u'){
                u++;
            } else if((int)html.charAt(z) == 160){
                aAcento++;
            } else if((int)html.charAt(z) == 130){
                eAcento++;
            } else if((int)html.charAt(z) == 161){
                iAcento++;
            } else if((int)html.charAt(z) == 162){
                oAcento++;
            } else if((int)html.charAt(z) == 163){
                uAcento++;
            } else if((int)html.charAt(z) == 133){
                aAcento2++;
            } else if((int)html.charAt(z) == 138){
                eAcento2++;
            } else if((int)html.charAt(z) == 141){
                iAcento2++;
            } else if((int)html.charAt(z) == 149){
                oAcento2++;
            } else if((int)html.charAt(z) == 151){
                uAcento2++;
            } else if((int)html.charAt(z) == 131){
                aChapeu++;
            } else if((int)html.charAt(z) == 136){
                eChapeu++;
            } else if((int)html.charAt(z) == 140){
                iChapeu++;
            } else if((int)html.charAt(z) == 147){
                oChapeu++;
            } else if((int)html.charAt(z) == 150){
                uChapeu++;
            } else if((int)html.charAt(z) == 198){
                aTil++;
            } else if((int)html.charAt(z) == 229){
                oTil++;
            } else if(html.charAt(z) == '<' && html.charAt(z+1) == 'b' && html.charAt(z+2) == 'r' && html.charAt(z+3) == '>'){
                br++;
                z = z + 3;
            } else if(html.charAt(z) == '<' && html.charAt(z+1) == 't'&& html.charAt(z+2) == 'a' && html.charAt(z+3) == 'b' && html.charAt(z+4) == 'l' && html.charAt(z+5) == 'e' && html.charAt(z+6) == '>'){
                table++;
                z = z + 6;
            } else if(html.charAt(z) != 'a' && html.charAt(z) != 'e' && html.charAt(z) != 'i' && html.charAt(z) != 'o' && html.charAt(z) != 'u') {
                consoantes++;
            }
        }
        return "a("+a+") e("+e+") i("+i+") o("+o+") u("+u+") á("+aAcento+") é("+eAcento+") í("+iAcento+") ó("+oAcento+") ú("+uAcento+") à("+aAcento2+") è("+eAcento2+") ì("+iAcento2+") ò("+oAcento2+") ù("+uAcento2+") ã("+aTil+") õ("+oTil+") ầ("+aChapeu+") ê("+eChapeu+") î("+iChapeu+") ô("+oChapeu+") û("+uChapeu+") consoante("+consoantes+") <br>("+br+") <table>("+table+")";
    }

    public static void main(String[] args) {
        MyIO.setCharset("iso8859-1");
        String[] entrada = new String[2000];
        int numEntrada = 0;
        String html;

        do{
            entrada[numEntrada] = MyIO.readLine();
        }while(isFim(entrada[numEntrada++]) == false);
        numEntrada--;

        for(int i = 1; i < numEntrada; i= i + 2){
            html = getHtml(entrada[i]);
            MyIO.println(lerHtml(html) + " " + entrada[i-1]);
        }
   }    

}
