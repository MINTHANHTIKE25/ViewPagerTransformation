package com.minthanhtike.swipeablewithframlayout

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.minthanhtike.swipeablewithframlayout.databinding.ActivityRecyclerViewWithItemDecoratorBinding
import com.minthanhtike.swipeablewithframlayout.databinding.ItemBinding
import java.util.Random


class RecyclerViewWithItemDecorator : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewWithItemDecoratorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecyclerViewWithItemDecoratorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        linearLayoutManager.reverseLayout = true
        val overlapAmount = 500
        recyclerView.addItemDecoration(OverlapDecorator(overlapAmount))

        val adapter = Adapter()
        recyclerView.adapter = adapter
    }


    internal class Adapter() : RecyclerView.Adapter<Adapter.ItemViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            ItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ).apply {
                return ItemViewHolder(this)
            }
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            holder.view.text = position.toString()
            holder.view.setTextColor(
                Color.BLACK
            )
            val rand: Random = Random()
            val bgColor = when(position){
                0 -> Color.BLUE
                1 -> Color.CYAN
                2 -> Color.DKGRAY
                3 -> Color.RED
                4 -> Color.YELLOW
                else -> Color.TRANSPARENT
            }
            holder.itemView.setBackgroundColor(bgColor)
        }

        override fun getItemCount(): Int {
            return 5
        }

        internal inner class ItemViewHolder(itemView: ItemBinding) :
            RecyclerView.ViewHolder(itemView.root) {
            var view: TextView = itemView.text
        }
    }
}