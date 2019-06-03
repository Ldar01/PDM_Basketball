package com.example.pdm_parcial1.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pdm_parcial1.R
import com.example.pdm_parcial1.Room.Entities.MatchEntity

class ContentFragment : Fragment() {

    var match = MatchEntity()

    companion object{
        fun newInstance(book: MatchEntity):ContentFragment{
            val newFragment = ContentFragment()
            newFragment.match = book
            return newFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_content, container, false)

        //bindData(view)

        return view
    }
/*
    fun bindData(view: View){
        view.tv_title_book_activityf.text = match.Titulo
        view.tv_autoresf.text = match.Autores
        view.tv_caratulaf.text = match.Caratula
        view.tv_edicionf.text = match.Edicion.toString()
        view.tv_editorialesf.text = match.Editorial
        view.tv_isbnf.text = match.ISBN
        view.tv_resumenf.text = match.Resumen
        view.tv_tagf.text = match.Tag
    }

*/
}
