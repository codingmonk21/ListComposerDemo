package com.codingmonk21.listcomposerdemo.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.codingmonk21.listcomposerdemo.R
import com.codingmonk21.listcomposerdemo.databinding.LayoutVhNestedColorBinding
import com.codingmonk21.listcomposerdemo.getColoredDrawable
import com.codingmonk21.listcomposerdemo.listcomposer.BaseViewHolder
import com.codingmonk21.listcomposerdemo.listcomposer.DelegateAdapter
import com.codingmonk21.listcomposerdemo.models.Orange

class OrangeAdapter(onClick: ((model: Orange, id: Int) -> Unit)?) :
    DelegateAdapter<Orange, OrangeAdapter.OrangeViewHolder>(Orange::class.java, onClick) {

    class OrangeViewHolder(
        private val binding: LayoutVhNestedColorBinding,
        onClick: ((Orange, Int) -> Unit)?
    ) : BaseViewHolder<Orange>(binding, onClick) {

        override fun bindData(model: Orange) {
            binding.card.background = getColoredDrawable(binding.root.context, R.color.orange)
            binding.tvContent.text = model.name
            binding.tvContent.setTextColor(Color.BLACK)
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        onClick: ((Orange, Int) -> Unit)?
    ): RecyclerView.ViewHolder {
        return OrangeViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater
                    .from(parent.context), R.layout.layout_vh_nested_color, parent, false
            ),
            onClick
        )
    }

    override fun onBindViewHolder(model: Orange, vh: OrangeViewHolder) {
        vh.bind(model)
    }
}