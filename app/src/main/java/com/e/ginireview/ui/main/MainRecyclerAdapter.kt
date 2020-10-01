package com.e.ginireview.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.e.ginireview.R
import com.e.ginireview.model.NumberModel
import kotlinx.android.synthetic.main.list_item_100.view.*

class MainRecyclerAdapter(private val interaction: Interaction? = null) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<NumberModel>() {

        override fun areItemsTheSame(oldItem: NumberModel, newItem: NumberModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: NumberModel, newItem: NumberModel): Boolean {
            return oldItem.number == newItem.number
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun getItemViewType(position: Int): Int {
        return if (differ.currentList[position].isPairToResult0) {
            1
        } else {
            0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            0 -> return NumVH(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.list_item_50,
                    parent,
                    false
                ),
                interaction
            )
            1 -> return NumVH(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.list_item_100,
                    parent,
                    false
                ),
                interaction
            )
            else -> {
                return NumVH(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.list_item_100,
                        parent,
                        false
                    ),
                    interaction
                )
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NumVH -> {
                holder.bind(differ.currentList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<NumberModel>) {
        differ.submitList(list)
    }

    class NumVH
    constructor(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bind(item: NumberModel) = with(itemView) {
            itemView.setOnClickListener {
                interaction?.onItemSelected(adapterPosition, item)
            }

            tv_num_value.text = "My Number is: ${item.number}"
        }
    }

    interface Interaction {
        fun onItemSelected(position: Int, item: NumberModel)
    }
}
