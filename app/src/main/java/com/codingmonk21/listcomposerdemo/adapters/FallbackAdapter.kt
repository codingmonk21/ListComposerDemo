package com.codingmonk21.listcomposerdemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.codingmonk21.listcomposerdemo.R
import com.codingmonk21.listcomposerdemo.databinding.LayoutVhFallbackBinding
import com.codingmonk21.listcomposerdemo.listcomposer.BaseViewHolder
import com.codingmonk21.listcomposerdemo.listcomposer.DelegateAdapter
import com.codingmonk21.listcomposerdemo.models.Fallback

class FallbackAdapter :
    DelegateAdapter<Fallback, FallbackAdapter.FallbackViewHolder>(Fallback::class.java) {

    class FallbackViewHolder(private val binding: LayoutVhFallbackBinding) :
        BaseViewHolder<Fallback>(binding) {

        override fun bindData(model: Fallback) {
            binding.tvContent.text = model.content
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(model: Fallback, vh: FallbackViewHolder) {
        vh.bind(model)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        onClick: ((Fallback, viewId: Int) -> Unit)?
    ): RecyclerView.ViewHolder {
        return FallbackViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater
                    .from(parent.context), R.layout.layout_vh_fallback, parent, false
            ),
        )
    }
}