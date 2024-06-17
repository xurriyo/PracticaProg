import java.util.Locale;

public  class Validaciones {

    //Crear todas las clases en estaticas
    public static boolean comprobarnombre(String nombre) {
        nombre=nombre.toLowerCase();
        int i;
        boolean comprobar= true;
        for (i = 0; i < nombre.length(); i++) {
            char letra = nombre.charAt(i);
            if ((letra < 'a' || letra > 'z') && letra != 'á' && letra != 'é' && letra != 'ú' && letra != 'ó' && letra != 'í' && letra != 'Á' && letra != 'Ú' && letra != 'É' && letra != 'Ó' && letra != 'Í' && letra != 'ñ' && letra != 'Ñ' && letra != ' ' && letra!='ç' && letra!='ü' && letra!='Ü') {
                System.out.println("Vuelve a repetir el nombre");
                comprobar= false;
            }
        }
        return comprobar;
    }

    public static boolean comprobaremail(String email){
        email=email.toUpperCase();
        email=email.replace(" ","");
        int i;
        boolean comprobar=true;

        for ( i= 0;i<email.length();i++){
            // Que no tenga al empezar ningun @ o un .
            if (email.length()!=0){
                if (email.charAt(0)=='@' || email.charAt(0)=='.'){
                    System.out.println("vuelve a repetir el email");
                    return false;
                }
            }
            //Bucle para comprobar si hay algun caracter extraño
            for (i=0;i<email.length();i++){
                if ((email.charAt(i)<'A'||email.charAt(i)>'Z')&& (email.charAt(i) != '@' && email.charAt(i) != '.') && (email.charAt(i) < '0' || email.charAt(i) >= '9')){
                    System.out.println("Vuelve a introducir el email.");
                    return false;
                    }
                }
            }
            if (email.indexOf("@")==-1){
                //vamos a comprobar si  tiene algun @
                System.out.println("Error al introducir el email");
            }else {
                // Verificar si el correo tiene más de una @
                int validar = email.indexOf("@");
                int mostrar = email.indexOf(".");
                if (email.indexOf("@", validar + 1) != -1) {
                    System.out.print("Vuelve a introducir el correo electronico: ");//Contiene @ de mas
                    return false;
                } else {
                    // Verificar si el correo tiene un punto después de la @
                    if (email.indexOf(".", mostrar) == -1) {
                        System.out.print("Vuelve a introducir el correo electronico: ");//Falta un .
                        return false;
                    }

                }
            }
            return comprobar;
        }


    public static boolean comprobartelefono(String telefono){
        boolean comprobar=true;
        telefono = telefono.replace(" ", "");
        telefono = telefono.replace("-", "");
        telefono = telefono.replace(".", "");

        if (telefono.length() == 9){
            for (int i = 0; i < 9 ; i++){
                if (telefono.charAt(i) < '0' || telefono.charAt(i) > '9'){
                    System.out.println("Supera el limite de caracteres vuelve a escribirlo");
                    return comprobar=false;
                }
            }
        } else {
            System.out.println("Vuelve a introducir el telefono");
            return comprobar=false;
        }
        return comprobar;
    }
}

