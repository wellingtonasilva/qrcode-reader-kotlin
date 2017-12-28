package com.example.wellingtonasilva.qrcode.pagamento

import android.os.Bundle
import com.example.wellingtonasilva.qrcode.R
import com.example.wellingtonasilva.qrcode.core.BasicActivity

/**
 * Created by wellingtonasilva on 28/12/17.
 */
class PagamentoActivity: BasicActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lay_pagamento_activity)
        //Configuração inicial
        init(savedInstanceState)
    }

    fun init(savedInstanceState: Bundle?)
    {
        val fragmentManager = supportFragmentManager
        var fragment = fragmentManager.findFragmentByTag(PagamentoFragment.TAG)
        if (fragment == null) {
            fragment = PagamentoFragment.newInstance()
        }
        fragment.arguments = savedInstanceState
        addFragmentToActivity(fragmentManager, fragment, R.id.frameLayout, PagamentoFragment.TAG)
    }
}