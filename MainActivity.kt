package com.example.loginapp
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class MainActivity : AppCompatActivity() {
    private var listado : ArrayList<Datos> = ArrayList<Datos>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // COMPONENTES
        // BOTON INGRESAR
    }
    // AGREGA DATOS USUARIO PASS A LA LISTA
    fun ingresarDatos(){
        if(listadoFinal.isEmpty()){
            listadoFinal.add(Datos("ADMIN", "ADMIN"))
            listadoFinal.add(Datos("JVV", "JVV"))
        }
    }
    //Retorna validacion
    fun validar(usuario: EditText, password: EditText){
        var respuesta = "Usuario no existe"
        try {
            for (item in listadoFinal) {
                if (item.getUsr().equals(usuario.text.toString())) {
                    if (item.getPass() == password.text.toString()) {
                        // entra al sistema
                        val menu = Intent(this, Menu::class.java)
                        //menu.putExtra("USUARIO", usuario.text.toString())
                        usuario_ingresa =  usuario.text.toString() // declarada global en class Datos.kt
                        startActivity(menu)
                        finish()
                        respuesta = "Bienvenido: ${usuario.text}"
                    } else {
                        respuesta = "Contraseña incorrecta"
                    }
                }
            }
        }catch (ex: Exception){
           respuesta = ex.toString()
        }
        Toast.makeText(this,
                        respuesta,
                        Toast.LENGTH_SHORT).show()
    }
}