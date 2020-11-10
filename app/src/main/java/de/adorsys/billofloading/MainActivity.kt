package de.adorsys.billofloading

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.textView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val billOfLoding = BillOfLoading.createBillOfLoadingList(100, "receiverId")
        textView.text = billOfLoding.entries.toString()
    }
}