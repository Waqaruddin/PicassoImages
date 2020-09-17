package com.example.picasso3
import com.android.volley.Request

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    var mList:ArrayList<Image> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        getData()
    }

    private fun getData() {
        var requestQueue = Volley.newRequestQueue(this)
        var url = "https://jsonplaceholder.typicode.com/photos"
        var request = StringRequest(
            Request.Method.GET, url,
            {
                var jsonDataArray = JSONArray(it)
                for(i in 0 until jsonDataArray.length()){
                    var jsonObj = jsonDataArray.getJSONObject(i)
                    var url = jsonObj.getString("url")
                    mList.add(Image(url))
                }
                var adapterImage = AdapterImage(this, mList)
                recycler_view.layoutManager = GridLayoutManager(this,2)
                recycler_view.adapter = adapterImage
            },
            {

            }
        )
        requestQueue.add(request)
    }
}