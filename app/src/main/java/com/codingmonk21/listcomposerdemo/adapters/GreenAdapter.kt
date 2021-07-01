package com.codingmonk21.listcomposerdemo.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.codingmonk21.listcomposerdemo.R
import com.codingmonk21.listcomposerdemo.databinding.LayoutVhColorBinding
import com.codingmonk21.listcomposerdemo.getColoredDrawable
import com.codingmonk21.listcomposerdemo.listcomposer.BaseViewHolder
import com.codingmonk21.listcomposerdemo.listcomposer.DelegateAdapter
import com.codingmonk21.listcomposerdemo.models.Green

class GreenAdapter(onClick: ((model: Green, id: Int) -> Unit)?) :
    DelegateAdapter<Green, GreenAdapter.GreenViewHolder>(Green::class.java, onClick) {

    class GreenViewHolder(
        private val binding: LayoutVhColorBinding,
        onClick: ((Green, Int) -> Unit)?
    ) : BaseViewHolder<Green>(binding, onClick) {

        override fun bindData(model: Green) {
            binding.card.background = getColoredDrawable(binding.root.context, R.color.green)
            binding.tvContent.text = model.name
            binding.tvContent.setTextColor(Color.BLACK)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        onClick: ((Green, Int) -> Unit)?
    ): RecyclerView.ViewHolder {
        return GreenViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater
                    .from(parent.context), R.layout.layout_vh_color, parent, false
            ),
            onClick
        )
    }

    override fun onBindViewHolder(model: Green, vh: GreenViewHolder) {
        vh.bind(model)
    }
}