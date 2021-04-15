package com.example.fragmentoskotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController


class PrimerFragment : Fragment(R.layout.fragment_primer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //mapeo de widgets
        val button = view.findViewById<Button>(R.id.btnNavegar)
        val texto = view.findViewById<TextView>(R.id.txtFragment1)

        //setear listener para recibir datos del fragment2
        setFragmentResultListener("requestKey"){ key, bundle ->
            val result = bundle.getString("bundleKey")
            texto.text = result
        }


        button.setOnClickListener{
            // findNavController().navigate(R.id.action_primerFragment_to_segundoFragment, bundleOf("nombre" to "Freddy", "edad" to 24))

            val action = PrimerFragmentDirections.actionPrimerFragmentToSegundoFragment("Freddy",24)
            findNavController().navigate(action)
            //findNavController().navigate(R.id.action_primerFragment_to_segundoFragment, bundleOf("nombre" to "Freddy", "edad" to 24))

        }
    }

    //para recibir los datos del fragment 2 debemos de escuchar un listener con setFragmentResultListener
    //para pasar parametros entre fragmento se agrego el plugin navigation-safe-args en el gradle del proyecto
    //classpath "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.4"
    // y en el gradle de la aplicación se agrego el plugin  id 'androidx.navigation.safeargs.kotlin'
}