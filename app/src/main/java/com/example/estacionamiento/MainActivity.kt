package com.example.estacionamiento

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener  {

    //cuando utilize el spinner, esta opcion lo guardara en texto
    val horaentrada:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //declaracion de variables
       //val txHe=findViewById<EditText>(R.id.txHentrada)
        val spHe: Spinner = findViewById(R.id.spentrada)
        val txMe=findViewById<EditText>(R.id.txMentrada)
        val txHs=findViewById<EditText>(R.id.txHsalida)
        val txMs=findViewById<EditText>(R.id.txMsalida)
        val btCal=findViewById<Button>(R.id.btCalcular)

        ArrayAdapter.createFromResource(
            this,
            R.array.hentrada_spinner,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spHe.adapter = adapter
        }


        //boton operaciones
        btCal.setOnClickListener(View.OnClickListener {
            var H1=horaentrada.toInt()
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

                 if (NwMinutos>0 || NwMinutos>  59){
                     var SumaH =NwHoras+1
                     Toast.makeText(this,"HORA 1\n\n"+"H: "+NwHoras+"\n\n m: "+NwMinutos+"\nPago: "+SumaH*15, Toast.LENGTH_LONG).show()
                }
                else{
                     Toast.makeText(this,"hora 1.1\n"+"h: "+NwHoras+"\n m: "+NwMinutos+"\nPago: "+NwHoras*15, Toast.LENGTH_LONG).show()
                 }
                // Toast.makeText(this,"hora1\n"+"h"+NwHoras+"m"+NwMinutos, Toast.LENGTH_LONG).show()
            }else if (H1<H2 && M1>M2){
                var SumaM=M2+60
                var RestaH=H2-1

                var NwMinutos=SumaM-M1
                var NwHoras=RestaH-H1

               // Toast.makeText(this,"hora12\n"+"h"+NwHoras+"m"+NwMinutos, Toast.LENGTH_LONG).show()
                if (NwMinutos>0 || NwMinutos>  59){
                    var SumaH =NwHoras+1
                    Toast.makeText(this,"HORA 1\n\n"+"H: "+NwHoras+"\n\n m: "+NwMinutos+"\nPago: "+SumaH*15, Toast.LENGTH_LONG).show()
                }
                else {
                    Toast.makeText(
                        this,
                        "hora 1.1\n" + "h: " + NwHoras + "\n m: " + NwMinutos + "\nPago: " + NwHoras * 15,
                        Toast.LENGTH_LONG
                    ).show()
                }

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

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
        val spinner: Spinner = findViewById(R.id.spentrada)
        spinner.onItemSelectedListener = this
        horaentrada= spinner.getItemAtPosition(position).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}
