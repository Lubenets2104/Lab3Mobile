package com.example.dailycooking.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dailycooking.R
import com.example.dailycooking.data.Tip

class TipAdapter(
    private val tips: List<Tip>,
    private val onItemClick: (Tip) -> Unit
) : RecyclerView.Adapter<TipAdapter.TipViewHolder>() {

    class TipViewHolder(
        itemView: View,
        private val onItemClick: (Tip) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {

        private val textDayLabel: TextView = itemView.findViewById(R.id.text_day_label)
        private val textTitle: TextView = itemView.findViewById(R.id.text_title)
        private val imageTip: ImageView = itemView.findViewById(R.id.image_tip)
        private val textShortDescription: TextView = itemView.findViewById(R.id.text_short_description)

        private var currentTip: Tip? = null

        init {
            itemView.setOnClickListener {
                currentTip?.let(onItemClick)
            }
        }

        fun bind(tip: Tip) {
            currentTip = tip
            textDayLabel.text = itemView.context.getString(R.string.day_label, tip.dayNumber)
            textTitle.text = itemView.context.getString(tip.titleResId)
            imageTip.setImageResource(tip.imageResId)
            textShortDescription.text = itemView.context.getString(tip.shortDescriptionResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tip, parent, false)
        return TipViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        holder.bind(tips[position])
    }

    override fun getItemCount(): Int = tips.size
}
