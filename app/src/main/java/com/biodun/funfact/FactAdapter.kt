package com.biodun.funfact

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FactAdapter(context: Context, fact: List<FactModel>) : ArrayAdapter<FactModel>(context, 0, fact){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val fact = getItem(position)
        if (view == null){
            view = LayoutInflater.from(parent.context).inflate(R.layout.fact_item, parent, false)
        }
        var logo = view?.findViewById<ImageView>(R.id.image_logo)
        var name = view?.findViewById<TextView>(R.id.nameTv)
        fact?.logo?.let {
            logo?.setImageResource(fact.logo)
        }
        name?.text = fact?.name

        view?.setOnClickListener{
            val intent = Intent(parent.context, DetailActivity::class.java)
            intent.putExtra(LOGO_EXTRAS, fact?.logo)
            intent.putExtra(NAME_EXTRAS, fact?.name)
            intent.putExtra(FACT_EXTRAS, fact?.fact)
            parent.context.startActivity(intent)
        }

        return view!!
    }

    companion object{
        val LOGO_EXTRAS = "logo extras"
        val NAME_EXTRAS = "name extras"
        val FACT_EXTRAS = "fact extras"
    }
}