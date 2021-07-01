package com.codingmonk21.listcomposerdemo.listcomposer

data class FallbackConfig(
    val viewType: AdapterItem,
    val delegateAdapter: DelegateAdapter<out AdapterItem, *>
)