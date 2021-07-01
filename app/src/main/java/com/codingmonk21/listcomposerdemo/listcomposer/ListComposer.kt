package com.codingmonk21.listcomposerdemo.listcomposer

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

@Suppress("UNCHECKED_CAST")
class ListComposer private constructor(
    private var data: List<AdapterItem>,
    delegateAdapters: List<DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>>,
    fallbackConfig: FallbackConfig,
    tag: String
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val delegateManager: DelegateManager by lazy { DelegateManager() }

    init {
        delegateManager.init(delegateAdapters, fallbackConfig, tag)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val delegate = delegateManager.getDelegateForViewType(viewType)
        return delegate.onCreateViewHolder(parent, delegate.onClick)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val delegate = delegateManager.getDelegateForViewType(holder.itemViewType)
        val item = if (delegateManager.isFallbackDelegate(delegate)) {
            delegateManager.getFallbackItem()
        } else data[position]
        delegate.onBindViewHolder(item, holder)
    }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int {
        return delegateManager.getViewTypeForItem(data[position])
    }

    fun setData(data: List<AdapterItem>) {
        this.data = data
        notifyDataSetChanged()
    }

    class Builder(private val fallbackConfig: FallbackConfig) {
        private val delegateAdapters: MutableList<DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>> by lazy { mutableListOf() }
        private var tag: String = "list_composer"

        fun add(delegateAdapter: DelegateAdapter<out AdapterItem, *>): Builder {
            delegateAdapters.add(delegateAdapter as DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>)
            return this
        }

        fun debugTag(tag: String): Builder {
            this.tag = tag
            return this
        }

        fun build(): ListComposer {
            require(delegateAdapters.size != 0) { "At least one delegate is required" }
            return ListComposer(listOf(), delegateAdapters, fallbackConfig, tag)
        }
    }
}