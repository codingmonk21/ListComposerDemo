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
import com.codingmonk21.listcomposerdemo.models.Purple

class PurpleAdapter(onClick: ((model: Purple, id: Int) -> Unit)?) :
    DelegateAdapter<Purple, PurpleAdapter.PurpleViewHolder>(Purple::class.java, onClick) {

    class PurpleViewHolder(
        private val binding: LayoutVhColorBinding,
        onClick: ((Purple, Int) -> Unit)?
    ) : BaseViewHolder<Purple>(binding, onClick) {

        override fun bindData(model: Purple) {
            binding.card.background = getColoredDrawable(binding.root.context, R.color.purple)
            binding.tvContent.text = model.name
            binding.tvContent.setTextColor(Color.WHITE)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        onClick: ((Purple, Int) -> Unit)?
    ): RecyclerView.ViewHolder {
        return PurpleViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater
                    .from(parent.context), R.layout.layout_vh_color, parent, false
            ),
            onClick
        )
    }

    override fun onBindViewHolder(model: Purple, vh: PurpleViewHolder) {
        vh.bind(model)
    }
}