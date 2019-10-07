package com.architeture.proprosal.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.architeture.proposal.databinding.ItemProductBinding
import com.architeture.proprosal.presentation.view.model.persistence.ProductViewModel

typealias OnClickItemListener = (product: ProductViewModel) -> Unit

class ProductAdapter (
    val products: MutableList<ProductViewModel> = mutableListOf(),
    val onClickitemListener: OnClickItemListener
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(), AdapterItemsContract {

    override fun onCreateViewHolder(container: ViewGroup, position: Int): ProductViewHolder =
        ProductViewHolder(ItemProductBinding.inflate(LayoutInflater.from(container.context), container, false), onClickitemListener)

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) =
        holder.bind(products[position])

    class ProductViewHolder (
        val view: ItemProductBinding,
        val onClickitemListener: OnClickItemListener
    ) : RecyclerView.ViewHolder(view.root) {
        fun bind(product: ProductViewModel) = with(view) {
            this.product = product
            root.setOnClickListener {
                onClickitemListener.invoke(product)
            }
            executePendingBindings()
        }
    }

    override fun replaceItems(list: List<Any>) {
        this.products.clear()
        this.products.addAll(list as List<ProductViewModel>)
        notifyDataSetChanged()
    }

}