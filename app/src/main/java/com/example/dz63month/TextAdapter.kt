package com.example.dz63month

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dz63month.`interface`.OnItemTextListener
import com.example.dz63month.data.TextModel
import com.example.dz63month.databinding.ItemTextBinding

class TextAdapter(
    private val listText: MutableList<TextModel>,
    private val onItemTextListener: OnItemTextListener
) :
    RecyclerView.Adapter<TextAdapter.TextViewHolder>(), View.OnLongClickListener {

    inner class TextViewHolder(private val binding: ItemTextBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(textModel: TextModel) {
            binding.textMain.text = textModel.text
            itemView.setOnClickListener {
                onItemTextListener.onClick(textModel)
                binding.textMain.text = textModel.text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        return TextViewHolder(
            ItemTextBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.itemView.setOnLongClickListener(this)
        holder.onBind(listText[position])
        holder.itemView.setOnLongClickListener {
            listText.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
            true
        }
    }

    override fun getItemCount(): Int = listText.size

    override fun onLongClick(v: View?): Boolean {
        onItemTextListener.onLongClick(v?.tag as TextModel)
        return true
    }
}




