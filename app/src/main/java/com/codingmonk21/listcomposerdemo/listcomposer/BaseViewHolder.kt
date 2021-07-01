package com.codingmonk21.listcomposerdemo.listcomposer

import androidx.annotation.CallSuper
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T : AdapterItem>(
    binding: ViewDataBinding,
    private val onClick: ((item: T, viewId: Int) -> Unit)? = null
) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var item: T

    init {
        binding.root.setOnClickListener {
            onClick?.invoke(item, binding.root.id)
        }
    }

    @CallSuper
    open fun bind(item: T) {
        this.item = item
        bindData(item)
    }

    protected abstract fun bindData(model: T)
}