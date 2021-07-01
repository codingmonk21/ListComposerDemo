package com.codingmonk21.listcomposerdemo.listcomposer

import androidx.recyclerview.widget.RecyclerView

interface DelegateStore {
    fun init(
        delegateAdapters: List<DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>>,
        fallbackConfig: FallbackConfig,
        tag: String
    )

    fun addDelegate(delegateAdapter: DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>)
    fun addDelegates(delegateAdapters: List<DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>>)
    fun getViewTypeForItem(item: AdapterItem): Int
    fun getDelegateForViewType(viewType: Int): DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>
    fun isFallbackDelegate(delegateAdapter: DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>): Boolean
    fun getFallbackItem(): AdapterItem
    fun clear()
}