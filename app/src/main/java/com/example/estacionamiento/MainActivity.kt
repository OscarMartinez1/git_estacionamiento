package com.example.estacionamiento

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //declaracion de variables
        val txHe=findViewById<EditText>(R.id.txHentrada)
        val txMe=findViewById<EditText>(R.id.txMentrada)
        val txHs=findViewById<EditText>(R.id.txHsalida)
        val txMs=findViewById<EditText>(R.id.txMsalida)
        val btCal=findViewById<Button>(R.id.btCalcular)

        //boton operaciones
        btCal.setOnClickListener(View.OnClickListener {
            var H1=txHe.text.toString().toInt()
            var M1=txMe.text.toString().toInt()
            var H2=txHs.text.toString().toInt()
            var M2=txMs.text.toString().toInt()


            //inicio del if
            if (H1<0 || H1>24 || M1<0 || M1>59 ||
                H2<0 || H2>24 || M2<0 || M2>59){
                Toast.makeText(this,"NO exite esa hora", Toast.LENGTH_LONG).show()
            }
            else if (H1<H2 && M1<=M2){

                var NwHoras =H2-H1
                var NwMinutos=M2-M1
                 Toast.makeText(this,"hora1\n"+"h"+NwHoras+"m"+NwMinutos, Toast.LENGTH_LONG).show()
            }else if (H1<H2 && M1>M2){
                var SumaM=M2+60
                var RestaH=H2-1

                var NwMinutos=SumaM-M1
                var NwHoras=RestaH-H1

                Toast.makeText(this,"hora12\n"+"h"+NwHoras+"m"+NwMinutos, Toast.LENGTH_LONG).show()

            }else if (H1==H2){
                if (M1<M2){
                    var Rminutos=M2-M1
                    Toast.makeText(this,"estuviste "+Rminutos+"minutos \n pagaras hora completa "+15, Toast.LENGTH_LONG).show()

                }else{
                    Toast.makeText(this,"no es posible entrar antes de tu hora de salir "+15, Toast.LENGTH_LONG).show()
                }

            }else if (H1<H2|| M1<M2) {
                Toast.makeText(this,"TE PASASTE UN DIA SE TE COBRARA PENSION", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"ultimo else", Toast.LENGTH_LONG).show()
            }
        })



    }
}
