TNT
  X3decimas
    analisis
    desarrollo
    programacion
    subir
  RED 
    Ignacio Gaete
    Jorge Vera

Ejercicio 1
        Usted se debe estacionar en un parquímetro, el cual tiene la siguiente tarifa: 
            De 0 a 25 minutos = $2850. 
            El valor del minuto adicional es de $28. 
            Genere un programa que calcule la cantidad de pesos (CLP) 
            que debe cancelar al parquímetro por estar estacionado por 
            N minutos, donde N debe ser ingresado por el usuario.
            Al ingresar el valor, este no debe estar vacío.
            Solo debe mostrar el último resultado ingresado.
            
SEUDOCODIGO
    PROGRAMA: parquimetro
        constantes:  //diccionario
            tarifa0a25=2850
            minutoAdicional=28
        INPUT:
            tiempo //valida no vacio
        PROCESO:
            BOTON
                btnCalculo
                    totalPesos=calculo(tiempo)
                    totalPesos=tarifa0a25+(tiempo*minutoAdicional)
                    presenta 
                    limpia el input
        OUTPUT:
            TEXTVIEW Y TOAST
                txvTotal=totalPesos
