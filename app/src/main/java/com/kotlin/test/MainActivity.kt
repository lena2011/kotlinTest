package test.kotlin.com.kotlin

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.kotlin.test.Forecast
import com.kotlin.test.Request
import com.kotlin.test.RequestForecastCommand
import com.kotlin.test.adapter.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.async
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import javax.xml.datatype.Duration

class MainActivity : AppCompatActivity() {
    //private  val  items=
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, duration).show()
    }

    private fun init() {
        val recyclerView: RecyclerView = find(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        async() {
            val items = RequestForecastCommand("573").execute()
            uiThread {
                recyclerView.adapter = RecyclerAdapter(items,object :RecyclerAdapter.onItemClickListener{
                    override fun invoke(forecast: com.kotlin.test.domain.Forecast) {
                        toast(forecast.date)
                    }
                })
            }
        }


    }
}
