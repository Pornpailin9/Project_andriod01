package com.example.fragment_listview

import android.content.ClipDescription
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentTransaction
import org.json.JSONObject
import com.bumptech.glide.Glide


class fragment_detail : Fragment() {

    var image:String ?= null
    var title:String ?= null
    var description:String ?= null

    fun newInstance(image:String,title:String,description: String): fragment_detail {
        val fragment = fragment_detail()
        val bundle = Bundle()
        bundle.putString("image",image);
        bundle.putString("title",title);
        bundle.putString("description",description);
        fragment.setArguments(bundle)

        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
            if(bundle != null){
                this.image = bundle.getString("image").toString()
                this.title = bundle.getString("title").toString()
                this.description = bundle.getString("description").toString()
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragment_detail, container, false)
            val image_view : ImageView = view.findViewById(R.id.image_view)
            val title_view : TextView = view.findViewById(R.id.title_view)
            val description_view : TextView = view.findViewById(R.id.description_view)

        val btn : Button = view.findViewById(R.id.linkfacebook)

        btn.setOnClickListener{
            //            val fragment_web =  com.example.implement.WebView()
//            val fm = fragmentManager
//            val transaction : FragmentTransaction = fm!!.beginTransaction()
//            transaction.replace(R.id.Layout, fragment_web,"fragment_web")
//            transaction.addToBackStack("fragment_web")
//            transaction.commit()
            var i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/pronpilin.Kc"))
            startActivity(i)
        }

            title_view.text = this.title
            description_view.text = this.description
            Glide.with(activity!!.baseContext).load(image).into(image_view)
        return view
    }

}
