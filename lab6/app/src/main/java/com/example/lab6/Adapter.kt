package com.example.lab6

import Model
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val context: Context,
              private val list: ArrayList<Model>,
              private val cellClickListener: CellClickListener
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val number: TextView = view.findViewById(R.id.number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cell_view,parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]

        holder.number.text = data.number.toString()
        val gradientDrawable = holder.number.background as StateListDrawable
        val drawableContainerState = gradientDrawable.constantState as DrawableContainer.DrawableContainerState
        val children = drawableContainerState.children
        val selectedItem = children[0] as GradientDrawable
        selectedItem.setColor(Color.parseColor(data.color))

        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(data.number.toString())
        }
    }
}