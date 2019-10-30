package es.deusto.server;

import java.util.ArrayList;

public class Auth {

        //private String host;
        //private int port;
        private ArrayList<String> lista = new ArrayList <String>();

        /*public GoogleAuth(String arg1, int arg2)
        {
            host = arg1;
            port = arg2;
        }*/
        public int darAltaUsuario(String correo)
        {
            /*lista.add("IMANOL");
            lista.add("ANNE");
            lista.add("GARI");
            lista.add("BENAT");*/

            //TODO: ANADIR VALIDACION DE BD
            System.out.println("LLego1");
            return this.verificar(correo);
        }
        public int verificar(String msg) {
            int existe=-1;
            System.out.println("LLego2");
            /*for(String aux : lista)
            {
                if(aux.compareTo(msg)==0)
                    existe=0;
            }*/
            existe = 0;
            return existe;
        }
}
