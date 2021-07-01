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
import com.codingmonk21.listcomposerdemo.models.Red

class RedAdapter(onClick: (model: Red, id: Int) -> Unit) :
    DelegateAdapter<Red, RedAdapter.RedViewHolder>(Red::class.java, onClick) {

    class RedViewHolder(
        private val binding: LayoutVhColorBinding,
        onClick: ((Red, Int) -> Unit)?
    ) : BaseViewHolder<Red>(binding, onClick) {

        override fun bindData(model: Red) {
            binding.card.background = getColoredDrawable(binding.root.context, R.color.red)
            binding.tvContent.text = model.name
            binding.tvContent.setTextColor(Color.BLACK)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        onClick: ((Red, Int) -> Unit)?
    ): RecyclerView.ViewHolder {
        return RedViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater
                    .from(parent.context), R.layout.layout_vh_color, parent, false
            ),
            onClick
        )
    }

    override fun onBindViewHolder(model: Red, vh: RedViewHolder) {
        vh.bind(model)
    }
}