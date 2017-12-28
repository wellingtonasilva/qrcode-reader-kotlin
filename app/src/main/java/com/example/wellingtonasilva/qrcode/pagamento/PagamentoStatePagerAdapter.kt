package com.example.wellingtonasilva.qrcode.pagamento

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.wellingtonasilva.qrcode.pagamento.barcode.PagamentoBarcodeListFragment
import com.example.wellingtonasilva.qrcode.pagamento.scanner.PagamentoScannerFragment

/**
 * Created by wellingtonasilva on 28/12/17.
 */
class PagamentoStatePagerAdapter(val fm: FragmentManager): FragmentStatePagerAdapter(fm)
{
    companion object {
        val PAGE_BARCODE_LIST: Int = 0
        val PAGE_SCANNER: Int = 1
    }

    override fun getItem(position: Int): Fragment
    {
        var fragment: Fragment = Fragment()
        val bundle = Bundle()
        when (position) {
            PAGE_BARCODE_LIST -> fragment = PagamentoBarcodeListFragment.newInstance()
            PAGE_SCANNER -> fragment = PagamentoScannerFragment.newInstance()
        }

        return fragment
    }

    override fun getCount(): Int
    {
        return 2
    }
}