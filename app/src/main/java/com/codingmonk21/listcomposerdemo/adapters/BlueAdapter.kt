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
import com.codingmonk21.listcomposerdemo.models.Blue

class BlueAdapter(onClick: ((model: Blue, id: Int) -> Unit)?) :
    DelegateAdapter<Blue, BlueAdapter.BlueViewHolder>(Blue::class.java, onClick) {

    class BlueViewHolder(
        private val binding: LayoutVhColorBinding,
        onClick: ((Blue, Int) -> Unit)?
    ) : BaseViewHolder<Blue>(binding, onClick) {
        override fun bindData(model: Blue) {
            binding.card.background = getColoredDrawable(binding.root.context, R.color.blue)
            binding.tvContent.text = model.name
            binding.tvContent.setTextColor(Color.WHITE)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        onClick: ((Blue, Int) -> Unit)?
    ): RecyclerView.ViewHolder {
        return BlueViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater
                    .from(parent.context), R.layout.layout_vh_color, parent, false
            ),
            onClick
        )
    }

    override fun onBindViewHolder(model: Blue, vh: BlueViewHolder) {
        vh.bind(model)
    }
}