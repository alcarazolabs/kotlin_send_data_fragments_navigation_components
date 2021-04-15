package com.example.fragmentoskotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.navArgs


class SegundoFragment : Fragment(R.layout.fragment_segundo) {

    //si obtenemos los argumentos antes en el onCreate decimos que
    //podemos usar usar los argumentos antes de que se cree y luego los podemos usar en el onViewCreated
    //lo ideal es hacerlo dentro del onCreate() ya que antes de iniciar ya estamos obteniendo los valores
    private var nombre: String? = ""
    private var edad: Int? = 0
    private val args: SegundoFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //obtener argmentos primera forma:
        //arguments?.getString(..)
        //Segunda forma con requireArguments -- ver clase retorna exception cuando es nulo
       // nombre = requireArguments().getString(MI_NOMBRE)
        //edad = requireArguments().getInt(MI_EDAD)
        //usando primera forma para no tener exception
        /*
        arguments?.let { bundle ->
            nombre = bundle.getString(MI_NOMBRE)
            edad = bundle.getInt(MI_EDAD)
        }
        */
        nombre = args.nombre
        edad = args.edad
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = view.findViewById<TextView>(R.id.txtFragment2)
        val button = view.findViewById<Button>(R.id.btnNavegarFrg2)
        button.setOnClickListener{
            val result = "Resultado data de fragment 2.."
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))

        }
        text.text = "Nombre: $nombre Edad: $edad"
    }

    companion object{ //metodos estaticos y variables
        //claves para acceder desde los argumentos
        private const val MI_NOMBRE = "nombre"
        private const val MI_EDAD = "edad"
        //newInstance hace referencia de una segunda instancia de SegundoFragment
        //apply = aplicar argumentos
        //bundleOf: crear un set de claves valor
        fun newInstance(nombre: String, edad: Int) = SegundoFragment().apply {
            arguments = bundleOf(
                    MI_NOMBRE to nombre,
                    MI_EDAD to edad)
        }
    }

}