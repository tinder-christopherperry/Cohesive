package com.tinder.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lorentzos.flingswipe.SwipeFlingAdapterView


class HomeFragment : Fragment(), SwipeFlingAdapterView.onFlingListener {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var cardStackAdapter: CardStackAdapter
    private lateinit var cardStackView: SwipeFlingAdapterView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        cardStackView = root.findViewById(R.id.card_stack)

        cardStackAdapter = CardStackAdapter(layoutInflater)
        cardStackView.setFlingListener(this)
        cardStackView.adapter = cardStackAdapter

        homeViewModel.cardComponents.observe(viewLifecycleOwner, Observer {
            cardStackAdapter.setItems(it)
        })

        return root
    }

    override fun removeFirstObjectInAdapter() {
        cardStackAdapter.removeFirstItem()
    }

    override fun onLeftCardExit(p0: Any?) {

    }

    override fun onRightCardExit(p0: Any?) {

    }

    override fun onAdapterAboutToEmpty(p0: Int) {

    }

    override fun onScroll(v: Float) {
        // Negative values means left, positive means right
        val view: View = cardStackView.selectedView
        when {
            v < 0 -> view.findViewById<View>(R.id.no).alpha = v * -0.8f
            v > 0 -> view.findViewById<View>(R.id.yes).alpha = v * 0.8f
            else -> {
                view.findViewById<View>(R.id.no).alpha = 0f
                view.findViewById<View>(R.id.yes).alpha = 0f
            }
        }
    }
}

private class CardStackAdapter(private val inflater: LayoutInflater): BaseAdapter() {
    private val stackItems = mutableListOf<CardComponent>()

    fun setItems(items: List<CardComponent>) {
        stackItems.clear()
        stackItems.addAll(items)
        notifyDataSetChanged()
    }

    fun removeFirstItem() {
        stackItems.removeAt(0)
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return stackItems.size
    }

    override fun getItem(position: Int): CardComponent {
        return stackItems[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null) {
            view = inflater.inflate(R.layout.card, parent, false)
        }

        val cardComponent = getItem(position)
        view?.findViewById<ImageView>(R.id.image)?.setImageResource(cardComponent.imageResourceId)
        view?.findViewById<TextView>(R.id.snippet)?.text = cardComponent.userName

        return view as View
    }

}