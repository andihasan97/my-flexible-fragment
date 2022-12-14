package com.andihasan7.myflexiblefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class HomeFragment : Fragment(), View.OnClickListener {

    //mendefinisikan layout interface & ditransformasikan dari layout berupa file .xml ke dalam objek view dengan metode inflate()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    //sama fungsi onCreate
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //menggunakan view.findViewById tanda btn_category berada pd objek view yg mana objek view berasal dari konversi fragment_main.xml
        val btnCategory: Button = view.findViewById(R.id.btn_category)
        btnCategory.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_category) {
            /*
            Metode addToBackStack akan menambahkan fragment ke backstack

            Behaviour dari back button :
            jika ada fragment di dalam backstack maka fragment yang akan di close / remove
            jika sudah tidak ada fragment di dalam backstack maka activity yang akan di close / finish
             */
            val mCategoryFragment = CategoryFragment()
            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(R.id.frame_container, mCategoryFragment, CategoryFragment::class.java.simpleName)
                //hapus addToBackStack() jika ingin aplikasi langsung close karena fragment sebelumnya tidak tersimpan di stack
                addToBackStack(null)
                commit()
            }
        }
    }
}