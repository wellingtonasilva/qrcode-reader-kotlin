package com.example.wellingtonasilva.qrcode.pagamento.barcode

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wellingtonasilva.qrcode.R

/**
 * Created by wellingtonasilva on 28/12/17.
 */
class PagamentoBarcodeListFragment: Fragment()
{
    companion object {
        val TAG: String = "PagamentoBarcodeListFragment"
        fun newInstance(): PagamentoBarcodeListFragment {
            return PagamentoBarcodeListFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view = inflater?.inflate(R.layout.lay_pagamento_barcode_list_fragment, container, false)
        return view
    }
}