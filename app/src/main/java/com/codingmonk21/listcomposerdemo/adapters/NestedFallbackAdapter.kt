package com.codingmonk21.listcomposerdemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.codingmonk21.listcomposerdemo.R
import com.codingmonk21.listcomposerdemo.databinding.LayoutVhNestedFallbackBinding
import com.codingmonk21.listcomposerdemo.listcomposer.BaseViewHolder
import com.codingmonk21.listcomposerdemo.listcomposer.DelegateAdapter
import com.codingmonk21.listcomposerdemo.models.NestedFallback

class NestedFallbackAdapter :
    DelegateAdapter<NestedFallback, NestedFallbackAdapter.NestedFallbackViewHolder>(NestedFallback::class.java) {

    class NestedFallbackViewHolder(private val binding: LayoutVhNestedFallbackBinding) :
        BaseViewHolder<NestedFallback>(binding) {

        override fun bindData(model: NestedFallback) {
            binding.tvContent.text = model.content
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(model: NestedFallback, vh: NestedFallbackViewHolder) {
        vh.bind(model)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        onClick: ((NestedFallback, viewId: Int) -> Unit)?
    ): RecyclerView.ViewHolder {
        return NestedFallbackViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater
                    .from(parent.context), R.layout.layout_vh_nested_fallback, parent, false
            ),
        )
    }
}