package com.example.dz63month

import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dz63month.`interface`.OnItemTextListener
import com.example.dz63month.data.TextModel
import com.example.dz63month.databinding.ItemTextBinding

class TextAdapter( private  val listText : MutableList<TextModel>,
         private val  OnItemTextListener:OnItemTextListener):
    RecyclerView.Adapter<TextAdapter.TextViewHolder>() {

    inner class TextViewHolder(private val binding:ItemTextBinding) : RecyclerView.ViewHolder(binding.root) {


        fun onBind(textModel: TextModel) {
            binding.textMain.text = textModel.text

             itemView.setOnClickListener{
                 OnItemTextListener.onClick(textModel)
             }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(ItemTextBinding.inflate(LayoutInflater.
        from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.onBind(listText[position])
    }

    override fun getItemCount(): Int = listText.size
}