package com.example.wellingtonasilva.qrcode.pagamento

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.example.wellingtonasilva.qrcode.R

/**
 * Created by wellingtonasilva on 28/12/17.
 */
class PagamentoFragment: Fragment()
{
    lateinit var mListPagerAdapter: PagamentoStatePagerAdapter
    lateinit var mViewPager: ViewPager
    lateinit var navigation: BottomNavigationView

    companion object {
        val TAG: String = "PagamentoFragment"
        fun newInstance(): PagamentoFragment {
            return PagamentoFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view = inflater?.inflate(R.layout.lay_pagamento_fragment, container, false)

        //Lista de Páginas a serem exibidas
        mListPagerAdapter = PagamentoStatePagerAdapter(fragmentManager)
        //ViewPage
        mViewPager = view?.findViewById<ViewPager>(R.id.viewPager)!!
        mViewPager.adapter = mListPagerAdapter
        mViewPager.addOnPageChangeListener(object: ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                pageSelected(position)
            }
        })
        navigation = view?.findViewById<BottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener{item: MenuItem ->  navigationItemSelected(item)}

        return view
    }

    private fun navigationItemSelected(item: MenuItem): Boolean
    {
        when (item.itemId) {
            R.id.navigation_barcode -> if (mViewPager.currentItem !== PagamentoStatePagerAdapter.PAGE_BARCODE_LIST)
                mViewPager.currentItem = PagamentoStatePagerAdapter.PAGE_BARCODE_LIST
            R.id.navigation_scanner -> if (mViewPager.currentItem !== PagamentoStatePagerAdapter.PAGE_SCANNER)
                mViewPager.currentItem = PagamentoStatePagerAdapter.PAGE_SCANNER
        }

        return true
    }

    private fun pageSelected(position: Int)
    {
        when (position) {
            PagamentoStatePagerAdapter.PAGE_BARCODE_LIST -> {
                if (navigation.selectedItemId !== R.id.navigation_barcode)
                    navigation.selectedItemId = R.id.navigation_barcode
            }
            PagamentoStatePagerAdapter.PAGE_SCANNER -> {
                if (navigation.selectedItemId !== R.id.navigation_scanner)
                    navigation.selectedItemId = R.id.navigation_scanner
            }
        }
    }
}
