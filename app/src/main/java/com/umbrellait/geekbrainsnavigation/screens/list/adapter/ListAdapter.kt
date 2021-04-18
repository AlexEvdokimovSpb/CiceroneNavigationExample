package com.umbrellait.geekbrainsnavigation.screens.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.umbrellait.geekbrainsnavigation.databinding.ItemListBinding

class ListAdapter(
    private val data: List<String>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onClickListener: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            onClickListener
        )

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(data[position])
    }

    inner class ViewHolder(
        private val binding: ItemListBinding,
        private var onClickListener: ((String) -> Unit)?
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {
            with(binding) {
                textView.text = item

                root.setOnClickListener {
                    onClickListener?.invoke(item)
                }
            }
        }
    }
}