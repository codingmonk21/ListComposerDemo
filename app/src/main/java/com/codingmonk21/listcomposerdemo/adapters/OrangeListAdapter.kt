package com.codingmonk21.listcomposerdemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingmonk21.listcomposerdemo.R
import com.codingmonk21.listcomposerdemo.databinding.LayoutVhColorListBinding
import com.codingmonk21.listcomposerdemo.listcomposer.*
import com.codingmonk21.listcomposerdemo.models.NestedFallback
import com.codingmonk21.listcomposerdemo.models.OrangeList

class OrangeListAdapter(
    parentClick: ((model: OrangeList, id: Int) -> Unit)?,
    childClick: ((model: AdapterItem, id: Int) -> Unit)?
) :
    ListDelegateAdapter<OrangeList, OrangeListAdapter.OrangeListViewHolder>(
        OrangeList::class.java,
        parentClick,
        childClick
    ) {

    class OrangeListViewHolder(
        private val binding: LayoutVhColorListBinding,
        onParentClick: ((OrangeList, Int) -> Unit)?,
        onChildClick: ((AdapterItem, Int) -> Unit)?
    ) : BaseViewHolder<OrangeList>(binding, onParentClick) {
        private var adapter: ListComposer

        init {
            binding.rvColors.layoutManager =
                LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)

            adapter = ListComposer.Builder(
                FallbackConfig(
                    NestedFallback("Nested\nFallback"),
                    NestedFallbackAdapter()
                )
            )
                .add(OrangeAdapter(onChildClick))
                .add(GreenAdapter(onChildClick))
                .build()

            binding.rvColors.adapter = adapter
        }

        override fun bindData(model: OrangeList) {
            adapter.setData(model.list)
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(model: OrangeList, vh: OrangeListViewHolder) {
        vh.bind(model)
    }

    override fun onCreateListViewHolder(
        parent: ViewGroup,
        parentClick: ((OrangeList, Int) -> Unit)?,
        childClick: ((AdapterItem, Int) -> Unit)?
    ): RecyclerView.ViewHolder {
        return OrangeListViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater
                    .from(parent.context), R.layout.layout_vh_color_list, parent, false
            ),
            parentClick,
            childClick
        )
    }
}