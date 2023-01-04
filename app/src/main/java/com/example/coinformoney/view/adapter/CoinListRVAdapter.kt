package com.example.coinformoney.view.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coinformoney.R
import com.example.coinformoney.datamodel.CurrentPriceResult
import com.example.coinformoney.db.entity.InterestCoinEntity
import timber.log.Timber

class CoinListRVAdapter(val context: Context, val dataSet: List<InterestCoinEntity>) :
    RecyclerView.Adapter<CoinListRVAdapter.ViewHolder>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val coinName = view.findViewById<TextView>(R.id.coinName)
        val likeBtn = view.findViewById<ImageView>(R.id.likeBtn)
        val coinPriceUpDown = view.findViewById<TextView>(R.id.coinPriceUpDown)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.main_coin_item, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.setOnClickListener { v ->
            itemClick?.onClick(v, position)
        }
        val fluctate_24H = dataSet[position].fluctate_24H

        if(fluctate_24H.contains("-")) {
            holder.coinPriceUpDown.text = "하락세입니다."
            holder.coinPriceUpDown.setTextColor(Color.parseColor("#114fed"))
        } else {
            holder.coinPriceUpDown.text = "상승세입니다."
            holder.coinPriceUpDown.setTextColor(Color.parseColor("#ed2e11"))
        }
        holder.coinName.text = dataSet[position].coin_name
        val selected = dataSet[position].selected
        if (selected) {
            holder.likeBtn.setImageResource(R.drawable.like_red)
        } else {
            holder.likeBtn.setImageResource(R.drawable.like_grey)
        }


    }

    override fun getItemCount(): Int {
        return dataSet.size
    }


}