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
import com.codingmonk21.listcomposerdemo.models.Yellow

class YellowAdapter(onClick: ((model: Yellow, id: Int) -> Unit)?) :
    DelegateAdapter<Yellow, YellowAdapter.YellowViewHolder>(Yellow::class.java, onClick) {

    class YellowViewHolder(
        private val binding: LayoutVhColorBinding,
        onClick: ((Yellow, Int) -> Unit)?
    ) : BaseViewHolder<Yellow>(binding, onClick) {

        override fun bindData(model: Yellow) {
            binding.card.background = getColoredDrawable(binding.root.context, R.color.yellow)
            binding.tvContent.text = model.name
            binding.tvContent.setTextColor(Color.BLACK)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        onClick: ((Yellow, Int) -> Unit)?
    ): RecyclerView.ViewHolder {
        return YellowViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater
                    .from(parent.context), R.layout.layout_vh_color, parent, false
            ),
            onClick
        )
    }

    override fun onBindViewHolder(model: Yellow, vh: YellowViewHolder) {
        vh.bind(model)
    }
}