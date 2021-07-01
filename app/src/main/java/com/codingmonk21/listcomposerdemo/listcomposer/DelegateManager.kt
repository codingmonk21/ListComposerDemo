package com.codingmonk21.listcomposerdemo.listcomposer

import androidx.recyclerview.widget.RecyclerView

@Suppress("UNCHECKED_CAST")
class DelegateManager : DelegateStore {
    private val delegateStore: DelegateStore by lazy { DelegateStoreImpl() }

    override fun init(
        delegateAdapters: List<DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>>,
        fallbackConfig: FallbackConfig,
        tag: String,
    ) = delegateStore.init(delegateAdapters, fallbackConfig, tag)

    override fun addDelegate(delegateAdapter: DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>) =
        delegateStore.addDelegate(delegateAdapter)

    override fun addDelegates(delegateAdapters: List<DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>>) =
        delegateStore.addDelegates(delegateAdapters)

    override fun getViewTypeForItem(item: AdapterItem): Int =
        delegateStore.getViewTypeForItem(item)

    override fun getDelegateForViewType(viewType: Int): DelegateAdapter<AdapterItem, RecyclerView.ViewHolder> =
        delegateStore.getDelegateForViewType(viewType)

    override fun isFallbackDelegate(delegateAdapter: DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>): Boolean =
        delegateStore.isFallbackDelegate(delegateAdapter)

    override fun getFallbackItem(): AdapterItem =
        delegateStore.getFallbackItem()

    override fun clear() = delegateStore.clear()

    private class DelegateStoreImpl : DelegateStore {
        private val delegateAdapters: MutableList<DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>> by lazy { mutableListOf() }
        private val viewTypePosPair: MutableMap<Class<*>, Int> by lazy { mutableMapOf() }
        private lateinit var fallbackConfig: FallbackConfig
        private lateinit var tag: String

        override fun init(
            delegateAdapters: List<DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>>,
            fallbackConfig: FallbackConfig,
            tag: String
        ) {
            this.tag = tag
            addDelegates(delegateAdapters)
            setCallbackConfig(fallbackConfig)
        }

        override fun addDelegate(delegateAdapter: DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>) {
            if (viewTypePosPair[delegateAdapter.viewType] == null) {
                delegateAdapters.add(delegateAdapter)
                viewTypePosPair[delegateAdapter.viewType] = delegateAdapters.size - 1
            }
        }

        override fun addDelegates(delegateAdapters: List<DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>>) {
            for (delegate in delegateAdapters) {
                addDelegate(delegate)
            }
        }

        override fun getViewTypeForItem(item: AdapterItem): Int {
            return viewTypePosPair[item.javaClass] ?: viewTypePosPair[fallbackConfig.viewType.javaClass]!!
        }

        override fun getDelegateForViewType(viewType: Int): DelegateAdapter<AdapterItem, RecyclerView.ViewHolder> {
            return delegateAdapters[viewType]
        }

        private fun setCallbackConfig(config: FallbackConfig) {
            fallbackConfig = config
            addDelegate(fallbackConfig.delegateAdapter as DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>)
        }

        override fun isFallbackDelegate(delegateAdapter: DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>): Boolean {
            return delegateAdapter.viewType == fallbackConfig.viewType::class.java
        }

        override fun getFallbackItem(): AdapterItem = fallbackConfig.viewType

        override fun clear() {
            delegateAdapters.clear()
            viewTypePosPair.clear()
        }
    }
}