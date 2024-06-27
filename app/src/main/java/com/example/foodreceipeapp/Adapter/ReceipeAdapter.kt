package com.example.foodreceipeapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodreceipeapp.Model.Receipe
import com.example.foodreceipeapp.R
import com.example.foodreceipeapp.ReceipeBottomSheetFragment
import com.example.foodreceipeapp.ReceipeViewActivity

class ReceipeAdapter(private val dataList: ArrayList<Receipe>,private val requireContext: Context): RecyclerView.Adapter<ReceipeAdapter.ViewHolderClass>() {
    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvImage: ImageView = itemView.findViewById(R.id.imageView)
        val rvName: TextView = itemView.findViewById(R.id.recipeName)
        val rvMin: TextView = itemView.findViewById(R.id.receipeMin)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.popular_item, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.rvImage.setImageResource(currentItem.imageUrl)
        holder.rvName.text = currentItem.title
        holder.rvMin.text = currentItem.min.toString()

        holder.itemView.setOnClickListener {
            val intent = Intent(requireContext,ReceipeViewActivity::class.java)
           requireContext.startActivity(intent)

        }
    }

}